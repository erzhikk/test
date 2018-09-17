package web.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.db.ControllerData;
import web.md5.GenerateMD5;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/index.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("login_email");
		String password = request.getParameter("login_password");
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
		int verifyLogin = cd.verifyLogin(email, hashPassword);
		
		if(verifyLogin == -1) {
			System.out.println("There is a problem with SQL Exception.");
			request.getRequestDispatcher("jsp/index.jsp").include(request, response);
		}else if(verifyLogin == 0) {
			System.out.println("There is incorrect login or password.");
			request.getRequestDispatcher("jsp/index.jsp").include(request, response);
			response.getWriter().println("<h2><font color = \"red\"><center>Incorrect login or password!</center></font></h2>");
		}else {
			System.out.println("Login and password are true.");
			HttpSession session=request.getSession();  
			request.setAttribute("userInfo", cd.userInfo(email));
			request.getRequestDispatcher("jsp/mainpage.jsp").include(request, response);
		}
	}
}
