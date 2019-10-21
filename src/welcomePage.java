
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class welcomePage extends javax.swing.JFrame {

    /**
     * Creates new form welcomePage
     */
    public welcomePage() {
        initComponents();
        showRec();
    }
    public void search(){
        
        String prodname = srchfield.getText();
        
        try{
             String sql = "select * from product where Product_name like ?;";
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/villaverdereg?", "root", "");
      
           PreparedStatement pstmt = conn.prepareStatement(sql);
           pstmt.setString(1, "%"+prodname+"%");
           ResultSet rs = pstmt.executeQuery();
           DefaultTableModel tbl = (DefaultTableModel)table.getModel();
           tbl.setRowCount(0);
           if(!rs.isBeforeFirst()){
               tbl.addRow(new Object[]{"NO DATA", "NO DATA", "NO DATA", "NO DATA"});
           }else{
               while(rs.next()){
                   
                   tbl.addRow(new Object[]{rs.getString("ID"),rs.getString("Product_name"),rs.getString("Quantity"),rs.getString("Price")});
               }
           }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showRec(){
        String sql = "SELECT * FROM product;";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/villaverdereg?", "root", "");
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            DefaultTableModel tab = (DefaultTableModel)table.getModel();
            tab.setRowCount(0);
            while(rs.next()){
                tab.addRow(new Object[]{rs.getInt("ID"),rs.getString("Product_name"),rs.getInt("Quantity"),rs.getString("Price")});
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addFrame = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pdname = new javax.swing.JTextField();
        qun = new javax.swing.JSpinner();
        prc = new javax.swing.JFormattedTextField();
        abtn = new javax.swing.JButton();
        sbtn = new javax.swing.JButton();
        idlb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        srchfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        addFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFrame.setMinimumSize(new java.awt.Dimension(450, 330));

        jLabel2.setText("PRODUCT NAME:");

        jLabel3.setText("QUANTITY:");

        jLabel4.setText("PRICE:");

        qun.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        prc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        abtn.setText("ADD");
        abtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abtnActionPerformed(evt);
            }
        });

        sbtn.setText("SAVE");
        sbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbtnActionPerformed(evt);
            }
        });

        idlb.setText("jLabel5");

        javax.swing.GroupLayout addFrameLayout = new javax.swing.GroupLayout(addFrame.getContentPane());
        addFrame.getContentPane().setLayout(addFrameLayout);
        addFrameLayout.setHorizontalGroup(
            addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(abtn, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(sbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(164, 164, 164))
            .addGroup(addFrameLayout.createSequentialGroup()
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addFrameLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(addFrameLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(prc))
                            .addGroup(addFrameLayout.createSequentialGroup()
                                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(addFrameLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pdname, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(addFrameLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(qun))))))
                    .addGroup(addFrameLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(idlb, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        addFrameLayout.setVerticalGroup(
            addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFrameLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(idlb)
                .addGap(18, 18, 18)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pdname, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qun)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(addFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(prc))
                .addGap(30, 30, 30)
                .addComponent(abtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("WELCOME :)");

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "PRODUCT NAME", "QUANTITY", "PRICE"
            }
        ));
        jScrollPane1.setViewportView(table);

        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        srchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srchfieldKeyReleased(evt);
            }
        });

        jLabel5.setText("PRODUCT NAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(srchfield))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(srchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abtnActionPerformed
String pname = pdname.getText();
int qty = (int)qun.getValue();
String pric = prc.getText();

prod_class prd = new prod_class();
int vill = prd.AddProducts(pname, qty, pric);
showRec();
if(vill==1){
    JOptionPane.showMessageDialog(rootPane, "PRODUCT ADDED");
}else{
    
}


        // TODO add your handling code here:
    }//GEN-LAST:event_abtnActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
this.setVisible(false);addFrame.setLocationRelativeTo(null);addFrame.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selRow = table.getSelectedRow();
        if (selRow != -1) {// meaning the row is valid
            int column = 0;  // the ID is located at the first column
            String id = table
                    .getValueAt(selRow, column).toString();
            int ans = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this product?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (ans == JOptionPane.YES_OPTION) {    // YES
                try {
                    Class.forName("com.mysql.jdbc.Driver");// the connector
                    String conURL = "jdbc:mysql://localhost/villaverdereg?"
                            + "user=root&password=";
                    Connection con = DriverManager.getConnection(conURL);
                    PreparedStatement pstmt = con.prepareStatement("DELETE FROM product WHERE id = ? ");
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();

                    showRec();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else { // meaning if the row is invalid ( -1 )
            JOptionPane.showMessageDialog(null, "Please select one to be deleted",
                    "No record selected",
                    JOptionPane.WARNING_MESSAGE);
            // TODO add your handling code here:
        }                            // TODO add your handling c        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int row =table.getSelectedRow();
if(row==-1){
    JOptionPane.showMessageDialog(table, "PLEASE SELECT DATA ON THE TABLE","ERROR",JOptionPane.ERROR_MESSAGE);
}else{
    int opti = JOptionPane.showConfirmDialog(table, "ARE YOU SURE YOU WANT TO EDIT THIS DATA?","CONFIRMATION",JOptionPane.YES_NO_OPTION);
    if(opti==JOptionPane.YES_OPTION){
    String id = table.getValueAt(row, 0).toString();
    String prodname = table.getValueAt(row, 1).toString();
    String qu = table.getValueAt(row, 2).toString();
    String popri = table.getValueAt(row, 3).toString();
    idlb.setText(id);
    pdname.setText(prodname);
    qun.setToolTipText(qu);
    prc.setText(popri);
    this.setVisible(false);
    addFrame.setVisible(true);
    }
}
addFrame.setVisible(true);this.setVisible(false);addFrame.setLocationRelativeTo(null);abtn.setVisible(false);sbtn.setVisible(true);qun.setEnabled(false);       // TODO add your handling code here:
       

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbtnActionPerformed
int id = Integer.parseInt(idlb.getText());
String prdname = pdname.getText();
String prqu = qun.getToolTipText();
String prci = prc.getText();

try{
    String sql = "update product set Product_name=?, Price=? where ID=?;";
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/villaverdereg?", "root", "");
    
    PreparedStatement pstmt = conn.prepareStatement(sql);
   
    pstmt.setString(1, prdname);
    pstmt.setString(2, prci);
     pstmt.setInt(3, id);
    if(pdname.getText().equals("") || prc.getText().equals("")){
      JOptionPane.showMessageDialog(addFrame, "PLEASE FILL UP ALL FIELDS","WARNING",JOptionPane.WARNING_MESSAGE);
    }else{
        pstmt.executeUpdate();
        pdname.setText("");
        prc.setText("");
        addFrame.setVisible(false);
        welcomePage mnp = new welcomePage();
        mnp.setVisible(true);  
    
    }
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(welcomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_sbtnActionPerformed

    private void srchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchfieldKeyReleased
search();
        // TODO add your handling code here:
    }//GEN-LAST:event_srchfieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abtn;
    private javax.swing.JButton add;
    private javax.swing.JFrame addFrame;
    private javax.swing.JLabel idlb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pdname;
    private javax.swing.JFormattedTextField prc;
    private javax.swing.JSpinner qun;
    private javax.swing.JButton sbtn;
    private javax.swing.JTextField srchfield;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
