/*
 * Filename: Cylinder.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the Cylinder related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the Cylinder related methods and extend the ThreeDimensionalShape
 * class
 */
public class Cylinder extends ThreeDimensionalShape {

    //Radius of the cylinder
    double radius;
    //Height of the cylinder
    double height;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of the cylinder
     * @param height - height of the cylinder
     */
    public Cylinder(double radius, double height) {
        super(AppResources.MSG_CYLINDER);
        this.radius = radius;
        this.height = height;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = (AppResources.PI * radius * radius * height);
    }

}
