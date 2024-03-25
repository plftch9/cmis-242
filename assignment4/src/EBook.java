/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class creates EBook objects and is a child of Media

public class EBook extends Media {

    private int numChapters; // chapters in the book

    // designed to take string from file. requires specific string format
    public EBook(String string) {
        super(string); // super to pass string to parent

        // parse substring with specific index for chapters
        this.numChapters = Integer
                .parseInt(string.substring(string.indexOf("chapters") + 11,
                        string.indexOf(",", string.indexOf("chapters"))));
    }

    // this method returns numChapters attribute values
    public int getNumChapters() {
        // params: none
        // user inputs: none
        // return value: numChapters attribute value
        return numChapters;
    }

    // this method sets numChapter attribute values
    public void setNumChapters(int numChapters) {
        // params: new numChapter value
        // user inputs: none
        // return value: none

        this.numChapters = numChapters;
    }

    // this method calculates the fee of Ebook objects
    public double calculateFee() {
        // params: none
        // user inputs: none
        // return value: fee for Ebook

        // fee = chapters * .1, if book published this year add $1
        double fee = (numChapters * 0.1);
        if (getYear() == 2022) {
            fee++;
        }
        return fee;
    }

    // this method displays object information in string format
    public String toString() {
        // params: none
        // user inputs: none
        // return value: string with object information

        return "EBook [id = " + getId() + ", title = " + getTitle() + ", year = " + getYear() + ", chapters = "
                + getNumChapters() + ", available = " + getIsAvailable() + "]";
    }
}