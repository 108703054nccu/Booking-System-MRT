import java.util.*;
public class Seat{
	private String Seat_Code;
	//Seat Data
	private boolean isEmpty;
	public Seat(){
		Seat_Code = "";
		isEmpty = true;
	}
	public void setSeatCode(String code){
		Seat_Code = code;
	}
	public String getSeatCode(){
		return Seat_Code;
	}
	public void changeSeatStatus(){
		isEmpty = !isEmpty;
	}
	public boolean getSeatStatus(){
		return isEmpty;
	}
}
