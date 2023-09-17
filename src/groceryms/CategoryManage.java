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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author aniruddha
 */
public class CategoryManage extends javax.swing.JFrame {

    /**
     * Creates new form CategoryManage
     */
    
        DefaultTableModel model;

    
    public CategoryManage(String manager) {
        initComponents();
        setCategoryToTable();
        lblManager.setText(manager);
    }
    public CategoryManage() {
        initComponents();
        setCategoryToTable();
    }
    
    public void setCategoryToTable(){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("Select * from productcategory order by id ASC");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int categoryId =rs.getInt("id");              
                String categoryInfo =rs.getString("category"); 
                String extraInfo =rs.getString("extra");
                
                Object[] obj={categoryId,categoryInfo,extraInfo};
                model=(DefaultTableModel)tblCategory.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean validation(){
        if(txtCategoryID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter ID");                    
            return false;
        }
        if(txtCategoryName.getText().equals("" ) ){
            JOptionPane.showMessageDialog(this, "Enter Name");                    
            return false;
        }
        if(txtCategoryDescription.getText().equals("" )){
            JOptionPane.showMessageDialog(this, "Enter Description");                    
            return false;
        }
        return true;
    }
    
    public void addCategory(int id , String cname , String description){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into productcategory values(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, cname);
            pst.setString(3, description);
            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Category Added Successfully");
                clearTable();
                setCategoryToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Category Added Failed");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Category Added Failed");                    
        }
    }
    public void clearTable(){
            DefaultTableModel model=(DefaultTableModel)tblCategory.getModel();
            model.setRowCount(0);
    }
    
    public void updateCategory(int id,String cname,String description){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("update productcategory set  category =? ,extra = ? where id= ? ");
            pst.setString(1, cname);
            pst.setString(2, description);
            pst.setInt(3, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Category Updated Successfully");
                clearTable();
                setCategoryToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Category Updation Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Category Updation Failed");                    
        }
    }
    
    public void deleteCategory(int id,String cname,String description){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("delete from productcategory where id=?");              
            pst.setInt(1, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Category Deleted Successfully");
                clearTable();
                setCategoryToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Category Deletion Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Category Deletion Failed");                    
        }
    }
    public void clearTextFromBox(){
        txtCategoryID.setText("");
        txtCategoryName.setText("");
        txtCategoryDescription.setText("");
        clearTable();
        setCategoryToTable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        lblManageEmployee = new javax.swing.JLabel();
        lblManageProduct = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCategoryName = new javax.swing.JTextField();
        txtCategoryDescription = new javax.swing.JTextField();
        txtCategoryID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Category");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(235, 251, 160));
        jPanel1.setForeground(new java.awt.Color(235, 251, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(187, 251, 48));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setBackground(new java.awt.Color(255, 153, 0));
        btnLogout.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 670, 110, -1));

        lblManageEmployee.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblManageEmployee.setForeground(new java.awt.Color(255, 153, 0));
        lblManageEmployee.setText("Manage Employee");
        lblManageEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageEmployeeMouseExited(evt);
            }
        });
        jPanel2.add(lblManageEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 180, 50));

        lblManageProduct.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblManageProduct.setForeground(new java.awt.Color(255, 155, 0));
        lblManageProduct.setText("Manage Product");
        lblManageProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageProductMouseExited(evt);
            }
        });
        jPanel2.add(lblManageProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 150, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 760));

        jPanel3.setBackground(new java.awt.Color(102, 204, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        jLabel1.setText(" Manage Category");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 420, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/user (2).jpg"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 70));

        lblManager.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblManager.setForeground(new java.awt.Color(255, 88, 63));
        lblManager.setText("Manager");
        jPanel3.add(lblManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 70));

        jLabel4.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel4.setText("Description");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 140, 40));

        jLabel6.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel6.setText("Category ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, -1));

        txtCategoryName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 220, 40));

        txtCategoryDescription.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtCategoryDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 220, 40));

        txtCategoryID.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtCategoryID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtCategoryID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 220, 40));

        btnAdd.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnAdd.setText("Save");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMouseExited(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 110, -1));

        jLabel7.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel7.setText("Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 70, -1));

        tblCategory.setBackground(new java.awt.Color(247, 214, 37));
        tblCategory.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tblCategory.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CATEGORY ID", "CATEGORY NAME", "DESCRIPTION"
            }
        ));
        tblCategory.setAlignmentX(2.0F);
        tblCategory.setAlignmentY(2.0F);
        tblCategory.setRowHeight(25);
        tblCategory.setRowMargin(2);
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCategory);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 570, 310));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setText("Caregory List");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 150, 60));

        btnEdit.setBackground(new java.awt.Color(255, 153, 0));
        btnEdit.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 160, 110, -1));

        btnDelete.setBackground(new java.awt.Color(255, 153, 0));
        btnDelete.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 110, -1));

        btnClear.setBackground(new java.awt.Color(255, 153, 0));
        btnClear.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnClear.setText("Clear");
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
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 240, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1330, 780));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr = new Color(255,0,0);
        btnLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr = new Color(255,153,0);
        btnLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Login l = new Login();
        l.show();
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void lblManageEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseClicked
        EmployeeManage em = new EmployeeManage(lblManager.getText());
        em.show();
        this.dispose();
    }//GEN-LAST:event_lblManageEmployeeMouseClicked

    private void lblManageEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseEntered
        Color clr = new Color(255,107,50);
        lblManageEmployee.setForeground(clr);
    }//GEN-LAST:event_lblManageEmployeeMouseEntered

    private void lblManageEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseExited
        Color clr = new Color(255,153,0);
        lblManageEmployee.setForeground(clr);
    }//GEN-LAST:event_lblManageEmployeeMouseExited

    private void lblManageProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageProductMouseClicked
        ProductManage pm = new  ProductManage( lblManager.getText());
        pm.show();
        this.dispose();
    }//GEN-LAST:event_lblManageProductMouseClicked

    private void lblManageProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageProductMouseEntered
        Color clr = new Color(255,107,50);
        lblManageProduct.setForeground(clr);
    }//GEN-LAST:event_lblManageProductMouseEntered

    private void lblManageProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageProductMouseExited
        Color clr = new Color(255,153,0);
        lblManageProduct.setForeground(clr);
    }//GEN-LAST:event_lblManageProductMouseExited

    private void txtCategoryIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryIDActionPerformed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        Color clr = new Color(209,209,13);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        Color clr = new Color(255,153,0);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int id = Integer.parseInt(txtCategoryID.getText());
        String cname = txtCategoryName.getText();
        String description = txtCategoryDescription.getText();

        addCategory(id, cname, description);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
       
        int rowNo = tblCategory.getSelectedRow();
        TableModel model=tblCategory.getModel();
        txtCategoryID.setText(model.getValueAt(rowNo, 0).toString());
        txtCategoryName.setText(model.getValueAt(rowNo, 1).toString());
        txtCategoryDescription.setText(model.getValueAt(rowNo, 2).toString());
        
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr = new Color(209,209,13);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr = new Color(255,153,0);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int id = Integer.parseInt(txtCategoryID.getText());
        String cname = txtCategoryName.getText();
        String description = txtCategoryDescription.getText();

        updateCategory(id, cname, description);

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        Color clr = new Color(209,209,13);
        btnDelete.setBackground(clr);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        Color clr = new Color(255,153,0);
        btnDelete.setBackground(clr);
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int id = Integer.parseInt(txtCategoryID.getText());
        String cname = txtCategoryName.getText();
        String description = txtCategoryDescription.getText();

        deleteCategory(id, cname, description);
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        Color clr = new Color(209,209,13);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        Color clr = new Color(255,153,0);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseExited

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       clearTextFromBox();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(CategoryManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblManageEmployee;
    private javax.swing.JLabel lblManageProduct;
    private javax.swing.JLabel lblManager;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTextField txtCategoryDescription;
    private javax.swing.JTextField txtCategoryID;
    private javax.swing.JTextField txtCategoryName;
    // End of variables declaration//GEN-END:variables
}
