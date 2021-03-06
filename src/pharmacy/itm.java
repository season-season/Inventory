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
public class itm extends javax.swing.JFrame {

    /**
     * Creates new form itm
     */
    public itm() {
        initComponents();
              DbConnection.FillConnection();
        fetchitem();
  populateCategory();
  fetchitem1();
    }
    
      public void fetchitem(){
        try{
        String queryfetch="select id,itemname,category from inventory";
        PreparedStatement pfetch= DbConnection.cn.prepareStatement(queryfetch);
        ResultSet rsfetch=pfetch.executeQuery();
        table1.setModel(DbUtils.resultSetToTableModel(rsfetch));
    }
       catch(Exception e){
        
    }
     
        
        
      }
    public void fetchitem1(){
        try{
        String queryfetch="select *from item";
        PreparedStatement pfetch= DbConnection.cn.prepareStatement(queryfetch);
        ResultSet rsfetch=pfetch.executeQuery();
        itemedit.setModel(DbUtils.resultSetToTableModel(rsfetch));
    }
    
    catch(Exception e){
        
    }
    }
  public void populateCategory(){
    try{
            String sql1 = "SELECT *FROM category";
          PreparedStatement  pst1 = DbConnection.cn.prepareStatement(sql1);
           ResultSet rs1 = pst1.executeQuery();
            while(rs1.next()){
                categorycombo.addItem(rs1.getString("category"));
            }
    }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        item = new javax.swing.JTextField();
        categorycombo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        alertunit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemedit = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        searchalert = new javax.swing.JTextField();
        searchedit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("item");
        setMinimumSize(new java.awt.Dimension(1300, 900));
        getContentPane().setLayout(null);

        item.setEnabled(false);
        getContentPane().add(item);
        item.setBounds(170, 100, 130, 30);

        categorycombo.setMaximumRowCount(100);
        categorycombo.setEnabled(false);
        getContentPane().add(categorycombo);
        categorycombo.setBounds(170, 140, 130, 30);

        jLabel3.setText("category");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 140, 60, 30);

        jLabel2.setText("ItemName");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 104, 80, 30);

        jLabel4.setText("Alert Units");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 200, 60, 14);
        getContentPane().add(alertunit);
        alertunit.setBounds(170, 190, 130, 30);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 233, 80, 40);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 230, 90, 40);

        itemedit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Itemname", "Category", "Alert Units"
            }
        ));
        itemedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemeditMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(itemedit);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 70, 260, 280);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Itemname", "Category"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(702, 70, 360, 270);

        jLabel7.setText("Search For AlertUnit");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(710, 40, 120, 14);

        searchalert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchalertKeyReleased(evt);
            }
        });
        getContentPane().add(searchalert);
        searchalert.setBounds(820, 30, 140, 30);

        searchedit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searcheditKeyReleased(evt);
            }
        });
        getContentPane().add(searchedit);
        searchedit.setBounds(490, 30, 110, 30);

        jLabel6.setText("Search Item:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 30, 80, 30);

        id.setEnabled(false);
        getContentPane().add(id);
        id.setBounds(70, 40, 6, 20);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 293, 63, 40);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-icon-1-20x20.gif"))); // NOI18N
        jMenu1.setText("Add User");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        jMenu3.setText("Stock");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sales.png"))); // NOI18N
        jMenu4.setText("Sales Report");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.gif"))); // NOI18N
        jMenu5.setText("Category");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/supp.png"))); // NOI18N
        jMenu6.setText("Supplier");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);
        jMenuBar1.add(jMenu7);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer.png"))); // NOI18N
        jMenu2.setText("Add customer");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/shop-cart-add-icon.png"))); // NOI18N
        jMenu8.setText("item");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alret.png"))); // NOI18N
        jMenu9.setText("Alert Item");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu9);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

if (!alertunit.getText().matches("[0-9\\.|]*")) {
            JOptionPane.showMessageDialog(null, "Invalid Format : Alertunit");
            return;
        }
                if(alertunit.equals("")){
       JOptionPane.showMessageDialog(null, "Please insert alertunit");
            return;
                    
                }
if(item.equals("")){
    JOptionPane.showMessageDialog(null,"Please Choose Item");
}
                
        try{
            
            String query="Insert into item (itemname,category,alretunit) values(?,?,?)";
            PreparedStatement ps= DbConnection.cn.prepareStatement(query);
            ps.setString(1, item.getText());
            ps.setString(2, categorycombo.getSelectedItem().toString());
            ps.setString(3, alertunit.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Added SucessFully");

            clearTextFields(this.getContentPane());

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
fetchitem();
 fetchitem1();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
try{
        
     int row =table1.getSelectedRow();
     
     String table_click1=(table1.getValueAt(row, 0).toString());
    String quer="select *from inventory where id='"+table_click1+"'";
  PreparedStatement   ptsupdate = DbConnection.cn.prepareStatement(quer);
   ResultSet rstupdate=ptsupdate.executeQuery();
     
     if(rstupdate.next()){
         String ids= rstupdate.getString("id");
id.setText(ids);         
         
         String itm1 = rstupdate.getString("itemname");
         item.setText(itm1);
         
         String cat = rstupdate.getString("category");
         categorycombo.setSelectedItem(cat);
 
     
         
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }









    }//GEN-LAST:event_table1MouseClicked

    private void itemeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemeditMouseClicked
        // TODO add your handling code here:

try{
        
     int row =itemedit.getSelectedRow();
     
     String table_click1=(itemedit.getValueAt(row, 0).toString());
    String quer="select *from item where id='"+table_click1+"'";
  PreparedStatement   ptsupdate = DbConnection.cn.prepareStatement(quer);
   ResultSet rstupdate=ptsupdate.executeQuery();
     
     if(rstupdate.next()){
         String ids= rstupdate.getString("id");
id.setText(ids);         
         
         String itm1 = rstupdate.getString("alretunit");
         alertunit.setText(itm1);
         
         String cat = rstupdate.getString("category");
         categorycombo.setSelectedItem(cat);
 
         String itm2 = rstupdate.getString("itemname");
         item.setText(itm2);
     
         
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }




    }//GEN-LAST:event_itemeditMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                if (!alertunit.getText().matches("[0-9\\.|]*")) {
            JOptionPane.showMessageDialog(null, "Invalid Format : Alertunit");
            return;
        }
                if(alertunit.equals("")){
       JOptionPane.showMessageDialog(null, "Please insert alertunit");
            return;
                    
                }
if(item.equals("")){
    JOptionPane.showMessageDialog(null,"Please Choose Item");
}
       String value1 = id.getText();
        String value2= alertunit.getText();
        try{
      String queryupuser="update item set id='"+value1+"', alretunit='"+value2+"' where id='"+value1+"'";
       PreparedStatement psupuser = DbConnection.cn.prepareStatement(queryupuser);
            psupuser.executeUpdate();
             JOptionPane.showMessageDialog(null, "data updated sucessfully");

        fetchitem();
         fetchitem1();
            clearTextFields(this.getContentPane());

        }
        
        catch(Exception e){
            
        }



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
 try{
             String querydel="Delete from  item where id=?";
             PreparedStatement psdel = DbConnection.cn.prepareStatement(querydel);
             psdel.setString(1,id.getText());
             psdel.execute();
             JOptionPane.showMessageDialog(null, "data deleted sucessfully");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
         fetchitem1();
        


                                         


    }//GEN-LAST:event_jButton3ActionPerformed

    private void searcheditKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searcheditKeyReleased
        // TODO add your handling code here:
                        try{
            
      String st=searchedit.getText().replaceAll(" ", "");
; 
     String quer="select *from item where itemname like '"+st+"%'";
     
 PreparedStatement   ptsearch = DbConnection.cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
            itemedit.setModel(DbUtils.resultSetToTableModel(rstsearch));
    
   
    }                
                
                
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    
   }



    }//GEN-LAST:event_searcheditKeyReleased

    private void searchalertKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchalertKeyReleased
        // TODO add your handling code here:
                                try{
            
      String st=searchalert.getText().replaceAll(" ", "");
; 
     String quer1="select id,itemname,category from inventory where itemname like '"+st+"%'";
     
 PreparedStatement   ptsearch1 = DbConnection.cn.prepareStatement(quer1);
 
  

 
  ResultSet rstsearch1 = ptsearch1.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rstsearch1));
    
   
    }                
                
                
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    
   }
        

        
        

    }//GEN-LAST:event_searchalertKeyReleased

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        adduser add = new adduser();
        add.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        inventory iv = new inventory();
        iv.setVisible(true);

    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:

        salesreport sl = new salesreport();
        sl.setVisible(true);

    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        category ct = new category();
        ct.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        supplier sp=new supplier();
        sp.setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        customer cs=new customer();
        cs.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        itm it=new itm();
        it.setVisible(true);
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        // TODO add your handling code here:
        alretunit al= new alretunit();
        al.setVisible(true);

    }//GEN-LAST:event_jMenu9MouseClicked

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
            java.util.logging.Logger.getLogger(itm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(itm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(itm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(itm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new itm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alertunit;
    private javax.swing.JComboBox<String> categorycombo;
    private javax.swing.JTextField id;
    private javax.swing.JTextField item;
    private javax.swing.JTable itemedit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField searchalert;
    private javax.swing.JTextField searchedit;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
