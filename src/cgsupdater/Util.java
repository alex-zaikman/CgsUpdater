package cgsupdater;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class Util {

    //-------------working with path--------------------------------------------
    public static String getWorkingPath() {

        String currentDir = System.getProperty("user.dir");

        return currentDir;
    }

    public static String getCefLib() {
        return "ecfclient";
    }

    public static String getCefExe() {
        return "cgsclient.exe";
    }

    public static String pathJoin(final String... pathElements) {
        final String path;

        if (pathElements == null || pathElements.length == 0) {
            path = File.separator;
        } else {
            final StringBuilder builder;

            builder = new StringBuilder();

            for (final String pathElement : pathElements) {
                final String sanitizedPathElement;

                // the "\\" is for Windows... you will need to come up with the 
                // appropriate regex for this to be portable
                sanitizedPathElement = pathElement.replaceAll("\\" + File.separator, "");

                if (sanitizedPathElement.length() > 0) {
                    builder.append(sanitizedPathElement);
                    builder.append(File.separator);
                }
            }
            path = builder.toString();
        }
        return (path);
    }

    public static String upALevel(String path) {

        if (path == null || path.isEmpty()
                || path.equals(File.separator)
                || !path.contains(File.separator)) {
            return path;
        } else {

            int sep = path.lastIndexOf(File.separator);
            if (sep == path.length() - 1) {
                path = path.substring(0, path.length() - 1);
                sep = path.lastIndexOf(File.separator);
                if (sep == -1) {
                    sep = path.length();
                }
            }

            return path.substring(0, sep);
        }
    }
    //----------------------cmd-------------------------------------------------
    public static void runCmd(String command) {
        try {
            Process child = Runtime.getRuntime().exec(command);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            showErrorBox("CGS failed to load,\n Please contact your vendor.\n \nErrNo:A13");
            System.exit(1);
        }
    }
    //------------------user interface------------------------------------------
    public static void showErrorBox(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error",
                JOptionPane.ERROR_MESSAGE);

    }
// 0 if ok ; 2 if cancel ; -1 if close
    public static int showConfirmDialog(String msg) {
        int result = JOptionPane.showConfirmDialog(null, msg, "CGS",
                JOptionPane.OK_CANCEL_OPTION);
        return result;
    }
    
    
    
   //------------------MD5------------------------------------------  
    
    @SuppressWarnings("FinallyDiscardsException")
    public static String getMd5Hash(File file) {
       
            FileInputStream fis;
            String md5 = null;
         try {    
            
            fis = new FileInputStream(file);  
            md5 = DigestUtils.md5Hex(fis);
     
         } catch (IOException ex) {
            Logger.getLogger(Splitter.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
           return md5;  
         }

    }

    
}
