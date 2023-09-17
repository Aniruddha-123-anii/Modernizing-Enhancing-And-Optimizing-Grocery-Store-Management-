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
public class EmployeeManage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeManage
     */
    
        DefaultTableModel model;

    public EmployeeManage(String manager) {
        initComponents();
        lblManager.setText(manager);  
        setcomboEmployeeGender();
        setEmployeeToTable();
    }
    public EmployeeManage() {
        initComponents();
        setcomboEmployeeGender();
        setEmployeeToTable();

    }
    
    public void setcomboEmployeeGender(){

        comboEmployeeGender.removeAllItems();
        
        comboEmployeeGender.addItem("Select Gender");
        comboEmployeeGender.addItem("Male");
        comboEmployeeGender.addItem("Female");
        comboEmployeeGender.addItem("Other");
            
            
    }
    
    public void setEmployeeToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from employee order by id");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int empID = rs.getInt("id");
                String empName = rs.getString("name");
                String empPassword = rs.getString("password");
                int mobileNo = rs.getInt("mobile");
                String empGender = rs.getString("gender");
                float salary = rs.getFloat("salary");

                Object[] obj = {empID,empName,empPassword,mobileNo,empGender,salary};
                model=(DefaultTableModel)tblEmployee.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void clearTable(){
            DefaultTableModel model=(DefaultTableModel)tblEmployee.getModel();
            model.setRowCount(0);
    } 
    
    public boolean validation(){
        if(txtEmployeeID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter ID");                    
            return false;
        }
        if(txtEmployeeName.getText().equals("" ) ){
            JOptionPane.showMessageDialog(this, "Enter Name");                    
            return false;
        }
        if(txtEmployeePassword.getText().equals("" ) || (txtEmployeePassword.getText().length() != 8)){
            JOptionPane.showMessageDialog(this, "Enter valid Password");                    
            return false;
        }
        if(txtEmployeeMobile.getText().equals("") || (txtEmployeeMobile.getText().length() != 10)){
            JOptionPane.showMessageDialog(this, "Enter valid Mobile Number");                    
            return false;
        }
        if(comboEmployeeGender.getSelectedItem().toString().equals("Select Gender")){
            JOptionPane.showMessageDialog(this, "Please Select Gender");                    
            return false;
        }
        if(txtEmployeeSalary.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Enter Salary");                    
            return false;
        }
        return true;
    }
    
    public void addEmployee(int id , String name , String password , int mobile , String gender , float salary){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, password);
            pst.setInt(4, mobile);
            pst.setString(5, gender);
            pst.setFloat(6, salary);
            
            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Employee Added Successfully");
                clearTable();
                setEmployeeToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Employee Added Failed");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Added Failed");                    
        }
    }
    
    public void updateEmployee(int id , String name , String password , int mobile , String gender , float salary){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("update employee set name=?, password=?, mobile=?, gender=?, salary=? where id=? ");
            pst.setString(1, name);
            pst.setString(2, password);
            pst.setInt(3, mobile);
            pst.setString(4, gender);
            pst.setFloat(5, salary);
            pst.setInt(6, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Employee Updated Successfully");
                clearTable();
                setEmployeeToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Employee Updation Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Updation Failed");                    
        }
    }
    
    public void deleteEmployee(int id , String name , String password , int mobile , String gender , float salary){
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pst=con.prepareStatement("delete from employee where id=?");              
            pst.setInt(1, id);

            int rowCount=pst.executeUpdate();
            if(rowCount==1){
                JOptionPane.showMessageDialog(this, "Employee Deleted Successfully");
                clearTable();
                setEmployeeToTable();
                clearTextFromBox();

            }else{
                JOptionPane.showMessageDialog(this, "Employee Deletion Faield");                    
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Deletion Failed");                    
        }
    }
    public void clearTextFromBox(){
        txtEmployeeID.setText("");
        txtEmployeeName.setText("");
        txtEmployeePassword.setText("");
        txtEmployeeMobile.setText("");
        txtEmployeeSalary.setText("");
        setcomboEmployeeGender();
        clearTable();
        setEmployeeToTable();
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
        lblManageProduct = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmployeePassword = new javax.swing.JTextField();
        txtEmployeeSalary = new javax.swing.JTextField();
        txtEmployeeID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        comboEmployeeGender = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmployeeMobile = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Employee");
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
        jPanel2.add(lblManageCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 170, 50));

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
        jLabel1.setText(" Manage Employee");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 420, 50));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/user (2).jpg"))); // NOI18N
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 60, 70));

        lblManager.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblManager.setForeground(new java.awt.Color(255, 88, 63));
        lblManager.setText("Manager");
        jPanel3.add(lblManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 1090, 70));

        jLabel2.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel2.setText("Salary");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 170, -1));

        jLabel3.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 80, -1));

        jLabel6.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel6.setText("Employee ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 140, -1));

        txtEmployeePassword.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtEmployeePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 150, 220, 40));

        txtEmployeeSalary.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtEmployeeSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 230, 220, 40));

        txtEmployeeID.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        txtEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 220, 40));

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
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 110, -1));

        jLabel7.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel7.setText("Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 70, -1));

        txtEmployeeName.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 220, 40));

        comboEmployeeGender.setBackground(new java.awt.Color(239, 214, 45));
        comboEmployeeGender.setFont(new java.awt.Font("Liberation Mono", 0, 18)); // NOI18N
        jPanel1.add(comboEmployeeGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 220, 40));

        tblEmployee.setBackground(new java.awt.Color(247, 214, 37));
        tblEmployee.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tblEmployee.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLOYEE ID", "NAME", "PASSWORD", "MOBILE", "GENDER", "SALARY"
            }
        ));
        tblEmployee.setAlignmentX(2.0F);
        tblEmployee.setAlignmentY(2.0F);
        tblEmployee.setRowHeight(25);
        tblEmployee.setRowMargin(2);
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmployee);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 750, 270));

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel8.setText("Employee Table");
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

        jLabel5.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 180, -1));

        txtEmployeeMobile.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jPanel1.add(txtEmployeeMobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, 220, 40));

        jLabel9.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        jLabel9.setText("Mobile");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 80, -1));

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

    private void lblManageCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseClicked
        CategoryManage cm = new CategoryManage(lblManager.getText());
        cm.show();
        this.dispose();
    }//GEN-LAST:event_lblManageCategoryMouseClicked

    private void lblManageCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseEntered
        Color clr = new Color(255,107,50);
        lblManageCategory.setForeground(clr);
    }//GEN-LAST:event_lblManageCategoryMouseEntered

    private void lblManageCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageCategoryMouseExited
        Color clr = new Color(255,153,0);
        lblManageCategory.setForeground(clr);
    }//GEN-LAST:event_lblManageCategoryMouseExited

    private void lblManageProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManageProductMouseClicked
        ProductManage pm = new  ProductManage( lblManager.getText() );
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

    private void txtEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIDActionPerformed

    private void btnAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseEntered
        Color clr = new Color(209,209,13);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseEntered

    private void btnAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseExited
        Color clr = new Color(255,153,0);
        btnAdd.setBackground(clr);
    }//GEN-LAST:event_btnAddMouseExited

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(validation()== true){
        try {
            int id = Integer.parseInt(txtEmployeeID.getText());
            String name = txtEmployeeName.getText();
            String password = txtEmployeePassword.getText();
            int mobile = Integer.parseInt(txtEmployeeMobile.getText());
            float salary = Float.parseFloat(txtEmployeeSalary.getText());
            String gender = comboEmployeeGender.getSelectedItem().toString();

            addEmployee(id, name, password, mobile, gender,salary);   
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Added Failed");                    
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        int rowNo = tblEmployee.getSelectedRow();
        TableModel model=tblEmployee.getModel();
        txtEmployeeID.setText(model.getValueAt(rowNo, 0).toString());
        txtEmployeeName.setText(model.getValueAt(rowNo, 1).toString());
        txtEmployeePassword.setText(model.getValueAt(rowNo, 2).toString());
        txtEmployeeMobile.setText(model.getValueAt(rowNo, 3).toString());
        comboEmployeeGender.setSelectedItem(model.getValueAt(rowNo, 4).toString());
        txtEmployeeSalary.setText(model.getValueAt(rowNo, 5).toString());
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr = new Color(209,209,13);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr = new Color(255,153,0);
        btnEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int id = Integer.parseInt(txtEmployeeID.getText());
            String name = txtEmployeeName.getText();
            String password = txtEmployeePassword.getText();
            int mobile = Integer.parseInt(txtEmployeeMobile.getText());
            float salary = Float.parseFloat(txtEmployeeSalary.getText());
            String gender = comboEmployeeGender.getSelectedItem().toString();

            updateEmployee(id, name, password, mobile, gender,salary);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Updation Failed");                    
        }
        
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
        try {
            int id = Integer.parseInt(txtEmployeeID.getText());
            String name = txtEmployeeName.getText();
            String password = txtEmployeePassword.getText();
            int mobile = Integer.parseInt(txtEmployeeMobile.getText());
            float salary = Float.parseFloat(txtEmployeeSalary.getText());
            String gender = comboEmployeeGender.getSelectedItem().toString();

            deleteEmployee(id, name, password, mobile, gender,salary);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Employee Deletion Failed");                    
        }
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
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> comboEmployeeGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblManageCategory;
    private javax.swing.JLabel lblManageProduct;
    private javax.swing.JLabel lblManager;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtEmployeeMobile;
    private javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtEmployeePassword;
    private javax.swing.JTextField txtEmployeeSalary;
    // End of variables declaration//GEN-END:variables
}
