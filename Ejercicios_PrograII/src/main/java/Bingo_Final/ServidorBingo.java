package Bingo_Final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author "Rolando Murillo Aguirre"
 */
public class ServidorBingo extends javax.swing.JFrame {

    private int cont = -1;
    private final int cantidadL = 75;
    private final int rangoL = (75 + 1);
    private final int cantidadB = 25;
    private final int rangoB = (25 + 1);

    static ServerSocket conection = null;
    static Socket conectionS = null;
    static DataOutputStream flujoSal;
    static DataInputStream flujoEnt;

    static Vector<UsuarioBingo> usuarios = new Vector();
    private int[] arreglo;

    public ServidorBingo() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(500, 200);
        initComponents();
        jtaInterraccion.setLineWrap(true);
        jbtSiguiente.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPTextArea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaInterraccion = new javax.swing.JTextArea();
        jPBotones = new javax.swing.JPanel();
        jbtInicir = new javax.swing.JButton();
        jbtSiguiente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlbNumero = new javax.swing.JLabel();
        jlbTituloNumero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtaInterraccion.setColumns(20);
        jtaInterraccion.setRows(5);
        jScrollPane1.setViewportView(jtaInterraccion);

        javax.swing.GroupLayout jPTextAreaLayout = new javax.swing.GroupLayout(jPTextArea);
        jPTextArea.setLayout(jPTextAreaLayout);
        jPTextAreaLayout.setHorizontalGroup(
            jPTextAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTextAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPTextAreaLayout.setVerticalGroup(
            jPTextAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTextAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtInicir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtInicir.setText("INICIAR");
        jbtInicir.setFocusable(false);
        jbtInicir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtInicir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInicirActionPerformed(evt);
            }
        });

        jbtSiguiente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtSiguiente.setText("SIGUIENTE");
        jbtSiguiente.setFocusable(false);
        jbtSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotonesLayout = new javax.swing.GroupLayout(jPBotones);
        jPBotones.setLayout(jPBotonesLayout);
        jPBotonesLayout.setHorizontalGroup(
            jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jbtInicir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jbtSiguiente)
                .addGap(24, 24, 24))
        );
        jPBotonesLayout.setVerticalGroup(
            jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtInicir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlbNumero.setFont(new java.awt.Font("Segoe UI", 3, 32)); // NOI18N
        jlbNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNumero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), null));
        jlbNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jlbTituloNumero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTituloNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTituloNumero.setText("NÚMERO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTituloNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jlbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTituloNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtInicirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInicirActionPerformed
        jbtSiguiente.setEnabled(true);

        int[] vectInicial = new int[76];
        for (int i = 0; i <= 75; i++) {
            vectInicial[i] = i;
            jtaInterraccion.append(vectInicial[i] + "   ");
        }
        
        int[] vectBin = obtenerLista(cantidadB, rangoB);
        String num="c";
        try {
            for (int i = 0; i < vectBin.length; i++) {
                num += vectBin[i] + ",";
            }
            
            flujoSal.writeUTF(num);
            flujoSal.flush();
        } catch (Exception e) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        }

    }//GEN-LAST:event_jbtInicirActionPerformed

    private void jbtSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSiguienteActionPerformed

        int[] vect1 = new int[75];
        vect1 = obtenerLista(cantidadL, rangoL);
        if (cont >= 0 || cont <= 75) {

            try {
                cont++;
                jlbNumero.setText(vect1[cont] + "");

                flujoSal.writeUTF("." + vect1[cont]);
                flujoSal.flush();

            } catch (Exception e) {
                System.out.println("No se puede acceder al servidor.");
                System.exit(1);
            }

        } else {
            jbtSiguiente.setEnabled(false);
        }

    }//GEN-LAST:event_jbtSiguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorBingo().setVisible(true);
            }
        });

        try {
            conection = new ServerSocket(8000);
            System.out.println("El servidor ha iniciado.... esperando usuarios");

        } catch (Exception e) {
            System.out.println("Comunicación rechazada." + e.getLocalizedMessage());
            System.exit(1);
        }
        while (true) {
            try {
                conectionS = conection.accept();

                flujoEnt = new DataInputStream(
                        new BufferedInputStream(conectionS.getInputStream()));
                flujoSal = new DataOutputStream(
                        new BufferedOutputStream(conectionS.getOutputStream()));
                String name = flujoEnt.readUTF();

                System.out.println("Conexión exitosa con: " + name);
                FlujoBingo flujoBingo = new FlujoBingo(conectionS, name);
                flujoBingo.start();

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getLocalizedMessage());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPBotones;
    private javax.swing.JPanel jPTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtInicir;
    private javax.swing.JButton jbtSiguiente;
    private javax.swing.JLabel jlbNumero;
    private javax.swing.JLabel jlbTituloNumero;
    private javax.swing.JTextArea jtaInterraccion;
    // End of variables declaration//GEN-END:variables

    /**
     * Método creado para la realización de la lista con números aleatorios sin
     * repetir
     *
     * @return
     */
    private int[] obtenerLista(int cantidad, int rango) {
        int i = 0;  
        
        arreglo = new int[cantidad];
        arreglo[i] = (int) (Math.random() * rango);

        for (i = 1; i < cantidad; i++) {
            arreglo[i] = (int) (Math.random() * rango);

            for (int j = 0; j < i; j++) {
                if (arreglo[i] == arreglo[j]) {
                    i--;

                }
            }
        }
        return arreglo;
    }

    /**
     * Método establecido para rellenar los botones alineados con respecto a la
     * columna de la letra B
     *
     * @return
     */


}
