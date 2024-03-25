/* Paul Fitch
 * CMIS 242-7360
 * Project 3
 * 17 Nov 2022
 * 
 * This program creates a GUI for users to convert miles -> kilometers
 * and fareneheit -> celcius
 */

// this class creates the GUI

// import swing and awt resources
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIConverter extends JFrame implements ActionListener {

    // GUI Components
    private JFrame frame;
    private JPanel panel;
    private JButton distanceButton;
    private JButton temperatureButton;
    private JButton exitButton;

    // create method: constructAndShowGui
    // this method arranges GUI components on a JFrame and displays the JFrame
    // window
    public void constructAndShowGUI() {
        // params: none
        // user inputs: none
        // return value: none

        // GUI component objects
        frame = new JFrame("Welcome to Converter"); // main window frame
        panel = new JPanel(new BorderLayout()); // panel to arrande items in window
        distanceButton = new JButton("Distance Converter"); // button for distance
        temperatureButton = new JButton("Temperature Converter"); // button for temperature
        exitButton = new JButton("Exit"); // button for exit

        // GUI component setup
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set window close
        // add action listeners to buttons
        distanceButton.addActionListener(this);
        temperatureButton.addActionListener(this);
        exitButton.addActionListener(this);

        // GUI layout
        frame.add(panel); // add panel to main window frame
        panel.add(distanceButton, BorderLayout.WEST); // add button to left side of panel
        panel.add(temperatureButton, BorderLayout.EAST); // add button to right side of panel
        panel.add(exitButton, BorderLayout.PAGE_END); // add button to bottom of panel
        // in the assignment pdf the distance button is slightly larger
        distanceButton.setPreferredSize(new Dimension(350, 100)); // set size of distance button

        // show GUI
        frame.pack();
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
        if (source.equals(distanceButton)) {
            distanceButtonHandler();
        } else if (source.equals(temperatureButton)) {
            temperatureButtonHandler();
        } else if (source.equals(exitButton)) {
            exitButtonHandler();
        }

    }

    // create method: temperatureInput
    // this method displays an input dialog and collects user input for temperature
    // conversion
    public TemperatureConverter temperatureInput() {
        // params: none
        // user inputs: farenheit temperature to be converted to celcius
        // return value: TemperatureConverter object with input, or NaN

        // display dialog box, gather user input for farenheit temperature
        String tempIn = JOptionPane.showInputDialog("Input temperature to convert");

        // create and return appropriate object
        if ((tempIn.length() > 0) && (tempIn != null)) {
            return new TemperatureConverter(Double.parseDouble(tempIn));
        } else
            return new TemperatureConverter();

    }

    // create method: distanceInput
    // this method displays an input dialog and collects user input for distance
    // conversion
    public DistanceConverter distanceInput() {
        // params: none
        // user inputs: miles distance to be converted to kilometers
        // return value: DistanceConverter object with input, or NaN

        // display dialog box, gather user input for miles distance
        String distIn = JOptionPane.showInputDialog("Input miles distance to convert");

        // create and return appropriate object
        if ((distIn.length() > 0) && (distIn != null)) {
            return new DistanceConverter(Double.parseDouble(distIn));
        } else
            return new DistanceConverter();

    }

    // button handlers
    // create method: temperatureButtonHandler
    // this method wil be called when temperatureButton registers an event
    // this method will create TemperatureConverter objects and display converted
    // temperatures
    public void temperatureButtonHandler() {
        // params: none
        // user inputs: none
        // return value: none

        // create TemperatureConverter object
        // TemperatureConverter tempCon = new TemperatureConverter(temperatureInput());
        TemperatureConverter tempCon = temperatureInput();

        // create message box with conversion calculation
        JOptionPane.showMessageDialog(null, tempCon.getInput() + " F equals " + tempCon.convert() + " C");
    }

    // create method: distanceButtonHandler
    // this method will be called when distanceButton registers an event
    // this method will create DistanceConverter objects and display converted
    // distances
    public void distanceButtonHandler() {
        // params: none
        // user inputs: none
        // return value: none

        // create DistanceConverter object
        DistanceConverter distCon = distanceInput();

        // create message box with conversion calculation
        JOptionPane.showMessageDialog(null, distCon.getInput() + " Miles equals " + distCon.convert() + " Kilometers");
    }

    // create method: exitButtonHandler
    // this method will be called when exitButton registers an event
    // this method will close the program
    public void exitButtonHandler() {
        // params: none
        // user inputs: none
        // return value: none

        // exit program
        System.out.println("The program has safely exited");
        System.exit(0);
    }

    // main method
    // this method runs when program is started, calling the GUI
    public static void main(String[] args) {

        // main class instantiation
        GUIConverter enabler = new GUIConverter();

        // call the GUI
        enabler.constructAndShowGUI();

    }
}