package Bingo_Final;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author "Rolando Murillo Aguirre"
 */
public class Bingo extends javax.swing.JFrame {

    static Socket conectionS = null;
    static DataInputStream entradaSocket;
    static DataOutputStream salidaSocket;
    static DefaultTableModel tableModel;
    static ArrayList numBingo = new ArrayList();

    public Bingo() {
        this.setLocation(500, 200);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBingo = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbtBingo = new javax.swing.JButton();
        jlbNumero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbBingo.setFont(jtbBingo.getFont().deriveFont((jtbBingo.getFont().getStyle() | java.awt.Font.ITALIC), 30));
        jtbBingo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "B", "I", "N", "G", "O"
            }
        ));
        jtbBingo.setCellSelectionEnabled(true);
        jtbBingo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtbBingo.setDoubleBuffered(true);
        jtbBingo.setGridColor(new java.awt.Color(153, 0, 0));
        jtbBingo.setRowHeight(50);
        jtbBingo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jtbBingo.setShowGrid(false);
        jtbBingo.setShowHorizontalLines(true);
        jtbBingo.setShowVerticalLines(true);
        jtbBingo.setSurrendersFocusOnKeystroke(true);
        jtbBingo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbBingo);
        if (jtbBingo.getColumnModel().getColumnCount() > 0) {
            jtbBingo.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtbBingo.getColumnModel().getColumn(1).setPreferredWidth(100);
            jtbBingo.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbBingo.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtbBingo.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jbtBingo.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jbtBingo.setText("¡BINGO!");
        jbtBingo.setFocusable(false);

        jlbNumero.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jlbNumero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNumero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.black, java.awt.Color.black, null));
        jlbNumero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbtBingo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtBingo, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(jlbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bingo().setVisible(true);
            }
        });

        String name = JOptionPane.showInputDialog("Ingrese su nombre");

        try {
            conectionS = new Socket("LocalHost", 8000);

            salidaSocket = new DataOutputStream(new BufferedOutputStream(
                    conectionS.getOutputStream()));

            salidaSocket.writeUTF(name);
            salidaSocket.flush();

        } catch (Exception e) {
            System.out.println("No se puede acceder al servidor.");
            System.exit(1);
        }

        while (true) {

            try {
                entradaSocket = new DataInputStream(new BufferedInputStream(
                        conectionS.getInputStream()));

                String numero = entradaSocket.readUTF();

                if (numero.startsWith(".")) {

                    jlbNumero.setText(numero.replace(".", ""));
                }

                if (numero.startsWith("c")) {
                    String[] arrayNum = numero.replace("c","").split(",");
                    for (int i = 0; i < arrayNum.length; i++) {
                        numBingo.add(arrayNum[i]);
                    }
                }
                if (!numBingo.isEmpty()) {
                    jtbBingo.setModel(new javax.swing.table.DefaultTableModel(
                            new Object[][]{
                                {numBingo.get(0), numBingo.get(1), numBingo.get(2), numBingo.get(3), numBingo.get(4)},
                                {numBingo.get(5), numBingo.get(6), numBingo.get(7), numBingo.get(8), numBingo.get(9)},
                                {numBingo.get(10), numBingo.get(11), numBingo.get(12), numBingo.get(13), numBingo.get(14)},
                                {numBingo.get(15), numBingo.get(16), numBingo.get(17), numBingo.get(18), numBingo.get(19)},
                                {numBingo.get(20), numBingo.get(21), numBingo.get(22), numBingo.get(23), numBingo.get(24)},
                            },
                            new String[]{
                                "B", "I", "N", "G", "o"
                            }
                    ));
                }

            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtBingo;
    private static javax.swing.JLabel jlbNumero;
    private static javax.swing.JTable jtbBingo;
    // End of variables declaration//GEN-END:variables
}
