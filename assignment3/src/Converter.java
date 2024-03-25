/* Paul Fitch
 * CMIS 242-7360
 * Project 3
 * 17 Nov 2022
 * 
 * This program creates a GUI for users to convert miles -> kilometers
 * and fareneheit -> celcius
 */

// this is the parent class of DistanceConverter and TemperatureConverter
public class Converter {

    // attributes
    private double input; // reads input from GUI

    // overloaded constructors
    // this constructor creates instances of converter objects if no parameter is
    // present
    public Converter() {
        // params: none
        // user inputs: none
        // return value: none

        // assign Not a Number
        this.input = Double.NaN;
    }

    // this constructor creates instances of converter objects if a parameter is
    // present
    public Converter(double input) {
        // params: input
        // user inputs: none in method, accepts user input as parameter
        // return value: none

        // assign parameter value as input value
        this.input = input;
    }

    // setters
    // setter setInput
    // this method allows classes to set input attribute value
    public void setInput(double input) {
        // params: new input value
        // user input: none
        // return value: none

        this.input = input;
    }

    // getters
    // getter getInput
    // this method allows classes to see input attribute value
    public double getInput() {
        // params: none
        // user inputs: none
        // return value: input attribute value

        return input;
    }

    // convert method
    // this method returns input attributes, as per instruction in assignment pdf
    public double convert() {
        // params: none
        // user inputs: none
        // return value: input attribute value
        return input;
    }
}