package uk.ac.dundee.computing.yek.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.regex.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Encoder;
import uk.ac.dundee.computing.yek.model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class user {
	
	public user(){
	}

	/** 
	 * Encryption algorithm source:
	 * http://sanjaal.com/java/tag/simple-java-tutorial-password-encryption/
	 * 
	 * Algorithm types: 
 		SHA    UTF-8    
		SHA-1  UTF-16   
		MD5    UTF-8    
		MD5    UTF-16
	 */
	public static synchronized String encrypt(String plaintext) {
        MessageDigest msgDigest = null;
        String hashValue = null;
        String algorithm = "SHA-1";
        String encoding = "UTF-16";
        try {
            msgDigest = MessageDigest.getInstance(algorithm);
            msgDigest.update(plaintext.getBytes(encoding));
            byte rawByte[] = msgDigest.digest();
            hashValue = (new BASE64Encoder()).encode(rawByte);
 
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm Exists");
        } catch (UnsupportedEncodingException e) {
            System.out.println("The Encoding Is Not Supported");
        }
        return hashValue;
    }
	
	/** 
	 * Encryption algorithm source:
	 * http://sanjaal.com/java/tag/simple-java-tutorial-password-encryption/
	 */
	public static String encryptPass(String plainTextPassword) {
		try {	
			DESKeySpec keySpec = new DESKeySpec("My Password encryptor phrase".getBytes("UTF8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey key = keyFactory.generateSecret(keySpec);
			sun.misc.BASE64Encoder base64encoder = new BASE64Encoder();
	
			// ENCODE plainTextPassword String
			byte[] cleartext = plainTextPassword.getBytes("UTF8");      
	
			Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread safe
			cipher.init(Cipher.ENCRYPT_MODE, key);
			String encrypedPwd = base64encoder.encode(cipher.doFinal(cleartext));
			// now you can store it 
			return encrypedPwd;
			
		} catch (Exception e) {
			return null;
		}

    }
	
	public static boolean verifyEmail(String emailAddress){  
		   String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		   CharSequence inputStr = emailAddress;   
		   Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		   Matcher matcher = pattern.matcher(inputStr);  
		   return matcher.matches();  
	}
	
	@SuppressWarnings("finally")
	public static boolean checkNameUnique(Connection con, String user){
       	boolean isValid = false;
       	ResultSet resultSet = null;
   	
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="SELECT * FROM user WHERE Username='" + user + "';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery); 
        		
       		if (resultSet!=null) isValid = true;
       		
       	}catch(Exception ex){
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return isValid;
       	}
	}
	
	@SuppressWarnings("finally")
	public static UserStore getUser(Connection con, String user){
		UserStore myUser = new UserStore();
       	ResultSet resultSet = null;
   	
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="SELECT * FROM user WHERE Username='" + user + "';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		if (resultSet.first()) {
       			myUser.setUsername(resultSet.getString("Username"));
       			myUser.setPassWord(resultSet.getString("Password"));
       			myUser.setEmail(resultSet.getString("Email"));
       		}
       		
       	}catch(Exception ex){
       		ex.printStackTrace();
       		return null;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		ex.printStackTrace();
   	    		return null;
   	    	}
   	    	return myUser;
       	}
	}
	
	@SuppressWarnings("finally")
	public static boolean updatePassword(Connection con, String user, String pass){
		com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="UPDATE user SET Password='"+pass+"' WHERE Username='"+user+"';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement)con.createStatement();
       		statement.execute(sqlQuery);
       	}catch(Exception ex){
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return true;
       	}
	}
	
	@SuppressWarnings("finally")
	public static boolean updateAccount(Connection con, String user, String old, String newP, String email){
		com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="UPDATE user SET Password='"+newP+"' AND Email='"+email+"' WHERE Username='"+user+"' AND Password='"+old+"';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement)con.createStatement();
       		statement.execute(sqlQuery);
       	}catch(Exception ex){
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return true;
       	}
	}
	
    @SuppressWarnings("finally")
   	public static LinkedList<UserStore> getUsers(Connection con){
       	LinkedList<UserStore> userList =  new LinkedList<UserStore>();
       	UserStore user = null;
       	ResultSet resultSet = null;
   	
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="SELECT * FROM user;";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		while (resultSet.next() ){
       			user= new UserStore();
       			user.setUsername(resultSet.getString("Username"));
       			user.setPassWord(resultSet.getString("Password"));
       			user.setEmail(resultSet.getString("Email"));
       			userList.add(user);
        		}
       	}catch(Exception ex){
       		return null;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return null;
   	    	}
   	    	return userList;
       	}
       }
    
	@SuppressWarnings("finally")
	public static boolean sendUser(Connection con, UserStore user){
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="INSERT INTO user (Username, Password, Email) VALUES ('"+user.getUsername()+"', '"+user.getPassWord()+"', '"+user.getEmail()+"');";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement)con.createStatement();
       		statement.execute(sqlQuery);
       	}catch(Exception ex){
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return true;
       	}
       }

    @SuppressWarnings("finally")
	public static LinkedList<UserStore> getLogin(Connection con, UserStore user){
       	LinkedList<UserStore> userList =  new LinkedList<UserStore>();
       	UserStore temp = null;
       	ResultSet resultSet = null;
   	
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="SELECT * FROM user WHERE Username='" + user.getUsername() + "' AND Password='" + user.getPassWord() + "';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		while (resultSet.next() ){
       			temp= new UserStore();
       			temp.setUsername(resultSet.getString("Username"));
       			temp.setPassWord(resultSet.getString("Password"));
       			temp.setEmail(resultSet.getString("Email"));
       			userList.add(temp);
        		}
       		
       	}catch(Exception ex){
       		return null;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return null;
   	    	}
   	    	return userList;
       	}
       }
    
    @SuppressWarnings("finally")
	public static boolean checkLogin(Connection con, UserStore user){
       	ResultSet resultSet = null;
       	
       	boolean logged = false;
       	com.mysql.jdbc.Statement statement=null;
       	String sqlQuery="SELECT * FROM user WHERE Username='" + user.getUsername() + "' AND Password='" + user.getPassWord() + "';";
       	System.out.println("User Query " + sqlQuery);
       	try {
       		
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		statement = (com.mysql.jdbc.Statement) con.createStatement();
        		resultSet=statement.executeQuery(sqlQuery);  		
       		 	if(resultSet.first()) logged = true;
       		
       	}catch(Exception ex){
       		return false;
       	}
       	finally{
   	    	try{
   	    		statement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return false;
   	    	}
   	    	return logged;
       	}
       }
}

