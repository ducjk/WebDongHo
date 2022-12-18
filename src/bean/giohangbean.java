package bean;

public class giohangbean {
	String maDongHo, tenDongHo;
	long gia, soLuong, thanhtien;
	String anh;
	String xuatXu;
	public giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public giohangbean(String maDongHo, String tenDongHo, long gia, long soLuong, String anh, String xuatXu) {
		super();
		this.maDongHo = maDongHo;
		this.tenDongHo = tenDongHo;
		this.gia = gia;
		this.soLuong = soLuong;
		this.thanhtien = soLuong * gia;
		this.anh = anh;
		this.xuatXu = xuatXu;
	}
	public String getMaDongHo() {
		return maDongHo;
	}
	public void setMaDongHo(String maDongHo) {
		this.maDongHo = maDongHo;
	}
	public String getTenDongHo() {
		return tenDongHo;
	}
	public void setTenDongHo(String tenDongHo) {
		this.tenDongHo = tenDongHo;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}
	public long getThanhtien() {
		return soLuong * gia;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	public String getXuatXu() {
		return xuatXu;
	}
	
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	
	
}
