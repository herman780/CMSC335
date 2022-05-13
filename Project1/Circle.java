/*
 * Filename: Circle.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the circle related methods and extend the TwoDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the circle related methods and extend the TwoDimensionalShape
 * class
 */
public class Circle extends TwoDimensionalShape {

    //Radius of the circle
    double radius;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of circle
     */
    public Circle(double radius) {
        super(AppResources.MSG_CIRCLE);
        this.radius = radius;
    }

    /**
     * To override the parent class method and calculate the area
     */
    @Override
    public void calculateArea() {
        this.area = AppResources.PI * radius * radius;
    }
}
