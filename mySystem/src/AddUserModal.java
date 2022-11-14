import java.sql.SQLException;

import javax.swing.JFrame;

public class AddUserModal extends javax.swing.JFrame {

    public AddUserModal() {
        initComponents();
        initialize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        outerPaneWhite = new javax.swing.JPanel();
        innerPaneBlue = new swing_assets.PanelRound();
        firstNameLabel = new javax.swing.JLabel();
        firstNameField = new swing_assets.TextField();
        lastNameField = new swing_assets.TextField();
        lookingForLabel1 = new javax.swing.JLabel();
        lookingForLabel2 = new javax.swing.JLabel();
        clearanceLevelSpinner = new javax.swing.JComboBox<>();
        lookingForLabel3 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        isSuspendedCheck = new javax.swing.JCheckBox();
        loginKeyField = new swing_assets.TextField();
        loginKey = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        terminal = new SystemTerminal(new Room(2, 2, 4));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        outerPaneWhite.setBackground(new java.awt.Color(255, 255, 255));

        innerPaneBlue.setBackground(new java.awt.Color(15, 94, 247));
        innerPaneBlue.setRoundBottomLeft(20);
        innerPaneBlue.setRoundBottomRight(20);
        innerPaneBlue.setRoundTopLeft(20);
        innerPaneBlue.setRoundTopRight(20);

        firstNameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        firstNameLabel.setText("First Name");
        

        firstNameField.setBackground(new java.awt.Color(247, 247, 247));
        firstNameField.setText("Enter your first name");
        firstNameField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        firstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(firstNameField.getText().equals("Enter your first name"))
                    firstNameField.setText("");
            }
        });
        firstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(firstNameField.getText().equals(""))
                    firstNameField.setText("Enter your first name");
            }
        });


        lastNameField.setBackground(new java.awt.Color(247, 247, 247));
        lastNameField.setText("Enter your last name");
        lastNameField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        lastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(lastNameField.getText().equals("Enter your last name"))
                    lastNameField.setText("");
            }
        });
        lastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(lastNameField.getText().equals(""))
                    lastNameField.setText("Enter your last name");
            }
        });

        lookingForLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lookingForLabel1.setForeground(new java.awt.Color(255, 255, 255));
        lookingForLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lookingForLabel1.setText("Last Name");
        lookingForLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lookingForLabel1MouseEntered(evt);
            }
        });

        lookingForLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lookingForLabel2.setForeground(new java.awt.Color(255, 255, 255));
        lookingForLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lookingForLabel2.setText("Clearance");
        lookingForLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lookingForLabel2MouseEntered(evt);
            }
        });

        clearanceLevelSpinner.setBackground(new java.awt.Color(255, 255, 255));
        clearanceLevelSpinner.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        clearanceLevelSpinner.setForeground(new java.awt.Color(0, 0, 0));
        clearanceLevelSpinner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        clearanceLevelSpinner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(clearanceLevelSpinner.getSelectedIndex() + 1 >= 5){
                    if(!loginKeyField.isEnabled())
                        loginKeyField.setEnabled(true);
                } else {
                    if(loginKeyField.isEnabled())
                        loginKeyField.setEnabled(false);
                }
            }
        });

        lookingForLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lookingForLabel3.setForeground(new java.awt.Color(255, 255, 255));
        lookingForLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lookingForLabel3.setText("Suspend Account");
        lookingForLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lookingForLabel3MouseEntered(evt);
            }
        });

        confirmButton.setBackground(new java.awt.Color(22, 199, 154));
        confirmButton.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        confirmButton.setForeground(new java.awt.Color(255, 255, 255));
        confirmButton.setText("Confirm");
        confirmButton.setBorder(null);
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(clearanceLevelSpinner.getSelectedIndex() + 1 >= 5){
                    updateDatabase(userUUID, keyUUID, firstNameField.getText().toString(), lastNameField.getText().toString(), loginKeyField.getText().toString(), !isSuspendedCheck.isSelected(), clearanceLevelSpinner.getSelectedIndex() + 1);
                    dispose();
                } else{
                    try {
                        updateDatabase(userUUID, keyUUID, firstNameField.getText().toString(), lastNameField.getText().toString(), !isSuspendedCheck.isSelected(), clearanceLevelSpinner.getSelectedIndex() + 1);
                        dispose();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        isSuspendedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isSuspendedCheckActionPerformed(evt);
            }
        });

        loginKeyField.setBackground(new java.awt.Color(247, 247, 247));
        loginKeyField.setText("Enter a password");
        loginKeyField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        loginKeyField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(loginKeyField.getText().equals("Enter a password"))
                    loginKeyField.setText("");
            }
        });
        loginKeyField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(loginKeyField.getText().equals(""))
                    loginKeyField.setText("Enter a password");
            }
        });

        loginKey.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        loginKey.setForeground(new java.awt.Color(255, 255, 255));
        loginKey.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginKey.setText("Login Password");
        loginKey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginKeyMouseEntered(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(241, 70, 104));
        cancelButton.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(null);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        javax.swing.GroupLayout innerPaneBlueLayout = new javax.swing.GroupLayout(innerPaneBlue);
        innerPaneBlue.setLayout(innerPaneBlueLayout);
        innerPaneBlueLayout.setHorizontalGroup(
            innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPaneBlueLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lookingForLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isSuspendedCheck)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(innerPaneBlueLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(loginKey))
                            .addGroup(innerPaneBlueLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(firstNameLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(innerPaneBlueLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lookingForLabel1)
                                    .addComponent(clearanceLevelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lookingForLabel2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, innerPaneBlueLayout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGap(24, 24, 24))))
        );
        innerPaneBlueLayout.setVerticalGroup(
            innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPaneBlueLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addComponent(lookingForLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addComponent(lookingForLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearanceLevelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(innerPaneBlueLayout.createSequentialGroup()
                        .addComponent(loginKey)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lookingForLabel3)
                    .addComponent(isSuspendedCheck))
                .addGap(18, 18, 18)
                .addGroup(innerPaneBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout outerPaneWhiteLayout = new javax.swing.GroupLayout(outerPaneWhite);
        outerPaneWhite.setLayout(outerPaneWhiteLayout);
        outerPaneWhiteLayout.setHorizontalGroup(
            outerPaneWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outerPaneWhiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(innerPaneBlue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        outerPaneWhiteLayout.setVerticalGroup(
            outerPaneWhiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outerPaneWhiteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(innerPaneBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outerPaneWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outerPaneWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                                     

    private void initialize() {                                            
        if(clearanceLevelSpinner.getSelectedIndex() + 1 >= 5){
            if(!loginKeyField.isEnabled())
                loginKeyField.setEnabled(true);
        } else {
            if(loginKeyField.isEnabled())
                loginKeyField.setEnabled(false);
        }
    }                                           

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void lookingForLabel1MouseEntered(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void lookingForLabel2MouseEntered(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void lookingForLabel3MouseEntered(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void isSuspendedCheckActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void loginKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void loginKeyMouseEntered(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void updateDatabase(String userId, String keyId, String firstName, String lastName, boolean isActive, int clearanceLevel) throws SQLException{                                        
        terminal.addUser(userId, keyId, firstName, lastName, isActive, clearanceLevel);
    }  

    private void updateDatabase(String userId, String keyId, String firstName, String lastName, String loginKey, boolean isActive, int clearanceLevel) {                                       
        terminal.addUser(userId, keyId, firstName, lastName, loginKey, isActive, clearanceLevel);
    }  

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddUserModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUserModal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton confirmButton;
    private javax.swing.JButton cancelButton;
    private swing_assets.TextField firstNameField;
    private swing_assets.TextField lastNameField;
    private swing_assets.TextField loginKeyField;
    private javax.swing.JLabel firstNameLabel;
    private swing_assets.PanelRound innerPaneBlue;
    private javax.swing.JCheckBox isSuspendedCheck;
    private javax.swing.JComboBox<String> clearanceLevelSpinner;
    private javax.swing.JLabel lookingForLabel1;
    private javax.swing.JLabel lookingForLabel2;
    private javax.swing.JLabel lookingForLabel3;
    private javax.swing.JLabel loginKey;
    private javax.swing.JPanel outerPaneWhite;
    private String userUUID, keyUUID;
    private SystemTerminal terminal;
    // End of variables declaration                   
}
