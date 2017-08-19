package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDA extends WHConnection{
	
	
	
	public void getAllProducts(){
		String sql = "SELECT * FROM products";
		
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				System.out.format("%3d %-10s %-10s %3d %3d %3d %6.2f \n", 
						rs.getInt("id"),
						rs.getString("productcode"),
						rs.getString("productname"),
						rs.getInt("categoryid"),
						rs.getInt("brandid"),
						rs.getInt("unitofmeasureid"),
						rs.getDouble("unitprice"));
						
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void insert (String pCode, String pName, int categoryid, int brandid,  int unitofmeasureid, double price, String description){
		String sql = "INSERT INTO products(productcode, productname, categoryid, brandid, unitofmeasureid, price, description)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, pCode);
			pstmt.setString(2, pName);
			pstmt.setInt(3, categoryid);
			pstmt.setInt(4, brandid);
			pstmt.setInt(5, unitofmeasureid);
			pstmt.setDouble(6, price);
			pstmt.setString(7, description);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
