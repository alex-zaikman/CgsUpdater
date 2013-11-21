package cgsupdater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Splitter {

    public static void splitFile(File file, int chunckSize) throws IOException {

        int i = 0, len = 0;
        try (FileInputStream fin = new FileInputStream(file)) {
            int c = fin.read();
            while (c != -1) {
                try (FileOutputStream fw = new FileOutputStream(file + "." + (i + 1) + "spt")) {
                    while (c != -1 && len < chunckSize) {
                        fw.write(c);
                        c = fin.read();
                        len++;
                    }
                    len = 0;
                }
                i++;
            }
        }
    }

    public static void reassembleFile(File dir) throws IOException {
        File[] files = dir.listFiles();

        String filename = files[0].getAbsolutePath().substring(0, files[0].getAbsolutePath().lastIndexOf("."));
        File dest = new File(filename);
        boolean createdNewFile = dest.createNewFile();
        try (FileOutputStream fw = new FileOutputStream(dest)) {
            if (createdNewFile) {
                for (File file : files) {
                    try (FileInputStream fin = new FileInputStream(file)) {
                        int c =  fin.read();
                        while (c != -1) {
                            fw.write(c);
                            c = fin.read();
                            
                        }
                    }
                    
                }
            }
        }
    }

}
