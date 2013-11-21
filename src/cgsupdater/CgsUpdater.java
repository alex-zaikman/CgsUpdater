package cgsupdater;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

public class CgsUpdater {

    public static void main(String[] args) throws Exception {
        
        //Splitter.splitFile(new File("C:\\test\\myCgsUpdater.zip"), 1024*4*2);
        Splitter.reassembleFile(new File("C:\\test\\split"));
        Zipper.unzip("C:\\test\\split\\myCgsUpdater.zip","C:\\test\\split");
    }

}
