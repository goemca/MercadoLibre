/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataBase.Conexion;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Logic.Almacenamiento;
import Logic.ChequeoMails;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Gonzalo
 */
public class Visualizador extends javax.swing.JFrame 
{

    /**
     * Creates new form Visualizador
     */
    
    Almacenamiento almc = new Almacenamiento();
    ChequeoMails cm = new ChequeoMails();
    DefaultTableModel dtm;
    Vector VCabercera = new Vector();
    boolean banderaMostrar = false;
    boolean banderaPersistir = false;
    boolean banderar = false;
    Conexion con;
    Connection reg;
    boolean tiempo = false;
      
        
    public Visualizador() 
    {
        initComponents();
        this.toFront();
        this.setTitle("\tGestor de Mails");
        this.setLocationRelativeTo(null);
        this.btngenerar.setEnabled(false);
        this.btn_persistir.setEnabled(false);
        this.VCabercera.addElement("\tNro Mail");
        this.VCabercera.addElement("\tFecha");
        this.VCabercera.addElement("\tDe");
        this.VCabercera.addElement("\tAsunto");
        this.VCabercera.addElement("\tMensaje");
        dtm = new DefaultTableModel(this.VCabercera,0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngenerar = new javax.swing.JButton();
        btnrecuperar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_persistir = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btngenerar.setText("Generar Listado Mails");
        btngenerar.setActionCommand("Generar Listado");
        btngenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btngenerarMouseClicked(evt);
            }
        });

        btnrecuperar.setLabel("Recuperar Mails");
        btnrecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnrecuperarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Mail", "Fecha", "De", "Asunto", "Mensaje"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_persistir.setText("Persistir Datos");
        btn_persistir.setName("btn_conexion"); // NOI18N
        btn_persistir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_persistirMouseClicked(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Salir.png"))); // NOI18N
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnrecuperar)
                        .addGap(18, 18, 18)
                        .addComponent(btngenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_persistir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrecuperar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_persistir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btngenerarMouseClicked
       this.banderaPersistir = true;
       this.btn_persistir.setEnabled(true);
       if(banderaMostrar == true)
       {
           this.jTable1.setModel(almc.listaMail());
           if(this.jTable1.getRowCount() == 0 || this.jTable1.getSelectedRow()== -1)
           {
               JOptionPane.showMessageDialog(rootPane, "No se encontraron mails que cumplan con la condicion \nVerifique su casilla de mensajes","\n¡Atencion!", WIDTH);;
           }
       }
       else
       {
           JOptionPane.showMessageDialog(rootPane, "Por favor primero presione el boton Recuperar Mails","\n¡Atencion!", WIDTH);;
       }
    }//GEN-LAST:event_btngenerarMouseClicked

    private void btnrecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnrecuperarMouseClicked
        Icon icono = new ImageIcon(getClass().getResource("/Resources/Reloj.png"));
        JOptionPane.showMessageDialog(null, "\tSe van a recuperar mensajes....\nPor favor aguarde!!!\n\nNota:Solo se recuperan aquellos mails que contengan como asunto y mensajes :"+"DevOps"+"","\t¡¡¡ Por favor espere !!!",JOptionPane.INFORMATION_MESSAGE, icono);
        ChequeoMails.validar();
        this.btngenerar.setEnabled(true);
        if(this.btngenerar.isEnabled() != true)
        {
            JOptionPane.showMessageDialog(rootPane, "Por favor aguarde se estan Recuperando Mails","\t¡Atencion!", WIDTH);;
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Se recuperaron los datos satisfactoriamente","\t¡Atencion!", WIDTH);;
        }
        banderaMostrar =  true;
        dtm = new DefaultTableModel();
        
    }//GEN-LAST:event_btnrecuperarMouseClicked

    private void btn_persistirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_persistirMouseClicked
        if(banderaPersistir == true)
        {
            con = new Conexion();
            reg = con.getConexion();
            if(this.jTable1.getRowCount() > 0)
            {
                for(int i = 0; i< jTable1.getRowCount();i++)
                {
                    try
                    {
                        con.sentencia.execute("insert into mails(fecha,de,asunto) values ('"+(jTable1.getValueAt(i,1))+"','"+(jTable1.getValueAt(i,2))+"','"+(jTable1.getValueAt(i,3))+"')");
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(Visualizador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                JOptionPane.showMessageDialog(this, "Se guardaron correctamente los datos en la Base de Datos");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "La tabla se encuentra vacia\nVerifique que la misma contenga datos para poder ser persistidos");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "Por favor primero presione el boton Generar Listado Mails","\n¡Atencion!", WIDTH);;
        } 
    }//GEN-LAST:event_btn_persistirMouseClicked

    private void btnsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseClicked
        int aux = JOptionPane.showConfirmDialog(rootPane, "Esta seguro que desea salir", "", JOptionPane.YES_NO_OPTION);
        if(aux == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnsalirMouseClicked

  
    
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
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new Visualizador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_persistir;
    private javax.swing.JButton btngenerar;
    private javax.swing.JButton btnrecuperar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
