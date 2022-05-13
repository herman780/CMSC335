/*
 * Filename: TwoDimensionalShape.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the TwoDimensionalShape related methods and extend the shape class
 */
//Package
package cmsc335_project2_hermanmann;

/**
 * Class to handle the TwoDimensionalShape related methods and extend the shape
 * class
 */
public class TwoDimensionalShape extends Shape {

    //Area of the two dimensional shape
    double area;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param name - name of the shape
     */
    public TwoDimensionalShape(String name) {
        super(name, AppResources.TWO_DIMENSION);
    }

    /**
     * To get area of the two dimensional shape
     *
     * @return - area of the two dimensional shape
     */
    public double getArea() {
        return area;
    }

    /**
     * To calculate the area of the two dimensional shape. It will override by
     * the child classes
     */
    public void calculateArea() {
    }

}
