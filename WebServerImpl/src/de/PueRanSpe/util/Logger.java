package de.PueRanSpe.util;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

public class Logger {
    private static File logfile;

      public static void setLogfile(File pLogfile) {
        logfile = pLogfile;
    }


    public static void access(String file, String ip) {
        write("[200] [" + ip.replace("/", "") + "] " + file);
    }


    public static void error(int code, String file, String ip) {
        write("[" + code + "] [" + ip.replace("/", "") + "] " + file);
    }


    public static void exception(String message) {
        write("[EXC] " + message);
    }


    private static void write(String message) {
        // Meldung zusammensetzen
        String out = "[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "] " + message;

        System.out.println(out);

        try {
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(logfile, true));
            printWriter.append(out).append("\r\n");
            printWriter.close();
        } catch (IOException ignored) {}
    }
}