package bean;

public class donghobean {
	private String maDongHo;
	private String tenDongHo;
	private long soLuong;
	private long gia;
	private String anh;
	private String xuatXu;
	private String maLoai;
	
	public donghobean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public donghobean(String maDongHo, String tenDongHo, long soLuong, long gia, String anh, String xuatXu,
			String maLoai) {
		super();
		this.maDongHo = maDongHo;
		this.tenDongHo = tenDongHo;
		this.soLuong = soLuong;
		this.gia = gia;
		this.anh = anh;
		this.xuatXu = xuatXu;
		this.maLoai = maLoai;
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

	public long getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
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

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	
	
}
