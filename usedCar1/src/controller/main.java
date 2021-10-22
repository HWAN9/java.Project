package controller;

import java.util.ArrayList;
import java.util.Scanner;
import dao.DB_Connection;
import dto.usedCarVo;
import service.usedCarService;

public class main {
	
	
	public static void main(String[] args) {
		menuWhile();
	}
	
	public static void menuWhile() {
		int choice = 0;
		String car_number;
		String wishbuyuser_name;
		String phone_num;
		String car_name;
		Double made_year;
		String wishSellUser_name;
		int dis_driven;
		usedCarService ucs = new usedCarService();
		DB_Connection db = new DB_Connection();
		managementClass mClass = new managementClass();
		boolean login = false;
		
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			choice = sc.nextInt();
			if (choice == 1) {
				userMenu2();
				choice = sc.nextInt();
				if (choice == 1) {
					search();
					break;
				} else if (choice == 2) {
					System.out.print("# 구매하려는 차량 번호를 입력하세요 : \n");
					System.out.print("# 예시)57두1234 \n");
					car_number=sc.next();
					db.SearchCar(car_number);
					System.out.print("\n");
					System.out.print("# 구매하시려는 차량 정보가 맞습니까?");
					System.out.print("1. 예  / 2. 아니오");
					
					choice = sc.nextInt();	
					if(choice == 1){
					System.out.print("이름 : \n");
					wishbuyuser_name=sc.next();
					System.out.print("ex) 010-0000-0000 \n");
					System.out.print("전화번호 : \n");
					phone_num=sc.next();
					db.insertwishBuyList(car_number,wishbuyuser_name,phone_num);
					
					System.out.print("# 이용해 주셔서 감사합니다. 빠른 시일 내에 담당자가 확인 후 연락드리겠습니다. \n");
					break;
					}
					else if(choice == 2){
						menuWhile();
				}
				} else if (choice == 3) {
					menuWhile();
				}
			} else if (choice == 2) {
				System.out.print("# 판매차량의 정보를 입력하세요. \n");
				System.out.print("ex) 26우3441 \n");
				System.out.print("1. 판매차량 번호 : \n");
				car_number=sc.next();
				System.out.print("2. 차량명 : \n");
				System.out.print("ex) 쏘나타, 아반떼 ... \n");
				car_name=sc.next();
				System.out.print("3. 연식 : \n");
				System.out.print("ex) 형식 : 0000년형 \n");
				made_year=sc.nextDouble();
				System.out.print("4. 주행거리 : \n");
				System.out.print("ex) 형식 : 000,000Km // 해당하는 숫자만표기 \n");
				dis_driven=sc.nextInt();
				System.out.print("5. 판매자이름 : \n");
				wishSellUser_name=sc.next();
				System.out.print("6. 판매자 연락처: \n");
				System.out.print("ex) 010-0000-0000 \n");
				phone_num=sc.next();
				
				System.out.print("# 입력하신 정보가 일치합니까? \n");
				System.out.print("1. 예 / 2. 아니오\n");	
				System.out.print("=====================\n");
				System.out.println(car_number  );
				System.out.println(car_name  );
				System.out.println(made_year+"년");
				System.out.println(dis_driven+"Km");
				System.out.println(wishSellUser_name);
				System.out.println(phone_num  );
				System.out.print("=====================\n");
				
				
				
				choice = sc.nextInt();	
				if(choice == 1){
					db.insertwishSellList(car_number, car_name, made_year, dis_driven, wishSellUser_name, phone_num);
					System.out.print("# 이용해 주셔서 감사합니다. 빠른 시일 내에 담당자가 확인 후 연락드리겠습니다. \n");
					break;
					
				}
				else if(choice == 2){
					menuWhile();
				}
				
				
				
			} else if (choice == 3) {
				if(login==false) {
					login=ucs.login(login);
					mClass.Menu();
				}else if(login==true){
					System.out.println("# 로그인 완료");
					mClass.Menu();
				}
			}  else if (choice == 4) {
				break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("# 중고차는 호카");
		System.out.println("1. 내차사기");
		System.out.println("2. 내차팔기");
		System.out.println("3. 관리자로그인");
		System.out.println("4. 프로그램 종료");
	}
	
	public static void userMenu1() {
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			userMenu2();
			choice = sc.nextInt();
			if (choice == 1) {
				search();
			} else if (choice == 2) {
			} else if (choice == 3) {
			} 
		}
	}
	
	public static void userMenu2() {
		System.out.println("1. 차량검색");
		System.out.println("2. 차량구매");
		System.out.println("3. 뒤로가기");
	}
	
	public static void search() {
		DB_Connection db = new DB_Connection();
		ArrayList<usedCarVo> arrayListCar;
		
		int choice = 0;
		int searchNum = 0;
		int min, max = 0;
		int cnt = 0;
		String searchWord = "";

		Scanner sc = new Scanner(System.in);

		while (true) {
			if(cnt == 0) {
			System.out.println("# 검색조건을 선택하세요.");
			} else {
				System.out.println("# 검색 추가조건을 선택하세요.");
			}
			System.out.println("1. 차량종류");
			System.out.println("2. 모델명");
			System.out.println("3. 제조사");
			System.out.println("4. 가격");
			System.out.println("5. 연식");
			System.out.println("6. 주행거리");
			System.out.println("7. 연료");
			System.out.println("8. 색상");
			System.out.println("9. 검색종료");
			choice = sc.nextInt();

			if (cnt == 0) {

				switch (choice) {
				case 1: // 차량종류 검색
					System.out.println("# 차량종류를 선택하세요.");
					System.out.println("1. 경차");
					System.out.println("2. SUV");
					System.out.println("3. 준중형");
					System.out.println("4. 중형");
					System.out.println("5. 대형");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "경차";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "SUV";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "준중형";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "중형";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "대형";
						db.searchByCarType(searchWord);
						cnt++;
						break;
					}
					break;
				case 2: // 모델명 검색
					System.out.println("# 모델명을 입력하세요.");
					System.out.println("ex) 쏘나타, 아반떼, 그랜져 등 // 대소문자를 구분합니다.");
					searchWord = sc.next();
					db.searchByName(searchWord);
					cnt++;
					break;
				case 3: // 제조사 검색
					System.out.println("# 제조사를 선택하세요.");
					System.out.println("1. 현대");
					System.out.println("2. 기아");
					System.out.println("3. 쉐보레");
					System.out.println("4. 삼성");
					System.out.println("5. 쌍용");
					System.out.println("6. 제네시스");
					System.out.println("7. 벤츠");
					System.out.println("8. BMW");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "현대";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "기아";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "쉐보레";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "삼성";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "쌍용";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "제네시스";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 7:
						searchWord = "벤츠";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					case 8:
						searchWord = "BMW";
						db.searchByCarCompany(searchWord);
						cnt++;
						break;
					}
					break;
				case 4: // 가격 검색
					System.out.println("# 가격 범위를 입력하세요.");
					System.out.println("범위 : 0 ~ 99,999만원");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarPrice(min, max);
					cnt++;
					break;
				case 5: // 연식 검색
					System.out.println("# 연식 범위를 입력하세요.");
					System.out.println("범위 : 0000년 ~ 9999년");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarMadeYear(min, max);
					cnt++;
					break;
				case 6: // 주행거리 검색
					System.out.println("# 주행거리 범위를 입력하세요.");
					System.out.println("범위 : 0km ~ 999,999km");
					min = sc.nextInt();
					max = sc.nextInt();
					db.searchByCarDriven(min, max);
					cnt++;
					break;
				case 7: // 연료타입 검색
					System.out.println("# 연료타입을 선택하세요.");
					System.out.println("1. 가솔린");
					System.out.println("2. 디젤");
					System.out.println("3. LPG");
					System.out.println("4. 가솔린 + 전기");
					System.out.println("5. 디젤 + 전기");
					System.out.println("6. 전기");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "가솔린";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "디젤";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "LPG";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "가솔린+전기";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "디젤+전기";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "전기";
						db.searchByCarFuelType(searchWord);
						cnt++;
						break;
					}
					break;
				case 8: // 색상타입 검색
					System.out.println("# 색상타입을 선택하세요.");
					System.out.println("1. 검정색");
					System.out.println("2. 흰색");
					System.out.println("3. 은색");
					System.out.println("4. 쥐색");
					System.out.println("5. 빨간색");
					System.out.println("6. 청색");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						searchWord = "검정색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "흰색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "은색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "쥐색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "빨간색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "청색";
						db.searchByCarColor(searchWord);
						cnt++;
						break;
					case 9: // 검색종료
						System.out.println("검색을 종료합니다.");
						System.out.print("\n");
						menuWhile();
					}
					break;
				}
			} else if (cnt > 0) {
				switch (choice) {
				case 1: // 차량종류 검색
					System.out.println("# 차량종류를 선택하세요.");
					System.out.println("1. 경차");
					System.out.println("2. SUV");
					System.out.println("3. 준중형");
					System.out.println("4. 중형");
					System.out.println("5. 대형");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "경차";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "SUV";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "준중형";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "중형";
						db.listByCarType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "대형";
						db.listByCarType(searchWord);
						cnt++;
						break;
					}
					break;
				case 2: // 모델명 검색
					System.out.println("# 모델명을 입력하세요.");
					System.out.println("ex) 쏘나타, 아반떼, 그랜져 등 // 대소문자를 구분합니다.");
					searchWord = sc.next();
					db.listByCarName(searchWord);
					cnt++;
					break;
				case 3: // 제조사 검색
					System.out.println("# 제조사를 선택하세요.");
					System.out.println("1. 현대");
					System.out.println("2. 기아");
					System.out.println("3. 쉐보레");
					System.out.println("4. 삼성");
					System.out.println("5. 쌍용");
					System.out.println("6. 제네시스");
					System.out.println("7. 벤츠");
					System.out.println("8. BMW");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "현대";
						db.listByCarCompany(searchWord);
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "기아";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "쉐보레";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "삼성";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "쌍용";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "제네시스";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 7:
						searchWord = "벤츠";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					case 8:
						searchWord = "BMW";
						db.listByCarCompany(searchWord);
						cnt++;
						break;
					}
					break;
				case 4: // 가격 검색
					System.out.println("# 가격 범위를 입력하세요.");
					System.out.println("범위 : 0 ~ 99,999만원");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarPrice(min, max);
					cnt++;
					break;
				case 5: // 연식 검색
					System.out.println("# 연식 범위를 입력하세요.");
					System.out.println("범위 : 0000년 ~ 9999년");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarMadeYear(min, max);
					cnt++;
					break;
				case 6: // 주행거리 검색
					System.out.println("# 주행거리 범위를 입력하세요.");
					System.out.println("범위 : 0km ~ 999,999km");
					min = sc.nextInt();
					max = sc.nextInt();
					db.listByCarDriven(min, max);
					cnt++;
					break;
				case 7: // 연료타입 검색
					System.out.println("# 연료타입을 선택하세요.");
					System.out.println("1. 가솔린");
					System.out.println("2. 디젤");
					System.out.println("3. LPG");
					System.out.println("4. 가솔린 + 전기");
					System.out.println("5. 디젤 + 전기");
					System.out.println("6. 전기");
					choice = sc.nextInt();

					switch (choice) {
					case 1:
						searchWord = "가솔린";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "디젤";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "LPG";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "가솔린+전기";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "디젤+전기";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "전기";
						db.listByCarFuelType(searchWord);
						cnt++;
						break;
					}
					break;
				case 8: // 색상타입 검색
					System.out.println("# 색상타입을 선택하세요.");
					System.out.println("1. 검정색");
					System.out.println("2. 흰색");
					System.out.println("3. 은색");
					System.out.println("4. 쥐색");
					System.out.println("5. 빨간색");
					System.out.println("6. 청색");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						searchWord = "검정색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 2:
						searchWord = "흰색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 3:
						searchWord = "은색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 4:
						searchWord = "쥐색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 5:
						searchWord = "빨간색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					case 6:
						searchWord = "청색";
						db.listByCarColor(searchWord);
						cnt++;
						break;
					}
					break;
				case 9: // 검색종료
					System.out.println("검색을 종료합니다.");
					System.out.print("\n");
					menuWhile();
				}
			}
		}
	}
}

