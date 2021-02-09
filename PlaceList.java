import java.util.*;
public class PlaceList{
	private int PlaceNum;
	private ArrayList<Place> PlaceList;
	public PlaceList(){
		PlaceNum = 0;
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
	public void ShowPlaceList(){
		System.out.print("List:");
		for(int i = 0; i<PlaceNum; i++){
			Place Store = PlaceList.get(i);
			System.out.print(" "+Store.getPlaceName());
		} 
		System.out.println();
	}
	public boolean isInPlaceList(String Place_Name){
		for(int i = 0; i<PlaceNum; i++){
			Place Store = PlaceList.get(i);
			if(Place_Name.equals(Store.getPlaceName()) == true)
				return true;
			else
				continue;
		}
		return false;
	}
	public int getPlaceNum(){
		return PlaceNum;
	}

}
