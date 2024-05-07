/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.spotify.ui;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import mx.itson.spotify.entities.Album;
import mx.itson.spotify.entities.Cancion;

/**
 *
 * @author Luis Morell
 */
public class SpotifyFrame extends javax.swing.JFrame {

    /**
     * Creates new form SpotifyFrame
     */
    public SpotifyFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSeleccionar = new javax.swing.JButton();
        labelAlbum = new javax.swing.JLabel();
        labelGenero = new javax.swing.JLabel();
        labelArtista = new javax.swing.JLabel();
        labelPerfil = new javax.swing.JLabel();
        labelFollowers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCanciones = new javax.swing.JTable();
        labelLanzamiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonSeleccionar.setText("Seleccionar archivo...");
        buttonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarActionPerformed(evt);
            }
        });

        labelAlbum.setText("Album");

        labelGenero.setText("Genero");

        labelArtista.setText("Artista");

        labelPerfil.setText("Perfil");

        labelFollowers.setText("Followers");

        tableCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Titulo", "Duracion"
            }
        ));
        jScrollPane1.setViewportView(tableCanciones);

        labelLanzamiento.setText("Fecha de lanzamiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelGenero)
                            .addComponent(labelArtista)
                            .addComponent(labelPerfil)
                            .addComponent(labelFollowers)
                            .addComponent(buttonSeleccionar)
                            .addComponent(labelAlbum)
                            .addComponent(labelLanzamiento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(buttonSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelAlbum)
                .addGap(24, 24, 24)
                .addComponent(labelGenero)
                .addGap(26, 26, 26)
                .addComponent(labelLanzamiento)
                .addGap(33, 33, 33)
                .addComponent(labelArtista)
                .addGap(31, 31, 31)
                .addComponent(labelPerfil)
                .addGap(31, 31, 31)
                .addComponent(labelFollowers)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarActionPerformed
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            
            if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                
                byte fileBytes[] = Files.readAllBytes(file.toPath());
                String contenido = new String(fileBytes, StandardCharsets.UTF_8);
                
                Album album = new Album().deserializar(contenido);
            
                    labelAlbum.setText(album.getNombre());
                    labelGenero.setText(album.getGenero());
                    labelArtista.setText(album.getArtista().getNombre());
                    labelPerfil.setText(album.getArtista().getPerfil());
                    labelFollowers.setText(album.getArtista().getFollowers() + " followers");
                    
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("ES", "es"));
                    
                    labelLanzamiento.setText(dateFormat.format(album.getFechaLanzamiento()));
                    DefaultTableModel model = (DefaultTableModel) tableCanciones.getModel();
                    model.setRowCount(0);
                    
                    for(Cancion c : album.getCanciones())
                        model.addRow(new Object[] {
                        c.getTitulo(),
                        c.getDuracion() + " segundos"
                    });
            }
                        
        
        } catch (Exception ex){
            System.err.println("ex.getMessage");
        }
    }//GEN-LAST:event_buttonSeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(SpotifyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SpotifyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SpotifyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SpotifyFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SpotifyFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlbum;
    private javax.swing.JLabel labelArtista;
    private javax.swing.JLabel labelFollowers;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelLanzamiento;
    private javax.swing.JLabel labelPerfil;
    private javax.swing.JTable tableCanciones;
    // End of variables declaration//GEN-END:variables
}