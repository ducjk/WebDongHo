package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.donghobean;
import bean.loaibean;
import bo.donghobo;
import bo.loaibo;

/**
 * Servlet implementation class quanlydongho
 */
@WebServlet("/quanlydongho")
public class quanlydongho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quanlydongho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		loaibo lbo = new loaibo();
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		if (request.getParameter("them") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("themdongho.jsp");
			rd.forward(request, response);
		}
		else if (request.getParameter("sua") != null) {
			String madongho = request.getParameter("madongho");
			String tendongho = request.getParameter("tendongho");
			Long gia = Long.parseLong(request.getParameter("gia"));
			Long soluong = Long.parseLong(request.getParameter("soluong"));
			String maloai = request.getParameter("maloai");
			String xuatxu = request.getParameter("xuatxu");
			String anh = request.getParameter("anh");
			
			donghobean dh = new donghobean(madongho, tendongho, soluong, gia, anh, xuatxu, maloai);
			request.setAttribute("dongho", dh);
			
			RequestDispatcher rd = request.getRequestDispatcher("suadongho.jsp");
			rd.forward(request, response);
		}
		else if (request.getParameter("xoa")!= null) {
			donghobo dhbo = new donghobo();
			int kt = dhbo.xoa(request.getParameter("madongho"));
			if (kt != 0) {
				request.setAttribute("xoadongho", "true");
				RequestDispatcher rd = request.getRequestDispatcher("hienthidonghoadmin");
				rd.forward(request, response);
			}else {
				request.setAttribute("xoathatbai", "true");
				RequestDispatcher rd = request.getRequestDispatcher("hienthidonghoadmin");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
