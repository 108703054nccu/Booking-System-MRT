import java.util.*;
public class CarSeatTable{
	private Car[] Car_Seat_Pic; 
	private int index_space;
	public CarSeatTable(){
		Car_Seat_Pic = new Car[15];
		for(int i = 0; i<15; i++)Car_Seat_Pic[i] = new Car();
		index_space = 0;
	}
	public void changeSeatStatus(String C_S_Code){
		//System.out.println(C_S_Code);
		
		if(C_S_Code.indexOf(32,0) != -1)
                        index_space = C_S_Code.indexOf(32,0);
                int Car_n = Integer.valueOf(C_S_Code.substring(0,index_space));
                char word = C_S_Code.charAt(C_S_Code.length()-1);
                int Seat_n = Integer.valueOf(C_S_Code.substring(index_space+1,C_S_Code.length()-1));
                Car_Seat_Pic[Car_n-1].changeCar_SeatStatus(Seat_n,word);//true is Empty
	}
	public boolean getSeatStatus(String C_S_Code){
		//System.out.println(C_S_Code);
		//return true;
		
		if(C_S_Code.indexOf(32,0) != -1)
			index_space = C_S_Code.indexOf(32,0);
		int Car_n = Integer.valueOf(C_S_Code.substring(0,index_space));	
		char word = C_S_Code.charAt(C_S_Code.length()-1);
		int Seat_n = Integer.valueOf(C_S_Code.substring(index_space+1,C_S_Code.length()-1));
		//Car Store = Car_Seat_Pic[Car_n-1];
		return Car_Seat_Pic[Car_n-1].getCar_SeatStatus(Seat_n,word);//true is Empty
		//return true;
	}
}
