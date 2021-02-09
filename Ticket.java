import java.util.*;
public class Ticket{
	private User T_O;//Ticket Owner
	private Place O_P;//Origin Place
	private Place T_P;//Terminal Place
	private Car T_C;//Ticket Car
	private Seat T_S;//Ticket Seat
	public Ticket(){
		T_O = new User();
		O_P = new Place();
		T_P = new Place();
		T_C = new Car();
		T_S = new Seat();
	}
	public void setTicket(String n,String o,String t,int c_n,String s_n){
		T_O.setUserName(n);
		O_P.setPlaceName(o);
		T_P.setPlaceName(t);
		T_C.setCarNum(c_n);
		T_S.setSeatCode(s_n);
	}
	public void setUserName(String n){
		T_O.setUserName(n);	
	}
	public void  setOPlaceName(String o){
		O_P.setPlaceName(o);
	}
	public void setTPlaceName(String t){
		T_P.setPlaceName(t);
	}
	public void setCarNum(int c_n){
		T_C.setCarNum(c_n);
	}
	public void setSeatCode(String s_n){
		T_S.setSeatCode(s_n);
	}
	public String getUserName(){
		return T_O.getUserName();	
	}
	public String getOPlaceName(){
		return O_P.getPlaceName();
	}
	public String getTPlaceName(){
		return T_P.getPlaceName();
	}
	public int getCarNum(){
		return T_C.getCarNum();
	}
	public String getSeatCode(){
		return T_S.getSeatCode();
	}
}//RESERVE SUCCESSED!! -> Chi-Hung 6 3A (Taipei - Hsinchu)

