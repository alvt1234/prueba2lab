
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Reproductor extends javax.swing.JFrame {

    private boolean reproducir=false;
    private long songs;
    private String direct,nombrecancion,directorio="cancion.xd";
    private String direccion="";
    MP3Player song;
    public Reproductor() {
        initComponents();
        try{
          File data = new File("cancion.xd");
          if (!data.exists()) {
          data.createNewFile();
                RandomAccessFile direccancion = new RandomAccessFile(data, "rw");
                direccancion.writeUTF("");
                direccancion.writeLong(0);
                direccancion.writeUTF("");
                direccancion.close();
          } else {
                RandomAccessFile rfdata = new RandomAccessFile(data, "rw");
                rfdata.seek(0);
                direccion = rfdata.readUTF();
                songs = rfdata.readLong();
                nombrecancion = rfdata.readUTF();
                cargar();
                ultimacancion();
            }
                
        }catch (Exception e) {
            e.printStackTrace();
        }
        btplay.setEnabled(false);
        btstop.setEnabled(false);
        
    }
    private void ajustarvolumen(javax.swing.event.ChangeEvent evt){
      int volume=volumen.getValue();
      
    }
    private void ajustarvolumen(int volumen){
        if(song!=null){
            
        }
    }
    private void guardar(String direcmusica,long tam,String nombre){
        try {
            System.out.println("Writing to disk...");
            RandomAccessFile rfdata = new RandomAccessFile(directorio, "rw");
            rfdata.writeUTF(direcmusica);
            rfdata.writeLong(tam);
            rfdata.writeUTF(nombre);
            rfdata.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btagregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        volumen = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        listacanciones = new javax.swing.JList<>();
        btatras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbnombre = new javax.swing.JLabel();
        btplay = new javax.swing.JButton();
        btstop = new javax.swing.JButton();
        btsiguiente = new javax.swing.JButton();
        btseleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btagregar.setText("Agregar");
        btagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarActionPerformed(evt);
            }
        });
        jPanel1.add(btagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setText("Volumen");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        jPanel1.add(volumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jScrollPane1.setViewportView(listacanciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 250));

        btatras.setText("<<");
        btatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btatrasActionPerformed(evt);
            }
        });
        jPanel1.add(btatras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 240, 170));

        lbnombre.setText("jLabel2");
        jPanel1.add(lbnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, -1));

        btplay.setText("Play");
        btplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btplayActionPerformed(evt);
            }
        });
        jPanel1.add(btplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 70, 40));

        btstop.setText("Stop");
        btstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstopActionPerformed(evt);
            }
        });
        jPanel1.add(btstop, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 60, 30));

        btsiguiente.setText(">>");
        btsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsiguienteActionPerformed(evt);
            }
        });
        jPanel1.add(btsiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        btseleccionar.setText("Seleccionar");
        btseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btseleccionarActionPerformed(evt);
            }
        });
        jPanel1.add(btseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
        if(song!=null)
         song.stop();
        
        JFileChooser file=new JFileChooser(System.getProperty("user.home"));
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        file.showOpenDialog(this);

        File selectedFolder = file.getSelectedFile();
        if (selectedFolder != null) {
            direccion = selectedFolder.getAbsolutePath();
            cargar();
        }
    }//GEN-LAST:event_btagregarActionPerformed

    private void btplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btplayActionPerformed
        if(listacanciones.getSelectedValue()!=null){
        if(reproducir){
            reproducir=false;
            btplay.setText("Play");
            song.pause();
        }else{
            reproducir=true;
            btplay.setText("Pausa");
            song.pause(); 
        }
        }else
            JOptionPane.showMessageDialog(null, "No hay cancion para reproducir");
        
    }//GEN-LAST:event_btplayActionPerformed

    private void btseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btseleccionarActionPerformed
        if(song!=null)
            song.stop();
        
      nombrecancion=listacanciones.getSelectedValue();
      lbnombre.setText(nombrecancion);
      btplay.setEnabled(true);
      btstop.setEnabled(true);
    }//GEN-LAST:event_btseleccionarActionPerformed

    private void btatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btatrasActionPerformed
       // TODO add your handling code here:
if (song != null) {
    song.skipBackward();

    for (int i = 0; i < listacanciones.getModel().getSize(); i++) {
        String n = listacanciones.getModel().getElementAt(i);

        if (n.equals(nombrecancion)) {
            if (i - 1 == -1) {
                nombrecancion = listacanciones.getModel().getElementAt(listacanciones.getModel().getSize() - 1);
            } else {
                nombrecancion = listacanciones.getModel().getElementAt(i - 1);
            }
            lbnombre.setText(nombrecancion);
            guardar(direccion, songs, nombrecancion);
            playSong(nombrecancion);
            break;
        }
    }
}

    }//GEN-LAST:event_btatrasActionPerformed

    private void btsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsiguienteActionPerformed
      // TODO add your handling code here:
if (song != null) {
    song.skipForward();

    for (int i = 0; i < listacanciones.getModel().getSize(); i++) {
        String n = listacanciones.getModel().getElementAt(i);

        if (n.equals(nombrecancion)) {
            if (i + 1 == listacanciones.getModel().getSize()) {
                nombrecancion = listacanciones.getModel().getElementAt(0);
            } else {
                nombrecancion = listacanciones.getModel().getElementAt(i + 1);
            }
            lbnombre.setText(nombrecancion);
            guardar(direccion, songs, nombrecancion);
            playSong(nombrecancion);
            break;
        }
    }
}

    }//GEN-LAST:event_btsiguienteActionPerformed

    private void btstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstopActionPerformed
        if(listacanciones.getSelectedValue()!=null)
        song.stop();
        else
        JOptionPane.showMessageDialog(null, "Elija una cancion");
    }//GEN-LAST:event_btstopActionPerformed

    private void cargar(){
        List<String> canciones=obtenernombres();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String song : canciones) {
            model.addElement(song);
        }
         SwingUtilities.invokeLater(() -> {
        listacanciones.setModel(model);
    });
        
    }
    
    private List<String> obtenernombres() {
    List<String> songs = new ArrayList<>();
    
    if (!direccion.isEmpty()) {
        File folder = new File(direccion);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".mp3")) {
                    songs.add(file.getName().replace(".mp3", ""));
                }
            }
        }
    }
    
    return songs;
}
     private void ultimacancion(){
         if(nombrecancion.equals("")){
             lbnombre.setText("No hay musica");
         }else{
             boolean play=false;
             for (int i = 0; i < listacanciones.getModel().getSize(); i++) {
    String name = listacanciones.getModel().getElementAt(i);

    if (name.equals(nombrecancion)) {
        System.out.println("Se encontró la última canción reproducida");
        String path = direccion + File.separator + nombrecancion + ".mp3";
        song = new MP3Player(new File(path));
        lbnombre.setText(nombrecancion);
        reproducir = false;
        btplay.setText("Play");
        play=true;
        break;
    }

    if (play) {
        String path = direccion + File.separator + name + ".mp3";
        song.addToPlayList(new File(path));
    }
}

         }
     }
     private void playSong(String songName) {
        String path = direccion + File.separator + songName + ".mp3";

        if (song != null) {
            song.stop();
        }
        song = new MP3Player(new File(path));
        song.play();
        reproducir= true;
        btplay.setText("PAUSE");
    }

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
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btagregar;
    private javax.swing.JButton btatras;
    private javax.swing.JButton btplay;
    private javax.swing.JButton btseleccionar;
    private javax.swing.JButton btsiguiente;
    private javax.swing.JButton btstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JList<String> listacanciones;
    private javax.swing.JSlider volumen;
    // End of variables declaration//GEN-END:variables
}
