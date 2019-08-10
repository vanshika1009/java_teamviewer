
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class homescreen extends javax.swing.JFrame //this is a jframe storing info about the system clicked on the connect window 
{

    String ip;       //we will get get every info about the paticular system with the help of ip

    public homescreen(String ip) {
        initComponents();
        this.ip = ip;
        jpanel1.setVisible(false);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        System.out.println("IP address: "+ip);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jb = new javax.swing.JButton();
        jpanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jbutton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_ip = new javax.swing.JLabel();
        lb_windows = new javax.swing.JLabel();
        lb_windowstype = new javax.swing.JLabel();
        lb_windowsversion = new javax.swing.JLabel();
        lb_processors = new javax.swing.JLabel();
        lb_freememory = new javax.swing.JLabel();
        lb_runtimemeory = new javax.swing.JLabel();
        lb_ip1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bt_shuutdown = new javax.swing.JButton();
        bt_restart = new javax.swing.JButton();
        bt_logout = new javax.swing.JButton();
        bt_viewscreen = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel3.setText("IP Address :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jb.setText("Login");
        jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActionPerformed(evt);
            }
        });
        getContentPane().add(jb);
        jb.setBounds(280, 30, 63, 25);

        jpanel1.setLayout(null);

        jLabel1.setText("Username:");
        jpanel1.add(jLabel1);
        jLabel1.setBounds(30, 50, 90, 20);

        jLabel2.setText("Password:");
        jpanel1.add(jLabel2);
        jLabel2.setBounds(30, 130, 80, 20);
        jpanel1.add(user);
        user.setBounds(119, 50, 150, 22);
        jpanel1.add(pass);
        pass.setBounds(120, 130, 150, 22);

        jbutton1.setText("Login");
        jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton1ActionPerformed(evt);
            }
        });
        jpanel1.add(jbutton1);
        jbutton1.setBounds(90, 200, 110, 50);

        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 90, 290, 340);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(null);

        jLabel4.setText("IP Address :");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 60, 90, 20);

        jLabel5.setText("Windows : ");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 90, 80, 20);

        jLabel6.setText("Windows Type :");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(20, 120, 100, 20);

        jLabel7.setText("Windows Version :");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 150, 110, 16);

        jLabel8.setText("Processors :");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(20, 180, 80, 16);

        jLabel9.setText("Free memory :");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(20, 210, 90, 16);

        jLabel10.setText("Runtime Memory :");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 240, 110, 16);
        jPanel3.add(lb_ip);
        lb_ip.setBounds(100, 60, 170, 0);
        jPanel3.add(lb_windows);
        lb_windows.setBounds(90, 90, 170, 0);
        jPanel3.add(lb_windowstype);
        lb_windowstype.setBounds(120, 120, 160, 0);
        jPanel3.add(lb_windowsversion);
        lb_windowsversion.setBounds(140, 150, 150, 0);
        jPanel3.add(lb_processors);
        lb_processors.setBounds(100, 180, 190, 0);
        jPanel3.add(lb_freememory);
        lb_freememory.setBounds(110, 210, 190, 0);
        jPanel3.add(lb_runtimemeory);
        lb_runtimemeory.setBounds(130, 240, 170, 0);
        jPanel3.add(lb_ip1);
        lb_ip1.setBounds(120, 60, 160, 20);

        jLabel12.setText("jLabel12");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(98, 90, 180, 16);

        jLabel13.setText("jLabel13");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(120, 120, 180, 16);

        jLabel14.setText("jLabel14");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(140, 150, 150, 16);

        jLabel15.setText("jLabel15");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(100, 180, 200, 16);

        jLabel16.setText("jLabel16");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(120, 210, 180, 16);

        jLabel17.setText("jLabel17");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(130, 240, 170, 16);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(300, 90, 310, 360);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(null);

        bt_shuutdown.setText("SHUTDOWN");
        bt_shuutdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_shuutdownActionPerformed(evt);
            }
        });
        jPanel2.add(bt_shuutdown);
        bt_shuutdown.setBounds(80, 50, 190, 60);

        bt_restart.setText("RESTART");
        bt_restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_restartActionPerformed(evt);
            }
        });
        jPanel2.add(bt_restart);
        bt_restart.setBounds(80, 130, 190, 60);

        bt_logout.setText("LOG OUT");
        bt_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_logoutActionPerformed(evt);
            }
        });
        jPanel2.add(bt_logout);
        bt_logout.setBounds(360, 50, 180, 60);

        bt_viewscreen.setText("VIEW SCREEN");
        bt_viewscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_viewscreenActionPerformed(evt);
            }
        });
        jPanel2.add(bt_viewscreen);
        bt_viewscreen.setBounds(360, 130, 180, 60);

        jButton1.setText("SEND MESSAGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(230, 210, 180, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 480, 660, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActionPerformed
        jpanel1.setVisible(true);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);

    }//GEN-LAST:event_jbActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
         try {
            String username = user.getText();
            String password = pass.getText();
            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8888/login")
                    .queryString("username", username)
                    .queryString("password", password)
                    .asString();
            String res = httpres.getBody();
            System.out.println(res);
            StringTokenizer st = new StringTokenizer(res, ",");
            String ip  = st.nextToken();
            lb_ip1.setText(ip);
            
            String windows = st.nextToken();
            jLabel12.setText(windows);
            
            String win_type = st.nextToken();
            jLabel13.setText(win_type);
            
            String win_version = st.nextToken();
            jLabel14.setText(win_version);
            
            String processors = st.nextToken();
            jLabel15.setText(processors);
            
            String runtimememory = st.nextToken();
            jLabel16.setText(runtimememory);
            
            String freememory = st.nextToken();
            jLabel17.setText(freememory);
            
            
            
            
        } catch (UnirestException ex) {
            Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbutton1ActionPerformed

    private void bt_shuutdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_shuutdownActionPerformed
        try
        {
            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8888/shutdown").asString();
            String res = httpres.getBody();
            System.out.println("res");
        } 
        catch (UnirestException ex) {
            Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bt_shuutdownActionPerformed

    private void bt_restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_restartActionPerformed
        // TODO add your handling code here:
         try
        {
            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8888/restart").asString();
            String res = httpres.getBody();
            System.out.println("res");
        } 
        catch (UnirestException ex) {
            Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_restartActionPerformed

    private void bt_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_logoutActionPerformed
        // TODO add your handling code here:
         try
        {
            HttpResponse<String> httpres = Unirest.get("http://" + ip + ":8888/logoff").asString();
            String res = httpres.getBody();
            System.out.println("res");
        } 
        catch (UnirestException ex) {
            Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String message = JOptionPane.showInputDialog("Leave a message");
        try
        {
            HttpResponse<String> message_response = Unirest.get("http://" + ip + ":8888/showmessage")
                    .queryString("msg", message)
                    .asString();

            String responseObj = message_response.getBody();

            System.out.println(responseObj);
        }
        catch(Exception ex)
        {
            Logger.getLogger(homescreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_viewscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_viewscreenActionPerformed
        // TODO add your handling code here:
        try
        {
          HttpResponse<String> screen_response = Unirest.get("http://" + ip + ":8888/screensize").asString();
            
            String responseObj = screen_response.getBody();
            
            StringTokenizer st = new StringTokenizer(responseObj, ",");
            
            String server_height = st.nextToken();
            
            int server_height1 = Integer.parseInt(server_height);	
            
            String server_width = st.nextToken();
            
            int server_width1 = Integer.parseInt(server_width);
            
            int my_height , my_width;
            
            // java - get screen size using the Toolkit class
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            // the screen height
            my_height = (int) screenSize.getHeight();

            // the screen width
            my_width = (int) screenSize.getWidth();
            
            viewscreen viewscreen_obj = new viewscreen(ip);
            
            viewscreen_obj.setVisible(true);
            
            viewscreen_obj.setSize(my_width, my_height);
            
            viewscreen_obj.jScrollPane1.setSize(my_width, my_height);
            
            viewscreen_obj.lb_view.setSize(server_width1, server_height1);
        }    
            
            
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
        
        
                                          

    }//GEN-LAST:event_bt_viewscreenActionPerformed
    
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
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homescreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new homescreen(String ip).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_logout;
    private javax.swing.JButton bt_restart;
    private javax.swing.JButton bt_shuutdown;
    private javax.swing.JButton bt_viewscreen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jb;
    private javax.swing.JButton jbutton1;
    private javax.swing.JPanel jpanel1;
    private javax.swing.JLabel lb_freememory;
    private javax.swing.JLabel lb_ip;
    private javax.swing.JLabel lb_ip1;
    private javax.swing.JLabel lb_processors;
    private javax.swing.JLabel lb_runtimemeory;
    private javax.swing.JLabel lb_windows;
    private javax.swing.JLabel lb_windowstype;
    private javax.swing.JLabel lb_windowsversion;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
