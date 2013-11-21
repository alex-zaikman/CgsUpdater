package cgsupdater;

import java.util.TreeMap;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitor;

public class CgsUpdater {

    private TreeMap<String, String> localConfig;
    private TreeMap<String, String> remoteConfig;
    public ProgressBar progressBar;
    public CgsUpdater() {
        this.progressBar = new ProgressBar();
        this.localConfig = new TreeMap<>();
        this.remoteConfig = new TreeMap<>();
    }

    public void init() {
        parceLocalConfig();
    }

    public boolean hashNewVersion() {
        parceRemoteConfig();
        return isRemoteNewer();
    }

    public void getUpdate() {
        //TODO create tmp dir for zip
         System.out.println("created tmp dir");
        updateProgress(5);
        //TODO download zip <- update progress up to 49%
          //TODO if failed error dialog
         System.out.println("downloadded zip");
        updateProgress(50);
        //TODO extract to tmp
        //TODO if failed error dialog
         System.out.println("cef extracted to tmp");
        updateProgress(80);
        //TODO move and replace
          //TODO if failed error dialog
         System.out.println("replaced old version");
        updateProgress(97);
        //TODO del tmp
         System.out.println("did cleanup");
       updateProgress(100);
    }

    public void startCef(){
        if(this.progressBar!=null)
            this.progressBar.stopProgressBar();
        //TODO get cef target exe
         System.out.println("starting cef....");
        //TODO run cmd command
    }

    private void parceLocalConfig() {
        //TODO  
    }

    private void parceRemoteConfig() {
        //TODO  
    }

    private boolean isRemoteNewer() {
        //TODO  
        return true;
    }

    public static void main(String[] args) throws Exception {
        CgsUpdater cu = new CgsUpdater();
        try {
            cu.init();
            System.out.println("inited");
            if (cu.hashNewVersion()) {
                System.out.println("new update found");
                int res = Util.showConfirmDialog("Update is avilable,\nwould you like to update now?");
                if (res == 0) {
                    System.out.println("update confirmed");
                    cu.progressBar.startProgressBar();
                    cu.getUpdate();
                }
            }
        } finally {
            cu.startCef();
        }




    }
    
    
    private void updateProgress(int p){
        if(this.progressBar!=null)
            progressBar.setProgress(p);
    }

}
