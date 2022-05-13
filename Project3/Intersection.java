/*
 * Filename: Intersection.java
 * Author: Herman Mann
 * Date: 05/08/2022
 * Description: Class to handle intersection to display traffic light colors
 */
package cmsc335_project3_hermanmann;

import java.awt.Color;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JLabel;

/**
 * Class to handle intersection to display traffic light colors
 */
public class Intersection implements Runnable {

    Thread thread;
    String threadName;
    //Array of colors
    private final String[] COLORS = {AppResources.MSG_GREEN, AppResources.MSG_YELLOW, AppResources.MSG_RED};
    private int index = 0;
    private String currentLight = COLORS[index];
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    public final AtomicBoolean suspended = new AtomicBoolean(false);
    private JLabel jLabel;

    /**
     * Constructor to initialize and construct intersection class
     *
     * @param name - name of intersection
     * @param j - label of interaction
     */
    public Intersection(String name, JLabel j) {
        this.threadName = name;
        this.jLabel = j;
        System.out.println(AppResources.MSG_CREATING + threadName);
    }

    /**
     * Synchronized method for getting traffic light color
     *
     * @return - interaction color
     */
    public synchronized String getColor() {
        this.currentLight = COLORS[index];
        return this.currentLight;
    }

    /**
     * To set the suspend
     */
    public void suspend() {
        suspended.set(true);
        System.out.println(AppResources.MSG_SUSPENDING + threadName);
    }

    /**
     * To set and synchronized the resume
     */
    public synchronized void resume() {
        suspended.set(false);
        notify();
        System.out.println(AppResources.MSG_RESUMING + threadName);
    }

    /**
     * To start thread
     */
    public void start() {
        System.out.println(AppResources.MSG_STARTING + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    /**
     * To stop the running
     */
    public void stop() {
        thread.interrupt();
        isRunning.set(false);
        System.out.println(AppResources.MSG_STOPPING + threadName);
    }

    /**
     * To interrupt a thread
     */
    public void interrupt() {
        thread.interrupt();
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
                synchronized (this) {
                    while (suspended.get()) {
                        System.out.println(threadName + AppResources.MSG_WAITING);
                        wait();
                    }
                }
                switch (getColor()) {
                    case AppResources.MSG_GREEN:
                        jLabel.setForeground(new Color(0, 200, 10));
                        jLabel.setText(getColor());
                        Thread.sleep(10000);
                        index++;

                        break;
                    case AppResources.MSG_YELLOW:
                        jLabel.setForeground(new Color(247, 226, 35));
                        jLabel.setText(getColor());
                        Thread.sleep(5000);
                        index++;
                        break;
                    case AppResources.MSG_RED:
                        jLabel.setForeground(Color.RED);
                        jLabel.setText(getColor());
                        Thread.sleep(5000);
                        index = 0;
                        break;
                    default:
                        break;
                }

            } catch (InterruptedException ex) {
                suspended.set(true);
            }
        }
    }

}
