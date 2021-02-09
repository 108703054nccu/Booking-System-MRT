import java.util.*;
import java.io.*;
public class main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		SystemKernal SK = new SystemKernal();
		boolean isInCommand = false;
		boolean isPlaceNum = false;
		int CommandNum = -1;//1 -> Transinformation 2-> Request
		int index = 0;
		int C_O = index;//Coomand Origin
		int C_T = index;//Command Terminal	
		String s1, Command, Data;
		Data = new String("");
		while(input.hasNextLine() && !((s1= input.nextLine()).equals(""))){
			if(s1.charAt(0) == '='){
				index = s1.indexOf('(');
				if(index != -1) {
					C_O = index+1;
				}
				index = s1.lastIndexOf(')');
				if(index != -1) {
					C_T = index;
				}
				Command = s1.substring(C_O,C_T);
				if(Command.indexOf("INFORMATION") !=-1){
					CommandNum = 1;
					isPlaceNum = true;
				}
				if(Command.indexOf("REQUEST") != -1){
					CommandNum = 2; 
				}
				if(Command.indexOf("BEGIN") != -1){
					isInCommand = true;
					s1 = "";
					continue;
				}
				if(Command.indexOf("END") != -1){
					isInCommand = false;
					Data = "";
					CommandNum = -1;
				}
				Command ="";
			}
			if(isInCommand == true){
				if(CommandNum == 1){
					if(isPlaceNum == true){
						SK.setPlaceNum(Integer.valueOf(s1));
						s1 = "";
						isPlaceNum = false;
						continue;
					}
					SK.setPlaceList(s1);
				}
				if(CommandNum == 2){
					SK.switchthing(s1);
				}
			}
			s1="";
		}
	}
}
