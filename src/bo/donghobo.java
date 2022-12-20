	package bo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import bean.donghobean;
import dao.donghodao;


public class donghobo {
	donghodao dhdao = new donghodao();
	ArrayList<donghobean> ds;
	
	public ArrayList<donghobean> getdongho(){
		ds = dhdao.getdongho();
		
		return ds;
	}
	
	public int xoa(String madongho) {
		return dhdao.xoa(madongho);
	}
	
	public donghobean getMotDongHo(String maDongHo) {
		return dhdao.getMotDongho(maDongHo);
	}
	
	public int themdongho(String maDongho,String TenDongho,Long gia ,Long soluong, String anh, String maloai, Date ngay, String xuatXu) {
		return dhdao.ThemDongHo(maDongho, TenDongho, gia, soluong, anh, maloai, ngay, xuatXu);
	}
	
	public int suadongho(String maDongho,String TenDongho,Long gia ,Long soluong, String anh, String maloai, Date ngay, String xuatXu) {
		return dhdao.suaDongHo(maDongho, TenDongho, gia, soluong, anh, maloai, ngay, xuatXu);
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
	
	
	
	public ArrayList<donghobean> sortPopulla(ArrayList<donghobean> ds) {
//		for (int i=0; i<ds.size() - 1; i++) {
//			for (int j=i +1; j<ds.size(); j++) {
//				if (ds.get(i).getSoLuong() < ds.get(j).getSoLuong()) {
//					donghobean temp = ds.get(i);
//					ds.set(i, ds.get(j));
//					ds.set(j, temp);
//				}
//			}
//		}
		ds.sort(Comparator.comparing(donghobean::getGia));
		
		return ds;
	}
	
	public ArrayList<donghobean> sortReverse(ArrayList<donghobean> ds) {
//		for (int i=0; i<ds.size() - 1; i++) {
//			for (int j=i +1; j<ds.size(); j++) {
//				if (ds.get(i).getSoLuong() < ds.get(j).getSoLuong()) {
//					donghobean temp = ds.get(i);
//					ds.set(i, ds.get(j));
//					ds.set(j, temp);
//				}
//			}
//		}
		ds.sort(Comparator.comparing(donghobean::getGia).reversed());
		
		return ds;
	}
}
