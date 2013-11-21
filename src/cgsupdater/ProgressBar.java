
package cgsupdater;
    
  
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class ProgressBar {
    
  private JProgressBar progressBar;
  private JFrame f;
  
  public void setProgress(int p){
      if(this.progressBar!=null)
            this.progressBar.setValue(p);
  }
  
  public void startProgressBar() {
    f = new JFrame("JProgressBar Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    progressBar = new JProgressBar();
    progressBar.setValue(0);
    progressBar.setStringPainted(true);
    Border border = BorderFactory.createTitledBorder("Updating...");
    progressBar.setBorder(border);
    content.add(progressBar, BorderLayout.NORTH);
    f.setSize(400, 100);
    f.setVisible(true);
  }
  
    public void stopProgressBar() {
        if(this.f!=null)
            this.f.dispose();
    }
  
}


