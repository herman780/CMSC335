/*
 * Filename: Vehicle.java
 * Author: Herman Mann
 * Date: 05/08/2022
 * Description: Class to handle the vehicle related methods and implements the runnable 
 */
//Package
package cmsc335_project3_hermanmann;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Class to handle the vehicle related methods and implements the runnable
 */
public class Vehicle implements Runnable {

    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public final AtomicBoolean atLight = new AtomicBoolean(false);
    public final AtomicBoolean suspended = new AtomicBoolean(false);
    private int xPosition;
    private int yPosition = 0;
    private String threadName = "";
    public Thread thread;
    private int speed = 0;

    /**
     * Constructor to construct the vehicle class
     *
     * @param name - name of the vehicle
     * @param max - max range of x position
     * @param min - min range of x position
     */
    public Vehicle(String name, int max, int min) {
        this.threadName = name;
        this.xPosition = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println(AppResources.MSG_CREATING + threadName);
    }

    public synchronized int getPosition() {
        return xPosition;
    }

    /**
     * To get speed of the vehicle
     *
     * @return - get speed of the vehicle
     */
    public int getSpeed() {
        if (isRunning.get()) {
            if (atLight.get()) {
                speed = 0;
            } else {
                speed = 3 * 50;
            }
        } else {
            speed = 0;
        }
        return speed;
    }

    /**
     * To start the vehicle thread
     */
    public void start() {
        System.out.println(AppResources.MSG_STARTING + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    /**
     * To stop the vehicle thread
     */
    public void stop() {
        thread.interrupt();
        isRunning.set(false);
        System.out.println(AppResources.MSG_STOPPING + threadName);
    }

    /**
     * To suspend the vehicle thread
     */
    public void suspend() {
        suspended.set(true);
        System.out.println(AppResources.MSG_SUSPENDING + threadName);
    }

    /**
     * To resume the vehicle thread
     */
    public synchronized void resume() {
        //If vehicle is suspended, set suspended to false and notify
        if (suspended.get() || atLight.get()) {
            suspended.set(false);
            atLight.set(false);
            notify();
            System.out.println(AppResources.MSG_RESUMING + threadName);
        }
    }

    /**
     * To run the thread and make sleeps
     */
    @Override
    public void run() {
        System.out.println(AppResources.MSG_RUNNING + threadName);
        isRunning.set(true);
        while (isRunning.get()) {
            try {
                while (xPosition < 3000) {
                    synchronized (this) {
                        while (suspended.get() || atLight.get()) {
                            System.out.println(threadName + AppResources.MSG_WAITING);
                            wait();
                        }
                    }
                    //Check if still running
                    if (isRunning.get()) {
                        Thread.sleep(100);
                        xPosition += 5;
                    }
                }
                xPosition = 0;
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

}
