/*
 * Filename: Shape.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the Shape related methods and variables and extends the JComponent class
 */
//Package
package cmsc335_project2_hermanmann;

import javax.swing.JComponent;

/**
 * Class to handle the Shape related methods and variables and extends the
 * JComponent class
 */
public class Shape extends JComponent {

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
        super.setLocation(50, 300);
        super.setSize(500, 500);
    }
}
