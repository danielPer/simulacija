package view.pomocne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import oracle.jbo.uicli.jui.JUPanelBinding;

import oracle.jdeveloper.layout.PaneConstraints;
import oracle.jdeveloper.layout.VerticalFlowLayout;

public class pumpaPanel extends JPanel{
    @SuppressWarnings("compatibility:7378740414167124522")
    private static final long serialVersionUID = 1L;
    
    private int velicinaReda;
    private int oznaka;
    private JUPanelBinding panelBinding = new JUPanelBinding("view_FormPageDef");
    
    private JButton jButton5 = new JButton();
    private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    //private BoxLayout boxLayout = new BoxLayout();
    
    public pumpaPanel(int oznaka){
        this.oznaka = oznaka;
        this.velicinaReda = 0;
        //this.panelBinding = panelBinding;
        create();
    }


    public void setVelicinaReda(int velicinaReda) {
        this.velicinaReda = velicinaReda;
    }

    public int getVelicinaReda() {
        return velicinaReda;
    }

    public void setOznaka(int oznaka) {
        this.oznaka = oznaka;
    }

    public int getOznaka() {
        return oznaka;
    }

    private void create(){
        jLabel1.setText("pumpa " + String.valueOf(oznaka));
        jLabel2.setText(String.valueOf(velicinaReda));
        jButton5.setText("Dolazak");
        jButton6.setText("Kraj punjenja");
        jButton7.setText("Odlazak");
        /* this.add(jLabel1, new PaneConstraints("jLabel1", "jLabel1", PaneConstraints.ROOT, 1.0f));
        this.add(jButton5, new PaneConstraints("jButton5", "jLabel1", PaneConstraints.RIGHT, 0.7941176f));
        this.add(jButton6, new PaneConstraints("jButton6", "jButton5", PaneConstraints.RIGHT, 0.7407407f));
        this.add(jButton7, new PaneConstraints("jButton7", "jButton6", PaneConstraints.RIGHT, 0.7f));
        this.add(jLabel2, new PaneConstraints("jLabel2", "jButton7", PaneConstraints.RIGHT, 0.5f));
         */
        System.out.println(" creiram " + oznaka);
        this.add(jLabel1);
        this.add(jButton5);
        this.add(jButton6);
        this.add(jButton7);
        this.add(jLabel2);
        
        
        //jButton5.setModel((ButtonModel) panelBinding.bindUIControl("proba", jButton5));
        
        ButtonModel mod = (ButtonModel) panelBinding.bindUIControl("proba", jButton5);
        jButton5.setModel(mod);
        
        this.setSize(60, 300);
    
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
}
