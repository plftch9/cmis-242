/* Paul Fitch
 * CMIS 242-7360
 * Project 3
 * 17 Nov 2022
 * 
 * This program creates a GUI for users to convert miles -> kilometers
 * and fareneheit -> celcius
 */

// this is a child of Converter and handles distance conversion
public class DistanceConverter extends Converter {

    // overloaded constructors
    // this constructor creates instances of DistanceConverter objects if no
    // parameter is present
    public DistanceConverter() {
        // params: none
        // user inputs: none
        // return value: none

        // assign Not a Number from parent class
        super();
    }

    // this constructor creates instances of DistanceConverter objects if a
    // parameter is present
    public DistanceConverter(double input) {
        // params: input
        // user inputs: none in method, accepts user input as parameter
        // return value: none

        // assign input value from parent class
        super(input);
    }

    // create method: convert
    // this method performs calculations for miles -> kilometers
    public double convert() {
        // params: none
        // user inputs: none
        // return value: kilometers from miles

        // KM = M * 1.609
        double km = (getInput() * 1.609);
        return km;
    }
}
