

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class log2
 */
public class log2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n=request.getParameter("nombre");
		String e=request.getParameter("email");
		String p=request.getParameter("password");
		String loc=request.getServletContext().getInitParameter("location");
		 String desktopFilePath = "/home/user/tomcat/logs/"+loc;
		File f= new File(desktopFilePath);
		if(!f.exists()) {
			f.createNewFile();
		}
		var fecha=LocalDateTime.now();
		var cli=request.getRemoteAddr();
		var usu=request.getRemoteHost();
		var uri=request.getRequestURI()+" metodo: "+ request.getMethod();
		

		FileWriter file = new FileWriter(f,true);
		PrintWriter a = new PrintWriter(file);
        String preTituloHTML5 = "<!DOCTYPE html>\n<html>\n<head>\n" + 
                "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n";
		   // String nombre = request.getParameter("nombre");
		    //String clave = request.getParameter("password");
		    response.setContentType("text/html");

		    a.println("Contenido almacenado: Fecha" + fecha);
		    a.println("Datos del formulario:" + n);
		    a.println("IP:" + cli + " " + usu + " " + uri);

		    a.close();
		    PrintWriter out=response.getWriter();
		    out.println(preTituloHTML5+"<title>Eco</title></head><body>");
		    out.println("<p> Se ha descargado en: "+desktopFilePath+" </p>");}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
