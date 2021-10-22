package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.DB_Connection;
import dto.wishBuyListVo;
import dto.wishSellListVo;
import dto.usedCarVo;
import dao.wishBuyListDao;
import dao.wishSellListDao;

public class usedCarService {
	// dao를 포함
		private DB_Connection dao;
		private usedCarVo vo;
		private wishBuyListDao wbdao;
		private wishBuyListVo wbvo;
		private wishSellListDao wsdao;
		private wishSellListVo wsvo;
		Scanner sc = new Scanner(System.in);

		public usedCarService() {
			dao = new DB_Connection();
			wbdao = new wishBuyListDao();
			wsdao = new wishSellListDao();
		}

		public ArrayList<usedCarVo> getAllUsedCar() {
			return dao.getAllUsedCar();
		}
		
		public ArrayList<wishBuyListVo> wishBuyList() {
			return wbdao.wishBuyList();
		}
		public ArrayList<wishSellListVo> wishSellList() {
			return wsdao.wishSellList();
		}
		

		public boolean login(boolean login) {

			String pw = "";
			String id = "";
			String PW = new String("1234");
			String ID = new String("system");

			while (true) {
				if (login == true) {
					System.out.println("이미 로그인 되어 있습니다.");
					System.out.println();
					break;
				}
				System.out.print("관리자 아이디로 로그인 하세요\n");
				System.out.print("로그인 화면을 종료하려면 f를 입력하세요\n");
				System.out.println("ID:");
				id = sc.next();

				if(id.equals("f")) {
					System.out.println("로그인 종료");
					break;
				}		
				else if(ID.equals(id)) {
					System.out.println("PW:");
					pw = sc.next();
					if (PW.equals(pw)) {
						System.out.println("로그인 성공");
						login = true;
						break;
					} else if (PW.equals(pw) == false) {
						System.out.println("로그인 실패, 비밀번호가 다릅니다");
					}
				} else if (ID.equals(id) == false) {
					if (PW.equals(pw) == false) {
						System.out.println("로그인 실패, 아이디와 비밀번호를 확인하세요.");
					} else {
						System.out.println("로그인 실패, 아이디가 다릅니다.");
					}
				}

			}
			return login;
		}

		public void managemermod() {
			
			
		}
}
