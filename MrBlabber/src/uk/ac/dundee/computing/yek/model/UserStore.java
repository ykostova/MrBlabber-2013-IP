package uk.ac.dundee.computing.yek.model;

public class UserStore {
	
	private String Username;
	private String PassWord;
	private String Email;
	
	public UserStore() {
		Username = "";
		PassWord = "";
		Email = "";
	}
	
	public void setUsername(String name){
		Username=name;
	}
	
	public String getUsername(){
		return Username;
	}
	
	public void setPassWord(String pass){
		PassWord=pass;
	}
	
	public String getPassWord(){
		return PassWord;
	}
	
	public void setEmail(String mail){
		Email=mail;
	}
	
	public String getEmail() {
		return Email;
	}
	

}
