/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class manages reading and writing files, storing media objects, and displaying objects stored

// import resources
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Manager {

    // initialize list
    private ArrayList<Media> inventory;

    // default constructor, creates empty list
    public Manager() {

        inventory = new ArrayList<Media>();
    }

    // constructor, creates and populates list
    public Manager(String directory) throws FileNotFoundException {
        // params: file path directory
        // user inputs: none
        // return value: none

        // instantiate
        inventory = new ArrayList<Media>(); // instantiate array list of media objects
        File path = new File(directory); // instantiate file object with directory

        // create new list of files in directory
        File files[] = path.listFiles();
        // throw exception if directory is empty
        if (files.length == 0) {
            throw new FileNotFoundException();
        }

        // call recurrsive method to populate list
        digDirectoryRecurrsive(files, 0);

    }

    // create recurrsive method: digDirectoryRecurrsive
    // this method will dig through a directory for subfolders and populate
    // arraylist with all files found
    private void digDirectoryRecurrsive(File[] arr, int level) {
        // params: file array, level of directory
        // user inputs: none
        // return value: none

        // initialize
        Scanner fileScan;
        Media inventoryItem = null;

        // for loop to iterate file array
        for (File file : arr) {

            // if array item is a file
            if (file.isFile()) {
                // if the file is from eBooks subfoler
                if (file.getPath().contains("eBooks")) {
                    try {
                        // scan contents of file
                        fileScan = new Scanner(file);
                        String lineFromFile = fileScan.nextLine(); // store text as string

                        // create new EBook object using info from file
                        inventoryItem = new EBook(lineFromFile);
                        inventory.add(inventoryItem); // append object to list

                    } catch (FileNotFoundException e) {
                        System.out.println("Error has occured loading files");
                    }
                }
                // if file is from movieDVDs subfolder
                if (file.getPath().contains("movieDVDs")) {

                    try {
                        // scan contents of file
                        fileScan = new Scanner(file);
                        String lineFromFile = fileScan.nextLine(); // store text as string

                        // create new MovieDVD object using info from file
                        inventoryItem = new MovieDVD(lineFromFile);
                        inventory.add(inventoryItem); // append object to list

                    } catch (FileNotFoundException e) {
                        System.out.println("Error has occured loading files");
                    }
                }
                // if file is from musicCDs subfolder
                if (file.getPath().contains("musicCDs")) {

                    try {
                        // scan contents of file
                        fileScan = new Scanner(file);
                        String lineFromFile = fileScan.nextLine(); // store text as string

                        // create new MusicCD object using info from file
                        inventoryItem = new MusicCD(lineFromFile);
                        inventory.add(inventoryItem);

                    } catch (FileNotFoundException e) {
                        System.out.println("Error has occured loading files");
                    }
                }
                // if array item is a subfolder
            } else if (file.isDirectory()) {
                file.getName();

                // recur using info from next folder
                digDirectoryRecurrsive(file.listFiles(), level++);
            }

        }
    }

    // create method: displayAll
    // this method returns all text from all objects
    public String displayAll() {
        // params: none
        // return value: all text from all objects
        // user inputs: none

        // instantiate string builder
        StringBuilder allText = new StringBuilder(); // stores all text from all objects as one stringbuiler
        String allTextString;

        // for loop to iterate array list
        for (Media inventoryItem : inventory) {
            // append object's toString method to string builder
            allText.append(inventoryItem.toString() + "\n");
        }

        // "convert" string builder to string value
        allTextString = allText.toString();
        // System.out.println(allTextString);

        return allTextString;
    }

    // create method: findMediaByTitle
    // this method searches title attributes in media objects from list for matching
    // values
    public String findMediaByTitle(String title) {
        // params: title to match with attribute
        // user inputs: none
        // return value: all text from objects with titles matching parameter

        // instantiate string builder
        StringBuilder matchingTitles = new StringBuilder(); // stores all text from objects with matching tile as one
                                                            // string builder
        String matchingTitlesString = "Media not found"; // default return value (if no matches are found)

        // if parameter passes is not null
        if (title != null) {
            // for loop to iterate array list
            for (Media inventoryItem : inventory) {
                // if title attribute matches parameter
                if (inventoryItem.getTitle().replaceAll("\\s", "").toLowerCase().contains(title)) {
                    matchingTitles.append(inventoryItem.toString() + "\n\n"); // append string builder
                    matchingTitlesString = matchingTitles.toString(); // "convert" stringbuilder to string value
                }

            }
        }

        return matchingTitlesString;
    }

    // create method: findMediaById
    // this method searches id attributes in media objects from list for matching
    // values, and sets isAvailable to false
    public Media findMediaById(int id) throws FileNotFoundException {
        // params: id to match with attribute
        // user inputs: none
        // return value: media object with matching id attribute, or null

        Media returnItem = null;

        // for loop to iterate array list
        for (Media inventoryItem : inventory) {

            // if id attribute matches parameter and media is available for rent
            if (inventoryItem.getId() == id && inventoryItem.getIsAvailable()) {

                // return the item
                returnItem = inventoryItem;
                inventoryItem.setIsAvalable(false); // remove from rentable objects

            }
            // if id attribute matches parameter and media is not available for rent
            else if (inventoryItem.getId() == id && !inventoryItem.getIsAvailable()) {

                throw new FileNotFoundException();
            }
        }

        return returnItem;
    }

    // create method: rentMedia
    // this method attempts to utilize findMediaById method to simulate removing the
    // media object from inventory
    public String rentMedia(int id) {
        // params: id of media object to be rented
        // user inputs: none
        // return value: string containing media object information, or appropriate
        // error message

        // instantiate string builder
        StringBuilder rentSelection = new StringBuilder();
        Media rentedMedia = null; // initialize to null to catch exception when necessary
        String rentConfirmation = "ID not found"; // default error message

        try {

            // will stay null or will copy attributes of object matching id
            rentedMedia = findMediaById(id);

            rentSelection.append("Selected item:\n\n");
            rentSelection.append(rentedMedia.toString());
            rentSelection.append("\n\nRental fee: ");
            rentSelection.append(String.format("%.2f", rentedMedia.calculateFee()));
            rentConfirmation = rentSelection.toString(); // replace error message with object info
            return rentConfirmation;
        } catch (NullPointerException e) { // thrown if rentedMedia stays null
            return rentConfirmation;
        } catch (FileNotFoundException e) { // thrown by findMediaById method if media is unavailable
            rentConfirmation = "That media is already rented";
            return rentConfirmation;
        }

    }

    // create method: newMediaFile
    // this method updates and saves files with information from media objects to
    // the appropriate subfolder
    public void newMediaFile(String directory) throws IOException {
        // params: user selected directory
        // user inputs: none
        // return value: none

        // initialize
        PrintWriter editor;
        OutputStream out;
        File updatedFile;

        // for loop to iterate inc=ventory array by index
        for (int i = 0; i < inventory.size(); i++) {

            if (inventory.get(i) instanceof EBook) { // save to ebooks folder
                updatedFile = new File(directory + "/eBooks", inventory.get(i).getTitle() + ".txt"); // file name will
                                                                                                     // be title .txt
                out = new FileOutputStream(updatedFile);
                editor = new PrintWriter(updatedFile);
                editor.println(inventory.get(i).toString()); // prints object.toString method to file

                // flush / close
                editor.flush();
                editor.close();
                out.close();
            }
            if (inventory.get(i) instanceof MovieDVD) { // saves to moviedvds folder
                updatedFile = new File(directory + "/movieDVDs", inventory.get(i).getTitle() + ".txt"); // file name
                                                                                                        // will be title
                                                                                                        // .txt
                out = new FileOutputStream(updatedFile);
                editor = new PrintWriter(updatedFile);
                editor.println(inventory.get(i).toString()); // prints object.toString method to file

                // flush / close
                editor.flush();
                editor.close();
                out.close();
            }

            if (inventory.get(i) instanceof MusicCD) { // saves to musiccds folder
                updatedFile = new File(directory + "/musicCDs", inventory.get(i).getTitle() + ".txt"); // file name will
                                                                                                       // be title .txt
                out = new FileOutputStream(updatedFile);
                editor = new PrintWriter(updatedFile);
                editor.println(inventory.get(i).toString()); // prints object.toString method to file

                // flush / close
                editor.flush();
                editor.close();
                out.close();
            }
        }
    }

}