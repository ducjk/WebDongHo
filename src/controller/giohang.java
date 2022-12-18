package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class giohang
 */
@WebServlet("/giohang")
public class giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohang() {
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
		giohangbo gh;
		HttpSession session = request.getSession();
		
		if (session.getAttribute("gio") == null){
			gh = new giohangbo();
			session.setAttribute("gio", gh);
		}
		
		gh = (giohangbo) session.getAttribute("gio");
		
		String removeItem = request.getParameter("remove");
		if (request.getParameter("remove") != null){
			String maSach = request.getParameter("ms");
			gh.Xoa(maSach);
			
		}
		else if (request.getParameter("addwatch") != null){
			String maDongho = request.getParameter("ms");
			long soLuong = (long)1;
			if (request.getParameter("quantity") != null)
				soLuong = Long.parseLong(request.getParameter("quantity"));
			
			String tenDongho = request.getParameter("tendongho");
			long giaSach = Long.parseLong(request.getParameter("gia"));
			String anh = request.getParameter("anh");
			String xuatxu = request.getParameter("xuatxu");
			gh.Them(maDongho, tenDongho, giaSach, soLuong, anh, xuatxu);
		}
		
		else if (request.getParameter("removeall") != null){
			gh.XoaAll();
		}
		else if (request.getParameter("suanhieu") != null && request.getParameter("delete") != null) {
			
			gh.XoaNhieu(request.getParameterValues("delete"));
		}
		//b3: luu gh vao session
		
		session.setAttribute("gio", gh);
		
		response.sendRedirect("htgio.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
