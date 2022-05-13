/*
 * Filename: Torus.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the Torus related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

public class Torus extends ThreeDimensionalShape {

    //Minor radius of the torus
    double radius1;
    //Major radius of the torus
    double radius2;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius1 - Minor radius
     * @param radius2 - Major radius
     */
    public Torus(double radius1, double radius2) {
        super(AppResources.MSG_TORUS);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = AppResources.VOLUME_MULTIPLY_TWICE * AppResources.PI * AppResources.PI * radius1 * radius1 * radius2;
    }
}
