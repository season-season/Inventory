/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy;

import java.awt.Component;
import java.awt.Container;
import java.awt.List;
import java.awt.Window;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import static org.xhtmlrenderer.util.Uu.p;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Sparrow
 */
public class adduser extends javax.swing.JFrame {

    /**
     * Creates new form adduser
     */
    public adduser() {
        DbConnection.FillConnection();
        initComponents();
        userfetch();
    }
    //userlist fetching from user table
    public void userfetch(){
        try{
        String queryfetch="Select *from login";
        PreparedStatement psfetch=DbConnection.cn.prepareStatement(queryfetch);
        ResultSet rsfetch=psfetch.executeQuery();
        userlisttable.setModel(DbUtils.resultSetToTableModel(rsfetch));
                
                
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userlisttable = new javax.swing.JTable();
        searchuser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        setTitle("admin panel");
        setMinimumSize(new java.awt.Dimension(1300, 900));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Add User");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 100, 30);

        jLabel2.setText("Firstname:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 60, 60, 20);
        getContentPane().add(fname);
        fname.setBounds(180, 60, 140, 30);

        jLabel3.setText("Lastname:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 110, 60, 20);
        getContentPane().add(lastname);
        lastname.setBounds(180, 100, 140, 30);

        jLabel4.setText("Phone:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(120, 144, 40, 30);
        getContentPane().add(phone);
        phone.setBounds(180, 140, 140, 30);

        jLabel5.setText("UserName:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 180, 60, 20);
        getContentPane().add(username);
        username.setBounds(180, 180, 140, 30);

        jLabel6.setText("Password:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 220, 60, 20);

        jLabel7.setText("Role:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(120, 270, 34, 14);

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        getContentPane().add(role);
        role.setBounds(180, 270, 140, 20);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 350, 51, 30);
        getContentPane().add(password);
        password.setBounds(180, 220, 140, 30);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(220, 350, 67, 30);

        userlisttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Firstname", "Lastname", "Phone", "Username", "Password", "Role"
            }
        ));
        userlisttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userlisttableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userlisttable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(440, 62, 650, 350);

        searchuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchuserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchuserKeyTyped(evt);
            }
        });
        getContentPane().add(searchuser);
        searchuser.setBounds(620, 20, 160, 30);

        jLabel8.setText("Search User By Name");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(500, 30, 120, 14);

        id.setEnabled(false);
        getContentPane().add(id);
        id.setBounds(260, 300, 50, 20);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 350, 63, 30);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
if(fname.getText().equals("")){
    JOptionPane.showMessageDialog(null,"Please Fill Username");
}
 if(lastname.getText().equals("")){
     JOptionPane.showMessageDialog(null,"please Insert Lastname ");
 }       
        if(phone.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Phone NUmber");
        }
        if (!phone.getText().matches("\\d{10}")) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Contact No.");
                return;
            }
        if(username.getText().equals(""))
       {
            JOptionPane.showMessageDialog(null, "Please Insert Username");
        }
        
        if(password.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Password");
        }
        
try{
    
    
    String querycheck="Select *from login where username='"+username.getText()+"'";
    PreparedStatement pscheck=DbConnection.cn.prepareStatement(querycheck);
    ResultSet rs= pscheck.executeQuery();
    if(rs.next()){
        JOptionPane.showMessageDialog(null,"Sorry Usename Already Exist");
    }
    else{
    String query="Insert into login(Firstname,Lastname,Phone,username,password,role) values(?,?,?,?,?,?)";
    PreparedStatement ps= DbConnection.cn.prepareStatement(query);
    ps.setString(1, fname.getText());
    ps.setString(2, lastname.getText());
    ps.setString(3, phone.getText());
    ps.setString(4, username.getText());
    ps.setString(5, password.getText());
    ps.setString(6, role.getSelectedItem().toString());
    
   ps.executeUpdate();
   JOptionPane.showMessageDialog(null, "User Add SucessFully");
  
   clearTextFields(this.getContentPane());
   
      } }
catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchuserKeyReleased
        // TODO add your handling code here:
                try{
            
      String st=searchuser.getText(); 
     String quer="select *from login where Firstname like '"+st+"%'";
     
 PreparedStatement   ptsearch = DbConnection.cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
    if(rstsearch.next()){     
            userlisttable.setModel(DbUtils.resultSetToTableModel(rstsearch));
        }
                
                else{
                        JOptionPane.showMessageDialog(null,"No result Found");    
                        }
                }
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
    
   }
        




    }//GEN-LAST:event_searchuserKeyReleased

    private void userlisttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userlisttableMouseClicked
        // TODO add your handling code here:
try{
        
     int row =userlisttable.getSelectedRow();
     
     String table_click1=(userlisttable.getValueAt(row, 0).toString());
    String quer="select *from login where id='"+table_click1+"'";
  PreparedStatement   ptsupdate = DbConnection.cn.prepareStatement(quer);
   ResultSet rstupdate=ptsupdate.executeQuery();
     
     if(rstupdate.next()){
         String ids= rstupdate.getString("id");
id.setText(ids);         
         
         String fnam = rstupdate.getString("Firstname");
         fname.setText(fnam);
         
         String lnam = rstupdate.getString("Lastname");
         lastname.setText(lnam);
 
        String phn = rstupdate.getString("Phone");
         phone.setText(phn);
         
         String uname = rstupdate.getString("username");
         username.setText(uname);
 
         String pass = rstupdate.getString("password");
         password.setText(pass);
         
         String rol = rstupdate.getString("role");
         role.setSelectedItem(rol);
 
         
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }






    }//GEN-LAST:event_userlisttableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

if(fname.getText().equals("")){
    JOptionPane.showMessageDialog(null,"Please Fill Username");
}
 if(lastname.getText().equals("")){
     JOptionPane.showMessageDialog(null,"please Insert Lastname ");
 }       
        if(phone.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Phone NUmber");
        }
        if (!phone.getText().matches("\\d{10}")) 
            {
                JOptionPane.showMessageDialog(null, "Invalid Contact No.");
                return;
            }
        if(username.getText().equals(""))
       {
            JOptionPane.showMessageDialog(null, "Please Insert Username");
        }
        
        if(password.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Please Insert Password");
        }
        






        else{  
        
        try {
    String querycheckupdate="Select  count(*)from login where username='"+username.getText()+"'";
    PreparedStatement pscheckupdate=DbConnection.cn.prepareStatement(querycheckupdate);
    ResultSet rsupdate= pscheckupdate.executeQuery();
    rsupdate.next();
    int rows = rsupdate.getInt(1);
    if(rows>1){
        
        int row=rsupdate.getRow();
        JOptionPane.showMessageDialog(null,"Sorry Usename Already Exist");
    }
    else{

       String value1 = id.getText();
        String value2 = fname.getText();
        String value3 = lastname.getText();
        String value4 = phone.getText();
        String value5 = username.getText();
        String value6 = password.getText();
        String value7 = role.getSelectedItem().toString();
        
        
      String queryupuser="update login set id='"+value1+"', Firstname='"+value2+"',Lastname='"+value3+"',Phone='"+value4+"',username='"+value5+"',password='"+value6+"',role='"+value7+"' where  id='"+value1+"'";
       PreparedStatement psupuser = DbConnection.cn.prepareStatement(queryupuser);
            psupuser.executeUpdate();
             JOptionPane.showMessageDialog(null, "data updated sucessfully");
    }
        }
        catch(Exception e){
            
        }
        userfetch();
    }                                      















    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:


 try{
             String querydel="Delete from  login where id=?";
             PreparedStatement psdel = DbConnection.cn.prepareStatement(querydel);
             psdel.setString(1,id.getText());
             psdel.execute();
             JOptionPane.showMessageDialog(null, "data deleted sucessfully");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        userfetch();
        


    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchuserKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchuserKeyTyped

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        adduser add = new adduser();
        add.setVisible(true);

    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adduser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adduser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id;
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
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField phone;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JTextField searchuser;
    private javax.swing.JTable userlisttable;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
