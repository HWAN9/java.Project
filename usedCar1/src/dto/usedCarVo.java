package dto;

public class usedCarVo {
	private String car_number;
	private String car_type;
	private String car_name;
	private String made_company;
	private int price;
	private double made_year;
	private int dis_driven;
	private String fuel_type;
	private String color;
	public usedCarVo() {
	}
	
	public usedCarVo(String car_number, String car_type, String car_name, String made_company, int price,
			double made_year, int dis_driven, String fuel_type, String color) {
		this.car_number=car_number;
		this.car_type=car_type;
		this.car_name=car_name;
		this.made_company=made_company;
		this.price=price;
		this.made_year=made_year;
		this.dis_driven=dis_driven;
		this.fuel_type=fuel_type;
		this.color=color;
	}

	public void setcar_number(String car_number) {
		this.car_number=car_number;
	}
	public String getcar_number() {
		return car_number;
	}
	public void setcar_type(String car_type) {
		this.car_type=car_type;
	}
	public String getcar_type() {
		return car_type;
	}
	public void setcar_name(String car_name) {
		this.car_name=car_name;
	}
	public String getcar_name() {
		return car_name;
	}
	public void setmade_company(String made_company) {
		this.made_company=made_company;
	}
	public String getmade_company() {
		return made_company;
	}
	public void setprice(int price) {
		this.price=price;
	}
	public int getprice() {
		return price;
	}
	public void setmade_year(double made_year) {
		this.made_year=made_year;
	}
	public double getmade_year() {
		return made_year;
	}
	public void setdis_driven(int dis_driven) {
		this.dis_driven=dis_driven;
	}
	public int getdis_driven() {
		return dis_driven;
	}
	public void setfuel_type(String fuel_type) {
		this.fuel_type=fuel_type;
	}
	public String getfuel_type() {
		return fuel_type;
	}
	public void setcolor(String color) {
		this.color=color;
	}
	public String getcolor() {
		return color;
	}
}
