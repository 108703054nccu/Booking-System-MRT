import java.util.*;

public class SystemKernal{
	private int PlaceNum;
	private String Command;
	private ArrayList<Place> PlaceList;
	//Car Seat pic
	public SystemKernal(){
		PlaceNum = 0;
		Command = "";
		PlaceList = new ArrayList<>(); 
	}
	public void setPlaceNum(int pn){
		PlaceNum = pn;
	}
	public void setPlaceList(String PlaceString){
		int next_index;
		int index;
		next_index = 0;
		index = 0;
		for(int i = 0; i<PlaceNum; i++){
			if(i+1 == 5) 
				index = PlaceString.length();
			else 
				index = PlaceString.indexOf(',',next_index);
			if(index != -1) {
				Place Store = new Place();
				if(i == 0){
					Store.setPlaceName(PlaceString.substring(0,index));
					PlaceList.add(Store);
				}
				else{
					Store.setPlaceName(PlaceString.substring(next_index+1,index));
					PlaceList.add(Store);
				}
			}	
			else{
				PlaceList.clear();
				break;
			}
			next_index = index+1;
		}
		System.out.println("Successs to Create Place List");
		next_index = 0;
		index = 0;
	}
	public void switchthing(String all_data){
		int index_space;
		index_space = 0;
		if(all_data.indexOf('\t') != -1)
			index_space = all_data.indexOf('\t');
		if(all_data.substring(0,index_space) == "RESERVE")
			reserveCommand(all_data.substring(index_space+1,all_data.length()));
		if(all_data.substring(0,index_space) == "CANCEL")
			cancelCommand(all_data.substring(index_space+1,all_data.length()));
		if(all_data.substring(0,index_space) == "CHECK")
			checkCommand(all_data.substring(index_space+1,all_data.length()));

	}
	public void reserveCommand(String c_data){
		 int index_name;
		 int index_O_P;//Origin Place
		 int index_T_P;//Terminal Place
		 int index_T_N;//Ticket Number
		 int index_C_S;//Car Seat
		
	}
	public void cancelCommand(String c_data){;}
	public void checkCommand(String c_data){;}
	public int getPlaceNum(){return PlaceNum;}
	public void ShowPlaceList(){
		System.out.print("List:");
		for(int i = 0; i<PlaceNum; i++){
			Place Store = PlaceList.get(i);
			System.out.print(" "+Store.getPlaceName());
		} 
		System.out.println();
	}

}
