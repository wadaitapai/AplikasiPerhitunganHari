package PenghitungHari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class PenghitungHariForm extends javax.swing.JFrame {
    
    public PenghitungHariForm() {
        initComponents();
        
        setTitle("Aplikasi Penghitungan Hari");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
         // 🔧 Kunci ukuran JTextArea agar tampilan tidak bergeser
        txtHasil.setLineWrap(true);
        txtHasil.setWrapStyleWord(true);
        txtHasil.setRows(6);
        txtHasil.setPreferredSize(new Dimension(350, 120));
        
        // 🌈 Warna tombol
        btnHitung.setBackground(new Color(76,175,80));  // Hijau
        btnReset.setBackground(new Color(255,235,59));  // Kuning
        btnKeluar.setBackground(new Color(244,67,54));  // Merah
        btnHitung.setForeground(Color.WHITE);
        btnReset.setForeground(Color.BLACK);
        btnKeluar.setForeground(Color.WHITE);
        
          // 🌿 Efek Hover
        addHoverEffect(btnHitung, new Color(76,175,80), new Color(56,142,60));
        addHoverEffect(btnReset, new Color(255,235,59), new Color(255,213,0));
        addHoverEffect(btnKeluar, new Color(244,67,54), new Color(211,47,47));
        
        // 🧮 Event Tombol
        btnHitung.addActionListener(e -> hitungHari());
        btnReset.addActionListener(e -> resetForm());
        btnKeluar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin keluar?", 
                    "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        });
        // 🗓️ Set tahun ke tahun sekarang dan hilangkan koma pemisah
        spnTahun.setValue(LocalDate.now().getYear());
        
    }
        
    
    // ================== LOGIKA UTAMA ==================
    private void hitungHari() {
        try {
            int tahun = spnTahun.getYear(); // ambil tahun dari JYearChooser
            int bulan = cmbBulan.getSelectedIndex() + 1; // Januari = 0

            LocalDate tanggalAwal = LocalDate.of(tahun, bulan, 1);
            int jumlahHari = tanggalAwal.lengthOfMonth();

            String hariPertama = tanggalAwal.getDayOfWeek()
                    .getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
            String hariTerakhir = tanggalAwal.withDayOfMonth(jumlahHari)
                    .getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
            boolean kabisat = Year.isLeap(tahun);

            txtHasil.setText(
                    "📅 Bulan: " + cmbBulan.getSelectedItem() + " " + tahun + "\n" +
                    "Jumlah Hari : " + jumlahHari + "\n" +
                    "Hari Pertama: " + hariPertama + "\n" +
                    "Hari Terakhir: " + hariTerakhir + "\n" +
                    "Tahun Kabisat: " + (kabisat ? "Ya" : "Tidak")
            );

                 // 🌟 Fitur tambahan: selisih tanggal
          if (cal1.getDate() != null && cal2.getDate() != null) {
                LocalDate tgl1 = cal1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate tgl2 = cal2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
                long selisih = ChronoUnit.DAYS.between(tgl1, tgl2);
                long hariAbsolut = Math.abs(selisih); // biar tidak minus
    
                // 🖥️ Tampilkan di TextArea
                txtHasil.append("\n\nSelisih antara dua tanggal: " + hariAbsolut + " hari");
    
                // 🏷️ Tampilkan juga di label bawah
                lblSelisih.setText("Selisih Hari : " + hariAbsolut + " hari");
            } else {
                lblSelisih.setText("Selisih Hari : -");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Masukkan data dengan benar!", 
                "Kesalahan", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
         // ================== RESET FORM ==================
    private void resetForm() {
        cmbBulan.setSelectedIndex(0);
        spnTahun.setValue(LocalDate.now().getYear());
        txtHasil.setText("");
        cal1.setDate(null);
        cal2.setDate(null);
        lblSelisih.setText("Selisih Hari : ");
    }

    // ================== EFEK HOVER ==================
    private void addHoverEffect(JButton button, Color normal, Color hover) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { button.setBackground(hover); }
            public void mouseExited(MouseEvent e) { button.setBackground(normal); }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        lblBulan = new javax.swing.JLabel();
        lblTahun = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHasil = new javax.swing.JTextArea();
        cal1 = new com.toedter.calendar.JDateChooser();
        cal2 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        lblSelisih = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFitur = new javax.swing.JLabel();
        cmbBulan = new javax.swing.JComboBox<>();
        spnTahun = new com.toedter.calendar.JYearChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        lblBulan.setText("Bulan");

        lblTahun.setText("Tahun");

        btnHitung.setText("Hitung");

        btnReset.setText("Reset");

        btnKeluar.setText("Keluar");

        txtHasil.setColumns(20);
        txtHasil.setRows(5);
        jScrollPane1.setViewportView(txtHasil);

        jLabel4.setText("tanggal 1");

        lblSelisih.setText("Selisih Hari : ");

        jLabel6.setText(" tanggal 2");

        lblFitur.setText("FiturTambahan : ");

        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblFitur))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSelisih)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBulan)
                        .addGap(42, 42, 42)
                        .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lblTahun)
                        .addGap(18, 18, 18)
                        .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnHitung)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnKeluar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBulan)
                        .addComponent(cmbBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTahun))
                    .addComponent(spnTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHitung)
                    .addComponent(btnReset)
                    .addComponent(btnKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblFitur)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17)
                        .addComponent(lblSelisih))
                    .addComponent(cal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("APLIKASI PENGHITUNGAN HARI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PenghitungHariForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenghitungHariForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenghitungHariForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReset;
    private com.toedter.calendar.JDateChooser cal1;
    private com.toedter.calendar.JDateChooser cal2;
    private javax.swing.JComboBox<String> cmbBulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBulan;
    private javax.swing.JLabel lblFitur;
    private javax.swing.JLabel lblSelisih;
    private javax.swing.JLabel lblTahun;
    private com.toedter.calendar.JYearChooser spnTahun;
    private javax.swing.JTextArea txtHasil;
    // End of variables declaration//GEN-END:variables
}
