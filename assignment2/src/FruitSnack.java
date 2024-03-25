/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 05 Nov 2022
 * 
 * This program creates classes for 2 types of snacks, and simulates an interface to order the snacks
 */

// This is a child class of Snack providing functionality unique to Fruit Snack objects

public class FruitSnack extends Snack {

    // subclass attribute
    private boolean hasCitrus; // boolean value, whether fruit snack has citrus or not

    // constructor FruitSnack
    // this method creates instances of FruitSnack objects
    public FruitSnack(char size, boolean hasCitrus) {
        // params: none
        // user inputs: none in method, accepts hasCitrus input as parameter
        // return value: none

        // call super to get attributes from parent class
        super(size);

        // assign citrus value
        this.hasCitrus = hasCitrus;

        // call calculatePrice to calculate new price
        calculatePrice();

        // call gerateFruitId to assign fruit snack id
        generateFruitId();
    }

    // method: toString
    // this method overrides parent toString function to return information about
    // the object's attributes
    public String toString() {
        // params: none
        // user inputs: none
        // return value: string containing object attribute values

        return "Snack type = Fruit Snack, of size = " + getSize() + " , id = " + getId() + " and price = "
                + String.format("%.2f", getPrice());
    }

    // method: calculatePrice
    // this method overrides parent calculatePrice method to ensure correct pricing
    // for citrus options (+ citrus = + 5.99)
    public void calculatePrice() {
        // params: none
        // user inputs: none
        // return value: none

        switch (getSize()) {

            case 'S': // small = 19.99, citrus + 5.99

                setPrice(19.99);
                if (hasCitrus) {
                    addSurcharge(5.99);
                }
                break;

            case 'M': // med = 29.99, citrus + 5.99

                setPrice(29.99);
                if (hasCitrus) {
                    addSurcharge(5.99);
                }
                break;

            case 'L': // lg = 39.99, citrus + 5.99

                setPrice(39.99);
                if (hasCitrus) {
                    addSurcharge(5.99);
                }
                break;
        }
    }

    // getter getHasCitrus
    // this method allows classes to see hasCitrus attribute value
    public boolean getHasCitrus() {
        // params: none
        // user inputs: none
        // return value: boolean citrus value

        return hasCitrus;
    }

    // setter setHasCitrus
    // this method allows classes to set new values for hasCitrus, and recalculates
    // price
    public void setHasCitrus(boolean hasCitrus) {
        // params: new hasCitrus value
        // user inputs: none
        // return value: none

        this.hasCitrus = hasCitrus;

        // recalculate price
        calculatePrice();
    }

    // method: generateFruitId
    // this method creates standardized unique id values for fruit snack objects
    public void generateFruitId() {
        // params: none
        // user inputs: none
        // return value: none

        // id is snack type + snack size + unique numeric identifier
        // fruit snack types are FWC or FNC
        if (hasCitrus) { // hasCitrus = true

            // FWC = Fruit With Citrus
            String uniqueId = "FWC" + generateId();
            setId(uniqueId);
        }

        if (!hasCitrus) { // hasCitrus = false

            // FNC = Fruit No Citrus
            String uniqueId = "FNC" + generateId();
            setId(uniqueId);
        }
    }

}
