	package bo;

import java.util.ArrayList;

import bean.donghobean;
import dao.donghodao;


public class donghobo {
	donghodao dhdao = new donghodao();
	ArrayList<donghobean> ds;
	
	public ArrayList<donghobean> getdongho(){
		ds = dhdao.getdongho();
		
		return ds;
	}
	
	public ArrayList<donghobean> timKiemTheoLoai(ArrayList<donghobean> ds ,String maLoai) {
		ArrayList<donghobean> dsSachCungMa = new ArrayList<donghobean>();
		for (donghobean item:ds) {
			if (item.getMaLoai().equals(maLoai)) {
				dsSachCungMa.add(item);
			}
		}
		
		return dsSachCungMa;
	}
	
	public ArrayList<donghobean> timKiemTheoTen(ArrayList<donghobean> ds ,String tenDongho) {
		ArrayList<donghobean> dsSachCungTen = new ArrayList<donghobean>();
		for (donghobean item: ds) {
			if (item.getTenDongHo().toLowerCase().trim().contains(tenDongho.toLowerCase().trim())
			 || item.getMaLoai().toLowerCase().trim().contains(tenDongho.toLowerCase().trim())
			 || item.getXuatXu().toLowerCase().trim().contains(tenDongho.toLowerCase().trim())
			) {
				dsSachCungTen.add(item);
			}
		}
		
		return dsSachCungTen;
	}
}
