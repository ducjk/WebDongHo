package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.donghobean;
import bean.loaibean;
import bo.donghobo;
import bo.loaibo;

/**
 * Servlet implementation class suadongho
 */
@WebServlet("/suadongho")
public class suadongho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suadongho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			donghobo dhbo = new donghobo();
			try {
				String madongho=null,tendongho=null,maloai=null,anhupload=null,xuatxu=null;
				Long gia = (long) 0;
				Long soluong = (long) 0;
				Date ngay=new java.util.Date();
				
				
					List<FileItem> fileItems = upload.parseRequest(request);
			         for (FileItem fileItem : fileItems) {
			 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
							String nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
								String dirUrl = request.getServletContext().getRealPath("") +  "image_dongho";
								File dir = new File(dirUrl);
								if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
							           String fileImg = dirUrl + File.separator + nameimg;
							           File file = new File(fileImg);//tạo file
							            try {
							               fileItem.write(file);// ghi file
							               anhupload =  "image_dongho/"+nameimg;
							              System.out.println(anhupload);
							 } catch (Exception e) {
							    e.printStackTrace();
							}
						}
			 			}
						else
						{
							String tentk=fileItem.getFieldName();
							if(tentk.equals("txtmadongho")) madongho = fileItem.getString("UTF-8");
							if(tentk.equals("txttendongho")) tendongho = fileItem.getString("UTF-8");
							if(tentk.equals("maloai")) maloai = fileItem.getString("UTF-8");
							if(tentk.equals("txtsoluong")) soluong = Long.parseLong(fileItem.getString());
							if(tentk.equals("txtgia")) gia = Long.parseLong(fileItem.getString());
							if(tentk.equals("txtxuatxu")) xuatxu = fileItem.getString("UTF-8");
							if(tentk.equals("txtngaynhap")) 
							{
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
								ngay = format.parse(fileItem.getString());
							}
						}
			         }
			         	if (anhupload == null) {
			         		anhupload = request.getParameter("anh");
			         	}
			         	int c = dhbo.suadongho(madongho, tendongho, gia, soluong, anhupload, maloai, ngay, xuatxu);
				     	if(c==0) {
					     		request.setAttribute("thatbai", "true");
					     		RequestDispatcher rd= request.getRequestDispatcher("suadongho.jsp");
					     		rd.forward(request, response);
					    }
				     	else {
				     		request.setAttribute("suathanhcong", "true");
				     		RequestDispatcher rd= request.getRequestDispatcher("hienthidonghoadmin");
				     		rd.forward(request, response);
				     	}
				     	 
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("htdonghoadmin");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
