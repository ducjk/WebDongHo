package bo;

import java.util.Date;

import bean.khachhangbean;
import dao.hoadondao;

public class hoadonbo {
	hoadondao hddao = new hoadondao();
	public int themhoadon(int makhachhang, Date ngaylap) {
		try {
			return hddao.ThemHoaDon(makhachhang, ngaylap);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int themchitiethoadon(String maDongho, int soluong, int mahoadon) {
		try {
			return hddao.ThemChiTietHoaDon(maDongho, soluong, mahoadon);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	 public int maxmahd() {
		 return hddao.maxhoadon();
	 }
	
	
	public khachhangbean getkhachhang(String email) {
		try {
			return hddao.getkhachhang(email);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
