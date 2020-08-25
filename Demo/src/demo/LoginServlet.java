package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
//    	
//    	String method = request.getMethod();
//    	if ("get".equalsIgnoreCase(method)) {
//    		doGet(request, response);
//    	}else if ("post".equalsIgnoreCase(method)) {
//    		doPost(request, response);
//    	}
//    	else {
//    		System.out.println("«Î«Û ß∞‹");
//    	}
//    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/jsp;charset=UTF-8");
		
		//String name =new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("LoginServlet.doGet()");
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("LoginServlet.doPost()");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		System.out.println(name);
		System.out.println(password);
		
		if ("jingyinkong".equals(name) && "123456".equals(password)) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

}
