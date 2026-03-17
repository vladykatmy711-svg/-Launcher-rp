package com.byreytiz.game;

import android.content.Context;
import android.widget.Toast;
import java.io.PrintWriter;
import java.io.StringWriter;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private Context context;

    public CrashHandler(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            // Собираем стек ошибки
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String stackTrace = sw.toString();

            // Показываем ошибку на экране
            String message = "❌ Приложение упало!\n\n";
            message += "Ошибка: " + ex.getMessage() + "\n\n";
            message += stackTrace.substring(0, Math.min(500, stackTrace.length())) + "...";

            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

            // Ждём немного, чтобы пользователь успел прочитать
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Закрываем приложение
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
