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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author aniruddha
 */
public class ProductManage extends javax.swing.JFrame {

    /**
     * Creates new form InventeryManagement
     */
    
    
    DefaultTableModel model;
    
    public ProductManage(String manager) {
        initComponents();
        setComboCategory();
        setProductTable();
        lblManager.setText(manager);
    }
    public ProductManage() {
        initComponents();
        setComboCategory();
        setProductTable();
    }
    
    public void setComboCategory(){
        try {
            comboProductCategory.removeAllItems();
            comboProductCategory.addItem("Select Category");
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select category from productcategory order by category");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                comboProductCategory.addItem(rs.getString("category"));
            }
            con.close();
        } catch (Exception e) {
        }
    }
    
    public void setProductTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from products order by id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("id");
                String productName = rs.getString("name");
                int productQuantity = rs.getInt("quantity");
                float productPrice = rs.getFloat("peice");
                String productCategory = rs.getString("category");

                Object[] obj = {productID,productName,productQuantity,productPrice,productCategory};
                model=(DefaultTableModel)tblProducts.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
        }

    }
    
    public void clearTable(){
            DefaultTableModel model=(DefaultTableModel)tblProducts.getModel();
            model.setRowCount(0);
    } 
    
    public boolean validation(){
        if(txtProductID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter ID");                    
            return false;
        }
        if(txtProductName.getText().equals("" ) ){
            JOptionPane.showMessageDialog(this, "Enter Name");                    
            return false;
        }
        if(txtProductQuantity.getText().equals("" )){
            JOptionPane.showMessageDialog(this, "Enter Quantity");                    
            return false;
        }
        if(txtProductPrice.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter Price");                    
            return false;
        }
        if(comboProductCategory.getSelectedItem().toString().equals("Select Category")){
            JOptionPane.showMessageDialog(this, "Please Select Category");                    
            return false;
        }
        return true;
    }
    
    public void addProduct(int id , String name , int quantity,float prise, String pcategory){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into products values(?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, quantity);
            pst.setFloat(4, prise);
            pst.setString(5, pcategory);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Product Added Successfully");
                clearTable();
                setProductTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Product Added Failed");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Product Added Failed");                    
        }
    }
    
    public void updateProduct(int id , String name , int quantity,float prise, String pcategory){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("update products set name=?, quantity=?, peice=?, category =? where id= ? ");
            pst.setString(1, name);
            pst.setInt(2, quantity);
            pst.setFloat(3, prise);
            pst.setString(4, pcategory);
            pst.setInt(5, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Product Updated Successfully");
                clearTable();
                setProductTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Product Updation Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Product Updation Failed");                    
        }
    }
    
    public void deleteProduct(int id , String name , int quantity,float prise, String pcategory){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("delete from products where id=?");              
            pst.setInt(1, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Product Deleted Successfully");
                clearTable();
                setProductTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Product Deletion Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Product Deletion Failed");                    
        }
    }
    public void clearTextFromBox(){
        txtProductID.setText("");
        txtProductName.setText("");
        txtProductQuantity.setText("");
        txtProductPrice.setText("");
        txtSearchProduct.setText("");
        setComboCategory();
        clearTable();
        setProductTable();
    }
    
    public void search(String str){
        model=(DefaultTableModel)tblProducts.getModel();
        TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(model);
        tblProducts.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter( str));
        
        
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
        lblManageCategory = new javax.swing.JLabel();
        lblManageEmployee = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProductQuantity = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        txtProductID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        comboProductCategory = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtSearchProduct = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Product");
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

        lblManageCategory.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        lblManageCategory.setForeground(new java.awt.Color(255, 153, 0));
        lblManageCategory.setText("Manage Category");
        lblManageCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManageCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManageCategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManageCategoryMouseExited(evt);
            }
        });
        jPanel2.add(lblManageCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 170, 50));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 760));

        jPanel3.setBackground(new java.awt.Color(102, 204, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        jLabel5.setText(" Manage Product");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 420, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/user (2).jpg"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 70));

        lblManager.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblManager.setForeground(new java.awt.Color(255, 88, 63));
        lblManager.setText("Manager");
        jPanel3.add(lblManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 70));

        jLabel2.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel2.setText("Category");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 180, -1));

        jLabel3.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel3.setText("Quantity");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 80, -1));

        jLabel4.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel4.setText("Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 80, -1));

        jLabel6.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel6.setText("Product ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 90, -1));

        txtProductQuantity.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtProductQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 220, 40));

        txtProductPrice.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, 220, 40));

        txtProductID.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtProductID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 220, 40));

        btnAdd.setBackground(new java.awt.Color(255, 153, 0));
        btnAdd.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        btnAdd.setText("Add");
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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 110, -1));

        jLabel7.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel7.setText("Search Product");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 150, 40));

        txtProductName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
        });
        jPanel1.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 220, 40));

        comboProductCategory.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        comboProductCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        jPanel1.add(comboProductCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 220, 40));

        tblProducts.setBackground(new java.awt.Color(247, 214, 37));
        tblProducts.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tblProducts.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT ID", "NAME", "QUANTITY", "PRICE", "CATEGORY"
            }
        ));
        tblProducts.setAlignmentX(2.0F);
        tblProducts.setAlignmentY(2.0F);
        tblProducts.setRowHeight(25);
        tblProducts.setRowMargin(2);
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProducts);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 750, 270));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setText("Product Table");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 150, 40));

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
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 110, -1));

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
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 110, -1));

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
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 340, 110, -1));

        txtSearchProduct.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchProductActionPerformed(evt);
            }
        });
        txtSearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchProductKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 220, 40));

        jLabel9.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel9.setText("Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1330, 780));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductIDActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(validation() == true){
            int id = Integer.parseInt(txtProductID.getText());
            String name = txtProductName.getText();
            int quantity = Integer.parseInt(txtProductQuantity.getText());
            float prise = Float.parseFloat(txtProductQuantity.getText());
            String pcategory = comboProductCategory.getSelectedItem().toString();

            addProduct(id, name, quantity,prise,pcategory);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int rowNo = tblProducts.getSelectedRow();
        TableModel model=tblProducts.getModel();
        txtProductID.setText(model.getValueAt(rowNo, 0).toString());
        txtProductName.setText(model.getValueAt(rowNo, 1).toString());
        txtProductQuantity.setText(model.getValueAt(rowNo, 2).toString());
        txtProductPrice.setText(model.getValueAt(rowNo, 3).toString());
        comboProductCategory.setSelectedItem(model.getValueAt(rowNo, 4).toString());

    }//GEN-LAST:event_tblProductsMouseClicked

    private void lblManageEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseClicked
        EmployeeManage em = new EmployeeManage(lblManager.getText());
        em.show();
        this.dispose();
    }//GEN-LAST:event_lblManageEmployeeMouseClicked

    private void lblManageCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseClicked
        CategoryManage cm = new CategoryManage( lblManager.getText());
        cm.show();
        this.dispose();
    }//GEN-LAST:event_lblManageCategoryMouseClicked

    private void lblManageEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseEntered
        Color clr = new Color(255,107,50);
        lblManageEmployee.setForeground(clr);
    }//GEN-LAST:event_lblManageEmployeeMouseEntered

    private void lblManageCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseEntered
        Color clr = new Color(255,107,50);
        lblManageCategory.setForeground(clr);
    }//GEN-LAST:event_lblManageCategoryMouseEntered

    private void lblManageEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageEmployeeMouseExited
        Color clr = new Color(255,153,0);
        lblManageEmployee.setForeground(clr);
    }//GEN-LAST:event_lblManageEmployeeMouseExited

    private void lblManageCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseExited
        Color clr = new Color(255,153,0);
        lblManageCategory.setForeground(clr);
    }//GEN-LAST:event_lblManageCategoryMouseExited

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
            Login l = new Login();
            l.show();
            this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr = new Color(255,0,0);
        btnLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr = new Color(255,153,0);
        btnLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        Color clr = new Color(255,153,0);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        Color clr = new Color(209,209,13);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr = new Color(209,209,13);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr = new Color(255,153,0);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int id = Integer.parseInt(txtProductID.getText());
        String name = txtProductName.getText();
        int quantity = Integer.parseInt(txtProductQuantity.getText());
        float prise = Float.parseFloat(txtProductQuantity.getText());
        String pcategory = comboProductCategory.getSelectedItem().toString();
        
        updateProduct(id, name, quantity,prise,pcategory);
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
        int id = Integer.parseInt(txtProductID.getText());
        String name = txtProductName.getText();
        int quantity = Integer.parseInt(txtProductQuantity.getText());
        float prise = Float.parseFloat(txtProductQuantity.getText());
        String pcategory = comboProductCategory.getSelectedItem().toString();
        
        deleteProduct(id, name, quantity,prise,pcategory);
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

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
       
    }//GEN-LAST:event_txtProductNameKeyReleased

    private void txtSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchProductActionPerformed

    private void txtSearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchProductKeyReleased
        String searchString = txtSearchProduct.getText();
        search(searchString);
    }//GEN-LAST:event_txtSearchProductKeyReleased

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
            java.util.logging.Logger.getLogger(ProductManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> comboProductCategory;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblManageCategory;
    private javax.swing.JLabel lblManageEmployee;
    private javax.swing.JLabel lblManager;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductQuantity;
    private javax.swing.JTextField txtSearchProduct;
    // End of variables declaration//GEN-END:variables
}
