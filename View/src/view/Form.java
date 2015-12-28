package view;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import javax.swing.text.Document;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFactory;
import oracle.adf.model.binding.DCDataControl;

import oracle.jbo.common.DefLocaleContext;
import oracle.jbo.uicli.binding.JUUtil;
import oracle.jbo.uicli.controls.JUErrorHandlerDlg;
import oracle.jbo.uicli.controls.JUNavigationBar;
import oracle.jbo.uicli.jui.JUEnvInfoProvider;
import oracle.jbo.uicli.jui.JUPanelBinding;
import oracle.jbo.uicli.mom.JUMetaObjectManager;


import view.pomocne.pumpaPanel;

public class Form extends JFrame {
    //PageDefinition File	
    private JUPanelBinding panelBinding = new JUPanelBinding("view_FormPageDef");
    private GridLayout gridLayout = new GridLayout();
    private BorderLayout borderLayout = new BorderLayout();
    private JPanel topPanel = new JPanel();
    private JPanel dataPanel = new JPanel();
    private JPanel pumpePanel = new JPanel();
    private JMenuBar menubarFrame = new JMenuBar();
    JUNavigationBar hiddenNavBar = new JUNavigationBar() {
        protected void _updateButtonStates() {
            super._updateButtonStates();
            menuItemsUpdate();
        }
    };

    private JMenu menuFile = new JMenu();
    private JMenuItem itemFileExit = new JMenuItem();
    private JMenu menuDatabase = new JMenu();
    private JMenuItem itemDatabaseFirst = new JMenuItem();
    private JMenuItem itemDatabasePrevious = new JMenuItem();
    private JMenuItem itemDatabaseNext = new JMenuItem();
    private JMenuItem itemDatabaseLast = new JMenuItem();
    private JMenuItem itemDatabaseInsert = new JMenuItem();
    private JMenuItem itemDatabaseDelete = new JMenuItem();
    private JMenuItem itemDatabaseCommit = new JMenuItem();
    private JMenuItem itemDatabaseRollback = new JMenuItem();
    private JMenuItem itemFindMode = new JMenuItem();
    private JMenuItem itemExecute = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem itemHelpAbout = new JMenuItem();
    private String aboutMessage = "about message";
    private String aboutTitle = "about title ";
    private JButton jButton2 = new JButton(); 
    //ArrayList<JButton> buttoni;
    private PanelTransmaster1Helper panelTransmaster1Helper1 = new PanelTransmaster1Helper();
    private JButton jButton3 = new JButton();
    private JButton jButton4 = new JButton();
    private JTextField jTextField1 = new JTextField();
    
    
    
    private Boolean init = false;
    
    
    
    ArrayList<PanelPumpa1> pumpaContainer;
    private FlowLayout flowLayout1 = new FlowLayout();
    
    private void createPumpe(int num){
        pumpaContainer = new ArrayList<PanelPumpa1>();
        for (int i = 0; i<num; i++){
            PanelPumpa1 p1 = new PanelPumpa1(i);
            pumpaContainer.add(p1);
            //System.out.println("---------"+p1.getVelicinaReda());
            //pumpaContainer.add(pumpaPanel);    
        } 
        init=true;
        
        /* pumpaPanel p1 = new pumpaPanel(num);
        pumpaContainer.add(p1);
        init = true; */
    }


    /**The default constructor for form
     */
    public Form() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int action = _popupTransactionDialog();
                if (action != JOptionPane.CLOSED_OPTION) {
                    panelBinding.releaseDataControl();

                    System.exit(0);
                }
            }
        });
    }


    /**the JbInit method
     */
    public void jbInit() throws Exception {
        panelTransmaster1Helper1.bindNestedContainer(panelBinding.findNestedPanelBinding("view_PanelTransmaster1HelperPageDef1"));
        dataPanel.setLayout(null);
        pumpePanel.setBounds(new Rectangle(5, 140, 430, 150));
        pumpePanel.setLayout(gridLayout);
        this.getContentPane().setLayout(gridLayout);
        topPanel.setLayout(borderLayout);
        this.getContentPane().add(topPanel);
        this.setSize(new Dimension(600, 350));
        pumpePanel.setLayout(flowLayout1);
        
        
        /* pumpaPanel p1 = new pumpaPanel("pumpa 1");
        pumpePanel.add(p1);
        pumpaPanel p2 = new pumpaPanel("pumpa 2");
        pumpePanel.add(p2); */
        
        /* for (int i = 0; i <1; i++){
            buttoni[i] = new JButton();
            dataPanel.add(buttoni[i], null);
        }  */
        /* buttoni[0] = new JButton();
        dataPanel.add(buttoni[0], null); */
        //createButtons(0);
        /*if (buttoni != null){
            for (JButton but : buttoni) {
                pumpePanel.add(but, null);
            }    
        }*/
        
        //System.out.println(" ---#####" + pumpaContainer);
        /* pumpaPanel p1 = new pumpaPanel(2);
        pumpaContainer.add(p1);
        for (pumpaPanel but : pumpaContainer) {
            
            pumpePanel.add(but, null);
            System.out.println("dodajem ");
        } */
        
        
        
        
        
        
        
        /* System.out.println("pump " + pumpePanel.getComponentCount());
        for(int i =0; i<pumpePanel.getComponentCount();i++){
            System.out.println(pumpePanel.getComponent(i));
        } */
        
        /* JButton but = getButtons().get(0);
        dataPanel.add(but,null); */
        


        //dataPanel.add(pumpePanel);
        dataPanel.add(jTextField1, null);
        dataPanel.add(jButton4, null);
        dataPanel.add(jButton3, null);
        dataPanel.add(panelTransmaster1Helper1, null);
        topPanel.add(dataPanel, BorderLayout.CENTER);
        

        setJMenuBar(menubarFrame);
        itemFileExit.setText("Exit");
        itemFileExit.setMnemonic('X');
        itemFileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, Event.ALT_MASK, false));
        itemFileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                file_exit_action(e);
            }
        });
        menuFile.add(itemFileExit);
        menuFile.setText("File");
        menuFile.setMnemonic('F');
        menubarFrame.add(menuFile);
        menuDatabase.setText("Database");
        menuDatabase.setMnemonic('D');
        itemDatabaseFirst.setText("First");
        itemDatabaseFirst.setMnemonic('F');
        itemDatabaseFirst.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, Event.ALT_MASK, false));
        itemDatabaseFirst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                first_action(e);
            }
        });
        menuDatabase.add(itemDatabaseFirst);
        itemDatabasePrevious.setText("Previous");
        itemDatabasePrevious.setMnemonic('P');
        itemDatabasePrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, Event.ALT_MASK, false));
        itemDatabasePrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                previous_action(e);
            }
        });
        menuDatabase.add(itemDatabasePrevious);
        itemDatabaseNext.setText("Next");
        itemDatabaseNext.setMnemonic('N');
        itemDatabaseNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, Event.ALT_MASK, false));

        itemDatabaseNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next_action(e);
            }
        });

        menuDatabase.add(itemDatabaseNext);
        itemDatabaseLast.setText("Last");
        itemDatabaseLast.setMnemonic('L');
        itemDatabaseLast.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_END, Event.ALT_MASK, false));
        itemDatabaseLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                last_action(e);
            }
        });
        menuDatabase.add(itemDatabaseLast);
        menuDatabase.addSeparator();
        itemDatabaseInsert.setText("Insert");
        itemDatabaseInsert.setMnemonic('I');
        itemDatabaseInsert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, Event.ALT_MASK, false));

        itemDatabaseInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insert_action(e);
            }
        });

        menuDatabase.add(itemDatabaseInsert);
        itemDatabaseDelete.setText("Delete");
        itemDatabaseDelete.setMnemonic('D');
        itemDatabaseDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, Event.ALT_MASK, false));

        itemDatabaseDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete_action(e);
            }
        });
        menuDatabase.add(itemDatabaseDelete);
        menuDatabase.addSeparator();
        itemDatabaseCommit.setText("Commit");
        itemDatabaseCommit.setMnemonic('C');
        itemDatabaseCommit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.ALT_MASK, false));

        itemDatabaseCommit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                commit_action(e);
            }
        });
        menuDatabase.add(itemDatabaseCommit);
        itemDatabaseRollback.setText("Rollback");
        itemDatabaseRollback.setMnemonic('R');
        itemDatabaseRollback.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.ALT_MASK, false));

        itemDatabaseRollback.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rollback_action(e);
            }
        });
        menuDatabase.add(itemDatabaseRollback);
        menuDatabase.addSeparator();
        itemFindMode.setText("Query Mode");
        itemFindMode.setMnemonic('Q');
        itemFindMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.ALT_MASK, false));

        itemFindMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                find_action(e);
            }
        });
        menuDatabase.add(itemFindMode);
        itemExecute.setText("Execute Query");
        itemExecute.setMnemonic('E');
        itemExecute.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.ALT_MASK, false));

        itemExecute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                execute_action(e);
            }
        });
        menuDatabase.add(itemExecute);
        menubarFrame.add(menuDatabase);
        menuHelp.setText("Help");
        menuHelp.setMnemonic('H');
        itemHelpAbout.setText("About");
        itemHelpAbout.setMnemonic('A');

        itemHelpAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                help_about_action(e);
            }
        });
        panelTransmaster1Helper1.setBounds(new Rectangle(125, 0, 320, 100));
        jButton3.setText("jButton3");
        jButton3.setBounds(new Rectangle(30, 20, 75, 21));
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton3_actionPerformed(e);
            }
        });
        jButton4.setText("proba");
        jButton4.setBounds(new Rectangle(30, 45, 75, 21));
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton4_actionPerformed(e);
            }
        });
        menuHelp.add(itemHelpAbout);
        menubarFrame.add(menuHelp);

        hiddenNavBar.setModel(JUNavigationBar.createPanelBinding(panelBinding, hiddenNavBar));
        /* for (int i = 0; i<2; i++){
            buttoni[i].setText("button" + i);
            buttoni[i].setBounds(new Rectangle(30,30+i*15,75,20));
        }  */
        /*  buttoni.get(0).setText("button1");
        buttoni.get(0).setBounds(new Rectangle(30,30,75,20)); */
        /* int inc = 1;
        if (pumpaContainer != null){
            for (JPanel but : pumpaContainer){
                JButton b = (JButton) but.getComponent(3);
                b.setText("button " + inc);
                b.setBounds(new Rectangle(30,30+inc*35,75,20));
                inc++;
            }
        } */
        
        PanelPumpa1 p1 = new PanelPumpa1(3);
        dataPanel.add(p1);
        
        jButton2.setText("jButton2");
        jButton2.setBounds(new Rectangle(30, 80, 75, 21));
        jTextField1.setBounds(new Rectangle(0, 70, 124, 20));
        jTextField1.setToolTipText((panelBinding.findCtrlValueBinding("Brojpumpi1")).getTooltip());
        jTextField1.setColumns((panelBinding.findCtrlValueBinding("Brojpumpi1")).getDisplayWidth());
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField1_actionPerformed(e);
            }
        });
        jButton4.setModel((ButtonModel) panelBinding.bindUIControl("proba", jButton4));
        jTextField1.setDocument((Document) panelBinding.bindUIControl("Brojpumpi1", jTextField1));
        //pumpaPanel.setLayout(verticalFlowLayout1);
        //dataPanel.repaint();
        
        
    } 


    private void first_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_FIRST);
    }

    private void previous_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_PREV);
    }

    private void next_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_NEXT);
    }

    private void last_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_LAST);
    }

    private void insert_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_INSERT);
    }

    private void delete_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_DELETE);
    }

    private void commit_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_COMMIT);
    }

    private void rollback_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_ROLLBACK);
    }

    private void find_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_FIND);
    }

    private void execute_action(ActionEvent e) {
        hiddenNavBar.doAction(JUNavigationBar.BUTTON_EXECUTE);
    }

    private void file_exit_action(ActionEvent e) {
        int action = _popupTransactionDialog();
        if (action != JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }
    }

    private void help_about_action(ActionEvent e) {
        JOptionPane.showMessageDialog(this, aboutMessage, aboutTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    private void menuItemsUpdate() {
        itemDatabaseFirst.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_FIRST));
        itemDatabasePrevious.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_PREV));
        itemDatabaseLast.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_LAST));
        itemDatabaseNext.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_NEXT));
        itemDatabaseInsert.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_INSERT));
        itemDatabaseDelete.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_DELETE));
        itemDatabaseCommit.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_COMMIT));
        itemDatabaseRollback.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_ROLLBACK));
        itemFindMode.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_FIND));
        itemExecute.setEnabled(hiddenNavBar.isButtonActive(JUNavigationBar.BUTTON_EXECUTE));
    }


    private int _popupTransactionDialog() {
        if (panelBinding == null || panelBinding.getPanel() == null) {
            return JOptionPane.NO_OPTION;
        }
        if (panelBinding.isTransactionDirty()) {
            JButton commitButton = new JButton("Commit");
            commitButton.setMnemonic('C');
            JButton rollBackButton = new JButton("Rollback");
            rollBackButton.setMnemonic('R');
            Object[] options = { commitButton, rollBackButton };
            final JOptionPane optionPane =
                new JOptionPane("How do you want to close the transaction?", JOptionPane.QUESTION_MESSAGE,
                                JOptionPane.YES_NO_OPTION, null, options, options[0]);
            commitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    optionPane.setValue(new Integer(JOptionPane.YES_OPTION));
                }
            });
            rollBackButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    optionPane.setValue(new Integer(JOptionPane.NO_OPTION));
                }
            });
            optionPane.createDialog(Form.this, "Transaction open").setVisible(true);

            int action = JOptionPane.CLOSED_OPTION;
            Object obj = optionPane.getValue();
            if (obj != null) {
                action = ((Integer) optionPane.getValue()).intValue();
            }
            switch (action) {
            case JOptionPane.NO_OPTION:
                hiddenNavBar.doAction(JUNavigationBar.BUTTON_ROLLBACK);
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            case JOptionPane.YES_OPTION:
            default:
                hiddenNavBar.doAction(JUNavigationBar.BUTTON_COMMIT);
                break;
            }
            return action;
        }
        return JOptionPane.NO_OPTION;
    }

    public JUPanelBinding getPanelBinding() {
        return panelBinding;
    }

    public void setPanelBinding(JUPanelBinding binding) {
        if (binding.getPanel() == null) {
            binding.setPanel(topPanel);
        }
        if (panelBinding == null || panelBinding.getPanel() == null) {
            try {
                panelBinding = binding;
                jbInit();
            } catch (Exception ex) {
                panelBinding.reportException(ex);
            }
        }
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


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exemp) {
            exemp.printStackTrace();
        }

        try {
            JUMetaObjectManager.setErrorHandler(new JUErrorHandlerDlg());
            JUMetaObjectManager mgr = JUMetaObjectManager.getJUMom();
            mgr.setJClientDefFactory(null);
            BindingContext ctx = new BindingContext();

            ctx.put(DataControlFactory.APP_PARAM_ENV_INFO, new JUEnvInfoProvider());
            ctx.setLocaleContext(new DefLocaleContext(null));
            HashMap map = new HashMap(4);
            map.put(DataControlFactory.APP_PARAMS_BINDING_CONTEXT, ctx);
            mgr.loadCpx("view.DataBindings.cpx", map);
            final Form frame = new Form();
            frame.setBindingContext(ctx);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = frame.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            frame.setVisible(true);
        } catch (Exception ex) {
            JUMetaObjectManager.reportException(null, ex, true);
            System.exit(1);
        }
    }

    private void jButton3_actionPerformed(ActionEvent e) {
        //createButtons(0);
        
        //createPumpe(1);
        int brojPumpi = Integer.valueOf(panelBinding.findCtrlValueBinding("Brojpumpi1").getInputValue().toString()); 
        createPumpe(brojPumpi);
        
        pumpePanel.removeAll();
        showPanel();
        //System.out.println(" - - -- - - - - - " + brojPumpi);
        //createButtons(brojPumpi);
        /* pumpaPanel p1 = new pumpaPanel(3);
        //jButton2.setText("buttttttt");
        
        pumpePanel.add(p1);
        pumpePanel.revalidate();
        dataPanel.add(pumpePanel);
        dataPanel.revalidate();
        validate();         */
        /* dataPanel.add(p1);
        dataPanel.revalidate();
        validate(); */
    }
    
    private void showPanel(){
        
        if (pumpaContainer != null){
            System.out.println("ušao");
            pumpePanel.setSize(600,300);
            for (PanelPumpa1 p : pumpaContainer){
                pumpePanel.add(p);
            }
            pumpePanel.revalidate();
            dataPanel.add(pumpePanel);
            dataPanel.revalidate();
            validate();  
        }
        
        
        /* pumpaPanel p1 = new pumpaPanel(1);
        pumpaPanel p2 = new pumpaPanel(2);
        pumpaPanel p3 = new pumpaPanel(3);
        pumpaPanel p4 = new pumpaPanel(4);
        pumpaContainer = new ArrayList<pumpaPanel>();
        pumpaContainer.add(p1);
        pumpaContainer.add(p2);
        pumpaContainer.add(p3);
        pumpaContainer.add(p4);
        
        
        
        pumpePanel.add(jButton2); */
        
        System.out.println("show panel");
        
    }

    private void jTextField1_actionPerformed(ActionEvent e) {
    }

    private void jButton4_actionPerformed(ActionEvent e) {
    }
}
