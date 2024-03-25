/* Paul Fitch
 * CMIS 242-7360
 * Project 3
 * 17 Nov 2022
 * 
 * This program creates a GUI for users to convert miles -> kilometers
 * and fareneheit -> celcius
 */

// this is a child class of converter and handles temperature conversion
public class TemperatureConverter extends Converter {

    // overloaded constructors
    // this constructor creates instances of TemperatureConverter objects if no
    // parameter is present
    public TemperatureConverter() {
        // params: none
        // user inputs: none
        // return value: none

        // assign not a number from parent class
        super();
    }

    // this constructor creates instances of TemperatureConverter objects is a
    // parameter is present
    public TemperatureConverter(double input) {
        // params: input
        // user inputs: none in method, accepts user input as parameter
        // return value: none

        // assign input value from parent class
        super(input);
    }

    // create method: convert
    // this method performs calculations for farenheit -> celcius
    public double convert() {
        // params: none
        // user inputs: none
        // return value: celcius from farenheit

        // C = ((F-32)*5)/9
        double c = ((getInput() - 32) * 5) / 9;
        return c;
    }
}
