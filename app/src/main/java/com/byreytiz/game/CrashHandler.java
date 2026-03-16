package com.byreytiz.game;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static final String CRASH_DIR = Environment.getExternalStorageDirectory() + "/crash_logs/";

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            File dir = new File(CRASH_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File crashFile = new File(dir, "crash_" + timeStamp + ".txt");

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String stackTrace = sw.toString();

            FileWriter writer = new FileWriter(crashFile);
            writer.write(stackTrace);
            writer.close();

            Log.e(TAG, "Crash saved to: " + crashFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
