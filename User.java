import java.util.*;
public class User{
	private String UserName;
        //User Data
	public User(){
		UserName = "";
	}	
	public void setUserName(String name){
		UserName = name;
	}
	public void getUserName(){
		return UserName;
	}
}
