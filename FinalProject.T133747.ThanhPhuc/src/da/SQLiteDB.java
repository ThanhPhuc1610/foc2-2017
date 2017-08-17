package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;

public class SQLiteDB {
	private Connection connect() {
		String url = "jdbc:sqlite:foc2warehouse.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void getAllProducts(){
		String sql = "SELECT * FROM products";
		
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				System.out.format("%3d %-40s %6.2f \n", 
						rs.getInt("productid"),
						rs.getInt("productcode"),
						rs.getString("productname"),
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
	
	public void update(String name, int categoryid, double pPrice, int pUnitInStock, int productid){
		String sql = "UPDATE products set productname = ?, categoryid = ?, unitprice = ?, unitinstock = ? "
				+ "WHERE(productid = ?)";
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, name);
			pstmt.setInt(2, categoryid);
			pstmt.setDouble(3, pPrice);
			pstmt.setInt(4, pUnitInStock);
			pstmt.setInt(5, productid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void delete( int productid){
		String sql = "DELETE FROM products WHERE productid = ? ";
		
		try (Connection conn = connect();
		PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, productid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public Vector<Category> getAllCategories(){
		String sql = "SELECT * FROM categories";
		Vector<Category> categoryList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				Category cat = new Category(rs.getInt("id"),
						rs.getString("categoryname"));
				
				categoryList.add(cat);
				
				
			}
			return categoryList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Vector<Brand> getAllBrands(){
		String sql = "SELECT * FROM brand";
		Vector<Brand> brandList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				Brand bra = new Brand(rs.getInt("id"),
						rs.getString("brandname"));
				
				brandList.add(bra);
				
				
			}
			return brandList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Vector<UnitOfMeasure> getAllUnitOfMeasure(){
		String sql = "SELECT * FROM unitofmeasure";
		Vector<UnitOfMeasure> UnitOfMeasureList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				UnitOfMeasure uom = new UnitOfMeasure(rs.getInt("id"),
						rs.getString("unitname"));
				
				UnitOfMeasureList.add(uom);
				
				
			}
			return UnitOfMeasureList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
}


