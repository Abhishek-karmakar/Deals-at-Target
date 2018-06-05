package com.abhishek.TargetDeals.utils;

import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by akarmakar.
 */
public class LogManager {

    private static final boolean isLogEnabled = true;
    private static final boolean isFileLogEnabled = false;

    public static void debug(String tag, String msg) {
        if (isLogEnabled) {
            Log.e("@Calory " + tag, msg);
            if (isFileLogEnabled)
                appendLog(getCurrentTime() + "  :  " + msg);
        }
    }

    public static void appendLog(String text) {
        File logFile = new File("sdcard/Calory-log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        try {
            //BufferedWriter for performance, true to set append to file flag
            BufferedWriter buf = new BufferedWriter(new FileWriter(logFile, true));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * get the current time in the specified format
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM hh:mm:ss");
        String format = s.format(new Date());

        return (format != null) ? format : "";
    }
}