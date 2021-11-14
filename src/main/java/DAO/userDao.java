package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.userVo;

public class userDao {
	private ArrayList<userVo> dtos;
	private Connection con;
	private Statement st;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String url = "jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";

	public userDao() {
		dtos = new ArrayList<userVo>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, dbID, dbPW);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 로그인 확인
	public boolean checkLogin(String input_id, String input_pw) {
		String SQL = "SELECT * FROM user where id =" + "" + "'" + input_id + "'" + "and" + " pw =" + "'" + input_pw
				+ "'";
		boolean checkLogin = false;
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone_num = rs.getString("phone_num");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String email2 = rs.getString("email2");
				userVo mvo = new userVo(name, id, pw, phone_num, address, email, email2);

				if (id.equals(input_id) == true) {
					if (pw.equals(input_pw) == true) {
						checkLogin = true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkLogin;
	}

	// 로그인 확인
	public void checkLogin2(String input_id) {
		String SQL = "SELECT * FROM user where id =" + "" + "'" + input_id + "'";
		boolean checkLogin = false;
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone_num = rs.getString("phone_num");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String email2 = rs.getString("email2");
				userVo mvo = new userVo(name, id, pw, phone_num, address, email, email2);

				if (id.equals(input_id) == true) {
					checkLogin = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<userVo> getIDInfo(String input_id) {
		dtos = new ArrayList<userVo>();
		String SQL = "SELECT * FROM user where id =" + "" + "'" + input_id
				+ "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone_num = rs.getString("phone_num");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String email2 = rs.getString("email2");
				userVo mvo = new userVo(name, id, pw, phone_num, address, email,
						email2);
				dtos.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtos;
	}
	

	// 회원가입
	public void newJoinMember(String name, String newId, String newPw, String phone_num, String newAddress,
			String email, String email2) {
		String SQL = "Insert INTO user VALUES(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, newId);
			pstmt.setString(3, newPw);
			pstmt.setString(4, phone_num);
			pstmt.setString(5, newAddress);
			pstmt.setString(6, email);
			pstmt.setString(7, email2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원탈퇴
	public void deletUserInfo(String outmemberid) {
		String SQL = "delete from user where id=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, outmemberid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//		이메일반환
	public String getEmail(String input_id) {
		String getEmail = "";
		String SQL = "SELECT * FROM user where id=" + "'" + input_id + "'";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {

				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone_num = rs.getString("phone_num");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String email2 = rs.getString("email2");

				userVo mvo = new userVo(name, id, pw, phone_num, address, email, email2);
				getEmail = mvo.getEmail();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getEmail;
	}

	// 중복체크
	public boolean checkDuplicateId(String input_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM user where id=?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, input_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public void modiInfo(String name,String id,String pw,String phone_num,String address,String email,String email2) {
		try {		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String selectSql = "UPDATE user SET name=?, id=?, pw=?, phone_num=?,address=? ,email=? ,email2=? WHERE id=?";
		pstmt = con.prepareStatement(selectSql);
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		pstmt.setString(3, pw);
		pstmt.setString(4, phone_num);
		pstmt.setString(5, address);
		pstmt.setString(6, email);	
		pstmt.setString(7, email2);	
		pstmt.setString(8, id);	
		pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}
