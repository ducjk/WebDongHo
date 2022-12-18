package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.xacnhanadminbo;


/**
 * Servlet implementation class xacnhanchuyentienadmin
 */
@WebServlet("/xacnhanchuyentienadmin")
public class xacnhanchuyentienadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanchuyentienadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		if(session.getAttribute("admin")!=null) {
			xacnhanadminbo xnbo=new xacnhanadminbo();
			request.setAttribute("dsxn", xnbo.getdsxn());
			RequestDispatcher rd=request.getRequestDispatcher("xacnhanchuyentien.jsp");
			rd.forward(request, response);
		}
		else response.sendRedirect("dangnhapadmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
