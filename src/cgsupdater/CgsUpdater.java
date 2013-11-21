package cgsupdater;

import java.util.TreeMap;

public class CgsUpdater {

    private TreeMap<String,String> localConfig;
    private TreeMap<String,String> remoteConfig;

    public CgsUpdater() {
        this.localConfig=new TreeMap<>();
        this.remoteConfig=new TreeMap<>();
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
        //TODO download zip
        //TODO extract to tmp
        //TODO move and replace
        //TODO del tmp
    }

    public void startCef() {
        //TODO get cef target exe
        //TODO run cmd command
    }

    
    private void parceLocalConfig(){
      //TODO  
    }
      
    private void parceRemoteConfig(){
      //TODO  
    }
       
    private boolean isRemoteNewer(){
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
               int res =  Util.showConfirmDialog("Update is avilable,\nwould you like to update now?");
               if(res==0){
                  System.out.println("update confirmed");
                  cu.getUpdate(); 
               }
            }
        } finally {
            System.out.println("starting cef");
            cu.startCef();
        }
    }

}
