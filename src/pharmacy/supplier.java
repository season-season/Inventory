/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pharmacy;

import java.awt.Component;
import java.awt.Container;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sparrow
 */
public class supplier extends javax.swing.JFrame {

    /** Creates new form supplier */
    
    
    public supplier() {
        DbConnection.FillConnection();
        initComponents();
        supplierfetch();
    }

   
public void supplierfetch(){
        try{
        String queryfetch="Select *from supplier";
        PreparedStatement psfetch=DbConnection.cn.prepareStatement(queryfetch);
        ResultSet rsfetch=psfetch.executeQuery();
        supplierlist.setModel(DbUtils.resultSetToTableModel(rsfetch));
                
                
    }
        catch(Exception e){
            
        }
        
    }
public void clearTextFields (Container container){

  for(Component c : container.getComponents()){
   if(c instanceof JTextField){
     JTextField f = (JTextField) c;
     f.setText("");
 } 
  else if (c instanceof Container)
     clearTextFields((Container)c);
}
}
/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        scontact = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        saddress = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        supplierlist = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        supplier = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jMenu21 = new javax.swing.JMenu();
        jMenu22 = new javax.swing.JMenu();
        jMenu23 = new javax.swing.JMenu();
        jMenu24 = new javax.swing.JMenu();
        jMenu25 = new javax.swing.JMenu();
        jMenu26 = new javax.swing.JMenu();
        jMenu31 = new javax.swing.JMenu();
        jMenu32 = new javax.swing.JMenu();

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-icon-1-20x20.gif"))); // NOI18N
        jMenu1.setText("Add User");
        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        jMenu3.setText("Stock");
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jMenu4.setText("Sales Report");
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.gif"))); // NOI18N
        jMenu5.setText("Category");
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supp.png"))); // NOI18N
        jMenu6.setText("Supplier");
        jMenuBar1.add(jMenu6);
        jMenuBar1.add(jMenu7);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-icon-1-20x20.gif"))); // NOI18N
        jMenu2.setText("Add User");
        jMenuBar2.add(jMenu2);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        jMenu8.setText("Stock");
        jMenuBar2.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jMenu9.setText("Sales Report");
        jMenuBar2.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.gif"))); // NOI18N
        jMenu10.setText("Category");
        jMenuBar2.add(jMenu10);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supp.png"))); // NOI18N
        jMenu11.setText("Supplier");
        jMenuBar2.add(jMenu11);
        jMenuBar2.add(jMenu12);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("supplier");
        setMinimumSize(new java.awt.Dimension(1300, 800));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Add Supplier");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(193, 20, 130, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(138, 0, 310, 50);

        jLabel2.setText("Supplier Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 84, 80, 20);
        jPanel1.add(sname);
        sname.setBounds(220, 80, 150, 30);

        jLabel3.setText("Contact:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 130, 60, 14);
        jPanel1.add(scontact);
        scontact.setBounds(220, 120, 150, 30);

        jLabel4.setText("Address:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 170, 60, 14);
        jPanel1.add(saddress);
        saddress.setBounds(220, 160, 150, 30);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(191, 210, 80, 23);

        supplierlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SupplierName", "Contact", "Address"
            }
        ));
        supplierlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(supplierlist);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(490, 82, 452, 340);

        jLabel5.setText("Search Supplier");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(510, 20, 100, 30);

        supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierActionPerformed(evt);
            }
        });
        supplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                supplierKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                supplierKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                supplierKeyTyped(evt);
            }
        });
        jPanel1.add(supplier);
        supplier.setBounds(600, 20, 180, 30);

        id.setEnabled(false);
        jPanel1.add(id);
        id.setBounds(140, 60, 40, 20);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(100, 210, 80, 23);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(280, 210, 63, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-3, 24, 950, 420);

        jMenu19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-icon-1-20x20.gif"))); // NOI18N
        jMenu19.setText("Add User");
        jMenu19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu19MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu19);

        jMenu20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        jMenu20.setText("Stock");
        jMenu20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu20MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu20);

        jMenu21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jMenu21.setText("Sales Report");
        jMenu21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu21MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu21);

        jMenu22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.gif"))); // NOI18N
        jMenu22.setText("Category");
        jMenu22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu22MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu22);

        jMenu23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supp.png"))); // NOI18N
        jMenu23.setText("Supplier");
        jMenu23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu23MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu23);
        jMenuBar4.add(jMenu24);

        jMenu25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        jMenu25.setText("Add customer");
        jMenu25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu25MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu25);

        jMenu26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shop-cart-add-icon.png"))); // NOI18N
        jMenu26.setText("item");
        jMenu26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu26MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu26);

        jMenu31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alret.png"))); // NOI18N
        jMenu31.setText("Alert Item");
        jMenu31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu31MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu31);

        jMenu32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout.png"))); // NOI18N
        jMenu32.setText("Logout");
        jMenu32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu32MouseClicked(evt);
            }
        });
        jMenuBar4.add(jMenu32);

        setJMenuBar(jMenuBar4);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
if(sname.getText().equals("")){
    JOptionPane.showMessageDialog(null,"Please Fill Supplier Name");
}
        
        if(scontact.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Phone NUmber");
        }
        if (!scontact.getText().matches("\\d{10}")) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Contact No.");
                return;
            }
        if(saddress.getText().equals(""))
       {
            JOptionPane.showMessageDialog(null, "Please Insert address");
        }
        
        
try{
    
    
    String querycheck="Select *from supplier where Supplier_name='"+sname.getText()+"'";
    PreparedStatement pscheck=DbConnection.cn.prepareStatement(querycheck);
    ResultSet rs= pscheck.executeQuery();
    if(rs.next()){
        JOptionPane.showMessageDialog(null,"Sorry Supplier Name Already Exist");
    }
    else{
    String query="Insert into supplier(Supplier_name,Contact,Address) values(?,?,?)";
    PreparedStatement ps= DbConnection.cn.prepareStatement(query);
    ps.setString(1, sname.getText());
    ps.setString(2, scontact.getText());
    ps.setString(3, saddress.getText());
    
   ps.executeUpdate();
   JOptionPane.showMessageDialog(null, "Supplier Added SucessFully");
  
   clearTextFields(this.getContentPane());
   
      }
supplierfetch();
}
catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }







    }//GEN-LAST:event_jButton1ActionPerformed

    private void supplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierKeyReleased
        // TODO add your handling code here:

          


    }//GEN-LAST:event_supplierKeyReleased

    private void supplierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierKeyTyped
        // TODO add your handling code here:
      try{
            
      String st=supplier.getText(); 
     String quer="select *from supplier where Supplier_name like'%"+st+"%'";
     
 PreparedStatement   ptsearch = DbConnection.cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
       
            supplierlist.setModel(DbUtils.resultSetToTableModel(rstsearch));
        
                
                
                
                }
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    
   }
        











    }//GEN-LAST:event_supplierKeyTyped

    private void supplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_supplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierKeyPressed

    private void supplierlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierlistMouseClicked
        // TODO add your handling code here:
try{
        
     int row =supplierlist.getSelectedRow();
     
     String table_click1=(supplierlist.getValueAt(row, 0).toString());
    String quer="select *from supplier where id='"+table_click1+"'";
  PreparedStatement   ptsupdate = DbConnection.cn.prepareStatement(quer);
   ResultSet rstupdate=ptsupdate.executeQuery();
     
     if(rstupdate.next()){
         String ids= rstupdate.getString("id");
id.setText(ids);         
         
         String snam = rstupdate.getString("Supplier_name");
         sname.setText(snam);
         
         String contact = rstupdate.getString("Contact");
         scontact.setText(contact);
 
        String sadd = rstupdate.getString("Address");
         saddress.setText(sadd);
         
         
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }





    }//GEN-LAST:event_supplierlistMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
if(sname.getText().equals("")){
    JOptionPane.showMessageDialog(null,"Please Fill Supplier Name");
}
        
        if(scontact.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Phone NUmber");
        }
        if (!scontact.getText().matches("\\d{10}")) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Contact No.");
                return;
            }
        if(saddress.getText().equals(""))
       {
            JOptionPane.showMessageDialog(null, "Please Insert address");
        }

        try{
        String value1 = id.getText();
        String value2 = sname.getText();
        String value3 = scontact.getText();
        String value4 = saddress.getText();
        
        
      String queryupuser="update supplier set id='"+value1+"', Supplier_name='"+value2+"',Contact='"+value3+"',Address='"+value4+"' where  id='"+value1+"'";
       PreparedStatement psupuser = DbConnection.cn.prepareStatement(queryupuser);
            psupuser.executeUpdate();
             JOptionPane.showMessageDialog(null, "data updated sucessfully");
    
        }
        catch(Exception e){
            
        }
        supplierfetch();
   clearTextFields(this.getContentPane());
                                          

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

 try{
             String querydel="Delete from  supplier where id=?";
             PreparedStatement psdel = DbConnection.cn.prepareStatement(querydel);
             psdel.setString(1,id.getText());
             psdel.execute();
             JOptionPane.showMessageDialog(null, "data deleted sucessfully");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        supplierfetch();
   clearTextFields(this.getContentPane());
        


                        


    }//GEN-LAST:event_jButton3ActionPerformed

    private void supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierActionPerformed

    private void jMenu19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu19MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        adduser add = new adduser();
        add.setVisible(true);
    }//GEN-LAST:event_jMenu19MouseClicked

    private void jMenu20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu20MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        inventory iv = new inventory();
        iv.setVisible(true);

    }//GEN-LAST:event_jMenu20MouseClicked

    private void jMenu21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu21MouseClicked
        // TODO add your handling code here:

        salesreport sl = new salesreport();
        sl.setVisible(true);

    }//GEN-LAST:event_jMenu21MouseClicked

    private void jMenu22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu22MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        category ct = new category();
        ct.setVisible(true);
    }//GEN-LAST:event_jMenu22MouseClicked

    private void jMenu23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu23MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        supplier sp=new supplier();
        sp.setVisible(true);
    }//GEN-LAST:event_jMenu23MouseClicked

    private void jMenu25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu25MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        customer cs=new customer();
        cs.setVisible(true);
    }//GEN-LAST:event_jMenu25MouseClicked

    private void jMenu26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu26MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        itm it=new itm();
        it.setVisible(true);
    }//GEN-LAST:event_jMenu26MouseClicked

    private void jMenu31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu31MouseClicked
        // TODO add your handling code here:
        alretunit al= new alretunit();
        al.setVisible(true);

    }//GEN-LAST:event_jMenu31MouseClicked

    private void jMenu32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu32MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        login lg = new login();
        lg.setVisible(true);

    }//GEN-LAST:event_jMenu32MouseClicked

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
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu31;
    private javax.swing.JMenu jMenu32;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField saddress;
    private javax.swing.JTextField scontact;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField supplier;
    private javax.swing.JTable supplierlist;
    // End of variables declaration//GEN-END:variables

}