package uk.ac.dundee.computing.yek.controller;

import java.sql.ResultSet;
import java.util.LinkedList;

import uk.ac.dundee.computing.yek.model.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class person {

	public person(){
	}

	@SuppressWarnings("finally")
	public static boolean sendPerson(Connection con, PersonStore user){

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery="INSERT INTO person (FirstName, LastName, City, CountryID, PhoneNumber, Website, Photo, Header, Username, Bio) VALUES ('"+
				user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getCity()+"', "+user.getCountryID()+", "+user.getPhoneNumber()+", '"+
				user.getWebsite()	+"', '"+user.getPhoto()+"', '"+user.getHeader()+"', '"+user.getUsername()+"', '"+user.getBio()+"');";

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			System.out.println("User Query " + sqlQuery);
			statement = (com.mysql.jdbc.Statement) con.createStatement();
			statement.execute(sqlQuery);

		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		finally{
			try{
				statement.close();
				con.close();
			}catch(Exception ex){
				ex.printStackTrace();
				return false;
			}
			return true;
		}
	}


	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getAllPeople(Connection con){
		LinkedList<PersonStore> personList =  new LinkedList<PersonStore>();
		PersonStore person = null;
		ResultSet resultSet = null;

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery="SELECT * FROM person ;";
		System.out.println("person Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  		
			while (resultSet.next() ){
				person= new PersonStore();
				person.setPersonID(resultSet.getInt("PersonID"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setCity(resultSet.getString("City"));
				person.setCountryID(resultSet.getInt("CountryID"));
				person.setCountryName(resultSet.getString("CountryName"));
				person.setPhoneCode(resultSet.getInt("PhoneCode"));
				person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
				person.setWebsite(resultSet.getString("Website"));
				person.setPhoto(resultSet.getString("Photo"));
				person.setHeader(resultSet.getString("Header"));
				person.setUsername(resultSet.getString("Username"));
				person.setBio(resultSet.getString("Bio"));
				personList.add(person);
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
			return personList;
		}
	}

	//get person by person ID
	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getPersonDetails(Connection con, int personID){
		LinkedList<PersonStore> personList =  new LinkedList<PersonStore>();
		PersonStore person = null;
		ResultSet resultSet = null;

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery="SELECT * FROM person LEFT JOIN country ON person.CountryID = country.CountryID WHERE person.PersonID=" + personID + ";";
		System.out.println("person Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);

			while (resultSet.next() ){
				person= new PersonStore();
				person.setPersonID(resultSet.getInt("PersonID"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setCity(resultSet.getString("City"));
				person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
				person.setWebsite(resultSet.getString("Website"));
				person.setPhoto(resultSet.getString("Photo"));
				person.setHeader(resultSet.getString("Header"));
				person.setUsername(resultSet.getString("Username"));
				person.setBio(resultSet.getString("Bio"));
				person.setCountryName(resultSet.getString("CountryName"));
				person.setPhoneCode(resultSet.getInt("PhoneCode"));
				personList.add(person);
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
			return personList;
		}
	}

	//get person by username
	@SuppressWarnings("finally")
	public static PersonStore getPersonByUsername(Connection con, String username){
		PersonStore person = null;
		ResultSet resultSet = null;

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery="SELECT * FROM person LEFT JOIN country ON person.CountryID = country.CountryID WHERE person.Username='" + username + "';";
		System.out.println("person Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (Statement)con.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			System.out.println(resultSet.toString());
			person = new PersonStore();

			resultSet.next();

			System.out.println(resultSet.getInt("PersonID"));
			System.out.println(resultSet.getString("FirstName"));
			System.out.println(resultSet.getString("LastName"));
			System.out.println(resultSet.getString("City"));
			System.out.println(resultSet.getInt("CountryID"));
			System.out.println(resultSet.getString("CountryName"));
			System.out.println(resultSet.getInt("PhoneCode"));
			System.out.println(resultSet.getInt("PhoneNumber"));
			System.out.println(resultSet.getString("Website"));
			System.out.println(resultSet.getString("Photo"));
			System.out.println(resultSet.getString("Header"));
			System.out.println(resultSet.getString("Username"));
			System.out.println(resultSet.getString("Bio"));

			person.setPersonID(resultSet.getInt("PersonID"));
			person.setFirstName(resultSet.getString("FirstName"));
			person.setLastName(resultSet.getString("LastName"));
			person.setCity(resultSet.getString("City"));
			person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
			person.setWebsite(resultSet.getString("Website"));
			person.setPhoto(resultSet.getString("Photo"));
			person.setHeader(resultSet.getString("Header"));
			person.setUsername(resultSet.getString("Username"));
			person.setBio(resultSet.getString("Bio"));
			person.setCountryID(resultSet.getInt("CountryID"));
			person.setCountryName(resultSet.getString("CountryName"));
			person.setPhoneCode(resultSet.getInt("PhoneCode"));

			System.out.println("QUERY EXECUTED");
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		finally{
			try{
				statement.close();
				con.close();
			}catch(Exception ex){
				return null;
			}
			return person;
		}
	}

	//Update a person with Bean PersonStore
	@SuppressWarnings("finally")
	public static boolean updatePerson(Connection con, PersonStore update){
		com.mysql.jdbc.Statement statement=null;
		String sqlQuery="UPDATE person SET FirstName='"+update.getFirstName()+"', LastName='"+ update.getLastName()+"', City='"+update.getCity()
				+"', PhoneNumber='"+update.getPhoneNumber()+"', Website='"+update.getWebsite()+"', Photo='"+update.getPhoto()
				+"', Header='"+update.getHeader()+"', Bio='"+update.getBio()+"'  WHERE Username='"+update.getUsername()+"';";
		System.out.println("User Query " + sqlQuery);
		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			statement = (com.mysql.jdbc.Statement) con.createStatement();
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
	public static LinkedList<PersonStore> getPersonFriend(Connection con, LinkedList<FriendshipStore> relationshipList){
		LinkedList<PersonStore> personList =  new LinkedList<PersonStore>();
		PersonStore person = null;
		ResultSet resultSet = null;

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery;

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			for(int i=0; i<relationshipList.size(); i++) {
				sqlQuery="SELECT * FROM person LEFT JOIN country ON person.CountryID = country.CountryID WHERE person.PersonID=" + relationshipList.get(i).getFollower() + ";";
				System.out.println("person Query " + sqlQuery);
				statement = (Statement) con.createStatement();
				resultSet=statement.executeQuery(sqlQuery);  	

				resultSet.next();

				person= new PersonStore();
				person.setPersonID(resultSet.getInt("PersonID"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setCity(resultSet.getString("City"));
				person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
				person.setWebsite(resultSet.getString("Website"));
				person.setPhoto(resultSet.getString("Photo"));
				person.setHeader(resultSet.getString("Header"));
				person.setUsername(resultSet.getString("Username"));
				person.setBio(resultSet.getString("Bio"));
				person.setCountryName(resultSet.getString("CountryName"));
				person.setPhoneCode(resultSet.getInt("PhoneCode"));
				personList.add(person);
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
			return personList;
		}
	}

	@SuppressWarnings("finally")
	public static int getIDbyUsername(Connection con, String username){
		int personID =  0;
		ResultSet resultSet = null;

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery ="SELECT PersonID FROM person WHERE person.Username='" + username + "';";

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			System.out.println("person Query " + sqlQuery);
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  
			System.out.println(resultSet.toString());
			resultSet.next();

			personID = (resultSet.getInt("PersonID"));
			System.out.println(personID);

		}catch(Exception ex){
			return -1;
		}
		finally{
			try{
				statement.close();
				con.close();
			}catch(Exception ex){
				return -1;
			}
			return personID;
		}
	  }
		
	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getSearchByUsername(Connection con, String username){
		PersonStore person = null;
		ResultSet resultSet = null;
		LinkedList<PersonStore> search = new LinkedList<PersonStore>();

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery ="SELECT * FROM person WHERE person.Username='" + username + "';";

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			System.out.println("person Query " + sqlQuery);
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  

			while (resultSet.next() ){
				person= new PersonStore();
				person.setPersonID(resultSet.getInt("PersonID"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setCity(resultSet.getString("City"));
				person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
				person.setWebsite(resultSet.getString("Website"));
				person.setPhoto(resultSet.getString("Photo"));
				person.setHeader(resultSet.getString("Header"));
				person.setUsername(resultSet.getString("Username"));
				person.setBio(resultSet.getString("Bio"));
				search.add(person);
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
			return search;
		}
	}
	
	@SuppressWarnings("finally")
	public static LinkedList<PersonStore> getSearchByName(Connection con, String name){
		PersonStore person = null;
		ResultSet resultSet = null;
		LinkedList<PersonStore> search = new LinkedList<PersonStore>();

		com.mysql.jdbc.Statement statement=null;
		String sqlQuery ="SELECT * FROM person WHERE person.FirstName='" + name + "' OR person.FirstName='" + name + "';";

		try {
			if(con.isClosed()) con = DBconnection.getConnectionInstance();
			System.out.println("person Query " + sqlQuery);
			statement = (Statement) con.createStatement();
			resultSet=statement.executeQuery(sqlQuery);  

			while (resultSet.next() ){
				person= new PersonStore();
				person.setPersonID(resultSet.getInt("PersonID"));
				person.setFirstName(resultSet.getString("FirstName"));
				person.setLastName(resultSet.getString("LastName"));
				person.setCity(resultSet.getString("City"));
				person.setPhoneNumber(resultSet.getInt("PhoneNumber"));
				person.setWebsite(resultSet.getString("Website"));
				person.setPhoto(resultSet.getString("Photo"));
				person.setHeader(resultSet.getString("Header"));
				person.setUsername(resultSet.getString("Username"));
				person.setBio(resultSet.getString("Bio"));
				search.add(person);
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
			return search;
		}
	}
}

