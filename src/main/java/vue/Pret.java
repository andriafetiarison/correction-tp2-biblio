/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vue;

import controller.LivreController;
import controller.PretController;
import controller.UtilisateurController;
import dao.PretDaoImpl;
import dao.LivreDaoImpl;
import dao.UtilisateurDaoImpl;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucah
 */
public class Pret extends javax.swing.JInternalFrame {
    
    private final PretController pretController;
    private final LivreController livreController;
    private final UtilisateurController utilisateurController;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form Pret
     */
    public Pret() {
        initComponents(); 
        numero.setVisible(false);
        PretDaoImpl pretDao = new PretDaoImpl();
        this.pretController = new PretController(pretDao);
        
        LivreDaoImpl livreDao = new LivreDaoImpl();
        this.livreController = new LivreController(livreDao);
        
        UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
        this.utilisateurController = new UtilisateurController(userDao);
        
        table.getColumnModel().getColumn(5).setMinWidth(0);
        table.getColumnModel().getColumn(5).setMaxWidth(0);
        table.getColumnModel().getColumn(5).setPreferredWidth(0);
        table.getColumnModel().getColumn(6).setMinWidth(0);
        table.getColumnModel().getColumn(6).setMaxWidth(0);
        table.getColumnModel().getColumn(6).setPreferredWidth(0);
        date_retour.setEnabled(false);
        listeLivre();
        listeUser();
        listerPret(table);
        remove();
    }
    
    public void remove(){
        putClientProperty("mouvement.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    
   public void listerPret(JTable table) {
    List<modele.Pret> list = pretController.afficherPret();
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);

    Object[] row;
    for (modele.Pret pret : list) {
        row = new Object[7];
        row[0] = pret.getId();
        row[1] = pret.getNom();
        row[2] = pret.getTitre();
        row[3] = pret.getDatePret();
        row[4] = pret.getDateRetour();
        row[5] = pret.getIdLivre();
        row[6] = pret.getIdUser();

        model.addRow(row);
    }

    // Ajouter un renderer pour colorer les lignes avec retard
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
           Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            try {
                // Récupérer la date de prêt et la date de retour
                String datePretStr = (String) table.getValueAt(row, 3);
                String dateRetourStr = (String) table.getValueAt(row, 4);

                if (datePretStr != null) {
                    Date datePret = sdf.parse(datePretStr);
                    Date maintenant = new Date();

                    if (dateRetourStr == null && (maintenant.getTime() - datePret.getTime()) > 7L * 24 * 60 * 60 * 1000) {
                        c.setBackground(Color.ORANGE);
                        c.setForeground(Color.WHITE);
                    } else {
                        c.setBackground(Color.WHITE);
                        c.setForeground(Color.BLACK);
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }

            // Conserver la couleur de sélection si la ligne est sélectionnée
            if (isSelected) {
                c.setBackground(table.getSelectionBackground());
                c.setForeground(table.getSelectionForeground());
            }

            return c;
        }
    });
}

    
   public void listeLivre(){
        List<modele.Livre> list = livreController.afficherLivre();
        for(modele.Livre books:list){
            livre.addItem(books.getId()+"-"+books.getTitre());
        }
    }
   
    public void listeUser(){
        List<modele.Utilisateur> list = utilisateurController.afficherUtilisateur();
        for(modele.Utilisateur user:list){
            utilisateur.addItem(user.getId()+"-"+user.getNom());
        }
    }
    
    public void initialise(){
        date_pret.setDate(null);
        date_retour.setDate(null);
        numero.setText("");
        date_retour.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        numero = new javax.swing.JTextField();
        livre = new javax.swing.JComboBox<>();
        utilisateur = new javax.swing.JComboBox<>();
        date_pret = new com.toedter.calendar.JDateChooser();
        date_retour = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRÊTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Livre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Utilisateur:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date prêt:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date retour:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Emprunter un livre");

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Annuler");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ajouter");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        livre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livreActionPerformed(evt);
            }
        });

        date_pret.setDateFormatString("yyyy-MM-dd");

        date_retour.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(livre, 0, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(utilisateur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(date_pret, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(date_retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(livre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(date_pret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Utilisateur", "Livre", "Date prêt", "Date retour", "idLivre", "idUser"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToggleButton1.setBackground(new java.awt.Color(255, 51, 51));
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setText("Supprimer");
        jToggleButton1.setBorder(null);
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Modifier");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jToggleButton2.setBackground(new java.awt.Color(0, 204, 102));
        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jToggleButton2.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton2.setText("Retour");
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sitka Small", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("La ligne orange indique une pénalité pour un retard de plus de 7 jours.");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7))
            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        initialise();
        jLabel6.setText("Emprunter un livre");
        jButton2.setText("Ajouter");
        
        livre.setEnabled(true);
        utilisateur.setEnabled(true);
        date_pret.setEnabled(true);
        date_retour.setEnabled(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(jButton2.getText() == "Ajouter"){
            String livres = (String) livre.getSelectedItem();
            if (livres == null || !livres.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un livre valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r1 = livres.split("-");
            int livreValue;
            try {
                livreValue = Integer.parseInt(r1[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID du livre invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String users = (String) utilisateur.getSelectedItem();
            if (users == null || !users.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r2 = users.split("-");
            int userValue;
            try {
                userValue = Integer.parseInt(r2[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de l'utilisateur invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            Date dates = date_pret.getDate();
            if (dates == null) {
                JOptionPane.showMessageDialog(null, "Veuillez compléter tous les champs.", "Attention", JOptionPane.WARNING_MESSAGE);
            }else{
                String dpValue = dateFormat.format(dates);
                modele.Pret pret = new modele.Pret();
                pret.setIdLivre(livreValue);
                pret.setIdUser(userValue);
                pret.setDatePret(dpValue);

                pretController.ajouterPret(pret);

                JOptionPane.showMessageDialog(null, "Ajout avec succès !", "Information", JOptionPane.INFORMATION_MESSAGE);
                initialise();
                listerPret(table);
            }
        }
        else if(jButton2.getText() == "Modifier"){
            String livres = (String) livre.getSelectedItem();
            if (livres == null || !livres.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un livre valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r1 = livres.split("-");
            int livreValue;
            try {
                livreValue = Integer.parseInt(r1[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID du livre invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String users = (String) utilisateur.getSelectedItem();
            if (users == null || !users.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r2 = users.split("-");
            int userValue;
            try {
                userValue = Integer.parseInt(r2[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de l'utilisateur invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date dates = date_pret.getDate();
            String numeroValue = numero.getText();
            int num = Integer.parseInt(numeroValue);

            if (dates == null) {
                JOptionPane.showMessageDialog(null, "Veuillez compléter tous les champs.", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            else{
                String dpValue = dateFormat.format(date_pret.getDate());
                modele.Pret pret = new modele.Pret();
                pret.setIdLivre(livreValue);
                pret.setIdUser(userValue);
                pret.setDatePret(dpValue);
                pret.setId(num);

                pretController.modifierPret(pret);

                JOptionPane.showMessageDialog(null,"Modification avec succès!","Information",JOptionPane.INFORMATION_MESSAGE);
                initialise();
                jLabel6.setText("Emprunter un livre");
                jButton2.setText("Ajouter");
                listerPret(table);
                
                livre.setEnabled(true);
                utilisateur.setEnabled(true);
                date_pret.setEnabled(true);
                date_retour.setEnabled(false);
            }
        }
        else{
            String livres = (String) livre.getSelectedItem();
            if (livres == null || !livres.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un livre valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r1 = livres.split("-");
            int livreValue;
            try {
                livreValue = Integer.parseInt(r1[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID du livre invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String users = (String) utilisateur.getSelectedItem();
            if (users == null || !users.contains("-")) {
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur valide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] r2 = users.split("-");
            int userValue;
            try {
                userValue = Integer.parseInt(r2[0]);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de l'utilisateur invalide.", "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Date dates = date_retour.getDate();
            String numeroValue = numero.getText();
            int num = Integer.parseInt(numeroValue);

            if (dates == null) {
                JOptionPane.showMessageDialog(null, "Veuillez compléter tous les champs.", "Attention", JOptionPane.WARNING_MESSAGE);
            }
            else{
                String drValue = dateFormat.format(date_retour.getDate());
                modele.Pret pret = new modele.Pret();
                pret.setDateRetour(drValue);
                pret.setId(num);

                pretController.restituer(pret);

                JOptionPane.showMessageDialog(null,"Restitution avec succès!","Information",JOptionPane.INFORMATION_MESSAGE);
                initialise();
                jLabel6.setText("Emprunter un livre");
                jButton2.setText("Ajouter");
                listerPret(table);
                
                livre.setEnabled(true);
                utilisateur.setEnabled(true);
                date_pret.setEnabled(true);
                date_retour.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        int itemSelected = table.getSelectedRow();
        if(table.isRowSelected(itemSelected)){
            String numeroValue = (String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
            int num = Integer.parseInt(numeroValue);

            int reponse = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment supprimer ce prêt ?",  "Confirmation",JOptionPane.YES_NO_OPTION);
            if(reponse == JOptionPane.YES_OPTION){
                pretController.supprimerPret(num);
                listerPret(table);
                JOptionPane.showMessageDialog(null,"Suppression bien réussie!","Information",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Veuillez d'abord sélectionnez l'élément à supprimer","Attention",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        livre.setEnabled(true);
        utilisateur.setEnabled(true);
        date_pret.setEnabled(true);
        date_retour.setEnabled(false);
        
        int itemSelected = table.getSelectedRow();
        if(table.isRowSelected(itemSelected)){
            numero.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
            String livreSelectionne = String.valueOf(table.getValueAt(table.getSelectedRow(),5))+"-"+String.valueOf(table.getValueAt(table.getSelectedRow(),2));
            boolean found = false;
            for (int i = 0; i < livre.getItemCount(); i++) {
                if (livre.getItemAt(i).equals(livreSelectionne)) {
                    livre.setSelectedItem(livreSelectionne);
                    found = true;
                    break;
                }
            }

            if (!found) {
                livre.addItem(livreSelectionne);
                livre.setSelectedItem(livreSelectionne);
            }
            
            String userSelected = String.valueOf(table.getValueAt(table.getSelectedRow(),6))+"-"+String.valueOf(table.getValueAt(table.getSelectedRow(),1));
            boolean foundUser = false;
            for (int i = 0; i < utilisateur.getItemCount(); i++) {
                if (utilisateur.getItemAt(i).equals(userSelected)) {
                    utilisateur.setSelectedItem(userSelected);
                    foundUser = true;
                    break;
                }
            }

            if (!foundUser) {
                utilisateur.addItem(userSelected);
                utilisateur.setSelectedItem(userSelected);
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datePret = String.valueOf(table.getValueAt(table.getSelectedRow(),3));
            
            try {
                java.util.Date parsedDate = sdf.parse(datePret);
                date_pret.setDate(parsedDate);
            } catch (ParseException ex) {
                Logger.getLogger(Pret.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String dateRetour = String.valueOf(table.getValueAt(table.getSelectedRow(),4));
            if (dateRetour == null || dateRetour.equals("null") || dateRetour.trim().isEmpty()) {
                date_retour.setDate(null);
            } else {
                try {
                    java.util.Date parsedDates = sdf.parse(dateRetour);
                    date_retour.setDate(parsedDates);
                } catch (ParseException ex) {
                    Logger.getLogger(Pret.class.getName()).log(Level.SEVERE, "Erreur de parsing de la date", ex);
                }
            }
            

            jLabel6.setText("Edition");
            jButton2.setText("Modifier");
        }else{
            JOptionPane.showMessageDialog(null,"Veuillez d'abord sélectionnez l'élément à modifier","Attention",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void livreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_livreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        livre.setEnabled(false);
        utilisateur.setEnabled(false);
        date_pret.setEnabled(false);
        date_retour.setEnabled(true);
        
        int itemSelected = table.getSelectedRow();
        if(table.isRowSelected(itemSelected)){
            numero.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
            String livreSelectionne = String.valueOf(table.getValueAt(table.getSelectedRow(),5))+"-"+String.valueOf(table.getValueAt(table.getSelectedRow(),2));
            boolean found = false;
            for (int i = 0; i < livre.getItemCount(); i++) {
                if (livre.getItemAt(i).equals(livreSelectionne)) {
                    livre.setSelectedItem(livreSelectionne);
                    found = true;
                    break;
                }
            }

            if (!found) {
                livre.addItem(livreSelectionne);
                livre.setSelectedItem(livreSelectionne);
            }
            
            String userSelected = String.valueOf(table.getValueAt(table.getSelectedRow(),6))+"-"+String.valueOf(table.getValueAt(table.getSelectedRow(),1));
            boolean foundUser = false;
            for (int i = 0; i < utilisateur.getItemCount(); i++) {
                if (utilisateur.getItemAt(i).equals(userSelected)) {
                    utilisateur.setSelectedItem(userSelected);
                    foundUser = true;
                    break;
                }
            }

            if (!foundUser) {
                utilisateur.addItem(userSelected);
                utilisateur.setSelectedItem(userSelected);
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String datePret = String.valueOf(table.getValueAt(table.getSelectedRow(),3));
            
            try {
                java.util.Date parsedDate = sdf.parse(datePret);
                date_pret.setDate(parsedDate);
            } catch (ParseException ex) {
                Logger.getLogger(Pret.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String dateRetour = String.valueOf(table.getValueAt(table.getSelectedRow(),4));
            if (dateRetour == null || dateRetour.equals("null") || dateRetour.trim().isEmpty()) {
                date_retour.setDate(null);
            } else {
                try {
                    java.util.Date parsedDates = sdf.parse(dateRetour);
                    date_retour.setDate(parsedDates);
                } catch (ParseException ex) {
                    Logger.getLogger(Pret.class.getName()).log(Level.SEVERE, "Erreur de parsing de la date", ex);
                }
            }
            

            jLabel6.setText("Restitution du livre");
            jButton2.setText("Rendre");
        }else{
            JOptionPane.showMessageDialog(null,"Veuillez d'abord sélectionnez l'élément à modifier","Attention",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jToggleButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_pret;
    private com.toedter.calendar.JDateChooser date_retour;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JComboBox<String> livre;
    private javax.swing.JTextField numero;
    private javax.swing.JTable table;
    private javax.swing.JComboBox<String> utilisateur;
    // End of variables declaration//GEN-END:variables
}
