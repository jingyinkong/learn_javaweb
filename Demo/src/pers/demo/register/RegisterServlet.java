package pers.demo.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.demo.information.user;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static user user = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		user = new user(null, null);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			user.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/jsp;charset=UTF-8");
		System.out.println("RegisterServlet.doGet()");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("RegisterServlet.doPost()");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		System.out.println(name);
		System.out.println(password);
		
		if (user.selectDatas(name)) {
			request.setAttribute("msg","用户名已注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
			user.insertDatas(name, password);
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}

	}

}
