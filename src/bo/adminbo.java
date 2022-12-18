package bo;

import bean.adminbean;
import dao.admindao;

public class adminbo {
	admindao addao = new admindao();
	
	public adminbean ktdn(String tendn, String pass) {
		return addao.ktdn(tendn, pass);
	}
}
