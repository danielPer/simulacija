package view;

import com.jgoodies.forms.layout.*;

import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.table.*;
import javax.swing.text.*;

import oracle.adf.model.*;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.*;

import oracle.jbo.uicli.binding.*;
import oracle.jbo.uicli.controls.*;
import oracle.jbo.uicli.jui.*;

import oracle.jdeveloper.layout.*;

public class PanelPumpa2 extends JPanel implements JUPanel {

    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelPumpa2PageDef");
    private JButton jButton1 = new JButton();
    /* private JPanel dataPanel = new JPanel();
    private BorderLayout borderLayout = new BorderLayout();

    private FormLayout panelLayout = new FormLayout("3dlu,d:g,3dlu,d:g,3dlu", "3dlu,d,3dlu,d,3dlu");
    private JTextField mId = new JTextField();
    private JLabel labelId = new JLabel();
    private JTextField mNaziv = new JTextField();
    private JLabel labelNaziv = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane(); */

    /**The default constructor for panel
     */
    public PanelPumpa2() {
        try {
            jbInit();
        } catch (Exception e) {
        }
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        /* dataPanel.setLayout(panelLayout);
        dataPanel.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setEnabled(true);
        jScrollPane1.setViewportView(dataPanel);
        this.setLayout(borderLayout);
        //Add the controls to the layout
        dataPanel.add(labelId, new CellConstraints("2 , 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mId, new CellConstraints("4, 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelNaziv, new CellConstraints("2 , 4 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mNaziv, new CellConstraints("4, 4 ,1,1,default," + CellConstraints.FILL));

        labelId.setLabelFor(mId);
        labelId.setText("<html><B>" + panelBinding.findCtrlValueBinding("Id").getLabel() + "</B></html>");
        mId.setToolTipText(panelBinding.findCtrlValueBinding("Id").getTooltip());
        mId.setColumns(15);
        mId.setColumns(panelBinding.findCtrlValueBinding("Id").getDisplayWidth());

        labelNaziv.setLabelFor(mNaziv);
        labelNaziv.setText(panelBinding.findCtrlValueBinding("Naziv").getLabel());
        mNaziv.setToolTipText(panelBinding.findCtrlValueBinding("Naziv").getTooltip());
        mNaziv.setColumns(15);
        mNaziv.setColumns(panelBinding.findCtrlValueBinding("Naziv").getDisplayWidth());
        add(jScrollPane1, BorderLayout.CENTER);
        //BindingCodes
        mId.setDocument((Document) panelBinding.bindUIControl("Id", mId));
        mNaziv.setDocument((Document) panelBinding.bindUIControl("Naziv", mNaziv));

        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("Pumpa1", "Id", null))) {
            dataPanel.remove(mId);
            dataPanel.remove(labelId);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("Pumpa1", "Naziv", null))) {
            dataPanel.remove(mNaziv);
            dataPanel.remove(labelNaziv);
        } */
        this.revalidate();
        validate();
        System.out.println(panelBinding.findCtrlValueBinding("Naziv").getLabel());
        jButton1.setText("proba" );
        this.add(jButton1, null);
        jButton1.setModel((ButtonModel) panelBinding.bindUIControl("proba", jButton1));
        
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

    
}
