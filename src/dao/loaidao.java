package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	
	   public ArrayList<loaibean> getloai(){
		   try {
			   ArrayList<loaibean> dsloai= new ArrayList<loaibean>();
//			   b1: ket noi vao csdl
			   CoSodao cs = new CoSodao();
			   cs.KetNoi();
//			   b2: Lay du lieu ve
			   String sql = "select * from loai";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   while(rs.next()) {
				   String maloai = rs.getString("maloai");
				   String tenloai = rs.getString("tenloai");
				   dsloai.add(new loaibean(maloai, tenloai));
			   }
			   
//			   b3: close rs, cn
			   rs.close();
			   cs.cn.close();
			   return dsloai;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
	   }
	   public int themloai(String maloai,String tenloai) throws Exception{
		   System.out.println("ma loai dao: " + maloai + ", ten loai dao: " + tenloai);
			CoSodao cs = new CoSodao();
			cs.KetNoi();
			
	        String sql = "insert into loai(maloai, tenloai) values (?,?)";
	        PreparedStatement cmd = cs.cn.prepareStatement(sql);
	        cmd.setString(1, maloai);
	        cmd.setString(2, tenloai);
	        int kq=cmd.executeUpdate();
			 
			 cs.cn.close();
			 return kq;
	    }
	   public int xoa(String maloai) throws Exception{
		 //Ket Noi
		   CoSodao cs = new CoSodao();
			cs.KetNoi();
		 String sql="delete from loai where maloai=?";
		 PreparedStatement cmd= cs.cn.prepareStatement(sql);
		  cmd.setString(1, maloai);
		  int kq=cmd.executeUpdate();
		 cmd.close();
		 cs.cn.close();
		 return kq;
		 }
	   
	   public int updatesach(String tenloai, String maloai) throws Exception{
			 //Ket Noi
			   CoSodao cs = new CoSodao();
				cs.KetNoi();
			 String sql="UPDATE loai"+" SET tenloai = ?"+" WHERE maloai =?";
			 PreparedStatement cmd= cs.cn.prepareStatement(sql);
			  cmd.setString(1, tenloai);
			  cmd.setString(2, maloai);
			  int kq=cmd.executeUpdate();
			 
			 cs.cn.close();
			 return kq;
			 }
}