/*
 * Filename: Shape.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the Shape related methods and variables
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the Shape related methods and variables
 */
public class Shape {

    //Name of the shape
    String name;
    //Number of dimensions of the shape
    int numberOfDimensions;

    /**
     * Constructor of the class to initialize variables
     *
     * @param name - name of the shape
     * @param numberOfDimensions - number of dimensions of the shape
     */
    public Shape(String name, int numberOfDimensions) {
        this.name = name;
        this.numberOfDimensions = numberOfDimensions;
    }
}
