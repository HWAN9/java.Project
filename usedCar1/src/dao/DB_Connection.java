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


public class DB_Connection {
	DecimalFormat DRIVEN = new DecimalFormat("###,###");
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private ArrayList<usedCarVo> usedCar;
	private ArrayList<usedCarVo> dtos;
	private ArrayList<usedCarVo> arrayListCar = new ArrayList<usedCarVo>();
	
	
	public DB_Connection() {
		usedCar = new ArrayList<usedCarVo>();
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
	
	public void searchByCarType(String type) {
		String SQL = "SELECT * FROM usedCar WHERE Car_type= " + "'" + type + "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void searchByModel(String type) {
		String SQL = "SELECT * FROM usedCar WHERE Car_name= " + "'" + type + "'";

		try {
			rs = st.executeQuery(SQL);
			
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				int made_year = rs.getInt("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");

				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : %d만원 / ", price);
				System.out.printf("연식 : %d년형 / ", made_year);
				System.out.printf("주행거리 : %dkm / ", dis_driven);
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertwishBuyList(String car_number, String wishbuyuser_name, String phone_num) {
	
		String SQL = "Insert INTO wishBuyList(car_number,wishbuyuser_name,phone_num)VALUES(?,?,?)";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_number);
			pstmt.setString(2, wishbuyuser_name);
			pstmt.setString(3, phone_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void SearchCar(String car_number) {

        String SQL = "SELECT * FROM usedcar WHERE car_number=" + "'" + car_number + "'";
        try {
            rs = st.executeQuery(SQL);

            while (rs.next()) {
                String car_type = rs.getString("car_type");
                String car_name = rs.getString("car_name");
                String made_company = rs.getString("made_company");
                int price = rs.getInt("price");
                double made_year = rs.getDouble("made_year");
                int dis_driven = rs.getInt("dis_driven");
                DecimalFormat DRIVEN = new DecimalFormat("###,###");
                String fuel_type = rs.getString("fuel_type");
                String color = rs.getString("color");

                System.out.printf("차량종류 : %s / ", car_type);
                System.out.printf("모델명 : %s / ", car_name);
                System.out.printf("제조사 : %s / ", made_company);
                System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
                System.out.printf("연식 : %.0f년형 / ", made_year);
                System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
                System.out.printf("연료 : %s / ", fuel_type);
                System.out.printf("색상 : %s \n", color);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void insertwishSellList(String car_number, String car_name, Double made_year, int dis_driven, String wishSellUser_name, String phone_num){
		String SQL = "Insert INTO wishSellList(car_number,car_name,made_year,dis_driven,wishSellUser_name,phone_num)VALUES(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_number);
			pstmt.setString(2, car_name);
			pstmt.setDouble(3, made_year);
			pstmt.setInt(4, dis_driven);
			pstmt.setString(5, wishSellUser_name);
			pstmt.setString(6, phone_num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<usedCarVo> getAllUsedCar() {
		String SQL = "SELECT * FROM usedcar";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				usedCarVo VO = new usedCarVo(car_number, car_type, car_name, made_company, price, made_year, dis_driven,
						fuel_type, color);
				dtos.add(VO);
				// ArrayList에 회원정보 추가

				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : %d만원 / ", price);
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : %dkm / ", dis_driven);
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public void InsertusedCar(String car_number, String car_type, String car_name, String made_company, int price, double made_year,
			int dis_driven, String fuel_type, String color) 
	{
		String SQL = "Insert INTO usedCar(Car_Number,Car_Type,Car_Name,Made_Company,Price,Made_Year,Dis_Driven,Fuel_Type,Color)"
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_number);
			pstmt.setString(2, car_type);
			pstmt.setString(3, car_name);
			pstmt.setString(4, made_company);
			pstmt.setInt(5, price);
			pstmt.setDouble(6, made_year);
			pstmt.setInt(7, dis_driven);
			pstmt.setString(8, fuel_type);
			pstmt.setString(9, color);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void SearchByNo(String input_car_number) {
		String SQL = "SELECT * FROM usedCar WHERE Car_Number=" + "'" + input_car_number + "'";
		try {
			rs = st.executeQuery(SQL);

			while (rs.next()) {

				String car_number = rs.getString("Car_Number");
				String car_type = rs.getString("Car_Type");
				String car_name = rs.getString("Car_Name");
				String made_company = rs.getString("Made_Company");
				int price = rs.getInt("Price");
				double made_year = rs.getDouble("Made_Year");
				int dis_driven = rs.getInt("Dis_Driven");
				String fuel_type = rs.getString("Fuel_Type");
				String color = rs.getString("Color");

				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : %d만원 / ", price);
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : %dkm / ", dis_driven);
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyCartype(String car_number, String car_type) {
		String SQL = "update usedCar set Car_Type=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_type);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateusedCarbyCarname(String car_number, String car_name) {
		String SQL = "update usedCar set Car_Name=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_name);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyCompany(String car_number, String made_company) {
		String SQL = "update usedCar set Made_Company=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, made_company);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyPrice(String car_number, int price) {
		String SQL = "update usedCar set Price=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, price);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyYear(String car_number, double made_year) {
		String SQL = "update usedCar set Made_Year=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setDouble(1, made_year);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyDis(String car_number, int dis_driven) {
		String SQL = "update usedCar set Dis_Driven=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, dis_driven);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyFuel(String car_number, String fuel_type) {
		String SQL = "update usedCar set Fuel_Type=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, fuel_type);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateusedCarbyColor(String car_number, String color) {
		String SQL = "update usedCar set Color=? where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, color);
			pstmt.setString(2, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


	}
	
	public void DeleteusedCar(String car_number) {
		String SQL = "delete from usedCar where Car_Number=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, car_number);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarType(String type) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			String word = arrayListCar.get(i).getcar_type();
			if (word.contains(type)) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
			
	public void searchByName(String type) {
		String SQL = "SELECT * FROM usedCar WHERE Car_name LIKE" + "'%" + type + "%'";

		try {
			rs = st.executeQuery(SQL);			
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);

				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarName(String type) {
		System.out.println(arrayListCar.size());
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			String word = arrayListCar.get(i).getcar_name();
			if (word.contains(type)) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarCompany(String type) { // 제조사 검색
		String SQL = "SELECT * FROM usedCar WHERE made_company= " + "'" + type + "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarCompany(String type) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			String word = arrayListCar.get(i).getmade_company();
			if (word.contains(type)) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarPrice(int min, int max) { // 가격 검색
		String SQL = "SELECT * FROM usedCar WHERE price between" + "'" + min + "'" + "AND" + "'" + max + "'" + "order by price";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarPrice(int min, int max) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			int price = arrayListCar.get(i).getprice();
			if (min <= price && price <= max) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarMadeYear(int min, int max) {
		String SQL = "SELECT * FROM usedCar WHERE made_year between" + "'" + min + "'" + "AND" + "'" + max + "'" + "order by made_year";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("car_color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarMadeYear(int min, int max) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			double made_year = arrayListCar.get(i).getmade_year();
			if (min <= made_year && made_year <= max) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarDriven(int min, int max) {
		String SQL = "SELECT * FROM usedCar WHERE dis_driven between" + "'" + min + "'" + "AND" + "'" + max + "'" + "order by dis_driven";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				usedCarVo list = new usedCarVo();
				
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarDriven(int min, int max) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			int dis_driven = arrayListCar.get(i).getdis_driven();
			if (min <= dis_driven && dis_driven <= max) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarFuelType(String type) { // 연료 검색
		String SQL = "SELECT * FROM usedCar WHERE fuel_type= " + "'" + type + "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarFuelType(String type) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			String word = arrayListCar.get(i).getfuel_type();
			if (word.contains(type)) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	public void searchByCarColor(String type) { // 색상 검색
		String SQL = "SELECT * FROM usedCar WHERE color= " + "'" + type + "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");				
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color");
				
				usedCarVo list = new usedCarVo();
				list.setcar_number(rs.getString("car_number"));
				list.setcar_type(rs.getString("car_type"));
				list.setcar_name(rs.getString("car_name"));
				list.setmade_company(rs.getString("made_company"));
				list.setprice(rs.getInt("price"));
				list.setmade_year(rs.getDouble("made_year"));
				list.setdis_driven(rs.getInt("dis_driven"));
				list.setfuel_type(rs.getString("fuel_type"));
				list.setcolor(rs.getString("car_color"));
				arrayListCar.add(list);
				
				System.out.printf("차량번호 : %s / ", car_number);
				System.out.printf("차량종류 : %s / ", car_type);
				System.out.printf("모델명 : %s / ", car_name);
				System.out.printf("제조사 : %s / ", made_company);
				System.out.printf("가격 : " + DRIVEN.format(price) + "만원 ");
				System.out.printf("연식 : %.0f년형 / ", made_year);
				System.out.printf("주행거리 : " + DRIVEN.format(dis_driven) + "km ");
				System.out.printf("연료 : %s / ", fuel_type);
				System.out.printf("색상 : %s \n", color);
			}
			rs.close();
			System.out.println(" ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listByCarColor(String type) {
		for (int i = (arrayListCar.size()-1); i > -1; i--) {
			String word = arrayListCar.get(i).getcolor();
			if (word.contains(type) == true) {
				double j = arrayListCar.get(i).getmade_year();
				System.out.printf("차량번호 : " + arrayListCar.get(i).getcar_number() + " / ");
				System.out.printf("차량종류 : " + arrayListCar.get(i).getcar_type() + " / ");
				System.out.printf("모델명 : " + arrayListCar.get(i).getcar_name() + " / ");
				System.out.printf("제조사 : " + arrayListCar.get(i).getmade_company() + " / ");
				System.out.printf("가격 : " + DRIVEN.format(arrayListCar.get(i).getprice()) + "만원 / ");
				System.out.printf("연식 : %.0f년형 / ", j);
				System.out.printf("주행거리 : " + DRIVEN.format(arrayListCar.get(i).getdis_driven()) + "km / ");
				System.out.printf("연료 : " + arrayListCar.get(i).getfuel_type() + " / ");
				System.out.println("색상 : " + arrayListCar.get(i).getcolor());
			} else {
				arrayListCar.remove(i);
			}
		}
		if(arrayListCar.isEmpty()) {
			System.out.println("조회 결과가 없습니다. 검색종료 후 재검색하세요.");
		}
		System.out.println(" ");
	}
	
	
}

