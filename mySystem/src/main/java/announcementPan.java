
public class announcementPan extends javax.swing.JPanel {

    public announcementPan(String title, String message, String author, String date) {
        initComponents();
        titleLabel.setText(title);
        bodyTextArea.setText(message);
        authorLabel.setText(author);
        dateLabel.setText(date);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyTextArea = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        titleLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("[REPLACE WITH TITTLE]");

        authorLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(0, 0, 0));
        authorLabel.setText("[REPLACE WITH AUTHOR]");

        dateLabel.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(0, 0, 0));
        dateLabel.setText("[REPLACE WITH DATE]");

        jScrollPane1.setBorder(null);

        bodyTextArea.setEditable(false);
        bodyTextArea.setBackground(new java.awt.Color(255, 255, 255));
        bodyTextArea.setColumns(10);
        bodyTextArea.setForeground(new java.awt.Color(0, 0, 0));
        bodyTextArea.setRows(5);
        bodyTextArea.setText("Hello");
        bodyTextArea.setWrapStyleWord(true);
        bodyTextArea.setBorder(null);
        jScrollPane1.setViewportView(bodyTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titleLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dateLabel)
                                                .addComponent(authorLabel)))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(titleLabel)
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(dateLabel)
                                .addContainerGap())
        );
    }
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextArea bodyTextArea;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration
}
