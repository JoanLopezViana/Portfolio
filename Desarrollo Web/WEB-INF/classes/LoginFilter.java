
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;

import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.HttpURLConnection;
import java.net.http.HttpResponse;

import java.time.LocalDateTime;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.CookieList;

import org.apache.tomcat.util.json.ParseException;


public class LoginFilter implements Filter {

    private File logFile;
    private Map<String, User> usuarios;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        usuarios = new HashMap<String,User>();
        
        // Profesores
        usuarios.put("23456733H", new User("23456733H", "123456"));
        usuarios.put("10293756L", new User("10293756L", "123456"));
        usuarios.put("06374291A", new User("06374291A", "123456"));
        usuarios.put("65748923M", new User("65748923M", "123456"));
        
        
        // Alumnos
        usuarios.put("12345678W", new User("12345678W","123456"));
        usuarios.put("23456387R", new User("23456387R", "123456"));
        usuarios.put("34567891F", new User("34567891F", "123456"));
        usuarios.put("93847525G", new User("93847525G", "123456"));
        usuarios.put("37264096W", new User("37264096W", "123456"));
        
        String logPath = fConfig.getInitParameter("logPath");           // Ubicación del log en web.xml
        logFile = new File(logPath);                                    // Creacion del archivo
        try {                                                           // Try-catch para su ejecucion y tratamiento en caso de error
            logFile.createNewFile();
        } catch (IOException e) {
            System.out.println("No se pudo crear el fichero de log");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	
        String nombreMaquina = request.getServerName();                                 // Nombre de la maquina donde se esta ejecutando CentroEducativo
        PrintWriter pw2 = new PrintWriter(new FileOutputStream(logFile, true));         // Abrimos el log para añadir nueva informacion (true para añadir no sobreescribir) 
        HttpServletRequest req = (HttpServletRequest) request;                          // Creacion de la var para solicitudes
        
        pw2.println(LocalDateTime.now().toString() + " " + req.getQueryString() + " " + req.getRemoteUser() + " " + request.getRemoteAddr() + " " + req.getServerName() + " " + req.getRequestURI() + " " + req.getMethod());       // Mensaje del log
        pw2.close();
        
        HttpServletResponse res = (HttpServletResponse) response;                       // Creacion de la var para respuestas
        
        HttpSession session = req.getSession(true);                                     // Variable para determinar si hay sesion o no, en caso de no haber se crea (true)

        if (session.getAttribute("key") == null) {                                      // Si no hay key de sesion (sesion nueva)
            String userTomcat = req.getRemoteUser();                                    // Obtenemos el login del usuario si ha sido identificado o nulo en caso de que no
            String user = usuarios.get(userTomcat).getDni();                            // DNI del usuario
            String pass =usuarios.get(userTomcat).getPassword();                        // Contraseña del usuario

            // Crear el objeto JSON con las credenciales del usuario
            JSONObject cred = new JSONObject();
            cred.put("dni", user);
            cred.put("password", pass);
            String entity = cred.toString();

            // Enviar la solicitud POST utilizando HttpURLConnection
            try {
                URL url = new URL("http://"+nombreMaquina+":9090/CentroEducativo/login");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                // Escribir la entidad de la solicitud
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = entity.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
                
                List<String> cookies = connection.getHeaderFields().get("Set-Cookie");

                // Leer la respuesta
                int responseCode = connection.getResponseCode();
                String keyRes = "-1";

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Leer la respuesta si el código de estado es 200
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                        StringBuilder responseBuilder = new StringBuilder();
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            responseBuilder.append(inputLine);
                        }
                        keyRes = responseBuilder.toString();
                    }
                }
              
                // Cerrar la conexión
                connection.disconnect();

                if (responseCode == HttpURLConnection.HTTP_OK && !keyRes.equals("-1")) {
                    session.setAttribute("dni", user);
                    session.setAttribute("password", pass);
                    session.setAttribute("key", keyRes);
                    session.setAttribute("cookie", cookies);
                    // No es posible almacenar las cookies en la sesión sin utilizar HttpComponents
                }
            } catch (IOException e) {       // En caso de error se redirige al usuario a la pagina error.html
            	res.sendRedirect(req.getContextPath() + "/error.html"); 
            }

        }

        chain.doFilter(request, response);  // En caso de que haya ido todo bien, se continua con la peticion que estaba realizando el usuario
    }
    
    @Override
    public void destroy() {
        // Código de limpieza si es necesario
    }
}