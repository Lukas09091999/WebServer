package de.PueRanSpe.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;

public class FileManager {
    private static HashMap<String, String> mimeTypes = new HashMap<>();
    private static boolean mimeTypesInitCompleted = false;

    public static HashMap<String, String> getMimeTypes() {
        if (mimeTypesInitCompleted) return mimeTypes;

        // Bilder
        mimeTypes.put(".gif", "image/gif");
        mimeTypes.put(".jpg", "image/jpeg");
        mimeTypes.put(".jpeg", "image/jpeg");
        mimeTypes.put(".png", "image/png");

        // Audio
        mimeTypes.put(".mp3", "audio/mpeg");
        mimeTypes.put(".mp4", "video/mp4");
        mimeTypes.put(".flv", "video/x-flv");

        // Webseiten
        mimeTypes.put(".html", "text/html");
        mimeTypes.put(".htm", "text/html");
        mimeTypes.put(".shtml", "text/html");
        mimeTypes.put(".xhtml", "text/html");
        mimeTypes.put(".css", "text/css");
        mimeTypes.put(".js", "text/js");

        // Anderes
        mimeTypes.put(".txt", "text/plain");
        mimeTypes.put(".log", "text/plain");
        mimeTypes.put(".md", "text/x-markdown");
        mimeTypes.put(".pdf", "application/pdf");
        mimeTypes.put(".xml", "application/xml");
        mimeTypes.put(".java", "text/plain");

        mimeTypesInitCompleted = true;
        return mimeTypes;
    }


    public static String getReadableFileSize(long size) {
        if (size <= 0) return "0";

        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB", "PB", "EB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }


    public static String getContentType(File file) {
        return getMimeTypes().get(getFileExtension(file));
    }


    private static String getFileExtension(File file) {
        String filename = file.getName();
        int pos = filename.lastIndexOf(".");
        if (pos >= 0) return filename.substring(pos).toLowerCase();
        return "";
    }
}