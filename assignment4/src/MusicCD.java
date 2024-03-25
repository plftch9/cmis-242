/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class creates MusicCD objects and is a child of Media

public class MusicCD extends Media {

    private int minutes; // length of cd in minutes

    // designed to take string from file. requires specific string format
    public MusicCD(String string) {
        super(string); // super to pass string to parent

        // parse substring with specific index for minutes
        this.minutes = Integer
                .parseInt(string.substring(string.indexOf("minutes") + 10,
                        string.indexOf(",", string.indexOf("minutes"))));
    }

    // this method returns minutes attribute values
    public int getMinutes() {
        // params: none
        // user inputs: none
        // return value: minutes attribute value

        return minutes;
    }

    // this method sets minutes attribute values
    public void setMinutes(int minutes) {
        // params: new numChapter value
        // user inputs: none
        // return value: none

        this.minutes = minutes;
    }

    // this method calculates the fee of Music objects
    public double calculateFee() {
        // params: none
        // user inputs: none
        // return value: fee for Musiccd

        // fee = miutes * .02, if cd published this year add $1
        double fee = (minutes * .02);
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

        return "MusicCD [id = " + getId() + ", title = " + getTitle() + ", year = " + getYear() + ", minutes = "
                + getMinutes() + ", available = " + getIsAvailable() + "]";
    }
}