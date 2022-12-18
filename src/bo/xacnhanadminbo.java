package bo;

import java.util.ArrayList;

import bean.xacnhanadminbean;
import dao.xacnhanadmindao;

public class xacnhanadminbo {
	xacnhanadmindao xndao = new xacnhanadmindao();
	 public ArrayList<xacnhanadminbean> getdanhsach(){
		  return xndao.getdanhsach();
	  }
	  public ArrayList<xacnhanadminbean> getdsxn(){
		  return xndao.getdsxn();
	  }
	public void xacnhan(long mct) {
		for(xacnhanadminbean ad:xndao.getdanhsach()) {
			if(ad.getMaChiTietHD()==(mct)) {
				xndao.xacnhan(mct);
				return;
			}
		}
	}
}
