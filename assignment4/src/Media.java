/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class creates Media objects, and provides get / set methods to child classes

public abstract class Media {

    // attributes
    private int id;
    private String title;
    private int year;
    private boolean isAvialable;

    // designed to take string from file. requires specific string format
    public Media(String string) {
        // parse substringstring with specific index for id
        this.id = Integer
                .parseInt(string.substring(string.indexOf("id") + 5, string.indexOf(",", string.indexOf("id"))));

        // parse substring with specific index for title
        this.title = string.substring(string.indexOf("title") + 8, (string.indexOf(",", string.indexOf("title"))));

        // parse substring with specific index for year
        this.year = Integer
                .parseInt(string.substring(string.indexOf("year") + 7, string.indexOf(",", string.indexOf("year"))));

        // parse substring with specific index for boolean value
        this.isAvialable = Boolean
                .parseBoolean(string.substring(string.indexOf("available") + 12, string.indexOf("]")));

    }

    // create method calculateFee
    // this method calculates the fee of media objects
    public double calculateFee() {
        // params: none
        // user inputs: none
        // return value: fee to rent media

        // flat $3.50
        double fee = 3.5;
        return fee;
    }

    // setters
    // this method sets id attribute values
    public void setId(int id) {
        // params: new id value
        // user inputs: none
        // return value: none

        this.id = id;
    }

    // this method sets title attribute values
    public void setTitle(String title) {
        // params: new title value
        // user inputs: none
        // return value: none

        this.title = title;
    }

    // this method sets year attribute values
    public void setYear(int year) {
        // params: new year value
        // user inputs: none
        // return value: none

        this.year = year;
    }

    // this method sets isAvailable attribute values
    public void setIsAvalable(boolean isAvialable) {
        // params: new isAvailable value
        // user inputs: none
        // return value: none

        this.isAvialable = isAvialable;
    }

    // getters
    // this method returns id attribute values
    public int getId() {
        // params: none
        // user inputs: none
        // return value: id attribute value

        return id;
    }

    // this method returns title attribute values
    public String getTitle() {
        // params: none
        // user inputs: none
        // return value: title attribute value
        return title;
    }

    // this method returns year attribute values
    public int getYear() {
        // params: none
        // user inputs: none
        // return value: year attribute value

        return year;
    }

    // this method returns isAvailable attribute values
    public boolean getIsAvailable() {
        // params: none
        // user inputs: none
        // return value: isAvailable attribute value

        return isAvialable;
    }
}