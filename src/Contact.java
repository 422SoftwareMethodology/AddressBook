//package addressbook;

import java.util.Comparator;

public class Contact implements Comparator<Contact>, Comparable<Contact> {
	private String _firstName;
	private String _lastName;
	private String _phoneNumber;
	private String _address;
	private String _city;
	private String _state;
	private String _email;
	private int _zip;
	
	public Contact (String firstName,String lastName, String phoneNumber, 
                    String address, String city, String state, String email, int zip) {
            
            set_firstName(firstName);
            set_lastName(lastName);
            set_phoneNumber(phoneNumber);
            set_address(address);
            set_city(city);
            set_state(state);
            set_email(email);
            set_zip(zip);
        
        }
        
	public String get_firstName() {
		return _firstName;
	}

	public void set_firstName(String firstName) {
		this._firstName = firstName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public void set_lastName(String lastName) {
		this._lastName = lastName;
	}

	public String get_phoneNumber() {
		return _phoneNumber;
	}

	public void set_phoneNumber(String phoneNumber) {
		this._phoneNumber = phoneNumber;
	}

	public String get_address() {
		return _address;
	}

	public void set_address(String address) {
		this._address = address;
	}

	public String get_city() {
		return _city;
	}

	public void set_city(String city) {
		this._city = city;
	}

	public String get_state() {
		return _state;
	}

	public void set_state(String state) {
		this._state = state;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String email) {
		this._email = email;
	}

	public int get_zip() {
		return _zip;
	}

	public void set_zip(int zip) {
		this._zip = zip;
	}

	@Override
	public int compareTo(Contact c) {
		return (this._lastName).compareTo(c._lastName);
	}

	@Override
	public int compare(Contact c1, Contact c2) {
		return (c1._zip - c2._zip);
	}
}