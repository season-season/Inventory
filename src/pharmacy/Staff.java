/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sparrow
 */
public class Staff extends javax.swing.JFrame {

    /**
     * Creates new form Staff
     */
    public Staff() {
        initComponents();
           DbConnection.FillConnection();
           inventoryfetch();
           populatecustomer();

    }
public void inventoryfetch(){
        try{
        String queryfetch="Select id,itemname,category,sellingprice from inventory where qty>0";
        PreparedStatement psfetch=DbConnection.cn.prepareStatement(queryfetch);
        ResultSet rsfetch=psfetch.executeQuery();
        searchitem.setModel(DbUtils.resultSetToTableModel(rsfetch));
                
                
    }
        catch(Exception e){
            
        }
        
    }
 public void populatecustomer(){
        try{
            String sql = "SELECT *FROM customer";
          PreparedStatement  pst = DbConnection.cn.prepareStatement(sql);
           ResultSet rs = pst.executeQuery();
            while(rs.next()){
                customername.addItem(rs.getString("customer_name"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
public void updateqty(){
    int uqty= Integer.parseInt(qty.getText());
            try {

    
    
 
       
       String value1 = id.getText();
        
      String queryupqty="Update inventory set qty=qty-" + uqty + " where id='"+value1+"'";;
       PreparedStatement psupqty = DbConnection.cn.prepareStatement(queryupqty);
            psupqty.executeUpdate();
             
    }
        
        catch(Exception e){
JOptionPane.showMessageDialog(null, e);            
        }
    
        
                                        

}

public void updateqtynext(){
            try {

    int Srowindex = salestable.getSelectedRow();

    DefaultTableModel Mode12=(DefaultTableModel)salestable.getModel();



      int ids =Integer.parseInt(salestable.getValueAt(Srowindex ,0).toString());
        
      int adqty =Integer.parseInt(salestable.getValueAt(Srowindex ,5).toString());
String idnew = String.valueOf(ids);       
 
        
      String queryupqty1="Update inventory set qty=qty+" + adqty + " where id='"+idnew+"'";;
       PreparedStatement psupqty1 = DbConnection.cn.prepareStatement(queryupqty1);
            psupqty1.executeUpdate();
             
    }
        
        catch(Exception e){
JOptionPane.showMessageDialog(null, e);            
        }
    
}
public void counttotal(){
     try{
        if (qty.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Insert Quantity");
            return;
        }

DefaultTableModel Model=(DefaultTableModel)salestable.getModel();
Model.addRow(new Object[]{id.getText(),customername.getSelectedItem().toString(),itemname.getText(),Category.getText(),price.getText(),qty.getText(),total.getText(),totalcost.getText()});


int sum=0;
        for(int i=0; i < salestable.getRowCount(); i++){
      sum+=Integer.parseInt(salestable.getValueAt(i ,6).toString());
        
            
    }  gt.setText(String.valueOf(sum));

int csum=0;
        for(int i=0; i < salestable.getRowCount(); i++){
      csum+=Integer.parseInt(salestable.getValueAt(i ,7).toString());
        
            
    } 

       
       
        wholecost.setText(String.valueOf(csum));
     

updateqty();           
                    }
           

      catch(Exception e){
    

}
        qty.setText("");
                   total.setText("");
   
       
}

 public void salesEntry(){
 int j=salestable.getRowCount();
        
        String salesgrandtot=finaltotal.getText();
                
if(j==0){
    
   JOptionPane.showMessageDialog(null, "Empty recodrd can be manipulated"); 
return;
}             
 String salesdisc=discount.getText();
                Date myDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
String myDateString = sdf.format(myDate);
if(j==1){
         try{
                            for(int l=0; l<j; l++){
      
                
        
                 String    customername= (String)salestable.getValueAt(l ,1).toString();
     String itemname=(String)salestable.getValueAt(l ,2).toString();
    String category=(String)salestable.getValueAt(l ,3).toString();
   String price=(String)salestable.getValueAt(l ,4).toString();
                 String qty=(String)salestable.getValueAt(l ,5).toString();
                String Total=(String)salestable.getValueAt(l ,6).toString();
                String costprice=(String)salestable.getValueAt(l ,7).toString();
                
                String Grandtotal=finaltotal.getText();
                
                
   
       String querysales2="Insert into sales(customername,itemname,category,price,qty,Total,Costprice,grandtotal,Date) values (?,?,?,?,?,?,?,?,?)";
             PreparedStatement pssales2 = DbConnection.cn.prepareStatement(querysales2);
    
      pssales2.setString(1, customername); //Invoice No
 pssales2.setString(2, itemname); //Code
 pssales2.setString(3, category); //Description
 pssales2.setString(4, price);
 pssales2.setString(5, qty);
 pssales2.setString(6, Total);
 pssales2.setString(7, costprice);
 pssales2.setString(8, Grandtotal);
 pssales2.setString(9, myDateString);
    pssales2.executeUpdate();
    } }
     catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }            }
                 
             else{
         try{
        
                for(int k=0; k<j; k++){
        
                 String    customername= (String)salestable.getValueAt(k ,1).toString();
     String itemname=(String)salestable.getValueAt(k ,2).toString();
    String category=(String)salestable.getValueAt(k ,3).toString();
   String price=(String)salestable.getValueAt(k ,4).toString();
                 String qty=(String)salestable.getValueAt(k ,5).toString();
                String Total=(String)salestable.getValueAt(k ,6).toString();
                String costprice=(String)salestable.getValueAt(k ,7).toString();
                
                
    String querysales="Insert into sales(customername,itemname,category,price,qty,Total,Costprice,Date) values (?,?,?,?,?,?,?,?)";
             PreparedStatement pssales = DbConnection.cn.prepareStatement(querysales);
    
     pssales.setString(1, customername); //Invoice No
 pssales.setString(2, itemname); //Code
 pssales.setString(3, category); //Description
 pssales.setString(4, price);
 pssales.setString(5, qty);
 pssales.setString(6, Total);
 pssales.setString(7, costprice);
 pssales.setString(8, myDateString);
    pssales.executeUpdate();
    } }
     catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }    
          try{     String gst=finaltotal.getText(); 
    String querysales1="Insert into sales(Grandtotal,Date) values (?,?)";
             PreparedStatement pssales1 = DbConnection.cn.prepareStatement(querysales1);
            
                   
 pssales1.setString(1, gst); //Bonusable
  pssales1.setString(2, myDateString);
    pssales1.executeUpdate();
    
          }
          catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }
   } }


     

 




/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customername = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        itemname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Category = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchitem = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        sitem = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        cp = new javax.swing.JTextField();
        cptot = new javax.swing.JTextField();
        totalcost = new javax.swing.JTextField();
        wholecost = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        salestable = new javax.swing.JTable();
        discount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        checkbox = new javax.swing.JCheckBox();
        tax = new javax.swing.JTextField();
        taxcheckbox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        gt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        finaltotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        disamt = new javax.swing.JTextField();
        taxpaiidamt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nnn.jpeg"))); // NOI18N

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales panel");
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setText("Welcome Staff");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(600, 20, 140, 14);

        jLabel2.setText("Customer Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(510, 100, 80, 20);

        jPanel1.add(customername);
        customername.setBounds(600, 100, 110, 30);

        jLabel3.setText("Item Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(510, 140, 70, 30);

        itemname.setEnabled(false);
        jPanel1.add(itemname);
        itemname.setBounds(600, 140, 110, 30);

        jLabel4.setText("Categroy:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(510, 180, 60, 30);

        Category.setEnabled(false);
        jPanel1.add(Category);
        Category.setBounds(600, 180, 110, 30);

        jLabel5.setText("Price:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(510, 230, 60, 20);

        price.setEnabled(false);
        jPanel1.add(price);
        price.setBounds(600, 220, 110, 30);

        jLabel6.setText("Qty");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(510, 280, 18, 14);

        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });
        jPanel1.add(qty);
        qty.setBounds(600, 260, 110, 30);

        total.setEnabled(false);
        jPanel1.add(total);
        total.setBounds(600, 300, 110, 30);

        jLabel7.setText("Total");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(510, 310, 34, 14);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shop-cart-add-icon.png"))); // NOI18N
        jButton1.setText("Ok");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(510, 360, 90, 40);

        searchitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Itemname", "Category", "Price", "costprice"
            }
        ));
        searchitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchitemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(searchitem);
        if (searchitem.getColumnModel().getColumnCount() > 0) {
            searchitem.getColumnModel().getColumn(4).setMinWidth(0);
            searchitem.getColumnModel().getColumn(4).setPreferredWidth(0);
            searchitem.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 102, 452, 330);

        jLabel10.setText("Search Item");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 54, 100, 30);

        sitem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sitemKeyReleased(evt);
            }
        });
        jPanel1.add(sitem);
        sitem.setBounds(110, 50, 170, 30);

        id.setEnabled(false);
        jPanel1.add(id);
        id.setBounds(410, 60, 70, 30);

        cp.setEnabled(false);
        jPanel1.add(cp);
        cp.setBounds(460, 70, 6, 20);

        cptot.setEnabled(false);
        jPanel1.add(cptot);
        cptot.setBounds(660, 70, 0, 20);

        totalcost.setEnabled(false);
        jPanel1.add(totalcost);
        totalcost.setBounds(449, 70, 6, 20);

        wholecost.setEnabled(false);
        jPanel1.add(wholecost);
        wholecost.setBounds(430, 70, 10, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 480);

        salestable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "customernamr", "itemname", "category", "price", "qty", "Total", "cp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salestable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salestableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(salestable);
        if (salestable.getColumnModel().getColumnCount() > 0) {
            salestable.getColumnModel().getColumn(0).setMinWidth(20);
            salestable.getColumnModel().getColumn(0).setPreferredWidth(20);
            salestable.getColumnModel().getColumn(0).setMaxWidth(20);
            salestable.getColumnModel().getColumn(5).setMinWidth(30);
            salestable.getColumnModel().getColumn(5).setPreferredWidth(30);
            salestable.getColumnModel().getColumn(5).setMaxWidth(39);
            salestable.getColumnModel().getColumn(7).setMinWidth(0);
            salestable.getColumnModel().getColumn(7).setPreferredWidth(0);
            salestable.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(750, 70, 610, 310);

        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });
        getContentPane().add(discount);
        discount.setBounds(900, 400, 40, 30);

        jLabel8.setText("Discount on %");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(780, 410, 70, 14);

        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
            }
        });
        getContentPane().add(checkbox);
        checkbox.setBounds(870, 410, 20, 21);
        getContentPane().add(tax);
        tax.setBounds(1040, 400, 60, 30);

        taxcheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxcheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(taxcheckbox);
        taxcheckbox.setBounds(1010, 400, 20, 21);

        jLabel9.setText("Tax %");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(950, 400, 40, 14);

        gt.setEnabled(false);
        getContentPane().add(gt);
        gt.setBounds(1200, 400, 90, 30);

        jLabel12.setText("Gross Total");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1120, 410, 70, 14);

        jLabel13.setText("Grand Total");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(1120, 434, 70, 30);

        finaltotal.setEnabled(false);
        getContentPane().add(finaltotal);
        finaltotal.setBounds(1200, 440, 90, 30);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1300, 440, 80, 30);

        disamt.setEnabled(false);
        getContentPane().add(disamt);
        disamt.setBounds(900, 440, 60, 40);

        taxpaiidamt.setEnabled(false);
        getContentPane().add(taxpaiidamt);
        taxpaiidamt.setBounds(1040, 440, 60, 30);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(820, 30, 110, 23);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jMenu1.setText("Sales Report");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alret.png"))); // NOI18N
        jMenu2.setText("Alret Quantity");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout.png"))); // NOI18N
        jMenu10.setText("Logout");
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu10);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed
        // TODO add your handling code here:
        try{
  
         //   System.out.println("Deselected!");
    

if(checkbox.isSelected()){
    
    
         
    double grandtotal = Double.parseDouble(gt.getText());
   
    double dis = Double.parseDouble(discount.getText());
    
    
    double discountamount = grandtotal * dis/100;
    double finalamt = grandtotal-discountamount;
String discountedamt=Double.toString(discountamount);
    String finalamts=Double.toString(finalamt);
       finaltotal.setText(String.valueOf(finalamts));
disamt.setText(discountedamt);
}
        }
            catch(Exception e){
                             
            }
                   

        
        
    }//GEN-LAST:event_checkboxActionPerformed

    private void sitemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sitemKeyReleased
        // TODO add your handling code here:

                  try{
            String st=sitem.getText();
     
     String quer="select id,itemname,category,sellingprice,costprice from inventory where itemname like '"+st+"%' and qty >0";
     
 PreparedStatement   ptsearch = DbConnection.cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
            searchitem.setModel(DbUtils.resultSetToTableModel(rstsearch));
    
   
    }                
                
                
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    
   }
      


    }//GEN-LAST:event_sitemKeyReleased

    private void searchitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchitemMouseClicked
        // TODO add your handling code here:


        try{
        
     int row =searchitem.getSelectedRow();
     
     String table_click1=(searchitem.getValueAt(row, 0).toString());
    String quer="select *from inventory where id='"+table_click1+"'";
  PreparedStatement   ptsupdate = DbConnection.cn.prepareStatement(quer);
   ResultSet rstupdate=ptsupdate.executeQuery();
     
     if(rstupdate.next()){
         String ids= rstupdate.getString("id");
id.setText(ids);         
         
         String inam = rstupdate.getString("itemname");
         itemname.setText(inam);
         
         String cat = rstupdate.getString("category");
         Category.setText(cat);
 
        String sp = rstupdate.getString("sellingprice");
         price.setText(sp);
         
        String cp1 = rstupdate.getString("costprice");
         cp.setText(cp1);
         
       
 
qty.setText(null);   
total.setText(null);        
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }




    }//GEN-LAST:event_searchitemMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         if (!qty.getText().matches("[0-9\\.|]*")) {
            JOptionPane.showMessageDialog(null, "Invalid Format : Quantity");
         qty.setText(null);
        }

    
             if(qty.getText().length()>4){
          JOptionPane.showMessageDialog(null, "Only 4 digits are allowed","ERROR",JOptionPane.ERROR_MESSAGE);
          qty.setText(null);
        }
    int vqty= Integer.parseInt(qty.getText());
             if(vqty<=0){
          JOptionPane.showMessageDialog(null, "Quantity Should Be greater than zero");
          qty.setText(null);
        }
        
        
        counttotal();
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        // TODO add your handling code here:
        try{
      
            
          
      
    String it=itemname.getText();
     String querycheck="Select qty from inventory where itemname='"+it+"'";
    PreparedStatement pscheck=DbConnection.cn.prepareStatement(querycheck);
    ResultSet rs= pscheck.executeQuery();
    
          if(rs.next()){
        double qtyvalid = Double.parseDouble(rs.getString("qty"));
    double  qtyin= Double.parseDouble(qty.getText());
    if(qtyvalid<qtyin){
        JOptionPane.showMessageDialog(null,"please nsert blower qty");
   qty.setText(null);
    } 
            
    else{

         
                
     
        
        String quantityget = qty.getText();
        String price_get = price.getText();
        String cppriceget=cp.getText();
     int quantity = Integer.parseInt(quantityget);
     int prize = Integer.parseInt(price_get);
     int cpprize = Integer.parseInt(cppriceget);
     
     int amt = (quantity * prize);
int cpamt=(quantity * cpprize);
     total.setText(String.valueOf(amt));
   totalcost.setText(String.valueOf(cpamt));
    }    }     
        }
        catch(HeadlessException | NumberFormatException e){
             } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        



    }//GEN-LAST:event_qtyKeyReleased

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        // TODO add your handling code here:
 if (!discount.getText().matches("[0-9\\.|]*")) {
            JOptionPane.showMessageDialog(null, "Invalid Format : Discount");
            return;
        }

    
             
    
if(discount.getText().length()>2){             
    JOptionPane.showMessageDialog(null, "Only 1 to 99 %","ERROR",JOptionPane.ERROR_MESSAGE);
          discount.setText(null);
        }
    int vdis= Integer.parseInt(discount.getText());
             if(vdis<=0){
          JOptionPane.showMessageDialog(null, "Discount Should Be greater than zero");
          discount.setText(null);
        }


    }//GEN-LAST:event_discountKeyReleased

    private void taxcheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxcheckboxActionPerformed
        // TODO add your handling code here:

        try{
  
         //   System.out.println("Deselected!");
    

if(taxcheckbox.isSelected()){
    
        if (finaltotal.getText().equals("")) {    
    double gross = Double.parseDouble(gt.getText());
   
    double tx = Double.parseDouble(tax.getText());
    
    
    double taxamt = gross * tx/100;
    double finaltotallamt = gross+taxamt;
String Taxamount=Double.toString(taxamt);
    
       finaltotal.setText(String.valueOf(finaltotallamt));
taxpaiidamt.setText(Taxamount);
        
        }
        else{
    double gross = Double.parseDouble(finaltotal.getText());
   
    double tx = Double.parseDouble(tax.getText());
    
    
    double taxamt = gross * tx/100;
    double finaltotallamt = gross+taxamt;
String Taxamount=Double.toString(taxamt);
    
       finaltotal.setText(String.valueOf(finaltotallamt));
taxpaiidamt.setText(Taxamount);
        }
}
        }
            catch(Exception e){
                             
            }
                   




    }//GEN-LAST:event_taxcheckboxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        
 updateqtynext();
        DefaultTableModel model = (DefaultTableModel) salestable.getModel();

       // get selected row index
int SelectedRowIndex = salestable.getSelectedRow();
       try{
       
    
       model.removeRow(SelectedRowIndex);

       DefaultTableModel Mode1l=(DefaultTableModel)salestable.getModel();


int sum=0;
        for(int i=0; i < salestable.getRowCount(); i++){
      sum+=Integer.parseInt(salestable.getValueAt(i ,6).toString());
        
               
    } 

        gt.setText(String.valueOf(sum));
int csum=0;
        for(int i=0; i < salestable.getRowCount(); i++){
      csum+=Integer.parseInt(salestable.getValueAt(i ,7).toString());
        
            
    } 

        
       
        wholecost.setText(String.valueOf(csum));
     


       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }

 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void salestableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salestableMouseClicked
        // TODO add your handling code here:
     

    }//GEN-LAST:event_salestableMouseClicked

 public PageFormat getPageFormat(PrinterJob pj)
{
   
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

    private Object showMessageDialog(String total_Amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class URISyntaException {

        public URISyntaException() {
        }
    }



    public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
             Date myDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
String myDateString = sdf.format(myDate);
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,6));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
  
                  
             
    
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=10;
            int headerRectHeighta=20;
            
            
            String  printdiscountprecentage;
            String printdisamount;
            String printtaxpercentage;
            String printtaxamount;
            String printgrosstotal;
            String printnettotal;
            
                
                 printdiscountprecentage=discount.getText();
                  printdisamount=disamt.getText();
                
                   printtaxpercentage=tax.getText();
                  printtaxamount=taxpaiidamt.getText();
                
                  printgrosstotal=gt.getText();
                 printnettotal=finaltotal.getText();
            ///////////////// Product names Get ///////////
                            
            
            ///////////////// Product price Get ///////////
                /////// ////////// Product price Get ///////////
          g2d.drawString("Date:"+myDateString+" ",10,y);y+=yShift;
          g2d.setFont(new Font("Monospaced",Font.ITALIC,10));
           g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("Gross amount: "+printgrosstotal+"",10,y);y+=yShift;
            g2d.drawString("Discount:"+printdiscountprecentage+"%                         ",10,y);y+=yShift;
            g2d.drawString("DiscountAmount:"+printdisamount+"                         ",10,y);y+=yShift;
           
            g2d.drawString("Tax:"+printtaxpercentage+"%                         ",10,y);y+=yShift;
            g2d.drawString("Tax Amount Amount:"+printtaxamount+"                         ",10,y);y+=yShift;
           g2d.drawString("------------------------",10,y);y+=yShift;
           g2d.drawString("Net  Payble amount: "+printnettotal+"",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
                   
           
             
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          
 
    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
salesEntry();
     MessageFormat header = new MessageFormat ("Report Print");
      MessageFormat footer = new MessageFormat ("Page[0,number,integer]");
      try
      {
        salestable.print(JTable.PrintMode.NORMAL, header, footer);
      }

      catch (java.awt.print.PrinterException e)
        {
          System.err.format("Cannot Print %s%n", e.getMessage());
        }
PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }

        DefaultTableModel model = (DefaultTableModel) salestable.getModel();
model.setRowCount(0);


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        salesreport sl = new salesreport();
        sl.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        alretunit al= new alretunit();
        al.setVisible(true);
        
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        login lg = new login();
        lg.setVisible(true);

    }//GEN-LAST:event_jMenu10MouseClicked

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Category;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField cptot;
    private javax.swing.JComboBox<String> customername;
    private javax.swing.JTextField disamt;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField finaltotal;
    private javax.swing.JTextField gt;
    private javax.swing.JTextField id;
    private javax.swing.JTextField itemname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField price;
    private javax.swing.JTextField qty;
    private javax.swing.JTable salestable;
    private javax.swing.JTable searchitem;
    private javax.swing.JTextField sitem;
    private javax.swing.JTextField tax;
    private javax.swing.JCheckBox taxcheckbox;
    private javax.swing.JTextField taxpaiidamt;
    private javax.swing.JTextField total;
    private javax.swing.JTextField totalcost;
    private javax.swing.JTextField wholecost;
    // End of variables declaration//GEN-END:variables
}
