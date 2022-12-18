package bean;

import java.util.Date;

public class lichsubean {
	int makh;
	String tendongho;
	int SoLuongMua;
	int gia;
	int ThanhTien;
	boolean damua;
	Date NgayMua;
	public lichsubean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public lichsubean(int makh, String tendongho, int soLuongMua, int gia, int thanhTien, boolean damua, Date ngayMua) {
		super();
		this.makh = makh;
		this.tendongho = tendongho;
		SoLuongMua = soLuongMua;
		this.gia = gia;
		ThanhTien = thanhTien;
		this.damua = damua;
		NgayMua = ngayMua;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public String getTenDongHo() {
		return tendongho;
	}
	public void setTenDongHo(String tendongho) {
		this.tendongho = tendongho;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(int thanhTien) {
		ThanhTien = thanhTien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	
	
}
