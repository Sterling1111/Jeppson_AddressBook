package com.company;

/**
 * @author Sterling Jeppson
 * @version 1.0
 * @since 1.2
 *
 * purpose: This class is used to contain and provide data necessary to represent an
 * AddressEntry
 */
public class AddressEntry implements Comparable<AddressEntry>{

    /**
     * first name
     */
    private String firstName;
    /**
     * last name
     */
    private String lastName;
    /**
     * street
     */
    private String street;
    /**
     * city
     */
    private String city;
    /**
     * state
     */
    private String state;
    /**
     * zip code
     */
    private int zip;
    /**
     * phone number
     */
    private String phone;
    /**
     * email
     */
    private String email;

    /**returns an AddressEntry initialized to nothing
     *
     */
    public AddressEntry() {
        firstName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        zip = 0;
        phone = "";
        email = "";
    }

    /**returns an address entry initialized to the data in parameters provided
     *
     * @param firstName is a firstname
     * @param lastName is a listname
     * @param street is a street
     * @param city is a city
     * @param state is a state
     * @param zip is a zip code
     * @param phone is a phone number
     * @param email is an email
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, int zip, String phone, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n   " +
                street + "\n   " + city + ", " + state + " " + zip +
                "\n   " + email + "\n   " + phone;
    }

    @Override
    public int compareTo(AddressEntry other) {
        if(this.lastName.compareTo(other.lastName) != 0)
            return this.lastName.compareTo(other.lastName);
        else if(this.firstName.compareTo(other.firstName) == 0 &&
                this.city.compareTo(other.city) == 0 &&
                this.phone.compareTo(other.phone) == 0 &&
                this.state.compareTo(other.state) == 0 &&
                this.street.compareTo(other.street) == 0 &&
                this.email.compareTo(other.email) == 0 &&
                this.zip == other.zip)
            return 0;
        else
            return 1;
    }

    /**
     *
     * @param firstName is a firstname
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     *
     * @param lastName is a lastName
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     *
     * @param street is a street
     */
    public void setStreet(String street) { this.street = street; }

    /**
     *
     * @param city is a city
     */
    public void setCity(String city) { this.city = city; }

    /**
     *
     * @param state is a state
     */
    public void setState(String state) { this.state = state; }

    /**
     *
     * @param zip is a zip code
     */
    public void setZip(int zip) { this.zip = zip; }

    /**
     *
     * @param phone is a phone number
     */
    public void setPhone(String phone) { this.phone = phone; }

    /**
     *
     * @param email is an email address
     */
    public void setEmail(String email) { this.email = email; }

    /**
     *
     * @return a String which represents first name
     */
    public String getFirstName() { return firstName; }

    /**
     *
     * @return a String which represents last name
     */
    public String getLastName() { return lastName; }

    /**
     *
     * @return a String which represents street
     */
    public String getStreet() { return street; }

    /**
     *
     * @return a String which represents city
     */
    public String getCity() { return city; }

    /**
     *
     * @return a String which represents state
     */
    public String getState() { return state; }

    /**
     *
     * @return an int which represents zip code
     */
    public int getZip() { return zip; }

    /**
     *
     * @return a String which represents phone number
     */
    public String getPhone() { return phone; }

    /**
     *
     * @return a String which represents email
     */
    public String getEmail() { return email; }
}
