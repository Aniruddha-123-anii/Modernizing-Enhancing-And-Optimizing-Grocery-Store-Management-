/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package groceryms;

import java.sql.Connection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author aniruddha
 */
public class EmployeeSide extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeSide
     */
    
    DefaultTableModel model;
    double totalBillAmount=0;
    public EmployeeSide(String employeeName) {
        initComponents();
        setComboProducts();
        setRecordToTable();
        lblEmployeeName.setText(employeeName);
    }
    public EmployeeSide() {
        initComponents();
        setComboProducts();
        setRecordToTable();
        //lblEmployeeName.setText(employeeName);
    }
    
    public void setComboProducts(){
        try {
            comboProducts.removeAllItems();
            comboProducts.addItem("Select Category");
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select category from productcategory");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                comboProducts.addItem(rs.getString("category"));
            }
            con.close();
        } catch (Exception e) {
        }
    }
    
    public void setRecordToTable(){
        try {
            Connection con = DBConnection.getConnection();
            String selectedItem = comboProducts.getSelectedItem().toString();
            
            if (selectedItem.equals("Select Category")) {
                PreparedStatement pst = con.prepareStatement("select * from products");
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
            }else{
                PreparedStatement pst = con.prepareStatement("select * from products where category='"+selectedItem+"'");
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
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void clearTable(){
            DefaultTableModel model=(DefaultTableModel)tblProducts.getModel();
            model.setRowCount(0);
    }     
    public boolean checkQuantity(String productQuantity){
        int len = productQuantity.length();
        for (int i = 0; i < len; i++) {
            if(!Character.isDigit(productQuantity.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean checkProductStock(String productName,String productQuantity){
        
        try {
            int product_quantity = Integer.parseInt(productQuantity);
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select quantity from products where name='"+productName+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                    
                int chectQuantity=rs.getInt("quantity");
                if(product_quantity>chectQuantity)
                    return false;
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public float getProductPrice(String productName,String productQuantity){
        float totalPrice = 00;
        int quantity=0,id=0;
        try {
            int product_quantity = Integer.parseInt(productQuantity);
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select peice,quantity,id from products where name='"+productName+"'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                    
                 totalPrice=rs.getFloat("peice");
                 quantity=rs.getInt("quantity");
                 id=rs.getInt(3);
            }
            PreparedStatement pst1 = con.prepareStatement("update products set quantity = ? where name='"+productName+"'");
            pst1.setInt(1, quantity-product_quantity);
            pst1.execute();
            Object[] obj = {id,productName,productQuantity,totalPrice,(totalPrice*product_quantity)};
                    model=(DefaultTableModel)tblBill.getModel();
                    model.addRow(obj);

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearTable();
        setRecordToTable();
        return totalPrice;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnFilter = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnAddToBill = new javax.swing.JButton();
        comboProducts = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        lblTotalAmount = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();
        lblLogout = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(187, 251, 48));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(235, 251, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(231, 28, 224));
        jLabel1.setText("NAME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 89, 150, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(231, 28, 224));
        jLabel2.setText("QUANTITY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(231, 28, 224));
        jLabel4.setText("PRODUCTS LIST");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(231, 28, 224));
        jLabel5.setText("BILING POINT");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(231, 28, 224));
        jLabel6.setText("Total :-");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 650, 130, -1));

        txtQuantity.setFont(new java.awt.Font("Liberation Mono", 0, 25)); // NOI18N
        txtQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 230, 40));

        txtName.setFont(new java.awt.Font("Liberation Mono", 0, 25)); // NOI18N
        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 230, 40));

        btnClear.setBackground(new java.awt.Color(231, 28, 224));
        btnClear.setFont(new java.awt.Font("Liberation Mono", 1, 20)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 100, 40));

        btnFilter.setBackground(new java.awt.Color(231, 28, 224));
        btnFilter.setFont(new java.awt.Font("Liberation Mono", 1, 20)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFilterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFilterMouseExited(evt);
            }
        });
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel1.add(btnFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 120, 40));

        btnRefresh.setBackground(new java.awt.Color(231, 28, 224));
        btnRefresh.setFont(new java.awt.Font("Liberation Mono", 1, 20)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRefreshMouseExited(evt);
            }
        });
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 130, 40));

        btnPrint.setBackground(new java.awt.Color(231, 28, 224));
        btnPrint.setFont(new java.awt.Font("Liberation Mono", 1, 20)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 720, 170, 40));

        btnAddToBill.setBackground(new java.awt.Color(231, 28, 224));
        btnAddToBill.setFont(new java.awt.Font("Liberation Mono", 1, 20)); // NOI18N
        btnAddToBill.setForeground(new java.awt.Color(255, 255, 255));
        btnAddToBill.setText("Add To Bill");
        btnAddToBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddToBillMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddToBillMouseExited(evt);
            }
        });
        btnAddToBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToBillActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddToBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, 40));

        comboProducts.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        comboProducts.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category" }));
        jPanel1.add(comboProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 220, 40));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 610, 290));

        lblTotalAmount.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalAmount.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(231, 28, 224));
        lblTotalAmount.setText("Total amount");
        jPanel1.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 650, 220, -1));

        tblBill.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tblBill.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Quantity", "Price", "Total"
            }
        ));
        tblBill.setAlignmentX(2.0F);
        tblBill.setAlignmentY(2.0F);
        tblBill.setRowHeight(25);
        tblBill.setRowMargin(2);
        jScrollPane3.setViewportView(tblBill);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 97, 610, 530));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 1330, 770));

        lblLogout.setBackground(new java.awt.Color(255, 255, 255));
        lblLogout.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(235, 163, 155));
        lblLogout.setText("LOGOUT");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLogoutMouseExited(evt);
            }
        });
        jPanel2.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 830, 140, -1));

        lblEmployeeName.setBackground(new java.awt.Color(255, 255, 255));
        lblEmployeeName.setFont(new java.awt.Font("Liberation Mono", 1, 25)); // NOI18N
        lblEmployeeName.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployeeName.setText("Employee");
        jPanel2.add(lblEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 10, 150, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/groceryms/Images/user (2).jpg"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, 60, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 1500));

        setSize(new java.awt.Dimension(1610, 930));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnAddToBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToBillActionPerformed
        String productName = txtName.getText();
        String productQuqntity = txtQuantity.getText();
        if (productName.trim().equals("") && productQuqntity.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Product Name And Quantity");
        } 
        else if(productName.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Product Name ");            
        }
        else if(productQuqntity.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Enter Product Quantity ");            
        }else{
            if(!checkQuantity(productQuqntity)){
                JOptionPane.showMessageDialog(this, "Enter Product Quantity in Number Only ");            
            }else{
                if(!checkProductStock(productName,productQuqntity)){
                    JOptionPane.showMessageDialog(this, " Product Quantity is not available ");            
                }else{
                    totalBillAmount += (Double.parseDouble(productQuqntity)) * getProductPrice(productName,productQuqntity) ;
                    lblTotalAmount.setText((String.valueOf(totalBillAmount)));
        
                }
            }
        }
        
    }//GEN-LAST:event_btnAddToBillActionPerformed

    private void btnAddToBillMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddToBillMouseEntered
        Color clr = new Color(255,102,255);
        btnAddToBill.setBackground(clr);
    }//GEN-LAST:event_btnAddToBillMouseEntered

    private void btnAddToBillMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddToBillMouseExited
        Color clr = new Color(231,28,224);
        btnAddToBill.setBackground(clr);
    }//GEN-LAST:event_btnAddToBillMouseExited

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        Color clr = new Color(255,102,255);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnFilterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseEntered
        Color clr = new Color(255,102,255);
        btnFilter.setBackground(clr);
    }//GEN-LAST:event_btnFilterMouseEntered

    private void btnRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseEntered
        Color clr = new Color(255,102,255);
        btnRefresh.setBackground(clr);
    }//GEN-LAST:event_btnRefreshMouseEntered

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        Color clr = new Color(255,102,255);
        btnPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        Color clr = new Color(231,28,224);
        btnPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseExited
        Color clr = new Color(231,28,224);
        btnRefresh.setBackground(clr);
    }//GEN-LAST:event_btnRefreshMouseExited

    private void btnFilterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseExited
        Color clr = new Color(231,28,224);
        btnFilter.setBackground(clr);
    }//GEN-LAST:event_btnFilterMouseExited

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        Color clr = new Color(231,28,224);
        btnClear.setBackground(clr);
    }//GEN-LAST:event_btnClearMouseExited

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtName.setText("");
        txtQuantity.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        clearTable();
        setComboProducts();
        setRecordToTable();
        txtName.setText("");
        txtQuantity.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        clearTable();
        setRecordToTable();
    }//GEN-LAST:event_btnFilterActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int rowNo = tblProducts.getSelectedRow();
        TableModel model=tblProducts.getModel();
        txtName.setText(model.getValueAt(rowNo, 1).toString());
        txtQuantity.setText("");
    }//GEN-LAST:event_tblProductsMouseClicked

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        Login l = new Login();
        l.show();
        this.dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed

        MessageFormat header= new MessageFormat("Indias Number One Grocery Store\n\n\tEmployee Name: "+lblEmployeeName.getText()+"\n");
        MessageFormat footer= new MessageFormat("page{0,number,integer}"+lblTotalAmount.getText());
        try {
            tblBill.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 
        
        
//        
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setJobName("Print Data");
//
//        job.setPrintable(new Printable(){
//            public int print(Graphics pg,PageFormat pf, int pageNum){
//                pf.setOrientation(PageFormat.LANDSCAPE);
//                if(pageNum > 0){
//                    return Printable.NO_SUCH_PAGE;
//                }
//
//                Graphics2D g2 = (Graphics2D)pg;
//                g2.translate(pf.getImageableX(), pf.getImageableY());
//                g2.scale(0.47,0.47);
//
//                tblBill.print(g2);
//
//                return Printable.PAGE_EXISTS;
//
//            }
//        });
//        boolean ok = job.printDialog();
//        if(ok){
//            try{
//                job.print();
//            }
//            catch (PrinterException ex){
//                ex.printStackTrace();
//            }
//        }
//            JOptionPane.showMessageDialog(this, " Wotking in progress ");            

    }//GEN-LAST:event_btnPrintActionPerformed

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
            Color clr = new Color(255,0,0);
            lblLogout.setForeground(clr);
    }//GEN-LAST:event_lblLogoutMouseEntered

    private void lblLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseExited
        Color clr = new Color(235,163,155);
        lblLogout.setForeground(clr);
    }//GEN-LAST:event_lblLogoutMouseExited

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
            java.util.logging.Logger.getLogger(EmployeeSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeSide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeSide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToBill;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> comboProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JTable tblBill;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
