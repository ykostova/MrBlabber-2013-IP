package uk.ac.dundee.computing.yek.controller;

import java.sql.ResultSet;
import java.util.LinkedList;

import uk.ac.dundee.computing.yek.model.CountryStore;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class country {
	private LinkedList<CountryStore> clist;
	
	public country(){
		this.setClist(new LinkedList<CountryStore> ());
	}
	
	public country(LinkedList<CountryStore> list){
		this.setClist(list);
	}

    @SuppressWarnings("finally")
   	public static LinkedList<CountryStore> getAllCountries(Connection con){
       	LinkedList<CountryStore> countryList =  new LinkedList<CountryStore>();
       	CountryStore country=null;
       	ResultSet resultSet=null;
   	
       	PreparedStatement preconstatement=null;
       	String sqlQuery="SELECT * FROM country ORDER BY CountryName ASC;";
       	System.out.println("Country Query" + sqlQuery);
       	try {
       		if(con.isClosed()) con = DBconnection.getConnectionInstance();
       		preconstatement = (PreparedStatement) con.prepareStatement(sqlQuery);
        		resultSet=preconstatement.executeQuery();  		
       		while (resultSet.next() ){
       			country= new CountryStore();
       			country.setCountryID(resultSet.getInt("CountryID"));
       			country.setCountryName(resultSet.getString("CountryName"));
       			country.setPhoneCode(resultSet.getInt("PhoneCode"));
       			countryList.add(country);
        		}
       	}catch(Exception ex){
       		return null;
       	}
       	finally{
   	    	try{
   	    		preconstatement.close();
   	    		con.close();
   	    	}catch(Exception ex){
   	    		return null;
   	    	}
   	    	return countryList;
       	}
       }

	public LinkedList<CountryStore> getClist() {
		return clist;
	}

	public void setClist(LinkedList<CountryStore> clist) {
		this.clist = clist;
	}
}

