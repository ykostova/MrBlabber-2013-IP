package uk.ac.dundee.computing.yek.model;

public class CountryStore {
	
	private int CountryID;
	private String CountryName;
	private int PhoneCode;

	public CountryStore() {
		CountryID = 0;
		CountryName = "";
		PhoneCode = 0;
	}

	public int getCountryID() {
		return CountryID;
	}

	public void setCountryID(int countryID) {
		CountryID = countryID;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public int getPhoneCode() {
		return PhoneCode;
	}

	public void setPhoneCode(int phoneCode) {
		PhoneCode = phoneCode;
	}
}
