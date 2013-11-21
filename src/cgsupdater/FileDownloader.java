package cgsupdater;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownloader {

    public static void getFileAsFile(String urlString, String targetFile) throws MalformedURLException, FileNotFoundException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(targetFile);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

    public static String getFileAsString(String urlString) throws MalformedURLException, IOException {

        String ret = "";
        URL oracle = new URL(urlString);
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                ret += inputLine + "\n";
            }
        }
        return ret;
    }

}
