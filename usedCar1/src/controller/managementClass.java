package controller;

import java.util.Scanner;
import dao.DB_Connection;
import service.usedCarService;

public class managementClass {

	public static void Menu() {
		System.out.print("# 관리자 기능 \n");
		System.out.print("1. 구매접수현황 \n");
		System.out.print("2. 판매접수현황 \n");
		System.out.print("3. 차량정보입력 \n");
		System.out.print("4. 차량정보수정 \n");
		System.out.print("5. 차량정보삭제 \n");
		System.out.print("6. 최초화면으로 이동 \n");

		String car_number = "";
		String car_type = "";
		String car_name = "";
		String made_company = "";
		int price = 0;
		double made_year = 0.0;
		int dis_driven = 0;
		String fuel_type = "";
		String color = "";

		int choice = 0;

		menuClass mc = new menuClass();
		DB_Connection car = new DB_Connection();
		Scanner sc = new Scanner(System.in);
		usedCarService ucs = new usedCarService(); 
		main mainc = new main();
		
		while (true) {
			choice = sc.nextInt();
			if (choice == 1) {
				ucs.wishBuyList();
				Menu();
			}
			if (choice == 2) {
				ucs.wishSellList();
				Menu();
			}
			if (choice == 3) {
				System.out.print("1. 차량 번호 입력 : ");
				car_number = sc.next();
				System.out.print("2. 차량 종류 입력 : \n");
				car_type = sc.next();
				System.out.print("3. 차량 모델명 입력 : ");
				car_name = sc.next();
				System.out.print("4. 제조사 입력 : ");
				made_company = sc.next();
				System.out.print("5. 가격 입력 : // 형식 : 0000만원");
				price = sc.nextInt();
				System.out.print("6. 연식 입력 : // 형식 : 0000년형");
				made_year = sc.nextDouble();
				System.out.print("7. 주행거리 입력 : // 형식 : 000,000Km ");
				dis_driven = sc.nextInt();
				System.out.print("8. 연료 종류 입력 : ");
				fuel_type = sc.next();
				System.out.print("9. 색상 입력 : ");
				color = sc.next();

				car.InsertusedCar(car_number, car_type, car_name, made_company, price, made_year, dis_driven, fuel_type,
						color);
				System.out.println("# 차량정보 입력이 완료되었습니다.");
				Menu();
			}
			if (choice == 4) {
				System.out.print("# 차량 번호 입력 : ");
				System.out.println("// 오입력 시 차량번호 미출력)");
				car_number = sc.next();
				car.SearchByNo(car_number);

				System.out.println("# 위 정보가 맞습니까?");
				System.out.println("1. 네");
				System.out.println("2. 아니오");

				choice = sc.nextInt();

				if (choice == 1) {
					System.out.println("# 수정할 항목을 선택하세요.");
					System.out.println("1. 차량 종류");
					System.out.println("2. 모델명");
					System.out.println("3. 제조사");
					System.out.println("4. 가격");
					System.out.println("5. 연식");
					System.out.println("6. 주행거리");
					System.out.println("7. 연료 종류");
					System.out.println("8. 색상");
					System.out.println("9. 수정 종료");

					choice = sc.nextInt();

					if (choice == 1) {
						System.out.println("# 수정할 차량종류를 선택하세요. ");
						mc.car_type();
					
						choice = sc.nextInt();

						if (choice == 1) {
							car_type = "경차";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 2) {
							car_type = "SUV";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 3) {
							car_type = "준중형";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 4) {
							car_type = "중형";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}
						if (choice == 5) {
							car_type = "대형";
							car.UpdateusedCarbyCartype(car_number, car_type);
						}

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 2) {
						System.out.print("# 수정할 모델명을 입력하세요 : ");
						car_name = sc.nextLine();
						car_name = sc.nextLine();
						car.UpdateusedCarbyCarname(car_number, car_name);

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 3) {
						System.out.println("# 수정할 제조사를 선택하세요. : ");
						System.out.println("1. 현대");
						System.out.println("2. 기아");
						System.out.println("3. 쉐보레");
						System.out.println("4. 삼성");
						System.out.println("5. 쌍용");
						System.out.println("6. 제네시스");
						System.out.println("7. 벤츠");
						System.out.println("8. BMW");

						choice = sc.nextInt();

						if (choice == 1) {
							made_company = "현대";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 2) {
							made_company = "기아";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 3) {
							made_company = "쉐보레";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 4) {
							made_company = "삼성";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 5) {
							made_company = "쌍용";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 6) {
							made_company = "제네시스";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 7) {
							made_company = "벤츠";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}
						if (choice == 8) {
							made_company = "BMW";
							car.UpdateusedCarbyCompany(car_number, made_company);
						}

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 4) {
						System.out.print("# 수정할 가격을 입력하세요. : ");
						price = sc.nextInt();

						car.UpdateusedCarbyPrice(car_number, price);

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 5) {
						System.out.print("# 수정할 연식을 입력하세요. : ");
						made_year = sc.nextDouble();

						car.UpdateusedCarbyYear(car_number, made_year);

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 6) {
						System.out.print("# 수정할 주행거리를 입력하십시오. : ");
						dis_driven = sc.nextInt();

						car.UpdateusedCarbyDis(car_number, dis_driven);

						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 7) {
						System.out.println("# 수정할 연료종류를 선택하세요. ");
						System.out.println("1. 가솔린");
						System.out.println("2. 디젤");
						System.out.println("3. LPG");
						System.out.println("4. 가솔린+전기");
						System.out.println("5. 디젤+전기");
						System.out.println("6. 전기");
						
						choice=sc.nextInt();
						
						if (choice == 1) {
							fuel_type = "가솔린";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 2) {
							fuel_type = "디젤";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 3) {
							fuel_type = "LPG";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 4) {
							fuel_type = "가솔린+전기";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 5) {
							fuel_type = "디젤+전기";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						if (choice == 6) {
							fuel_type = "전기";
							car.UpdateusedCarbyCompany(car_number, fuel_type);
						}
						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 8) {
						System.out.println("# 수정할 색상을 선택하세요.");
						System.out.println("1. 검정색");
						System.out.println("2. 흰색");
						System.out.println("3. 은색");
						System.out.println("4. 쥐색");
						System.out.println("5. 빨간색");
						System.out.println("6. 청색");
						
						choice=sc.nextInt();
						
						if (choice == 1) {
							color = "검정색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 2) {
							color = "흰색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 3) {
							color = "은색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 4) {
							color = "쥐색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 5) {
							color = "빨간색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						if (choice == 6) {
							color = "청색";
							car.UpdateusedCarbyColor(car_number, color);
						}
						System.out.println("# 다음과 같이 수정되었습니다.");
						car.SearchByNo(car_number);
						Menu();
					}
					if (choice == 9) {
						Menu();
					}
				}
				if (choice == 2) {
					Menu();
				}
			}
			if (choice == 5) {
				System.out.print("# 차량 번호 입력:");
				car_number = sc.next();
				car.SearchByNo(car_number);
			
				System.out.println("위의 차량 정보를 삭제하겠습니까?");
				System.out.println("// 오입력 시 차량번호 미출력)");
				System.out.println("1. 네");
				System.out.println("2. 아니오");
				System.out.println("3. 초기화면으로");

				choice = sc.nextInt();

				if (choice == 1) {
					car.DeleteusedCar(car_number);
					Menu();
				}
				if (choice == 2) {
					Menu();
				}
				if (choice == 3) {
					managementClass.Menu();
				}
			}
			if (choice == 6) {
				mainc.menuWhile();
			}
		}
	}
}