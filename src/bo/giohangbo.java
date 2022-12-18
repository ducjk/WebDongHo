package bo;

import java.util.ArrayList;

import bean.donghobean;
import bean.giohangbean;

public class giohangbo {
	public ArrayList<giohangbean> ds = new ArrayList<giohangbean>();
	public void Them(String maDongho, String tenDongHo, long giaSach, long soLuong, String anh, String xuatXu) {
		for (giohangbean g:ds) {
			if (g.getMaDongHo().equals(maDongho)) {
				
				if (soLuong < 0)
					soLuong = 1;	
				g.setSoLuong(soLuong);
				return;
			}
		}
		
		ds.add(new giohangbean(maDongho, tenDongHo, giaSach, soLuong, anh, xuatXu));
		
	}
	
	public void Xoa(String maDongHo) {
		for (int i=0; i<ds.size(); i++) {
			if (ds.get(i).getMaDongHo().equals(maDongHo)) {
				ds.remove(i);
				return;
			}
		}
	}
	
	public void XoaAll() {
		ds.removeAll(ds);
	}
	
	public long TongTien() {
		long Sum = 0;
		for (giohangbean g: ds) {
			Sum += g.getThanhtien();
		}
		return Sum;
	}
	
	public int countBook() {
		int count = 0;
		for (giohangbean g: ds) {
			count++;
		}
		
		return count;
	}
	
	public void XoaNhieu(String [] list) {
		for (String item: list) {
			for (int i=0; i<ds.size(); i++) {
				if (item.equals(ds.get(i).getMaDongHo())) {
					ds.remove(i);
					i--;
				}
			}
		}
	}
}
