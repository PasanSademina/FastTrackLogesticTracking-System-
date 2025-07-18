/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySql;

/**
 *
 * @author cnn
 */
public class CustomerReg extends javax.swing.JFrame {
    private ManageShipments crv;

    public void setCms(ManageShipments crv) {
        this.crv = crv;
    }

    public CustomerReg() {

        initComponents();

        genarateCustomerId();
        loadCustomer();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
    }

    public void loadCustomer() {
        try {
            // jButton6.setEnabled(false);
            ResultSet rs = MySql.executeSearch("SELECT * FROM `customers`");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("customer_id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("address"));

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void genarateCustomerId() {

        long mTime = System.currentTimeMillis();
        int customId = (int) (mTime % 1000000); // Get the last 6 digits
        String formattedId = String.format("%04d", customId); // Format to ensure it's always 6 digits

        String customText = "50";
        String finalId = customText + formattedId;

        jLabel2.setText(finalId);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 10, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1234567");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.add(jLabel2);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Full Name", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2);

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mobile Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3);

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Address", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Id", "Full Name", "Email", "Mobile", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add New Customer");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Update Customer");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Remove Customer");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Management ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int Cid = Integer.parseInt(jLabel2.getText());
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String mobile = jTextField3.getText();
        String address = jTextField4.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter First name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact number must be exactly 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter  address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ResultSet rs = MySql.executeSearch("SELECT * FROM customers WHERE email='" + email + "' OR phone='" + mobile + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Customer already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySql.executeIUD("INSERT INTO customers (customer_id, name,email, phone, address) VALUES ('"
                            + Cid + "', '" + name + "', '" + email + "', '" + mobile + "', '" + address + "')");
                    // Clear all fields
                    jLabel2.setText("12345");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    JOptionPane.showMessageDialog(this, "New Supplier Added", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadCustomer();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int Cid = Integer.parseInt(jLabel2.getText());
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String mobile = jTextField3.getText();
        String address = jTextField4.getText();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter First name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!name.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact number must be exactly 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // First check if the customer exists
                ResultSet rs = MySql.executeSearch("SELECT * FROM `customers` WHERE `customer_id`='" + Cid + "'");
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(this, "Customer not found", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Check if email or phone already exists for other customers
                    ResultSet duplicateCheck = MySql.executeSearch("SELECT * FROM `customers` WHERE (`email`='" + email + "' OR `phone`='" + mobile + "') AND `customer_id`!='" + Cid + "'");
                    if (duplicateCheck.next()) {
                        JOptionPane.showMessageDialog(this, "Email or phone number already exists for another customer", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        // Update the customer record
                        MySql.executeIUD("UPDATE `customers` SET `name`='" + name + "', `email`='" + email + "', `phone`='" + mobile + "', `address`='" + address + "' WHERE `customer_id`='" + Cid + "'");

                        // Clear all fields
                        jLabel2.setText("12345");
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");

                        JOptionPane.showMessageDialog(this, "Customer Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        loadCustomer();
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2) {
            
            if (crv != null) {
                
                crv.getCustomer_id().setText(String.valueOf(jTable1.getValueAt(selectedRow, 0)));
                crv.getCustomerName().setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
                crv.getCustomerContact().setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
                this.dispose();
            }
            
            jButton2.setEnabled(true);
            jButton3.setEnabled(Boolean.TRUE);
            jLabel2.setText(jTable1.getValueAt(selectedRow, 0).toString());
            jTextField1.setText(jTable1.getValueAt(selectedRow, 1).toString());
            jTextField2.setText(jTable1.getValueAt(selectedRow, 2).toString());
            jTextField3.setText(jTable1.getValueAt(selectedRow, 3).toString());
            jTextField4.setText(jTable1.getValueAt(selectedRow, 4).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int Cid = Integer.parseInt(jLabel2.getText());

// For delete operation, we only need the customer ID
        try {
            // First check if the customer exists
            ResultSet rs = MySql.executeSearch("SELECT * FROM `customers` WHERE `customer_id`='" + Cid + "'");
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Customer not found", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                // Check if customer has any related shipments
                ResultSet shipmentCheck = MySql.executeSearch("SELECT COUNT(*) AS count FROM `shipments` WHERE `customer_id`='" + Cid + "'");
                shipmentCheck.next();
                int shipmentCount = shipmentCheck.getInt("count");

                if (shipmentCount > 0) {
                    JOptionPane.showMessageDialog(this,
                            "Cannot delete customer. This customer has " + shipmentCount + " shipment(s) associated.\n"
                            + "Please delete or reassign the shipments first.",
                            "Cannot Delete",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // Confirm deletion with user
                    int confirm = JOptionPane.showConfirmDialog(this,
                            "Are you sure you want to delete this customer?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Delete the customer record
                        MySql.executeIUD("DELETE FROM `customers` WHERE `customer_id`='" + Cid + "'");

                        // Clear all fields
                        jLabel2.setText("12345");
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");

                        JOptionPane.showMessageDialog(this, "Customer Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        loadCustomer();
                        jButton2.setEnabled(false);
                        jButton3.setEnabled(false);
                    }
                }
            }
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            jLabel2.setText("12345");
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            JOptionPane.showMessageDialog(this,
                    "Cannot delete customer. This customer has related records in other tables.\n"
                    + "Please delete or reassign the related records first.",
                    "Foreign Key Constraint",
                    JOptionPane.WARNING_MESSAGE);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
