
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			response.setContentType("text/html; charset=ISO-8859-1");
			// response.setCharacterEncoding("text/html");
			//PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			//out.println("Bienvenido, " + n)
			
			Cookie ckName = new Cookie("Nombre", n);// creating cookie object
			response.addCookie(ckName);// adding cookie in the response
			

			Cookie ckAge = new Cookie("Edad", age);
			response.addCookie(ckAge);
			
			Cookie ckGender = new Cookie("Genero", gender);
			response.addCookie(ckGender);
			
			Cookie ckEmail = new Cookie("Email", email);
			response.addCookie(ckEmail);
			
			Cookie ckPhone = new Cookie("Telefono", phone);
			response.addCookie(ckPhone);
			
			Cookie[] cookies = request.getCookies();
			
			if (cookies != null) {
		        // Quitar la cookie de JSESSIONID y guardar solo las mías
		        List<Cookie> misCookies = Arrays.stream(cookies)
		                .filter(c -> !c.getName().equalsIgnoreCase("JSESSIONID"))
		                .collect(Collectors.toList());

		        request.setAttribute("listaCookies", misCookies);
		    }
		    
		    request.getRequestDispatcher("verDatos.jsp").forward(request, response);
			
			// creating submit button
			//out.print("<form action='Servlet2' method='post'>");
			//out.print("<input type='submit' value='go'>");
			//out.print("</form>");

			//out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
