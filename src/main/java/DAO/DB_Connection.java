package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import DTO.SellVO;

public class DB_Connection {
	
	private ArrayList<SellVO> dtos;
	Connection con = null;
	Statement st = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
		public DB_Connection() {
			dtos = new ArrayList<SellVO>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false", "root", "1234");
				st=con.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void insertSellList(String CarNumber, String Name, String PhoneNumber, String Email) {			
			try {
				ps = con.prepareStatement("INSERT INTO WISHSELLLIST(wishSellUser_name, phone_num, car_number, email) VALUES(?, ?, ?, ?)");
				
				ps.setString(1, Name);
				ps.setString(2, PhoneNumber);
				ps.setString(3, CarNumber);
				ps.setString(4, Email);
				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void insertSearchList(String carNumber, String carType, String carName, String carCompany, int carPrice, double carYear, int carDriven,
				String carFuel, String carColor) {			
			try {
				ps = con.prepareStatement("INSERT INTO SEARCHLIST(CAR_NUMBER, CAR_TYPE, CAR_NAME, MADE_COMPANY, PRICE, MADE_YEAR,"
						+ "DIS_DRIVEN, FUEL_TYPE, COLOR) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				ps.setString(1, carNumber);
				ps.setString(2, carType);
				ps.setString(3, carName);
				ps.setString(4, carCompany);
				ps.setInt(5, carPrice);
				ps.setDouble(6, carYear);
				ps.setInt(7, carDriven);
				ps.setString(8, carFuel);
				ps.setString(9, carColor);
				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void truncateSearchList() {
			try {
				ps = con.prepareStatement("TRUNCATE SEARCHLIST");
				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<SellVO> searchCar(){
			dtos = new ArrayList<SellVO>();
			
			try {
				rs = st.executeQuery("SELECT * FROM USEDCAR");
				
				while(rs.next()) {
					String car_number = rs.getString("car_number");
					String car_type = rs.getString("car_type");
					String car_name = rs.getString("car_name");
					String made_company = rs.getString("made_company");
					int price = rs.getInt("price");
					double made_year = rs.getDouble("made_year");
					int dis_driven = rs.getInt("dis_driven");
					String fuel_type = rs.getString("fuel_type");
					String color = rs.getString("color"); 
					
					SellVO VO = new SellVO(car_number, car_type, car_name, made_company, price,
					made_year, dis_driven, fuel_type, color);
					
					dtos.add(VO);
				}
				rs.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return dtos;
		}
}
