package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.UnitOfMeasure;

public class UnitofMeasureDA extends WHConnection{
	
		
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
