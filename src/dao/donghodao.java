package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.donghobean;

public class donghodao {
	
	public ArrayList<donghobean> getdongho() {
		try {
			ArrayList<donghobean> dsdongho = new ArrayList<donghobean>();
//			   b1: ket noi vao csdl
			   CoSodao cs = new CoSodao();
			   cs.KetNoi();
//			   b2: Lay du lieu ve
			   String sql = "select * from DongHo";
			   PreparedStatement cmd = cs.cn.prepareStatement(sql);
			   ResultSet rs = cmd.executeQuery();
			   while(rs.next()) {
				   String maDongHo = rs.getString("MaDongHo");
				   String tenDongHo = rs.getString("TenDongHo");
				   long soLuong = rs.getLong("SoLuong");
				   long gia = rs.getLong("Gia");
				   String anh = rs.getString("Anh");
				   String maLoai = rs.getString("MaLoai");
				   String xuatxu = rs.getString("XuatXu");
				   dsdongho.add(new donghobean(maDongHo, tenDongHo, soLuong, gia, anh, xuatxu, maLoai));

			   }
			   
//			   b3: close rs, cn
			   rs.close();
			   cs.cn.close();
			   
			   return dsdongho;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		
	}
	
	public donghobean getMotDongho(String madongho)
	{
		try {
        	CoSodao cs = new CoSodao();
    		cs.KetNoi();
//			   b2: Lay du lieu ve
            String sql = "select * from DongHo where MaDongHo = ?";
           	PreparedStatement cmd = cs.cn.prepareStatement(sql);
	    	cmd.setString(1, madongho);
            ResultSet rs = cmd.executeQuery();
            donghobean dongho = new donghobean();
            if(rs.next()) {
            	String MaDongHo = rs.getString("MaDongHo");
				   String tenDongho = rs.getString("TenDongHo");
				   Long soLuong = rs.getLong("SoLuong");
				   Long gia = rs.getLong("Gia");
				   String anh = rs.getString("Anh");
				   String xuatXu = rs.getString("XuatXu");
				   String MaLoai = rs.getString("MaLoai");
				   dongho = new donghobean(MaDongHo, tenDongho, soLuong, gia, anh, xuatXu, MaLoai);
            }
            
            rs.close();
			   
            return dongho;
	} catch (Exception e) {
            // TODO: handle exception
          e.printStackTrace();
          return null;
	}
	}
	public int ThemDongHo(String maDongho,String TenDongho,Long gia ,Long soluong, String anh, String maloai,Date ngay, String xuatXu)
	{
		try {
			//b1: ket noi vao csdl
			CoSodao cs = new CoSodao();
    		cs.KetNoi();
			String sql="insert into DongHo (MaDongHo,TenDongho,SoLuong, Gia, Anh, MaLoai, NgayNhap,XuatXu) values (?,?,?,?,?,?,?,?)";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(1,maDongho);
				cmd.setString(2,TenDongho);
				cmd.setLong(3,soluong);
				cmd.setLong(4,gia);
				cmd.setString(5,anh);
				cmd.setString(6,maloai);
				cmd.setDate(7, new java.sql.Date(ngay.getTime()));
				cmd.setString(8, xuatXu);
				//b4: Thuc hien cau lieu
				int kq=cmd.executeUpdate();
				 
				 cs.cn.close();
				 return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int xoa(String maDongHo){
		 //Ket Noi
		  try {
			  CoSodao cs = new CoSodao();
				cs.KetNoi();
			 String sql="delete from DongHo where madongho=?";
			 PreparedStatement cmd= cs.cn.prepareStatement(sql);
			  cmd.setString(1, maDongHo);
			  int kq=cmd.executeUpdate();
			 cmd.close();
			 cs.cn.close();
			 return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int suaDongHo(String maDongho,String TenDongho,Long gia ,Long soluong, String anh, String maloai,Date ngay, String xuatXu) {
		try {
			//b1: ket noi vao csdl
			CoSodao cs = new CoSodao();
    		cs.KetNoi();
			String sql="update DongHo set TenDongho = ?,SoLuong = ?, Gia = ?, Anh = ?, MaLoai = ?, NgayNhap = ?,XuatXu = ? where MaDongHo = ?";
			PreparedStatement cmd = cs.cn.prepareStatement(sql);
			cmd.setString(8,maDongho);
				cmd.setString(1,TenDongho);
				cmd.setLong(2,soluong);
				cmd.setLong(3,gia);
				cmd.setString(4,anh);
				cmd.setString(5,maloai);
				cmd.setDate(6, new java.sql.Date(ngay.getTime()));
				cmd.setString(7, xuatXu);
				//b4: Thuc hien cau lieu
				int kq=cmd.executeUpdate();
				 
				 cs.cn.close();
				 return kq;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}