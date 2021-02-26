import java.util.*;

public class SystemKernal{
	private String Command;
	private int index_name = 0;
	private int index_O_P = 0;//Origin Place
	private int index_T_P = 0;//Terminal Place
	private int index_T_N = 0;//Ticket Number
	private int index_C_S = 0;//Car Seat
	private int index_C_S_last = 0; //Car Seat Next
	private PlaceList PL;
	private CarSeatTable CST;

	public SystemKernal(){
		index_name = 0;
		index_O_P = 0;
		index_T_P = 0;
		index_T_N = 0;
		index_C_S = 0;
		index_C_S_last = 0;
		Command = "";
		PL = new PlaceList();
		CST = new CarSeatTable();
	}
	public void allIndexClear(){
		index_name = 0;
		index_O_P = 0;
		index_T_P = 0;
		index_T_N = 0;
		index_C_S = 0;
		index_C_S_last = 0;
	}
	public void setPlaceNum(int p_n){
		PL.setPlaceNum(p_n);
	}
	public void setPlaceList(String p_s){
		PL.setPlaceList(p_s);
	}
	public void reserveCommand(String c_data){
		int Ticket_Num = 0;
		if(c_data.indexOf(',') != -1)
			index_name = c_data.indexOf(',');
		if(c_data.indexOf(',',index_name+2) != -1)
			index_O_P = c_data.indexOf(',',index_name+2);
		if(c_data.indexOf(',',index_O_P+2) != -1)
			index_T_P = c_data.indexOf(',',index_O_P+2);
		if(c_data.indexOf(',',index_T_P+2) != -1)
			index_T_N = c_data.indexOf(',',index_T_P+2);
		String U_N = c_data.substring(0,index_name);
		String O_P = c_data.substring(index_name+2,index_O_P);
		String T_P = c_data.substring(index_O_P+2,index_T_P);

		if(PL.isInPlaceList(O_P) == false || PL.isInPlaceList(T_P) == false){
			allIndexClear();
			return ;
		}
		Ticket_Num = Integer.valueOf(c_data.substring(index_T_P+2,index_T_N));
		index_C_S = index_T_N;
		index_C_S_last = index_C_S;
		for(int i = 0; i<Ticket_Num; i++){
			index_C_S_last = index_C_S+2;
			if(i+1 <Ticket_Num){
				if(c_data.indexOf(',',index_C_S+2) != -1 )
					index_C_S = c_data.indexOf(',',index_C_S+2);
			}
			else
				index_C_S = c_data.length();
			if(CST.getSeatStatus(c_data.substring(index_C_S_last,index_C_S))){
				CST.changeSeatStatus(c_data.substring(index_C_S_last,index_C_S));
				System.out.println("RESERVE SUCCESSED!! -> "+U_N+" "+c_data.substring(index_C_S_last,index_C_S)+" ("+O_P+" - "+T_P+")");
			}
		}
		allIndexClear();
	}
	public void cancelCommand(String c_data){
		if(c_data.indexOf(',') != -1)
			index_name = c_data.indexOf(',');
		if(c_data.indexOf(',',index_name+2) != -1)
			index_O_P = c_data.indexOf(',',index_name+2);
		if(c_data.indexOf(',',index_O_P+2) != -1)
			index_T_P = c_data.indexOf(',',index_O_P+2);
		String U_N = c_data.substring(0,index_name);
		String O_P = c_data.substring(index_name+2,index_O_P);
		String T_P = c_data.substring(index_O_P+2,index_T_P);

		if(PL.isInPlaceList(O_P) == false || PL.isInPlaceList(T_P) == false){
			allIndexClear();
			return ;
		}
		if(CST.getSeatStatus(c_data.substring(index_T_P+2,c_data.length())) == false){
                                CST.changeSeatStatus(c_data.substring(index_T_P+2,c_data.length())); 
				System.out.println("CANCELLATION SUCCESSED!! "+c_data.substring(index_T_P+2,c_data.length())+" ("+O_P+" - "+T_P+")");
                }
		allIndexClear();
	}
	public void checkCommand(String c_data){
		if(c_data.indexOf(',') != -1)
                        index_name = c_data.indexOf(',');
                String U_N = c_data.substring(0,index_name);
		if(CST.getSeatStatus(c_data.substring(index_name+2,c_data.length())) == false){
				System.out.println("check -> "+U_N+"--"+c_data.substring(index_name+2,c_data.length()));
                }
                allIndexClear();
	}

	public void switchthing(String all_data){
		int index_space;
		index_space = 0;
		if(all_data.indexOf(32,1) != -1)
			index_space = all_data.indexOf(32,1);
		String Command = all_data.substring(0,index_space);
		if(Command.equals("RESERVE"))
			reserveCommand(all_data.substring(index_space+1,all_data.length()));
		if(Command.equals("CANCEL"))
			cancelCommand(all_data.substring(index_space+1,all_data.length()));
		if(Command.equals("CHECK"))
			checkCommand(all_data.substring(index_space+1,all_data.length()));
		Command ="";
		index_space = 0;
	}
	public void FlowControl(){
		//Start System
		//Start Page upload
		//Get Choice
		//Gointo Chocie
		//--->Loop---->//Get Command
			//|--->//EXECUTE Command
			//|--->//wait some time jump over the get
	}

}
