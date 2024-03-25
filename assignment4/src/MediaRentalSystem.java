/* Paul Fitch
 * CMIS 242-7360
 * Final Project
 * 5 Dec 2022
 * 
 * This program simulates renting media online. This program reads and writes files
 */

// this class greates the GUI, stores file directories

// import resources
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MediaRentalSystem extends JFrame implements ActionListener {

    // initialize GUI components
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem load;
    private JMenuItem find;
    private JMenuItem rent;
    private JMenuItem quit;

    // initialize necessary variables
    private Manager mediaManager = null; // will be used to instantiate new Manager object
    private String dirString; // will store directory path

    // create method: constructAndShowGui
    // this method arranges GUI components in a JFrame and displays the window
    public void constructAndShowGUI() {
        // params: none
        // user inputs: none
        // return value: none

        // GUI component objects
        frame = new JFrame("Welcome to Media Rental System"); // main window fram
        menuBar = new JMenuBar(); // menu bar, primary user interaction
        menu = new JMenu("Menu");
        load = new JMenuItem("Load Media Objects..."); // load menu button
        find = new JMenuItem("Find Media Objects..."); // find menu button
        rent = new JMenuItem("Rent Media Objects..."); // rent menu button
        quit = new JMenuItem("Quit"); // quit menu button

        // component setup
        frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Program has safely exited");
                // quit program
                System.exit(0);
            }
        });
        // add action listeners to buttons
        load.addActionListener(this);
        find.addActionListener(this);
        rent.addActionListener(this);
        quit.addActionListener(this);

        // GUI layout
        menu.add(load);
        menu.addSeparator();
        menu.add(find);
        menu.addSeparator();
        menu.add(rent);
        menu.addSeparator();
        menu.add(quit);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        frame.setSize(400, 400);

        // show GUI
        frame.setVisible(true);

    }

    // action listener
    // this method will get the source of events and call the appropriate button
    // handler
    public void actionPerformed(ActionEvent e) {
        // params: event
        // user inputs: none in method, parameter is user generated event
        // return value: none

        Object source = e.getSource(); // get the source of event

        // call corresponding button handler based on event source
        if (source.equals(load)) {
            loadHandler();
        } else if (source.equals(find)) {
            findHandler();
        } else if (source.equals(rent)) {
            rentHandler();
        } else if (source.equals(quit)) {
            quitHandler();
        }
    }

    // button handlers
    // create method: loadHandler
    // this method will be called when load registers an event
    // this method will create file choser objects, update dirString to store
    // directory path, and instantiate Manager class
    public void loadHandler() {
        // params: none
        // user inputs: file(s) directory
        // return value: none

        // instantiate JFileChooser
        JFileChooser file = new JFileChooser("."); // current directory
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // make only directories visible / selectable
        file.setSelectedFile(null); // no file initially chosen
        File selectedDirectory = null; // initialize File to store user selected directory

        // open file dialog
        int returnVal = file.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedDirectory = file.getSelectedFile();
            try {

                dirString = selectedDirectory.toString(); // store directory as string
                mediaManager = new Manager(dirString); // pass directory to instantiate Manager object

                // message dialog to show loaded files
                JOptionPane.showMessageDialog(this, mediaManager.displayAll());
            }

            // if no files are in directory...
            catch (FileNotFoundException e) {

                // ...dispaly dialog
                JOptionPane.showMessageDialog(this, "No Files in Directory");
                return;
            }
        }

    }

    // create method: findHandler
    // this method will be called when find registers an event
    // this method will display Media objects with title that matches user input
    public void findHandler() {
        // params: none
        // user inputs: title to be searched
        // return value: none

        // prevent user from searching with no loaded directory
        if (mediaManager == null) {
            JOptionPane.showMessageDialog(this, "No directory has been loaded");
            return;
        }

        // gather input
        String input = JOptionPane.showInputDialog("Input title of media");

        if (input != null) {
            // if user has input something
            if (input.length() > 0) {
                // statement to ease user experience
                // standardizes input to remove spaces and set chars to lower case
                String title = input.replaceAll("\\s", "").toLowerCase();
                JOptionPane.showMessageDialog(this, mediaManager.findMediaByTitle(title)); // pass to find, display
                                                                                           // results
            }

            // if user has input nothing
            if (input.length() == 0) {
                JOptionPane.showMessageDialog(this, "No input entered");
            }
        } else {
            return;
        }

    }

    // create method: rentHandler
    // this method will be called when rent registers an event
    // this method passes relevent information to Manager class to rent Media
    public void rentHandler() {
        // params: none
        // user inputs: ID of rented media
        // return value: none

        // initialize intInput
        int inputInt; // will parse string to gather int input

        // prevent user from searching with no loaded directory
        if (mediaManager == null) {
            JOptionPane.showMessageDialog(this, "No directory has been loaded");
            return;
        }

        // gather input
        String input = JOptionPane.showInputDialog("Input Id of desired media");

        if (input != null) {
            // if user inputs nothing
            if (input.length() == 0) {
                JOptionPane.showMessageDialog(this, "No input entered");
            }
            // if user inputs something
            else {
                // convert sting of numbers to int
                inputInt = Integer.parseInt(input);

                JOptionPane.showMessageDialog(this, mediaManager.rentMedia(inputInt)); // pass to rent, display results
                try {
                    // attempt to update file of media object
                    mediaManager.newMediaFile(dirString);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error updating file");
                }
            }
        } else {
            return;
        }

    }

    // Create method: quitHandler
    // this method will be called when quit registers an event
    // this method will close the program
    public void quitHandler() {
        // params: none
        // user inputs: none
        // return value: none

        System.out.println("Program has safely exited");
        // quit program
        System.exit(0);
    }

    // main method
    // this method calls GUI when program starts
    public static void main(String[] args) {

        // main class instantiation
        MediaRentalSystem enabler = new MediaRentalSystem();

        // call the GUI
        enabler.constructAndShowGUI();

    }
}