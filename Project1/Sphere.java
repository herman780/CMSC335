/*
 * Filename: Sphere.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the Sphere related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the Sphere related methods and extend the ThreeDimensionalShape
 * class
 */
public class Sphere extends ThreeDimensionalShape {

    //Radius of the sphere
    double radius;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of the sphere
     */
    public Sphere(double radius) {
        super(AppResources.MSG_SPHERE);
        this.radius = radius;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = (AppResources.VOLUME_MULTIPLY_FACTOR / AppResources.VOLUME_BY_FACTOR) * AppResources.PI * radius * radius * radius;
    }
}
