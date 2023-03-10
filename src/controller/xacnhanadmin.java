package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.xacnhanadminbean;
import bo.xacnhanadminbo;

/**
 * Servlet implementation class xacnhanadmin
 */
@WebServlet("/xacnhanadmin")
public class xacnhanadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		xacnhanadminbo xnbo = new xacnhanadminbo();
		if (request.getParameter("mct") != null) {
			xnbo.xacnhan(Long.parseLong(request.getParameter("mct")));
		}
		request.setAttribute("ds", xnbo.getdanhsach());
		RequestDispatcher rd=request.getRequestDispatcher("xacnhanadmin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
