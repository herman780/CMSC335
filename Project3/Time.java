/*
 * Filename: Time.java
 * Author: Herman Mann
 * Date: 05/08/2022
 * Description: Class to handle the application date time and implements the runnable 
 */
//Package
package cmsc335_project3_hermanmann;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to handle the application date time and implements the runnable
 */
public class Time implements Runnable {

    private boolean isRunning;
    private String timePattern = AppResources.MSG_TIME_FORMAT;
    private SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
    Date date = new Date(System.currentTimeMillis());

    /**
     * Construct the time class
     */
    public Time() {
        this.isRunning = Thread.currentThread().isAlive();
    }

    /**
     * To get the current time in specific format
     *
     * @return
     */
    public String getTime() {
        date = new Date(System.currentTimeMillis());
        return timeFormat.format(date);
    }

    /**
     * To run the current date time update
     */
    @Override
    public void run() {
        //While running, constantly update current time
        while (isRunning) {

            GUI.timeText.setText(getTime());
        }
    }

}
