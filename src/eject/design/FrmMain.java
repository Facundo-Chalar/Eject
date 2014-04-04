/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eject.design;


import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import eject.domain.ConfigurationManager;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Tower
 */
public class FrmMain extends javax.swing.JFrame {
    private frmConsole frmConsola;
    /**
     * Creates new form FrmMain
     */

    public FrmMain() {
        
            initComponents();
           
           frmConsola=new frmConsole();
           frmConsola.setVisible(false);
           
        
        
    }
public void ejectStream(boolean xEstaListo){
     try{
         ProcessBuilder ejectBuilder;
         String rutaLs=ConfigurationManager.getConfigSettings("rutaLs");
         if(xEstaListo){
            
          ejectBuilder=new ProcessBuilder("cmd.exe","/C",rutaLs+ " twitch.tv/"+jTextField1.getText()+" "+jComboBox1.getModel().getSelectedItem().toString()); 
         }else{
             
           
               ejectBuilder=new ProcessBuilder("cmd.exe","/C", rutaLs+" twitch.tv/"+ jTextField1.getText());
            
         }
        ejectBuilder.redirectErrorStream(true);
            Process eject=ejectBuilder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(eject.getInputStream()));
        String line;
     
       while (true) {
            
            line = r.readLine();
            frmConsola.agregarLinea(line);
            
            if (line == null) { break; }
             System.out.println(line);
            if(line.contains("Available streams:")){
                line=line.replace("Available streams:","");
            }if(line.contains("(worst)") || line.contains("(best)")){
                line=line.replace("(worst)", "");
                line=line.replace("(best)", "");
              }  
            String[] resoluciones=line.split(",");
                for(int i=0;i<resoluciones.length-1;i++){
                    ComboBoxModel comboResoluciones=new DefaultComboBoxModel(resoluciones);
                    jComboBox1.setModel(comboResoluciones);
                    
                }
                if(line.contains("livestreamer: error")|| line.contains("error: Unable to open URL") || line.contains("No streams found")){
                    JOptionPane.showMessageDialog(null, "Stream not found,check name.");
                }else if(line.contains("null")){
                    JOptionPane.showMessageDialog(null, "Error on livestreamer executable path,please check if path is correct");
                }
            }
         }catch (IOException e){
             System.out.println("Error");
         }    
}public void ejectarStream(){
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        btnEject = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eject");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMain.class.getResource("eject.png")));

        jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enter a stream to pick quality" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eject/design/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnEject.setBackground(new java.awt.Color(100, 65, 165));
        btnEject.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEject.setForeground(new java.awt.Color(204, 204, 255));
        btnEject.setText("EJECT STREAM!");
        btnEject.setToolTipText("Press Eject to open the stream in a new window");
        btnEject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(100, 65, 165));
        jLabel2.setText(" Twitch.tv/");

        jMenu2.setText("Config");

        jMenuItem1.setText("Path to livestreamer app.");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Other");

        jMenuItem3.setText("Show console");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEject, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter the stream name.");
        }else {
        ejectStream(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjectActionPerformed
             if(jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please enter stream");
        }else if(jComboBox1.getSelectedItem().toString().equals("Enter a stream to pick quality")){
            JOptionPane.showMessageDialog(null, "Search for the stream and pick quality first.");
        }
             else {
        ejectStream(true);
        }
    }//GEN-LAST:event_btnEjectActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fcRutaLs=new JFileChooser();
        fcRutaLs.setFileFilter(new FileNameExtensionFilter(".EXE Executable Files", "exe"));
         fcRutaLs.showOpenDialog(this);
        
         if(fcRutaLs.getSelectedFile()!= null){
             
            if(fcRutaLs.getSelectedFile().getName().equals("livestreamer.exe")){
                
           
             try{
             String rutaLs=fcRutaLs.getSelectedFile().getAbsolutePath();
             
             ConfigurationManager.saveConfig("rutaLs", rutaLs);
             }catch(IOException e){
                 JOptionPane.showMessageDialog(null, "Failed to load LiveStreamer path.");
             }
            }else{
                JOptionPane.showMessageDialog(null, "Please choose livestreamer.exe.");
                fcRutaLs.setSelectedFile(null);
            }
            
         }else{
                     JOptionPane.showMessageDialog(null, "Choose livestreamer.exe path first");
                     }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          JOptionPane.showMessageDialog(null, "Programmed by facu.ch");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      
        frmConsola.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEject;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}