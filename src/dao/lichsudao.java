package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import bean.khachhangbean;
import bean.lichsubean;

public class lichsudao {
	public ArrayList<lichsubean> getlichsu(int makh){
        try {
        	CoSodao cs = new CoSodao();
    		cs.KetNoi();
           String sql = "select * from VLichSuMuaHang where makh = ?";
           	PreparedStatement cmd = cs.cn.prepareStatement(sql);
	    	cmd.setInt(1, makh);
            
            ResultSet rs = cmd.executeQuery();
            ArrayList<lichsubean> listls = new ArrayList<lichsubean>();
            while(rs.next()) {
            	lichsubean ls = new lichsubean();
            	int makhachhang = rs.getInt("makh");
				String tenDongho = rs.getString("TenDongHo");
				int SoLuongMua = rs.getInt("SoLuongMua");
				int gia = rs.getInt("Gia");
				int ThanhTien = rs.getInt("ThanhTien");
				boolean damua =rs.getBoolean("damua");
				Date NgayMua = rs.getDate("NgayMua");
				ls = new lichsubean(makhachhang, tenDongho, SoLuongMua, gia, ThanhTien, damua, NgayMua);
				listls.add(ls);
            }
            
            rs.close();
			
            return listls;
	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
	}
    }
}
