package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DataBaseConnection1 {
	Statement st;
	
	public DataBaseConnection1() {
		String host="127.0.0.1";
		String port="3306";
		try {
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qtripData","root","Test@123");
		st=con.createStatement();
		}catch(SQLException e) {
			System.out.println("Exception occured during the jdbc connection");
		}
	}
	
	public void setData() {
		String str=UUID.randomUUID().toString();
		String email="Test_"+str.substring(0,6)+"@gmail.com";
		String password="Test@123";
		try {
			st.executeUpdate("insert into loginData(email,password) values('"+email+"','"+password+"')");
			
		}catch(SQLException e) {
			System.out.println("Exception occured during the insert data to database");
		}
	}
	
	public String getData(String columnName) {
		String data=null;
		try {
			ResultSet res=st.executeQuery("select * from loginData");
			while(res.next()) {
				data=res.getString(columnName);
			}
			
		}catch(SQLException e) {
			System.out.println("Exception occured during the fetching the data from database");
		}
		return data;
	}
	
	

}
