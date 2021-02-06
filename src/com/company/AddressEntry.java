package com.company;

public class AddressEntry implements Comparable<AddressEntry>{

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String phone;
    private String email;

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

    public String toString() {
        return firstName + " " + lastName + "\n   " +
                street + "\n   " + city + ", " + state + " " + zip +
                "\n   " + email + "\n   " + phone;
    }

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

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setStreet(String street) { this.street = street; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setZip(int zip) { this.zip = zip; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getStreet() { return street; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public int getZip() { return zip; }

    public String getPhone() { return phone; }

    public String getEmail() { return email; }
}
