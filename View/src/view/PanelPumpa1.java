package view;

import com.jgoodies.forms.layout.*;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.ActionEvent;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.*;
import javax.swing.text.*;

import javax.swing.text.Document;

import oracle.adf.model.*;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.*;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import oracle.jdeveloper.layout.*;

public class PanelPumpa1 extends JPanel implements JUPanel {

    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelPumpa1PageDef");
    
    private int velicinaReda;
    private int oznaka;
    private String clicked;
    
    private JButton jButton5 = new JButton();
    private JButton jButton6 = new JButton();
    private JButton jButton7 = new JButton();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton jButton1 = new JButton();
    private JTextField jTextField1 = new JTextField();

    /**The default constructor for panel
     */
    public PanelPumpa1(int oznaka) {
        this.oznaka = oznaka;
        this.velicinaReda = 0;
        //this.panelBinding = panelBinding;
        //create();
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        
        System.out.println(" creiram " + oznaka);
        this.add(jLabel1);
        this.add(jButton5);
        this.add(jButton6);
        this.add(jButton7);
        this.add(jLabel2);
        
        this.setSize(60, 300);
    
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        try {
            jbInit();
        } catch (Exception e) {
        }
    }

    


    /**JUPanel implementation
     */
    public JUPanelBinding getPanelBinding() {
        return panelBinding;
    }

    public void bindNestedContainer(JUPanelBinding ctr) {
        if (panelBinding.getPanel() == null) {
            ctr.setPanel(this);
            panelBinding.release(DCDataControl.REL_VIEW_REFS);
            panelBinding = ctr;
            registerProjectGlobalVariables(panelBinding.getBindingContext());
            try {
                jbInit();
            } catch (Exception ex) {
                ex.printStackTrace();
                ctr.reportException(ex);
            }
        }
    } 

    private void registerProjectGlobalVariables(BindingContext bindCtx) {
        JUUtil.registerNavigationBarInterface(panelBinding, bindCtx);
    }

    private void unRegisterProjectGlobalVariables(BindingContext bindCtx) {
        JUUtil.unRegisterNavigationBarInterface(panelBinding, bindCtx);
    }

    public void setBindingContext(BindingContext bindCtx) {
        if (panelBinding.getPanel() == null) {
            panelBinding = panelBinding.setup(bindCtx, this);
            registerProjectGlobalVariables(bindCtx);
            panelBinding.refreshControl();
            try {
                jbInit();
                panelBinding.refreshControl();
            } catch (Exception ex) {
                panelBinding.reportException(ex);
            }
        }
    } 

    private void jbInit() throws Exception {
        
        jLabel1.setText("pumpa " + String.valueOf(oznaka));
        jLabel2.setText(String.valueOf(velicinaReda));
        jButton1.setText("proba");
        jButton5.setText("Dolazak");
        jButton6.setText("Kraj punjenja");
        jButton7.setText("Odlazak");
        
        System.out.println(" creiram " + oznaka);
        this.add(jLabel1);
        this.add(jButton5);
        this.add(jButton6);
        this.add(jButton7);
        this.add(jLabel2);

        this.add(jButton1, null);
        jButton1.setModel((ButtonModel) panelBinding.bindUIControl("proba", jButton1));
    }


    public String getClicked() {
        return "kliknut je " + clicked;
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exemp) {
            exemp.printStackTrace();
        }

        PanelTransmaster1Helper panel = new PanelTransmaster1Helper();
        panel.setBindingContext(JUTestFrame.startTestFrame("view.DataBindings.cpx", "null", panel,
                                                           panel.getPanelBinding(), new Dimension(400, 300)));
        panel.revalidate();
    }


}
