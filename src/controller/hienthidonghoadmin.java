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
 * Servlet implementation class hienthidonghoadmin
 */
@WebServlet("/hienthidonghoadmin")
public class hienthidonghoadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hienthidonghoadmin() {
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
		if (request.getAttribute("thanhcong") != null) {
			request.setAttribute("themdonghothanhcong", "true");
		}
		request.setAttribute("dsloai", dsloai);
		
		ArrayList<donghobean> dsdongho;
		if (session.getAttribute("dsdonghoadmin") == null){
			dsdongho = new ArrayList<donghobean>();
			session.setAttribute("dsdonghoadmin", dsdongho);
		}
		
		dsdongho = (ArrayList<donghobean>) session.getAttribute("dsdonghoadmin");
		
		donghobo dhbo = new donghobo();
		
		if (request.getParameter("ml")!=null){
			dsdongho = dhbo.getdongho();
		    dsdongho = dhbo.timKiemTheoLoai(dsdongho, request.getParameter("ml"));
		}
		else {
			dsdongho = dhbo.getdongho();
		}
		
		if (request.getAttribute("suathanhcong")!= null) {
			request.setAttribute("suadongho", "true");
		}
		else if (request.getAttribute("xoadongho")!= null) {
			request.setAttribute("xoadongho", "true");
		}
		else if (request.getAttribute("xoathatbai")!= null) {
			request.setAttribute("xoathatbai", "true");
		}
		
		session.setAttribute("dsdonghoadmin", dsdongho);
		
		RequestDispatcher rd = request.getRequestDispatcher("htdonghoadmin.jsp");
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
