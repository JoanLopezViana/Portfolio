

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Log0
 */

public class log0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log0() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//String n=request.getParameter("nombre");
			//String e= request.getParameter("email");
			//String p= request.getParameter("password");
			var fecha= LocalDateTime.now();
	        var cli= request.getRemoteAddr()+" "+ request.getRemoteHost();
	        var uri= request.getRequestURI()+" "+ request.getMethod();
	        PrintWriter out= response.getWriter();
	        
	      
	        String preTituloHTML5 = "<!DOCTYPE html>\n<html>\n<head>\n" + 
                    "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n";
	        		//String nombre = request.getParameter("usuario");
	        		//String clave = request.getParameter("pass");
	        		response.setContentType("text/html");
	        		//out = response.getWriter();
	        		out.println(preTituloHTML5+"<title>Eco</title></head><body>");
	        		out.println("<h1>" +fecha+"<br/>"+cli+"<br/>"+uri+"</h1>");
	        		//out.println("<p>Eres el usuario <strong>"+nombre+"</strong>, tu clave tiene <strong>"+clave.length()+"</strong> caracteres.</p>");
	        		out.println("</body></html>");
	        		
	        
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
