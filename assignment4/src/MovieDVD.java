/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class creates MovieDVD objects and is a child of Media

public class MovieDVD extends Media {

    private double fileSize; // size of file in megabytes

    // designed to take string from file. requires specific string format
    public MovieDVD(String string) {
        super(string); // super to pass string to parent

        // parse substring with specific index for file size
        this.fileSize = Double
                .parseDouble(string.substring(string.indexOf("size") + 7, string.indexOf(",", string.indexOf("size"))));
    }

    // this method returns fileSize attribute values
    public double getFileSize() {
        // params: none
        // user inputs: none
        // return value: fileSize attribute value

        return fileSize;
    }

    // this method sets fileSize attribute values
    public void setFileSize(double fileSize) {
        // params: new fileSize value
        // user inputs: none
        // return value: none

        this.fileSize = fileSize;
    }

    // this method displays object information in string format
    public String toString() {
        // params: none
        // user inputs: none
        // return value: string with object information

        return "MovieDVD [id = " + getId() + ", title = " + getTitle() + ", year = " + getYear() + ", size = "
                + getFileSize() + ", available = " + getIsAvailable() + "]";
    }
}