/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 05 Nov 2022
 * 
 * This program creates classes for 2 types of snacks, and simulates an interface to order the snacks
 */

// This is a child class of Snack providing functionality unique to Salty Snack objects

public class SaltySnack extends Snack {

    // subclass attribute
    private boolean hasNuts; // boolean value, wheter salt snack has nuts or not

    // constructor SaltySnack
    // this method creates instances of SaltySnack objects
    public SaltySnack(char size, boolean hasNuts) {
        // params: none
        // user inputs: none in method, accepts hasNuts input as parameter
        // return value: none

        // call super to get attributes from parent class
        super(size);

        // assign nuts value
        this.hasNuts = hasNuts;

        // calculate new price
        calculatePrice();

        // assign salt snack id
        generateSaltId();
    }

    // method: toString
    // this method overrides parent toString function to return information about
    // the object's attributes
    public String toString() {
        // params: none
        // user inputs: none
        // return value: string containing object attribute values

        return "Snack type = Salty Snack, of size = " + getSize() + " , id = " + getId() + " and price = "
                + String.format("%.2f", getPrice());
    }

    // method: calculatePrice
    // this method overrides parent calculatePrice method to ensure correct pricing
    // for nut options (+ nuts = + 5.99)
    public void calculatePrice() {
        // params: none
        // user inputs: none
        // return value: none

        switch (getSize()) {

            case 'S': // small = 19.99, nuts + 4.50

                setPrice(19.99);
                if (hasNuts) {
                    addSurcharge(4.5);
                }
                break;

            case 'M': // med = 29.99, nuts + 4.50

                setPrice(29.99);
                if (hasNuts) {
                    addSurcharge(4.5);
                }
                break;

            case 'L': // lg = 39.99, nuts + 4.50

                setPrice(39.99);
                if (hasNuts) {
                    addSurcharge(4.5);
                }
                break;
        }
    }

    // getter getHasNuts
    // this method allows classes to see hasNuts attribute value
    public boolean getHasNuts() {
        // params: none
        // user inputs: none
        // return value: boolean nuts value

        return hasNuts;
    }

    // setter setHasNuts
    // this method allows classes to set new values for hasNuts, and recalculates
    // price
    public void setHasNuts(boolean hasNuts) {
        // params: none
        // user inputs: none
        // return value: none

        this.hasNuts = hasNuts;

        // recalculate price
        calculatePrice();
    }

    // method: generateFruitId
    // this method creates standardized unique id values for salt snack objects
    public void generateSaltId() {
        // params: none
        // user inputs: none
        // return value: none

        // id is snack type + snack size + unique numeric identifier
        // salt snack types are SWN or SNN

        if (hasNuts) { // hasNuts = true

            // SWN = Salty With Nuts
            String uniqueId = "SWN" + generateId();
            setId(uniqueId);
        }

        if (!hasNuts) { // hasNuts = false

            // SNN = Salty No Nuts
            String uniqueId = "SNN" + generateId();

            // set the new id
            setId(uniqueId);
        }

    }
}
