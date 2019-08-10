
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class maincontroller extends javax.swing.JFrame
{

    ArrayList<PCinfo> pclist = new ArrayList<>();  //this will store store all the info about all the pc's in the network in a arraylist 
    public maincontroller()
    {
        initComponents();
        setSize(500, 500);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        getContentPane().setLayout(null);

        jButton1.setText("Connect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(390, 30, 140, 40);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 870, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         detect d = new detect();
        Thread t = new Thread(d);
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    public class detect implements Runnable  //"implements runnable" will convert a class into thread
    {

        @Override
        public void run()
        {
            int count = 1;
            for (int i=1; i<=15;i++)
            {
                Thread tarr[] = new Thread[17];  // an array of thread types so the request is generated to 17 systems at the same time to work faster
                for (int j=0; j<17; j++)
                {
                    connect c = new connect(count+"");
                    tarr[j] = new Thread(c);
                    tarr[j].start();             //starts the thread
                    count++;
                }
                for (int k=0; k<17;k++)
                {
                    try
                    {
                        tarr[k].join();       // will join 17 threads used at a time
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                         
                }
            }
        }
        
        
    }
    public class connect implements Runnable
    {
        String ip;
        connect(String ip)
        {
            this.ip = ip;
        }

        @Override
        public void run() 
        {
            try
            {
                HttpResponse<String> httpres = Unirest.get("http://"+crdentials.ipadd+ip+":8888/connect").asString();
                String res = httpres.getBody();
                if(res!=null)
                {
                    StringTokenizer st = new StringTokenizer(res,",");
                    String pcname = st.nextToken();
                    String os = st.nextToken();
                    
                    String pic = "";
                    if(os.contains("Windows"))
                    {
                        pic = "src/pics/window.png";
                    }
                    else if(os.contains("Mac"))
                    {
                        pic = "src/pics/mac.png";
                    }
                    else
                    {
                        pic = "src/pics/linux.jpg";
                    }
                    
                    pclist.add(new PCinfo (pcname, crdentials.ipadd+ip, os, pic));
                    System.out.println(pclist.size());
                    createpanel();
                }
                
                System.out.println(res);
            }
            catch(Exception e)
            {
//                e.printStackTrace();
            }
        }
        
        
    }
    public void createpanel() throws IOException
    {
        jPanel1.removeAll();       //name of the panel in it sdesign. the command is if there is something already this will remove it 
        jPanel1.repaint();         //this will refresh the whole panel
        int x = 10,y = 10;         // these values are temporarily given the bounds of single label which we'll have to change aftrewords 
        clientpanel sp[] = new clientpanel[pclist.size()];   //an array of type clientpanel(the class where one sample apnel is created)is created where the size is same as the array list
        for (int i = 0; i < pclist.size(); i++)
        {
            sp[i] = new clientpanel();
            sp[i].setBounds(x, y, 300, 250);
            sp[i].ip.setText(pclist.get(i).ip);       //we are getting all the variables stored in client panel now in array
            sp[i].pcname.setText(pclist.get(i).pcname);
            String pic = pclist.get(i).photo;
            BufferedImage img = ImageIO.read(new File (pic));
            BufferedImage obj = resize(img, sp[i].jLabel3.getWidth(), sp[i].jLabel3.getHeight());
            sp[i].jLabel3.setIcon(new ImageIcon(img));
            jPanel1.add(sp[i]);
            String total_ip = pclist.get(i).ip;
            sp[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount()== 2){
                        homescreen obj = new homescreen(total_ip);
                        obj.setVisible(true);
                    }
                    
                    }
                
            });
            x = x+350;
            if(x>1000)
            {
                y = y+270;
            }
            jPanel1.repaint();
                    
        }
    }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
    int w = img.getWidth();  
    int h = img.getHeight();  
    BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
    Graphics2D g = dimg.createGraphics();  
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
    RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
    g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
    g.dispose();  
    return dimg;  
}
    
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
            java.util.logging.Logger.getLogger(maincontroller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(maincontroller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(maincontroller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(maincontroller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new maincontroller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
