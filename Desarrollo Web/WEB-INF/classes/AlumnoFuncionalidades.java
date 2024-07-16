
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class alumnoApi
 */
public class AlumnoFuncionalidades extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> asignaturasAlumno = new HashMap<>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoFuncionalidades() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Nombre de la maquina que ejecuta el servidor CentroEducativo para las peticiones
        String nombreMaquina = request.getServerName();

        // Variables de la sesion

        HttpSession ses = request.getSession(false);                            // Sesion  (el false es para evitar que se creen sesiones nuevas)
        HttpClient httpClient = HttpClient.newHttpClient();                     // Cliente http
        List<String> cookies = (List<String>) ses.getAttribute("cookie");       // Cookies de la sesion
        String dni = (String) ses.getAttribute("dni");                          // Valor identificador del usuario (dni)
        String key = (String) ses.getAttribute("key");                          // Key de la sesion
        
        HttpRequest httpRequest = null;                                         
        JSONArray asignaturas = new JSONArray();                                // Variable donde se guardaran la lista de asignaturas obtenidas con la peticion a CentroEducativo
        JSONObject dniydatos = new JSONObject();                                // Datos del usuario
        JSONObject imagen = new JSONObject();                                   // Imagen del usuario
        
        if (request.isUserInRole("rolalu")) {                                   // En caso de ser un alumno y
            String param = request.getParameter("opcion");                      // dependiendo de la opcion que se le pase se realizaran una de las siguientes peticiones
            response.setContentType("application/json");
            
            if ("asig".equals(param)) {                                  // Se devuelve las asignaturas en las que esta matriculado el alumno
                httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://" + nombreMaquina + ":9090/CentroEducativo/alumnos/" + dni + "/asignaturas?key=" + key))    // Solicitud de petición
                    .header("Cookie", String.join(";", cookies))                                                                        // Paso de cookies
                    .build();                                                                                                           // Finalización de la petición
                
            } else if ("dni".equals(param)) {                                   // Se devuelve la informacion relacionada con el alumno (nombre, apellidos...)
                httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://" + nombreMaquina + ":9090/CentroEducativo/alumnos/" + dni + "?key=" + key))
                    .header("Cookie", String.join(";", cookies))
                    .build();
                
            } else if ("imagen".equals(param)) {                                // Se devuelve la imagen del alumno
                ServletContext context = getServletContext();                   // Path actual
                String pathToImagen = context.getRealPath("/WEB-INF/img");      // Ubicacion concreta de la imagen
                
                response.setContentType("text/plain");
                response.setCharacterEncoding("UTF-8");
                try (BufferedReader origen = new BufferedReader(new FileReader(pathToImagen + "/" + dni + ".pngb64"));      // Lectura de la imagen 
                     PrintWriter out = response.getWriter()) {
                     
                    out.print("{\"dni\": \"" + dni + "\", \"img\": \"");        // Formateo de la respuesta JSON
                    String linea;
                    while ((linea = origen.readLine()) != null) {
                        out.print(linea);
                    }
                    out.print("\"}");
                }
                return;
                
            } else if ("detalles".equals(param)) {                          // Detalles de la asignatura escogida (creditos, cuatri, nombre...)
                String acronimo = request.getParameter("acron");
                if (this.asignaturasAlumno.get(dni).contains(acronimo)) {
                    httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create("http://" + nombreMaquina + ":9090/CentroEducativo/asignaturas/" + acronimo + "?key=" + key))
                        .header("Cookie", String.join(";", cookies))
                        .build();
                } else {
                    response.sendError(403, "La asignatura solicitada no existe / no estás matriculado en ella!");      // Respuesta de error
                    return;
                }
                
            } else if ("asignaturasprofesor".equals(param)) {                            // Devuelve los profesores que imparten una asignatura especifica
                String acronimo = request.getParameter("acron");
                if (this.asignaturasAlumno.get(dni).contains(acronimo)) {
                    httpRequest = HttpRequest.newBuilder()
                        .uri(URI.create("http://" + nombreMaquina + ":9090/CentroEducativo/asignaturas/" + acronimo + "/profesores?key=" + key))
                        .header("Cookie", String.join(";", cookies))
                        .build();
                } else {
                    response.sendError(403, "La asignatura solicitada no existe / no estás matriculado en ella!");
                    return;
                }
            }
            
            if (httpRequest != null) {                      // Tratamiento de las peticiones
                HttpResponse<String> httpResponse;          // Declaración de la var donde se almacenara la respuesta

				try {
					httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());      // Se manda la petición construida previamente
					if (httpResponse.statusCode() == 200) {                                                 // En caso de que todo vaya bien se trata la informaccion recibida
	                    String content = httpResponse.body();                                               // Datos recibidos
	                    if (this.asignaturasAlumno.get(dni) == null && "asig".equals(param)) {       // Si no habia asignaturas guardadas previamente y el parametro el igual al solicitado se alamcenan con la instruccion de abajo
	                        this.asignaturasAlumno.put(dni, content);
	                    }
	                    response.getWriter().append(content);                                               // Escribimos la respuesta
                    } else {
	                    response.getWriter().append(String.valueOf(httpResponse.statusCode()));             // En caso de que haya dado error, imprimimos el codigo que ha saltado
	                }

				} catch (IOException e) {                                                                   // Doble catch por si sucede algo imprimimos la traza
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
             } else {                                       // En caso de la petición ser nula se avisa y salta un error
                response.setStatus(403);
                response.getWriter().append("No tienes permitido realizar esta accion!");
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}