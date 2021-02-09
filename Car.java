import java.util.*;
public class Car{
	private int Car_Num;
	private Seat[][] Seat_Table;
	public Car(){
		Car_Num  = 0;
		Seat_Table = new Seat[5][50];// 4 Lines, 50 Rows
		for(int i = 0; i<5; i++)
			for(int j = 0; j<50; j++)
				Seat_Table[i][j] = new Seat();
	}
	public void setCarNum(int n){
		Car_Num = n;
	}
	public int getCarNum(){
		return Car_Num;
	}
	public boolean getCar_SeatStatus(int LineNum,char RowWord){
		return Seat_Table[(int)(RowWord-'A')][LineNum-1].getSeatStatus();
	}	
	public void changeCar_SeatStatus(int LineNum,char RowWord){
		Seat_Table[(int)(RowWord-'A')][LineNum-1].changeSeatStatus();
	}
}
