package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.donghobean;
import bean.loaibean;

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
	
	
}