/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author NandiniCreations
 */
public class Task4_Online_Exam_Signup extends javax.swing.JFrame {

    /**
     * Creates new form Task4_Online_Exam_Signup
     */
    public Task4_Online_Exam_Signup() {
        initComponents();
    }
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static ArrayList <String> username_store;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        submit_button = new javax.swing.JButton();
        name_tf = new javax.swing.JTextField();
        age_tf = new javax.swing.JTextField();
        phone_tf = new javax.swing.JTextField();
        username_tf = new javax.swing.JTextField();
        pass_tf = new javax.swing.JPasswordField();
        confirm_pass_tf = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("SIGN UP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel3.setText("NAME :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setText("AGE :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        jLabel5.setText("PHONE :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel6.setText("USER NAME :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel7.setText("PASSWORD :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel8.setText("CONFIRM PASSWORD :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        submit_button.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        submit_button.setText("SUBMIT");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(submit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));
        jPanel1.add(name_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 160, -1));
        jPanel1.add(age_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 110, -1));
        jPanel1.add(phone_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 150, -1));
        jPanel1.add(username_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, -1));
        jPanel1.add(pass_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 120, -1));
        jPanel1.add(confirm_pass_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 120, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
        // TODO add your handling code here:
        try{
            String userName = "root";
            String password = "aryan7";
            String url = "jdbc:mysql://localhost:3306/oasis_internship";

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            
            
            String name = name_tf.getText();
            Integer age = Integer.parseInt(age_tf.getText());
            String phone = phone_tf.getText();
            String username = username_tf.getText().toLowerCase();
            String pass = pass_tf.getText();
            String confirm_pass = confirm_pass_tf.getText();
            
            username_store = new ArrayList<>();
            stmt.execute("select username from details");
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                username_store.add(rs.getString(1));
            }
            
            if(age instanceof Integer && phone.length()==10 && pass.equals(confirm_pass) && username.length()>=8 && username.length()<=16 && !username_store.contains(username)){
                stmt.execute("insert into details values(\""+name+"\","+age+",\""+phone+"\",\""+username+"\",\""+pass+"\");");
                JOptionPane.showMessageDialog(this,"Sign Up successful");
                new Task4_Online_Exam_Profile().setVisible(true);
                this.setVisible(false);
            }else if(!(age instanceof Integer)){
                JOptionPane.showMessageDialog(this,"Age must be a number");
            }else if(phone.length() != 10){
                JOptionPane.showMessageDialog(this,"Phone no. must have 10 digits only");
            }else if(!pass.equals(confirm_pass)){
                JOptionPane.showMessageDialog(this,"Passwords don't match");
            }else if(!(username.length()>=8 && username.length()<=25)){
                JOptionPane.showMessageDialog(this,"Username must be at least 8 and at most 16 characters");
            }else if(username_store.contains(username)){
                JOptionPane.showMessageDialog(this,"Username already taken");
            }
            
        }catch(Exception e){
            System.out.println("Error in submit button : "+e.getMessage());
        }
    }//GEN-LAST:event_submit_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Task4_Online_Exam_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task4_Online_Exam_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task4_Online_Exam_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task4_Online_Exam_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task4_Online_Exam_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age_tf;
    private javax.swing.JPasswordField confirm_pass_tf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField name_tf;
    private javax.swing.JPasswordField pass_tf;
    private javax.swing.JTextField phone_tf;
    private javax.swing.JButton submit_button;
    private javax.swing.JTextField username_tf;
    // End of variables declaration//GEN-END:variables
}