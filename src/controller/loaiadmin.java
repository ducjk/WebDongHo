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

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class loaiadmin
 */
@WebServlet("/loaiadmin")
public class loaiadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loaiadmin() {
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
		
		loaibo lbo = new loaibo();

		if(request.getParameter("add")!=null) {
			String ma=request.getParameter("txtml");
			String tl=request.getParameter("txttl");
			System.out.println("ma loai: " + ma + "|| ten loai: " + tl);
			lbo.Themloai(ma, tl);
		}
		else if(request.getParameter("remove")!=null) {
			String ml=request.getParameter("ml");
			lbo.Xoa(ml);
		}
		else if (request.getParameter("update")!=null) {
			String tenloai = request.getParameter("suacmn");
			System.out.println("ten loai update: " + tenloai);
			int kq = lbo.update(tenloai, request.getParameter("update"));
		}
		ArrayList<loaibean> dsloai = lbo.getloai();
		request.setAttribute("dsloai", dsloai);
		RequestDispatcher rd =request.getRequestDispatcher("quanlyloaiadmin.jsp");
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
