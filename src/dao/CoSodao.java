package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class CoSodao {
	public Connection cn;
	public void KetNoi(){
		try {
			//b1: xac dinh he quan tri csdl
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("xong b1");
			cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-9J4G90P\\SQLEXPRESS:1433;databaseName=QLDongHo;user=sa; password=123456");
			System.out.println("Ok b2");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String [] ts) {
		try {
			CoSodao cs = new CoSodao();
			cs.KetNoi();
//			loaibo lbo = new loaibo();
//			lbo.update("Dia ly", "Dia ly");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
