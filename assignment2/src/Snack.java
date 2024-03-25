/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 05 Nov 2022
 * 
 * This program creates classes for 2 types of snacks, and simulates an interface to order the snacks
 */

/* This is the parent class of the Salty and Fruit snack classes, providing common functionality */
public class Snack {

    // static variable count, used for assigning id number values
    private static int counter = 1;

    // attributes
    private String id; // snack id, comprised of snack type, size, and a numeric identifier
    private char size; // size of snack can be small(S), medium (M), or large (L)
    private double price; // price of snack S = 19.99, M = 29.99, L = 39.99

    // constructor Snack
    // this method creates instances of snack objects
    public Snack(char size) {
        // params: size
        // user inputs: none in method, accepts size input as parameter
        // return value: none

        // call generateId to assign id value
        id = generateId();

        // this.id = id;

        // use parameter value as size attribute value
        this.size = size;

        // call calculatePrice to assign correct price
        calculatePrice();
    }

    // method: toString
    // this method overrides buit in toString function to return information about
    // the object's attributes
    public String toString() {
        // params: none
        // user inputs: none
        // return value: string containing object attribute values

        return "Snack type: regular\nSnack ID: " + getId() + "\nSnack size: " + getSize() + "\nSnack price: "
                + getPrice();
    }

    // method: calculatePrice
    // this method will calculate the price of snacks based on size
    public void calculatePrice() {
        // params: none
        // user inputs: none
        // return value: none

        switch (getSize()) {

            case 'S': // small snack = 19.99
                setPrice(19.99);
                break;

            case 'M': // med snack = 29.99
                setPrice(29.99);
                break;

            case 'L': // lg snack = 39.99
                setPrice(39.99);
                break;
        }
    }

    // method: addSurcharge
    // this method will allow the fruit and salt methods to add surcharge for citrus
    // and nuts
    public void addSurcharge(double surcharge) {
        // params: surcharge to be added to price
        // user inputs: none
        // return value: none

        setPrice(price += surcharge);
    }

    // method: geterateId
    // this method will gereate a basis for id's by combining size and numeric
    // identifiers
    public String generateId() {
        // params: none
        // user inputs: none
        // return value: string with size and numeric identifier

        String uniqueId = getSize() + "" + counter;

        // increment counter for unique numeric identifiers
        counter++;

        return uniqueId;
    }

    // setters

    // setter setId
    // this method allows classes to set id attribute values
    public void setId(String id) {
        // params: new id value
        // user inputs: none
        // return value: none

        this.id = id;
    }

    // setter setSize
    // this method allows classes to set size attribute values
    public void setSize(char size) {
        // params: new size value
        // user inputs: none
        // return value: none

        this.size = size;
    }

    // setter setPrice
    // this method allows classes to set price attribute values
    public void setPrice(double price) {
        // params: new price value
        // user inputs: none
        // return value: none

        this.price = price;
    }

    // getters

    // getter getId
    // this method allows classes to see id attribute values
    public String getId() {
        // params: none
        // user inputs: none
        // return value: id attribute value

        return id;
    }

    // getter getSize
    // this method allows classes to see size attribute values
    public char getSize() {
        // params: none
        // user inputs: none
        // return value: size attribute value
        return size;
    }

    // getter getPrice
    public double getPrice() {
        // params: none
        // user inputs: none
        // return value: price attribute value
        return (price);
    }
}
