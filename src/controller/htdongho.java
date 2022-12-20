package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.donghobean;
import bean.loaibean;
import bo.donghobo;
import bo.loaibo;

/**
 * Servlet implementation class htdongho
 */
@WebServlet("/htdongho")
public class htdongho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htdongho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		
		ArrayList<donghobean> dsdongho;
		
		if (session.getAttribute("dsdongho") == null){
			dsdongho = new ArrayList<donghobean>();
			session.setAttribute("dsdongho", dsdongho);
		}
		
		dsdongho = (ArrayList<donghobean>) session.getAttribute("dsdongho");
		
		donghobo dhbo = new donghobo();
		
		if (request.getParameter("search")!=null){
			dsdongho = dhbo.getdongho();
			dsdongho = dhbo.timKiemTheoTen(dsdongho, request.getParameter("search"));
		}
		else if (request.getParameter("ml")!=null){
			dsdongho = dhbo.getdongho();
			dsdongho = dhbo.timKiemTheoLoai(dsdongho, request.getParameter("ml"));
		}
		else {
			dsdongho = dhbo.getdongho();
		}
		
		if (request.getParameter("sortpopulla") != null) {
		 	
		 	dsdongho = dhbo.sortReverse(dsdongho);
		}
		else if (request.getParameter("sortreverse") != null) {
			dsdongho = dhbo.sortPopulla(dsdongho);
		}
		session.setAttribute("dsdongho", dsdongho);
		
		RequestDispatcher rd = request.getRequestDispatcher("htdongho.jsp");
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
