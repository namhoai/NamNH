/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ChiDinhXetNghiemController;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import model.BenhAn;
import model.Buong;
import model.PhieuXetNghiem;
import model.XetNghiem;

/**
 *
 * @author HoaiNam
 */
public class ChiDinhXetNghiemFrm extends javax.swing.JFrame {

    /**
     * Creates new form ChiDinhXetNghiemFrm
     */
    private BenhAn benhAn;
    private List<XetNghiem> dsXN;
    private List<PhieuXetNghiem> dsPXN;
    private List<Buong> dsBuong;
    private int selectPXN = -1;
    private int selectedXN = 0;
    
    private DefaultTableModel modelPXN;

    ChiDinhXetNghiemFrm(BenhAn benhAn) {
        initComponents();

        this.benhAn = benhAn;
        
        if (benhAn == null) return;

        dsPXN = benhAn.getDsPhieuXN();

        if (dsPXN != null) {
            // Nếu có dữ liệu thì vẽ lên.
            drawPXN(dsPXN);
        }

        ChiDinhXetNghiemController chiDinhXetNghiemCtr = new ChiDinhXetNghiemController();

        // xét dữ liệu các xét nghiệm.
        dsXN = chiDinhXetNghiemCtr.getDSXetNghiem();
        if (dsXN != null) {
            drawXN(dsXN);
        }

        // Lấy danh sách buồng của Xét nghiệm đầu tiên.
        if (dsXN != null) {
            dsBuong = chiDinhXetNghiemCtr.getBuongXN(dsXN.get(0).getId());
        }

    }

    private void drawPXN(List<PhieuXetNghiem> dsPhieuXN) {
        modelPXN = (DefaultTableModel) tbl_phieuXN.getModel();
        while (modelPXN.getRowCount() > 0) {
            modelPXN.removeRow(0);
        }

        int i = 1;

        for (PhieuXetNghiem phieuXN : dsPhieuXN) {
            String trangThai = (phieuXN.getKetQua().length() > 0) ? "Đã có" : "Chưa có";
            modelPXN.addRow(new Object[]{
                i++,
                phieuXN.getXetNghiem().getTen(),
                phieuXN.getBuong().getTen(),
                trangThai,});
        }
    }

    private void drawXN(List<XetNghiem> dsXN) {
        for (XetNghiem xn : dsXN) {
            cbb_xetNghiem.addItem(xn.getTen());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_them = new javax.swing.JButton();
        cbb_xetNghiem = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_phieuXN = new javax.swing.JTable();
        btn_xoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lab_tenBN = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lab_tuoi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_them.setText("Thêm");
        btn_them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themMouseClicked(evt);
            }
        });
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        cbb_xetNghiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_xetNghiemActionPerformed(evt);
            }
        });

        tbl_phieuXN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên xét nghiệm", "Phòng xét nghiệm", "Trạng thái"
            }
        ));
        tbl_phieuXN.getTableHeader().setReorderingAllowed(false);
        tbl_phieuXN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_phieuXNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_phieuXNMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_phieuXN);

        btn_xoa.setText("Xóa");
        btn_xoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoaMouseClicked(evt);
            }
        });
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Chỉ định xét nghiệm");

        jLabel4.setText("Bệnh nhân : ");

        lab_tenBN.setText("Nguyễn Hoài Nam");

        jLabel6.setText("Tuổi : ");

        lab_tuoi.setText("45");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbb_xetNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(48, 48, 48)
                        .addComponent(lab_tenBN)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lab_tuoi)))
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lab_tenBN)
                        .addComponent(jLabel6)
                        .addComponent(lab_tuoi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_xetNghiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themMouseClicked
        //
    }//GEN-LAST:event_btn_themMouseClicked

    private void tbl_phieuXNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_phieuXNMouseClicked
        selectPXN = tbl_phieuXN.getSelectedRow();
    }//GEN-LAST:event_tbl_phieuXNMouseClicked

    private void tbl_phieuXNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_phieuXNMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_phieuXNMouseEntered

    private void btn_xoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoaMouseClicked

    }//GEN-LAST:event_btn_xoaMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Random rand = new Random();
        Buong buongXN = dsBuong.get(rand.nextInt(dsBuong.size()));
        XetNghiem xetNghiem = dsXN.get(selectedXN);
        
        PhieuXetNghiem phieuXN = new PhieuXetNghiem(0, buongXN, xetNghiem, "");
        
        // Cập nhập vào csdl.
        ChiDinhXetNghiemController chiDinhXetNghiemCtr = new ChiDinhXetNghiemController();
        chiDinhXetNghiemCtr.addPhieuXN(phieuXN, benhAn.getId());

        // Cập nhập lại danh sách phiếu xét nghiệm.
        dsPXN.add(phieuXN);
        drawPXN(dsPXN);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        if (selectPXN == -1) {
            return;
        }

        // Cập nhập vào csdl.
        ChiDinhXetNghiemController chiDinhXetNghiemCtr = new ChiDinhXetNghiemController();
        chiDinhXetNghiemCtr.deletePhieuXN(dsPXN.get(selectPXN).getId());

        // Cập nhập lại danh sách phiếu xét nghiệm.
        dsPXN.remove(selectPXN);
        drawPXN(dsPXN);
        selectPXN = -1;
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void cbb_xetNghiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_xetNghiemActionPerformed
        // TODO add your handling code here:
        selectedXN = cbb_xetNghiem.getSelectedIndex();
        ChiDinhXetNghiemController chiDinhXetNghiemCtr = new ChiDinhXetNghiemController();
        dsBuong = chiDinhXetNghiemCtr.getBuongXN(dsXN.get(selectedXN).getId());
    }//GEN-LAST:event_cbb_xetNghiemActionPerformed

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
            java.util.logging.Logger.getLogger(ChiDinhXetNghiemFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiDinhXetNghiemFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiDinhXetNghiemFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiDinhXetNghiemFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiDinhXetNghiemFrm(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_xetNghiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lab_tenBN;
    private javax.swing.JLabel lab_tuoi;
    private javax.swing.JTable tbl_phieuXN;
    // End of variables declaration//GEN-END:variables

}