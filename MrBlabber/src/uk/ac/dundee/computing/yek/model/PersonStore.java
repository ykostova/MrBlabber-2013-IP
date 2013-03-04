package uk.ac.dundee.computing.yek.model;

public class PersonStore {
	
	private int PersonID;
	private String FirstName;
	private String LastName;
	private String City;
	private int CountryID;
	private String CountryName;
	private int PhoneNumber;
	private int PhoneCode;
	private String Website;
	private String Photo;
	private String Header;
	private String Username;
	private String Bio;
	private long date;
	
	
	public PersonStore(){
		PersonID = 0;
		FirstName = "";
		LastName = "";
		City = "";
		CountryID = 288;
		CountryName = "";
		PhoneNumber = 0;
		PhoneCode = 0;
		Website = "";
		Photo = "";
		Header = "";
		Username = "";
		Bio = "";
	}
	
	public void setFirstName(String name){
		FirstName=name;
	}
	
	public String getFirstName(){
		return FirstName;
	}
	
	public void setLastName(String name){
		LastName=name;
	}
	
	public String getLastName(){
		return LastName;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getCountryID() {
		return CountryID;
	}

	public void setCountryID(int countryID) {
		CountryID = countryID;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String WEbsite) {
		Website = WEbsite;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	public int getPersonID() {
		return PersonID;
	}

	public void setPersonID(int personID) {
		PersonID = personID;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String country) {
		CountryName = country;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public int getPhoneCode() {
		return PhoneCode;
	}

	public void setPhoneCode(int phoneCode) {
		PhoneCode = phoneCode;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
}
