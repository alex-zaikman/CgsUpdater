package cgsupdater;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.*;

public class Zipper {

     public static void zipDir(String zipFileName, String dir) throws Exception {
        File dirObj = new File(dir);
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName))) {
            System.out.println("Creating : " + zipFileName);
            addDir(dirObj, out);
        }
    }

    private static void addDir(File dirObj, ZipOutputStream out) throws IOException {
        File[] files = dirObj.listFiles();
        byte[] tmpBuf = new byte[1024];
        for (File file : files) {
            if (file.isDirectory()) {
                addDir(file, out);
                continue;
            }
            try (FileInputStream in = new FileInputStream(file.getAbsolutePath())) {
                System.out.println(" Adding: " + file.getAbsolutePath());
                out.putNextEntry(new ZipEntry(file.getAbsolutePath()));
                int len;
                while ((len = in.read(tmpBuf)) > 0) {
                    out.write(tmpBuf, 0, len);
                }
                out.closeEntry();
            }
        }
    }

    
    
    
    
    public static void unzip(String sfile , String targetDir) throws IOException{

		
                    try (ZipFile zipFile = new ZipFile(sfile)) {
                        Enumeration<?> enu = zipFile.entries();
                        while (enu.hasMoreElements()) {
                            ZipEntry zipEntry = (ZipEntry) enu.nextElement();
                            
                            String name =targetDir+"\\"+ zipEntry.getName();
                            long size = zipEntry.getSize();
                            long compressedSize = zipEntry.getCompressedSize();
                            System.out.printf("name: %-20s | size: %6d | compressed size: %6d\n",
                                    name, size, compressedSize);
                            
                            File file = new File(name);
                            if (name.endsWith("/")) {
                                file.mkdirs();
                                continue;
                            }
                            
                            File parent = file.getParentFile();
                            if (parent != null) {
                                parent.mkdirs();
                            }
                            FileOutputStream fos;
                            try (InputStream is = zipFile.getInputStream(zipEntry)) {
                                fos = new FileOutputStream(file);
                                byte[] bytes = new byte[1024];
                                int length;
                                while ((length = is.read(bytes)) >= 0) {
                                    fos.write(bytes, 0, length);
                                }
                            }
                            fos.close();
                            
                        }
                    }
		
	}

}
