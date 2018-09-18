package we.library.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.db.BookControllerData;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_name = request.getParameter("book_name");
		String book_author = request.getParameter("book_author");
		String book_price = request.getParameter("book_price");
		String isbn_code = request.getParameter("ISBN_code");
		
		BookControllerData bcd = new BookControllerData();
		
		int result = bcd.addBook(book_name, book_author, book_price, isbn_code);
		
		if(result == 1) {
			System.out.println("Book is added!");
			request.getRequestDispatcher("jsp/mainpage.jsp").include(request, response);
		}else {
			System.out.println("Book is not added. Something wrong!");
			request.getRequestDispatcher("jsp/mainpage.jsp").include(request, response);
			response.getWriter().println("<h2><font color = \"red\"><center>Book is not added!</center></font></h2>");
		}	
	}
}