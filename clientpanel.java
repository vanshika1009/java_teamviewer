public class clientpanel extends javax.swing.JPanel 
{

    public clientpanel()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ip = new javax.swing.JLabel();
        pcname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        ip.setText("IP  Address :");
        add(ip);
        ip.setBounds(60, 150, 200, 20);

        pcname.setText("PC Name :");
        add(pcname);
        pcname.setBounds(70, 200, 190, 16);

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel3);
        jLabel3.setBounds(60, 10, 150, 120);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ip;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel pcname;
    // End of variables declaration//GEN-END:variables
}
