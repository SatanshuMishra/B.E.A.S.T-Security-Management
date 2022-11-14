import java.util.ArrayList;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 
import javax.swing.table.DefaultTableModel;

public class SystemTerminalGui extends javax.swing.JFrame {

    public SystemTerminalGui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
                     
    private void initComponents() {

        LoginScreen = new javax.swing.JPanel();
        HelloText = new javax.swing.JLabel();
        SignInToAccText = new javax.swing.JLabel();
        KeyIdField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JTextField();
        signInBtn = new javax.swing.JButton();
        panelRound3 = new swing_assets.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        configPage = new javax.swing.JPanel();
        navigationBar = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        systemLabel = new javax.swing.JLabel();
        logOutLabel = new javax.swing.JLabel();
        dashboardLabel = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        paneCollection = new javax.swing.JTabbedPane();
        dashboardPane = new javax.swing.JPanel();
        welcomeBackPane = new swing_assets.PanelRound();
        imageLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        welcomeBackLabel = new javax.swing.JLabel();
        dashboardTitleText = new javax.swing.JLabel();
        dataText = new javax.swing.JLabel();
        usersPane = new javax.swing.JPanel();
        usersTitleText = new javax.swing.JLabel();
        activeUsersPane = new swing_assets.PanelRound();
        activeUsersLabel = new javax.swing.JLabel();
        activeUsers = new javax.swing.JLabel();
        suspendedUsersPane = new swing_assets.PanelRound();
        suspendedUsersLabel = new javax.swing.JLabel();
        suspendedUsers = new javax.swing.JLabel();
        privilegedUsersPane = new swing_assets.PanelRound();
        privilegedUsersLabel = new javax.swing.JLabel();
        privilegedUsers = new javax.swing.JLabel();
        lookingForPane = new swing_assets.PanelRound();
        lookingForLabel = new javax.swing.JLabel();
        findButton = new javax.swing.JButton();
        findField = new swing_assets.TextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        usersTable = new swing_assets.Table();
        addNewUser = new javax.swing.JButton();
        resetQuery = new javax.swing.JButton();
        terminal = new SystemTerminal(new Room(1, 1, 4));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        LoginScreen.setBackground(new java.awt.Color(22, 98, 243));
        LoginScreen.setMaximumSize(new java.awt.Dimension(950, 550));
        LoginScreen.setMinimumSize(new java.awt.Dimension(950, 550));
        LoginScreen.setPreferredSize(new java.awt.Dimension(950, 550));
        LoginScreen.setRequestFocusEnabled(false);

        HelloText.setFont(new java.awt.Font("Segoe UI Black", 1, 60)); // NOI18N
        HelloText.setForeground(new java.awt.Color(255, 255, 255));
        HelloText.setText("Hello");

        SignInToAccText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignInToAccText.setForeground(new java.awt.Color(255, 255, 255));
        SignInToAccText.setText("Sign in to your account.");

        KeyIdField.setBackground(new java.awt.Color(22, 98, 243));
        KeyIdField.setForeground(new java.awt.Color(255, 255, 255));

        // -DEBUG-
        KeyIdField.setText("Enter your KeyCard ID");
        // KeyIdField.setText("38f5b748-0ca9-4873-ad07-014749cf8389");

        KeyIdField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        KeyIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(KeyIdField.getText().equals("Enter your KeyCard ID"))
                    KeyIdField.setText("");
            }
        });
        KeyIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(KeyIdField.getText().equals(""))
                    KeyIdField.setText("Enter your KeyCard ID");
            }
        });

        PasswordField.setBackground(new java.awt.Color(22, 98, 243));
        PasswordField.setForeground(new java.awt.Color(255, 255, 255));

        // -DEBUG-
        PasswordField.setText("Enter your password");
        // PasswordField.setText("Johnpass");
        PasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));        PasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(PasswordField.getText().equals("Enter your password"))
                    PasswordField.setText("");
            }
        });
        PasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(PasswordField.getText().equals(""))
                    PasswordField.setText("Enter your password");
            }
        });

        signInBtn.setBackground(new java.awt.Color(255, 255, 255));
        signInBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(0, 0, 0));
        signInBtn.setText("SIGN IN");
        signInBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String enteredKeyID = KeyIdField.getText().toString();
                String enteredPassword = PasswordField.getText().toString();
                User user = terminal.authenticateUser(enteredKeyID);
                if(user != null){
                    if(terminal.checkPassword(user, enteredPassword)){
                        LoginScreen.setVisible(false);
                        userNameLabel.setText(user.getFirstName());
                        paneCollection.setSelectedIndex(0);
                        configPage.setVisible(true);
                    } else {
                        Notify notifyWindow = new Notify();
                        notifyWindow.setVisible(true);
                    }
                } else{
                    Notify notifyWindow = new Notify();
                    notifyWindow.setVisible(true);
                }
            }
        });

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(0);
        panelRound3.setRoundTopLeft(0);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/undraw_my_password_re_ydq7@0.8x.png"))); // NOI18N

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(33, 33, 33))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout LoginScreenLayout = new javax.swing.GroupLayout(LoginScreen);
        LoginScreen.setLayout(LoginScreenLayout);
        LoginScreenLayout.setHorizontalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginScreenLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(signInBtn)
                    .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(KeyIdField)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(HelloText)
                        .addComponent(SignInToAccText, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginScreenLayout.setVerticalGroup(
            LoginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginScreenLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(HelloText)
                .addGap(0, 0, 0)
                .addComponent(SignInToAccText)
                .addGap(30, 30, 30)
                .addComponent(KeyIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(signInBtn)
                .addGap(138, 138, 138))
            .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(LoginScreen, "card2");

        configPage.setBackground(new java.awt.Color(247, 248, 252));
        configPage.setForeground(new java.awt.Color(247, 248, 252));
        configPage.setMaximumSize(new java.awt.Dimension(950, 550));
        configPage.setMinimumSize(new java.awt.Dimension(950, 550));
        configPage.setPreferredSize(new java.awt.Dimension(950, 550));

        navigationBar.setBackground(new java.awt.Color(255, 255, 255));
        navigationBar.setForeground(new java.awt.Color(255, 255, 255));

        userLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        userLabel.setForeground(new java.awt.Color(40, 48, 59));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/users-alt.png"))); // NOI18N
        userLabel.setText("Users");
        userLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 0, 0));
        userLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                initializeData();
                paneCollection.setSelectedIndex(1);
            }
        });

        systemLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        systemLabel.setForeground(new java.awt.Color(40, 48, 59));
        systemLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        systemLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/code-compare.png"))); // NOI18N
        systemLabel.setText("System");
        systemLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 0, 0));

        logOutLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        logOutLabel.setForeground(new java.awt.Color(40, 48, 59));
        logOutLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logOutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/exit.png"))); // NOI18N
        logOutLabel.setText("Sign out");
        logOutLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 0, 0));
        logOutLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logOutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeyIdField.setText("Enter your KeyCard ID");
                PasswordField.setText("Enter your password");
                
                configPage.setVisible(false);
                LoginScreen.setVisible(true);
            }
        });

        dashboardLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        dashboardLabel.setForeground(new java.awt.Color(40, 48, 59));
        dashboardLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/dashboard.png"))); // NOI18N
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 2, 0, 0));
        dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paneCollection.setSelectedIndex(0);
            }
        });

        javax.swing.GroupLayout navigationBarLayout = new javax.swing.GroupLayout(navigationBar);
        navigationBar.setLayout(navigationBarLayout);
        navigationBarLayout.setHorizontalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addGap(0, 21, Short.MAX_VALUE)
                .addGroup(navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(systemLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logOutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        navigationBarLayout.setVerticalGroup(
            navigationBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBarLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(dashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(systemLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257)
                .addComponent(logOutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPane.setBackground(new java.awt.Color(247, 248, 252));
        contentPane.setForeground(new java.awt.Color(247, 248, 252));

        paneCollection.setBackground(new java.awt.Color(247, 247, 247));
        paneCollection.setForeground(new java.awt.Color(0, 0, 0));
        paneCollection.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        paneCollection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dashboardPane.setBackground(new java.awt.Color(247, 247, 247));
        dashboardPane.setForeground(new java.awt.Color(247, 248, 252));

        welcomeBackPane.setBackground(new java.awt.Color(248, 72, 94));
        welcomeBackPane.setRoundBottomLeft(20);
        welcomeBackPane.setRoundBottomRight(20);
        welcomeBackPane.setRoundTopLeft(20);
        welcomeBackPane.setRoundTopRight(20);

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/undraw_dev_focus_re_6iwt@0.8x.png"))); // NOI18N

        userNameLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("Name");

        welcomeBackLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        welcomeBackLabel.setForeground(new java.awt.Color(255, 255, 255));
        welcomeBackLabel.setText("Welcome back,");

        javax.swing.GroupLayout welcomeBackPaneLayout = new javax.swing.GroupLayout(welcomeBackPane);
        welcomeBackPane.setLayout(welcomeBackPaneLayout);
        welcomeBackPaneLayout.setHorizontalGroup(
            welcomeBackPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomeBackPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(welcomeBackPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeBackLabel)
                    .addComponent(userNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(imageLabel)
                .addGap(54, 54, 54))
        );
        welcomeBackPaneLayout.setVerticalGroup(
            welcomeBackPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeBackPaneLayout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(welcomeBackPaneLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(welcomeBackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dashboardTitleText.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        dashboardTitleText.setForeground(new java.awt.Color(0, 0, 0));
        dashboardTitleText.setText("Dashboard");

        java.util.Date date = new java.util.Date();    

        dataText.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
        dataText.setForeground(new java.awt.Color(153, 153, 153));
        dataText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dataText.setText(date.toString());
        dataText.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 5));

        javax.swing.GroupLayout dashboardPaneLayout = new javax.swing.GroupLayout(dashboardPane);
        dashboardPane.setLayout(dashboardPaneLayout);
        dashboardPaneLayout.setHorizontalGroup(
            dashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPaneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dashboardPaneLayout.createSequentialGroup()
                        .addComponent(dashboardTitleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dataText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(welcomeBackPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        dashboardPaneLayout.setVerticalGroup(
            dashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dashboardPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dashboardTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(welcomeBackPane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(826, Short.MAX_VALUE))
        );

        paneCollection.addTab("tab1", dashboardPane);

        usersPane.setBackground(new java.awt.Color(247, 247, 247));
        usersPane.setForeground(new java.awt.Color(247, 248, 252));

        usersTitleText.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        usersTitleText.setForeground(new java.awt.Color(0, 0, 0));
        usersTitleText.setText("Users");

        activeUsersPane.setBackground(new java.awt.Color(15, 94, 247));
        activeUsersPane.setPreferredSize(new java.awt.Dimension(213, 95));
        activeUsersPane.setRoundBottomLeft(20);
        activeUsersPane.setRoundBottomRight(20);
        activeUsersPane.setRoundTopLeft(20);
        activeUsersPane.setRoundTopRight(20);

        activeUsersLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        activeUsersLabel.setForeground(new java.awt.Color(255, 255, 255));
        activeUsersLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        activeUsersLabel.setText("Total Users");
        activeUsersLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        activeUsersLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activeUsersLabelMouseEntered(evt);
            }
        });

        activeUsers.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        activeUsers.setForeground(new java.awt.Color(255, 255, 255));
        activeUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        activeUsers.setText("65");
        activeUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        activeUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activeUsersMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout activeUsersPaneLayout = new javax.swing.GroupLayout(activeUsersPane);
        activeUsersPane.setLayout(activeUsersPaneLayout);
        activeUsersPaneLayout.setHorizontalGroup(
            activeUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activeUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(activeUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeUsersLabel)
                    .addComponent(activeUsers))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        activeUsersPaneLayout.setVerticalGroup(
            activeUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(activeUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(activeUsersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(activeUsers)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        suspendedUsersPane.setBackground(new java.awt.Color(235, 83, 83));
        suspendedUsersPane.setRoundBottomLeft(20);
        suspendedUsersPane.setRoundBottomRight(20);
        suspendedUsersPane.setRoundTopLeft(20);
        suspendedUsersPane.setRoundTopRight(20);

        suspendedUsersLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        suspendedUsersLabel.setForeground(new java.awt.Color(255, 255, 255));
        suspendedUsersLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        suspendedUsersLabel.setText("Suspended Users");
        suspendedUsersLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        suspendedUsersLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suspendedUsersLabelMouseEntered(evt);
            }
        });

        suspendedUsers.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        suspendedUsers.setForeground(new java.awt.Color(255, 255, 255));
        suspendedUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        suspendedUsers.setText("23");
        suspendedUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        suspendedUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                suspendedUsersMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout suspendedUsersPaneLayout = new javax.swing.GroupLayout(suspendedUsersPane);
        suspendedUsersPane.setLayout(suspendedUsersPaneLayout);
        suspendedUsersPaneLayout.setHorizontalGroup(
            suspendedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suspendedUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(suspendedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suspendedUsersLabel)
                    .addComponent(suspendedUsers))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        suspendedUsersPaneLayout.setVerticalGroup(
            suspendedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suspendedUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(suspendedUsersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suspendedUsers)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        privilegedUsersPane.setBackground(new java.awt.Color(255, 184, 0));
        privilegedUsersPane.setRoundBottomLeft(20);
        privilegedUsersPane.setRoundBottomRight(20);
        privilegedUsersPane.setRoundTopLeft(20);
        privilegedUsersPane.setRoundTopRight(20);

        privilegedUsersLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 15)); // NOI18N
        privilegedUsersLabel.setForeground(new java.awt.Color(0, 0, 0));
        privilegedUsersLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        privilegedUsersLabel.setText("Privileged Users");
        privilegedUsersLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        privilegedUsersLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                privilegedUsersLabelMouseEntered(evt);
            }
        });

        privilegedUsers.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        privilegedUsers.setForeground(new java.awt.Color(0, 0, 0));
        privilegedUsers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        privilegedUsers.setText("45");
        privilegedUsers.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        privilegedUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                privilegedUsersMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout privilegedUsersPaneLayout = new javax.swing.GroupLayout(privilegedUsersPane);
        privilegedUsersPane.setLayout(privilegedUsersPaneLayout);
        privilegedUsersPaneLayout.setHorizontalGroup(
            privilegedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(privilegedUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(privilegedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(privilegedUsersLabel)
                    .addComponent(privilegedUsers))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        privilegedUsersPaneLayout.setVerticalGroup(
            privilegedUsersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(privilegedUsersPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(privilegedUsersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(privilegedUsers)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        lookingForPane.setBackground(new java.awt.Color(255, 255, 255));
        lookingForPane.setRoundBottomLeft(20);
        lookingForPane.setRoundBottomRight(20);
        lookingForPane.setRoundTopLeft(20);
        lookingForPane.setRoundTopRight(20);

        lookingForLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        lookingForLabel.setForeground(new java.awt.Color(40, 48, 59));
        lookingForLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lookingForLabel.setText("Who are you looking for?");
        lookingForLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        lookingForLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lookingForLabelMouseEntered(evt);
            }
        });

        findButton.setBackground(new java.awt.Color(22, 98, 243));
        findButton.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        findButton.setForeground(new java.awt.Color(255, 255, 255));
        findButton.setText("Find");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayQueryResult();
            }
        });

        findField.setBackground(new java.awt.Color(247, 247, 247));
        findField.setText("Enter a name");
        findField.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        findField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if(findField.getText().equals("Enter a name"))
                    findField.setText("");
            }
        });
        findField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if(findField.getText().equals(""))
                    findField.setText("Enter a name");
            }
        });

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane5.setForeground(new java.awt.Color(255, 255, 255));

        usersTable.setBackground(new java.awt.Color(255, 255, 255));
        usersTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        usersTable.setForeground(new java.awt.Color(0, 0, 0));
        usersTableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Clearance", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        usersTable.setModel(usersTableModel);
        usersTable.setColumnSelectionAllowed(true);
        usersTable.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        usersTable.setSelectionBackground(new java.awt.Color(22, 98, 243));
        usersTable.setShowHorizontalLines(false);
        usersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(usersTable);
        usersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(0).setResizable(false);
            usersTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(35);
            usersTable.getColumnModel().getColumn(3).setPreferredWidth(35);
        }
        usersTable.getColumnModel().removeColumn(usersTable.getColumn("ID"));
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRow = usersTable.getSelectedRow();
                String id = usersTableModel.getValueAt(selectedRow, 0).toString();

                ModifyUserModal popup = new ModifyUserModal();
                User user = terminal.findUser(id);
                popup.setValues(user);
                popup.setVisible(true);
            }
        });

        addNewUser.setBackground(new java.awt.Color(10, 25, 49));
        addNewUser.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        addNewUser.setForeground(new java.awt.Color(255, 255, 255));
        addNewUser.setText("Add New User");
        addNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserModal popup = new AddUserModal();
                popup.setVisible(true);
            }
        });

        resetQuery.setBackground(new java.awt.Color(10, 25, 49));
        resetQuery.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        resetQuery.setForeground(new java.awt.Color(255, 255, 255));
        resetQuery.setText("Refresh Table");
        resetQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initializeData();
            }
        });

        javax.swing.GroupLayout lookingForPaneLayout = new javax.swing.GroupLayout(lookingForPane);
        lookingForPane.setLayout(lookingForPaneLayout);
        lookingForPaneLayout.setHorizontalGroup(
            lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lookingForPaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lookingForPaneLayout.createSequentialGroup()
                        .addComponent(lookingForLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resetQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lookingForPaneLayout.createSequentialGroup()
                        .addComponent(findField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(findButton)))
                .addGap(20, 20, 20))
        );
        lookingForPaneLayout.setVerticalGroup(
            lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lookingForPaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lookingForLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(lookingForPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout usersPaneLayout = new javax.swing.GroupLayout(usersPane);
        usersPane.setLayout(usersPaneLayout);
        usersPaneLayout.setHorizontalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPaneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usersTitleText)
                    .addGroup(usersPaneLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(activeUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(suspendedUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(privilegedUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lookingForPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        usersPaneLayout.setVerticalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(usersTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(usersPaneLayout.createSequentialGroup()
                        .addGroup(usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersPaneLayout.createSequentialGroup()
                                .addComponent(suspendedUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usersPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(activeUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lookingForPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(privilegedUsersPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(609, 609, 609))
        );

        paneCollection.addTab("tab2", usersPane);

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(paneCollection)
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneCollection)
                .addContainerGap())
        );

        paneCollection.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout configPageLayout = new javax.swing.GroupLayout(configPage);
        configPage.setLayout(configPageLayout);
        configPageLayout.setHorizontalGroup(
            configPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPageLayout.createSequentialGroup()
                .addComponent(navigationBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        configPageLayout.setVerticalGroup(
            configPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navigationBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getContentPane().add(configPage, "card3");

        pack();
    }                   
    
    private void tableInit(){
        usersTable.fixTable(jScrollPane5);
    }

    private void clearUsersTable() {                                           
        int rowCount = usersTable.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            usersTableModel.removeRow(i);
        }
    }                                          

    private void repopulateUsersTable() {                                              
        ArrayList<Object[]> tableRows = terminal.fetchTable();

        if(!tableRows.isEmpty()){
            for (int i = 0; i < tableRows.size(); i++) {
                Object[] row = tableRows.get(i);
                usersTable.addRow(row);
            }
        } else{
            System.out.println("THERE ARE NO USERS IN THE DATABASE!");
        }
    }
    
    private void repopulateUsersTable(ArrayList<Object[]> table) {                                              
        ArrayList<Object[]> tableRows = table;

        if(!tableRows.isEmpty()){
            for (int i = 0; i < tableRows.size(); i++) {
                Object[] row = tableRows.get(i);
                usersTable.addRow(row);
            }
        } else{
            System.out.println("THERE ARE NO USERS IN THE DATABASE!");
        }
    }

    private void initializeData() {  
        clearUsersTable();                                       
        activeUsers.setText(String.valueOf(terminal.countUsers()));
        suspendedUsers.setText(String.valueOf(terminal.countSuspendedUsers()));
        privilegedUsers.setText(String.valueOf(terminal.countPrivilagedUsers()));
        repopulateUsersTable();
    }                                                                                                             

    private void displayQueryResult() {
        String[] searchTerms = findField.getText().split(" ");
        if(searchTerms.length == 2){
            clearUsersTable();
            repopulateUsersTable(terminal.findUser(searchTerms[0], searchTerms[1]));
        } else{
            System.out.println("INVALID SEARCH PARAMETERS");
        }
    }                                           

    private void KeyIdFieldFocusGained(java.awt.event.FocusEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void lookingForLabelMouseEntered(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void findFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void activeUsersLabelMouseEntered(java.awt.event.MouseEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void activeUsersMouseEntered(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void suspendedUsersLabelMouseEntered(java.awt.event.MouseEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void suspendedUsersMouseEntered(java.awt.event.MouseEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void privilegedUsersLabelMouseEntered(java.awt.event.MouseEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void privilegedUsersMouseEntered(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void addNewUserActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void resetQueryActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(SystemTerminalGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemTerminalGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemTerminalGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemTerminalGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemTerminalGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel HelloText;
    private javax.swing.JTextField KeyIdField;
    private javax.swing.JPanel LoginScreen;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JLabel SignInToAccText;
    private javax.swing.JLabel activeUsers;
    private javax.swing.JLabel activeUsersLabel;
    private swing_assets.PanelRound activeUsersPane;
    private javax.swing.JButton addNewUser;
    private javax.swing.JPanel configPage;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JPanel dashboardPane;
    private javax.swing.JLabel dashboardTitleText;
    private javax.swing.JLabel dataText;
    private javax.swing.JButton findButton;
    private swing_assets.TextField findField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton signInBtn;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel logOutLabel;
    private javax.swing.JLabel lookingForLabel;
    private swing_assets.PanelRound lookingForPane;
    private javax.swing.JPanel navigationBar;
    private javax.swing.JTabbedPane paneCollection;
    private swing_assets.PanelRound panelRound3;
    private javax.swing.JLabel privilegedUsers;
    private javax.swing.JLabel privilegedUsersLabel;
    private swing_assets.PanelRound privilegedUsersPane;
    private javax.swing.JButton resetQuery;
    private javax.swing.JLabel suspendedUsers;
    private javax.swing.JLabel suspendedUsersLabel;
    private swing_assets.PanelRound suspendedUsersPane;
    private javax.swing.JLabel systemLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JPanel usersPane;
    private swing_assets.Table usersTable;
    private javax.swing.JLabel usersTitleText;
    private javax.swing.JLabel welcomeBackLabel;
    private swing_assets.PanelRound welcomeBackPane;
    private SystemTerminal terminal;
    private DefaultTableModel usersTableModel;
    // End of variables declaration                   
}
