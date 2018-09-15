package web.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.db.ControllerData;
import web.md5.GenerateMD5;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/signUp.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("signup_email");
		String name = request.getParameter("signup_name");
		String surname = request.getParameter("signup_surname");
		String password = request.getParameter("signup_password");
		System.out.println("login: " + email + ", password: " + password);
		
		GenerateMD5 md = new GenerateMD5();
		
		String hashPassword="";
		
		try {
			hashPassword = md.generateMD5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("hashcode is : " + hashPassword);
		
		ControllerData cd = new ControllerData();
		int signUp = cd.signUp(email, name, surname, hashPassword);
		
		if(signUp == -1) {
			System.out.println("There is a problem with SQL Exception.");
			request.getRequestDispatcher("jsp/index.jsp").include(request, response);
		}else if(signUp == 0) {
			System.out.println("There is already exist this email.");
			request.getRequestDispatcher("jsp/signUp.jsp").include(request, response);
			response.getWriter().println("<h2><font color = \"red\"><center>There is already exist this email</center></font></h2>");
		}else {
			System.out.println("Login and password are true.");
			request.getRequestDispatcher("jsp/signUp.jsp").include(request, response);
			response.getWriter().println("<h2><font color = \"red\"><center>Registration passed successfully!</center></font></h2>");
		}
	}

}
