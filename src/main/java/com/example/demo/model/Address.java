package com.example.demo.model;

/**
 * Created by Kalidass Mahalingam on 11/8/2017.
 */
public class Address {

    private String streetOne;
    private String streetTwo;
    private String state;
    private String postCode;
    private String country;

    /**
     * Gets street one.
     *
     * @return the street one
     */
    public String getStreetOne() {
        return streetOne;
    }

    /**
     * Sets street one.
     *
     * @param streetOne the street one
     */
    public void setStreetOne(String streetOne) {
        this.streetOne = streetOne;
    }

    /**
     * Gets street two.
     *
     * @return the street two
     */
    public String getStreetTwo() {
        return streetTwo;
    }

    /**
     * Sets street two.
     *
     * @param streetTwo the street two
     */
    public void setStreetTwo(String streetTwo) {
        this.streetTwo = streetTwo;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets post code.
     *
     * @param postCode the post code
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return "Address{" +
                "streetOne='" + streetOne + '\'' +
                ", streetTwo='" + streetTwo + '\'' +
                ", state='" + state + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
