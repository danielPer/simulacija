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

public class PanelTransmaster1Helper extends JPanel implements JUPanel {

    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_PanelTransmaster1HelperPageDef");
    private JPanel dataPanel = new JPanel();
    private BorderLayout borderLayout = new BorderLayout();

    private FormLayout panelLayout = new FormLayout("3dlu,d:g,3dlu,d:g,3dlu", "3dlu,d,3dlu,d,3dlu");
    private JTextField mBrojpumpi = new JTextField();
    private JLabel labelmBrojpumpi = new JLabel();
    private JTextField mOznaka = new JTextField();
    private JLabel labelmOznaka = new JLabel();
    private JUNavigationBar navBar = new JUNavigationBar();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JButton jButton1 = new JButton();

    /**The default constructor for panel
     */
    public PanelTransmaster1Helper() {
    }

    /**the JbInit method
     */
    public void jbInit() throws Exception {
        dataPanel.setLayout(panelLayout);
        dataPanel.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setMinimumSize(new Dimension(100, 100));
        jScrollPane1.setEnabled(true);
        jButton1.setText("proba");
        jScrollPane1.setViewportView(dataPanel);
        this.setLayout(borderLayout);
        //Add the controls to the layout
        dataPanel.add(labelmBrojpumpi, new CellConstraints("2 , 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mBrojpumpi, new CellConstraints("4, 2 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(labelmOznaka, new CellConstraints("2 , 4 ,1,1,default," + CellConstraints.FILL));
        dataPanel.add(mOznaka, new CellConstraints("4, 4 ,1,1,default," + CellConstraints.FILL));

        dataPanel.add(jButton1, new CellConstraints(2, 2, 1, 1, CellConstraints.DEFAULT, CellConstraints.DEFAULT));
        labelmBrojpumpi.setLabelFor(mBrojpumpi);
        labelmBrojpumpi.setText(panelBinding.findCtrlValueBinding("Brojpumpi").getLabel());
        mBrojpumpi.setToolTipText(panelBinding.findCtrlValueBinding("Brojpumpi").getTooltip());
        mBrojpumpi.setColumns(15);

        labelmOznaka.setLabelFor(mOznaka);
        labelmOznaka.setText(panelBinding.findCtrlValueBinding("Oznaka").getLabel());
        mOznaka.setToolTipText(panelBinding.findCtrlValueBinding("Oznaka").getTooltip());
        mOznaka.setColumns(15);
        navBar.setModel(JUNavigationBar.createViewBinding(panelBinding, navBar, "Transmaster1", null,
                                                          "Transmaster1Iterator"));
        add(navBar, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);
        //BindingCodes
        mBrojpumpi.setToolTipText((panelBinding.findCtrlValueBinding("Brojpumpi")).getTooltip());
        mBrojpumpi.setColumns(panelBinding.findCtrlValueBinding("Brojpumpi").getDisplayWidth());
        mOznaka.setToolTipText((panelBinding.findCtrlValueBinding("Oznaka")).getTooltip());
        mOznaka.setColumns(panelBinding.findCtrlValueBinding("Oznaka").getDisplayWidth());

        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("Transmaster1", "Brojpumpi", null))) {
            dataPanel.remove(mBrojpumpi);
            dataPanel.remove(labelmBrojpumpi);
        }
        if ("Hide".equalsIgnoreCase(panelBinding.getDisplayHint("Transmaster1", "Oznaka", null))) {
            dataPanel.remove(mOznaka);
            dataPanel.remove(labelmOznaka);
        }

        mBrojpumpi.setDocument((Document) panelBinding.bindUIControl("Brojpumpi", mBrojpumpi));
        mOznaka.setDocument((Document) panelBinding.bindUIControl("Oznaka", mOznaka));
        jButton1.setModel((ButtonModel) panelBinding.bindUIControl("proba1", jButton1));
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
