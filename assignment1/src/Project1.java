/* Paul Fitch
 * CMIS 242-7380
 * Project 1
 * 20 Oct 2022
 * 
 * This program will create three weight objects, then find the minimun, maximum, and average wieght of the objects
 */

// create "main" class
public class Project1 {

    // create method: findMinimum
    // this method will find the minimum weight of three weight objects
    private static Weight findMinimum(Weight obj_1, Weight obj_2, Weight obj_3) {
        // params: three weight objects
        // user inputs: none
        // return value: weight object with minimum weight

        if ((obj_1.lessThan(obj_2)) && (obj_1.lessThan(obj_3))) {
            return obj_1;
        } else if ((obj_2.lessThan(obj_1)) && (obj_2.lessThan(obj_3))) {
            return obj_2;
        } else {
            return obj_3;
        }
    }

    // create method: findMaximum
    // this method will find the maximum of three weight objects
    private static Weight findMaximum(Weight obj_1, Weight obj_2, Weight obj_3) {
        // params: three weight objects
        // user inputs: none
        // return value: weight object with maximum weight

        if ((!obj_1.lessThan(obj_2)) && (!obj_1.lessThan(obj_3))) {
            return obj_1;
        } else if ((!obj_2.lessThan(obj_1)) && (!obj_2.lessThan(obj_3))) {
            return obj_2;
        } else {
            return obj_3;
        }
    }

    // create method: findAverage
    // this method will find the average of three weight objects
    private static Weight findAverage(Weight obj_1, Weight obj_2, Weight obj_3) {
        // params: three weight objects
        // user inputs: none
        // return value: weight object with average weight

        // average = total weight / number of objects (3)
        Weight average = new Weight(0, 0);
        average.addTo(obj_1);
        average.addTo(obj_2);
        average.addTo(obj_3);
        average.divideByThree();

        return average;
    }

    // create main method
    public static void main(String[] args) {

        // instance 1 of weight object 11p, 3o
        Weight weight1 = new Weight(11, 3);

        // instance 2 of weight object 7p, 20o
        Weight weight2 = new Weight(7, 20);

        // instance 3 of weight object 14p, 6o
        Weight weight3 = new Weight(14, 6);

        // System.out.println(weight1.toString());
        // System.out.println(weight2.toString());
        // System.out.println(weight3.toString());

        // test for findMinimum
        Weight min = findMinimum(weight1, weight2, weight3);
        System.out.println("Minimum weight value is: " + min.toString());

        // test for findMaximum
        Weight max = findMaximum(weight1, weight2, weight3);
        System.out.println("Maximum weight value is: " + max.toString());

        // test for findAverage
        Weight avg = findAverage(weight1, weight2, weight3);
        System.out.println("Average weight value is: " + avg.toString());

    }
}