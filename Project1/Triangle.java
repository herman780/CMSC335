/*
 * Filename: Triangle.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the triangle related methods and extend the TwoDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the triangle related methods and extend the TwoDimensionalShape
 * class
 */
public class Triangle extends TwoDimensionalShape {

    //Base of a triangle
    double base;
    //Height of a triangle
    double height;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param base- base of triangle
     * @param height- height of triangle
     */
    public Triangle(double base, double height) {
        super(AppResources.MSG_TRIANGLE);
        this.base = base;
        this.height = height;
    }

    /**
     * To override the parent class method and calculate the area
     */
    @Override
    public void calculateArea() {
        this.area = (base * height) / AppResources.AREA_BY_FACTOR;
    }

}
