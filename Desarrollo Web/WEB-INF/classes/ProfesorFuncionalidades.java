import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ProfesorFuncionalidades
 */
public class ProfesorFuncionalidades extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, String> asignaturasProfe = new HashMap<>();
    private Map<String, Map<String, String>> alumnosProfe = new HashMap<>();

    public ProfesorFuncionalidades() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreMaquina = request.getServerName();
        HttpSession ses = request.getSession(false);

        if (ses == null || ses.getAttribute("key") == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No session found");
            return;
        }

        List<String> cookies = (List<String>) ses.getAttribute("cookie");
        String dni = (String) ses.getAttribute("dni");
        String key = (String) ses.getAttribute("key");

        if (cookies == null || dni == null || key == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing session attributes");
            return;
        }

        String param = request.getParameter("opcion");
        response.setContentType("application/json");

        if (request.isUserInRole("rolpro")) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest httpRequest = null;
                URI uri;

                switch (param) {
                    case "profasig":
                        uri = new URI("http://" + nombreMaquina + ":9090/CentroEducativo/profesores/" + dni + "/asignaturas?key=" + key);
                        httpRequest = HttpRequest.newBuilder(uri)
                                .header("Cookie", String.join(";", cookies))
                                .GET()
                                .build();
                        break;
                    case "asigalum":
                        String acronimo = request.getParameter("acronimo");
                        if (this.asignaturasProfe.get(dni).contains(acronimo)) {
                            uri = new URI("http://" + nombreMaquina + ":9090/CentroEducativo/asignaturas/" + acronimo + "/alumnos?key=" + key);
                            httpRequest = HttpRequest.newBuilder(uri)
                                    .header("Cookie", String.join(";", cookies))
                                    .GET()
                                    .build();
                        } else {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "La asignatura no existe / no es impartida por usted!");
                            return;
                        }
                        break;
                    case "getalumno":
                        String dnialumno = request.getParameter("dnialumno");
                        if (this.alumnosProfe.get(dni).get(dnialumno) != null) {
                            uri = new URI("http://" + nombreMaquina + ":9090/CentroEducativo/alumnos/" + dnialumno + "?key=" + key);
                            httpRequest = HttpRequest.newBuilder(uri)
                                    .header("Cookie", String.join(";", cookies))
                                    .GET()
                                    .build();
                        } else {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "El alumno solicitado no existe / no tienes permisos para acceder a el.");
                            return;
                        }
                        break;
                    case "dni":
                        uri = new URI("http://" + nombreMaquina + ":9090/CentroEducativo/profesores/" + dni + "?key=" + key);
                        httpRequest = HttpRequest.newBuilder(uri)
                                .header("Cookie", String.join(";", cookies))
                                .GET()
                                .build();
                        break;
                    case "avatar":
                        String dniparam = request.getParameter("dniavatar");
                        if (this.alumnosProfe.get(dni).get(dniparam) != null || dniparam.equals(dni)) {
                            ServletContext context = getServletContext();
                            String pathToAvatar = context.getRealPath("/WEB-INF/img");

                            response.setContentType("text/plain");
                            response.setCharacterEncoding("UTF-8");
                            try (BufferedReader origen = new BufferedReader(new FileReader(pathToAvatar + "/" + dniparam + ".pngb64"));
                                 PrintWriter out = response.getWriter()) {
                                out.print("{\"dni\": \"" + dniparam + "\", \"img\": \"");
                                String linea = origen.readLine();
                                out.print(linea);
                                while ((linea = origen.readLine()) != null) {
                                    out.print("\n" + linea);
                                }
                                out.print("\"}");
                            }
                            return;
                        } else {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "El alumno solicitado no existe / no tienes permisos para acceder a el.");
                            return;
                        }
                    case "setnota":
                        String acron = request.getParameter("acron");
                        if (this.asignaturasProfe.get(dni).contains(acron)) {
                            Float nota = Float.parseFloat(request.getParameter("nota"));
                            if (nota >= 0 && nota <= 10) {
                                String dnialum = request.getParameter("dnialumno");
                                uri = new URI("http://" + nombreMaquina + ":9090/CentroEducativo/alumnos/" + dnialum + "/asignaturas/" + acron + "?key=" + key);
                                httpRequest = HttpRequest.newBuilder(uri)
                                        .header("Content-Type", "application/json")
                                        .header("Cookie", String.join(";", cookies))
                                        .PUT(BodyPublishers.ofString(nota.toString()))
                                        .build();
                                HttpResponse<String> httpResponse = client.send(httpRequest, BodyHandlers.ofString());
                                response.setContentType("text/plain");
                                response.getWriter().append(httpResponse.body());
                            } else {
                                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La nota no es válida");
                            }
                        } else {
                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "La asignatura no existe / no es impartida por usted!");
                        }
                        return;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Opción no válida");
                        return;
                }

                if (httpRequest != null) {
                    HttpResponse<String> httpResponse = client.send(httpRequest, BodyHandlers.ofString());
                    String content = httpResponse.body();

                    if (param.equals("profasig") && this.asignaturasProfe.get(dni) == null) {
                        this.asignaturasProfe.put(dni, content);
                    } else if (param.equals("asigalum")) {
                        JSONArray jsonAsigs = new JSONArray(content);
                        if (this.alumnosProfe.get(dni) == null) {
                            this.alumnosProfe.put(dni, new HashMap<String, String>() {{
                                put("", "");
                            }});
                        }
                        Map<String, String> alreadyAlums = this.alumnosProfe.get(dni);
                        for (int i = 0; i < jsonAsigs.length(); i++) {
                            alreadyAlums.put(jsonAsigs.getJSONObject(i).getString("alumno"), "");
                        }
                        this.alumnosProfe.put(dni, alreadyAlums);
                    }

                    response.getWriter().append(content);
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal server error");
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().append("No tienes permitido realizar esta accion!");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
