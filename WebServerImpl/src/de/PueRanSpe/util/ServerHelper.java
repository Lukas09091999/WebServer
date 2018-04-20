package de.PueRanSpe.util;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class ServerHelper {

    public static String getServerIp() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            Logger.exception(e.getMessage());
            return "127.0.0.1";
        }
    }

    
    public static String getCanonicalWebRoot(File webRoot) {
        String canonicalWebRoot = "";
        try {
            canonicalWebRoot = webRoot.getCanonicalPath();
        } catch (IOException e) {
            Logger.exception(e.getMessage());
        }
        return canonicalWebRoot;
    }
}
