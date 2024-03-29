/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package groceryms;


import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author aniruddha
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public void adminVerification(String username,String password){
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from adminlogin where name=? and password=?");
            pst.setString(1, username);
               pst.setString(2, password);
               ResultSet rs= pst.executeQuery();
               
               if(rs.next()){
                   JOptionPane.showMessageDialog(this,"Login Successfuly");
                   ProductManage adminSide= new ProductManage(username);
                   adminSide.show();
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(this,"Wrong Username or Password");
               }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void employeeVerification(String username,String password){
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from employee where name=? and password=?");
            pst.setString(1, username);
               pst.setString(2, password);
               ResultSet rs= pst.executeQuery();
               
               if(rs.next()){
                   JOptionPane.showMessageDialog(this,"Login Successfuly");
                   EmployeeSide employeeSide= new EmployeeSide(username);
                   employeeSide.show();
                   this.dispose();
               }else{
                   JOptionPane.showMessageDialog(this,"Wrong Username or Password");
               }
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        comboBoxRole = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(235, 251, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(187, 251, 48));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(220, 57, 126));
        jLabel1.setText("LOGIN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 140, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 57, 126));
        jLabel3.setText("User Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 240, 40));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(239, 153, 195));
        jLabel4.setText("Grocery Store System");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 473, 290, 40));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(220, 57, 126));
        jLabel5.setText("Select Role");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 230, 40));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(220, 57, 126));
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 240, 40));

        btnClear.setBackground(new java.awt.Color(220, 57, 126));
        btnClear.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(101, 101, 215)));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearMouseExited(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 110, 40));

        btnLogin.setBackground(new java.awt.Color(220, 57, 126));
        btnLogin.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(101, 101, 215)));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 110, 40));

        txtUsername.setFont(new java.awt.Font("Liberation Mono", 0, 19)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 240, 40));

        comboBoxRole.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        comboBoxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Employee" }));
        jPanel2.add(comboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 240, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/shoping.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        txtPassword.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 240, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 640, 530));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/cart.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 710));

        setSize(new java.awt.Dimension(951, 737));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtPassword.setText("");
        txtUsername.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String username=txtUsername.getText();
        String password=txtPassword.getText();
        if(username.trim().equals("")&&password.trim().equals("")){
            // lblError.setText("Enter Username and Passworld !");
            JOptionPane.showMessageDialog(this, "Enter User name and Password");
        }else if(username.equals("")){
            JOptionPane.showMessageDialog(this, "Enter User name");
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(this, "Enter Password");
        }else{
            // userVarification( username, password);
            String checkCombo = comboBoxRole.getSelectedItem().toString();
            if(checkCombo.equals("Manager")){
                adminVerification(username, password);
            }else{
                employeeVerification(username, password);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        // TODO add your handling code here:
        Color clr = new Color(230,16,107);
        btnLogin.setBackground(clr);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        // TODO add your handling code here:
        Color clr = new Color(220,57,126);
        btnLogin.setBackground(clr);
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        // TODO add your handling code here:
        Color clr = new Color(230,16,107);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        // TODO add your handling code here:
        Color clr = new Color(220,57,126);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> comboBoxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
