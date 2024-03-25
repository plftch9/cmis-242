/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 20 Oct 2022
 * 
 * This program will create three weight objects, then find the minimun, maximum, and average wieght of the objects
 */

// create weight class
public class Weight {

    // constant, always 16 oz in pound
    private final int OUNCES_IN_A_POUND = 16;

    // attributes: pounds, ounces
    private int pounds;
    private double ounces;

    // constructor
    public Weight(int pounds, double ounces) {
        this.pounds = pounds;
        this.ounces = ounces;
        normalize();
    }

    // Weight Class methods

    // create class method: toOunces
    // this method will convert pounds to ounces, giving total number of ounces
    private double toOunces() {
        // params: none
        // user inputs: none
        // return value: total ounces in weight object

        while (pounds > 0) {
            ounces = ounces + OUNCES_IN_A_POUND;
            pounds--;
        }
        return ounces;
    }

    // create class method: normalize
    // this method will convert ounces over 16 into pounds
    private void normalize() {
        // params: none
        // user inputs: none
        // return value: none

        while (ounces >= OUNCES_IN_A_POUND) {
            ounces = ounces - OUNCES_IN_A_POUND;
            pounds++;
        }
    }

    // create class method: lessThan
    // this method will compare two weight objects and check if parameter is less
    // than object
    public boolean lessThan(Weight comparedWeight) {
        // params: one weight object
        // user inputs: none
        // return value: false if parameter is less or equal, true if parameter is
        // greater
        // equal

        // call toOunces on objects
        toOunces();
        comparedWeight.toOunces();

        // compare ounce values, normalize, and return
        if (ounces >= comparedWeight.ounces) {
            normalize();
            comparedWeight.normalize();
            return false;
        } else if (ounces < comparedWeight.ounces) {
            normalize();
            comparedWeight.normalize();
            return true;
        } else {
            normalize();
            comparedWeight.normalize();
            return false;
        }
    }

    // create class method: addTo
    // this method will add two weight objects together
    public void addTo(Weight addedWeight) {
        // params: one weight object
        // user inputs: none
        // return value: none

        // call toOunces on objects
        toOunces();
        addedWeight.toOunces();

        // add ounces
        ounces += addedWeight.ounces;

        // normalize
        normalize();
        addedWeight.normalize();
    }

    // create class method: divideByThree
    // this method divides total ounces of weight object by three, then normalizes
    public void divideByThree() {
        // params: none
        // user inputs: none
        // return value: none

        // call to ounces on object
        toOunces();

        // divide number of ounces by 3
        ounces = ounces / 3;

        // normalize result
        normalize();
    }

    // create class override: toString
    // this method overrides the built in toString method
    public String toString() {
        // params: none
        // user inputs: none
        // return value: pounds and ounces of weight object
        return pounds + " pounds and " + ounces + " ounces";
    }
}
