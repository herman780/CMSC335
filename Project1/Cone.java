/*
 * Filename: Cone.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the cone related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

/**
 * Class to handle the cone related methods and extend the ThreeDimensionalShape
 * class
 */
public class Cone extends ThreeDimensionalShape {

    //Radius of the cone
    double radius;
    //Height of the cone
    double height;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of the cone
     * @param height - height of the cone
     */
    public Cone(double radius, double height) {
        super(AppResources.MSG_CONE);
        this.radius = radius;
        this.height = height;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = (AppResources.PI * radius * radius * height) / AppResources.VOLUME_BY_FACTOR;
    }

}
