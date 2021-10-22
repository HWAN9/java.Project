package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dto.usedCarVo;
import dto.wishBuyListVo;
import dto.wishSellListVo;

public class wishSellListDao {
	private ArrayList<wishSellListVo> dtos;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DecimalFormat DRIVEN = new DecimalFormat("###,###");

	public wishSellListDao() {
		dtos = new ArrayList<wishSellListVo>();
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public ArrayList<wishSellListVo> wishSellList() {
		String SQL = "SELECT * FROM wishSellList";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_Number = rs.getString("car_Number");
				String car_name = rs.getString("car_name");
				Double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String wishSellUser_name = rs.getString("wishSellUser_name");
				String phone_Num = rs.getString("phone_Num");
				wishSellListVo gwVO = new wishSellListVo(car_Number,car_name,made_year,dis_driven,wishSellUser_name, phone_Num);
				dtos.add(gwVO);
				System.out.printf("차번호 : %s / ", car_Number);
				System.out.printf("차량명 : %s / ", car_name);
				System.out.printf("연식 : %.0f년도 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("판매자 이름 : %s / ", wishSellUser_name);
				System.out.printf("휴대폰 번호 : %s /\n", phone_Num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}

}
