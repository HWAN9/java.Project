package dto;

public class wishBuyListVo {
	private String wishBuyUser_name;
	private String phone_Num;
	private String car_Number;
	private Double made_year;
	private int dis_driven;
	private String car_name;
	
	public wishBuyListVo(String car_Number,
			String wishSellUser_name, String phone_Num) {
		this.wishBuyUser_name=wishBuyUser_name;
		this.phone_Num=phone_Num;
		this.car_Number=car_Number;

	}
	
	public void setwishBuyUser_name(String wishBuyUser_name) {
		this.wishBuyUser_name=wishBuyUser_name;
	}
	public String getwishBuyUser_name() {
		return wishBuyUser_name;
	}
	public void setphone_Num(String phone_Num) {
		this.phone_Num=phone_Num;
	}
	public String getphone_Num() {
		return phone_Num;
	}
	public void setcar_Number(String car_Number) {
		this.car_Number=car_Number;
	}
	public String getcar_Number() {
		return car_Number;
	}
	public void setmade_year(Double made_year) {
		this.made_year=made_year;
	}
	public Double getmade_year() {
		return made_year;
	}
	public void setdis_driven(int dis_driven) {
		this.dis_driven=dis_driven;
	}
	public int getdis_driven() {
		return dis_driven;
	}
	public void setcar_name(String car_name) {
		this.car_name=car_name;
	}
	public String getcar_name() {
		return car_name;
	}
}
