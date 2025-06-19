/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySql;

/**
 *
 * @author cnn
 */
public class DriverReg extends javax.swing.JFrame {

    private ManageShipments Ms;

    public void setMs(ManageShipments Ms) {
        this.Ms = Ms;
    }

    public DriverReg() {
        initComponents();
        genarateDriverId();
        LoadVehtype();
//        LoadStatus();
//        employeeStatus();
        LoadRoute();
        loadDrivers();
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
//        jComboBox1.setVisible(false);
//        jComboBox3.setVisible(false);
    }

    public void loadDrivers() {
        try {
            ResultSet rs = MySql.executeSearch(
                    "SELECT d.driver_id, d.name, d.contact, vt.type_name, d.license_number, d.email, "
                    + "d.vehicle_registration, ds.status_name AS driver_status, es.status_name AS employment_status, "
                    + "r.name, r.id "
                    + "FROM drivers d "
                    + "LEFT JOIN vehicle_types vt ON d.vehicle_type_id = vt.type_id "
                    + "LEFT JOIN driver_status ds ON d.status_id = ds.status_id "
                    + "LEFT JOIN employment_status es ON d.employment_status_id = es.status_id "
                    + "LEFT JOIN route r ON d.route_id = r.id"
            );
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("driver_id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("contact"));
                v.add(rs.getString("vehicle_registration"));
                v.add(rs.getString("license_number"));
                v.add(rs.getString("type_name")); // Vehicle type
                v.add(rs.getString("employment_status"));
                v.add(rs.getString("r.name")); // Route information
                //v.add(rs.getString("driver_status"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadRoute() {
        try {

            ResultSet rs = MySql.executeSearch("SELECT * FROM `route`");

            Vector v = new Vector();
            v.add("Select Route ");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadVehtype() {
        try {

            ResultSet rs = MySql.executeSearch("SELECT * FROM `vehicle_types`");

            Vector v = new Vector();
            v.add("Select Vehicle Type");

            while (rs.next()) {
                v.add(rs.getString("type_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void LoadStatus() {
//        try {
//
//            ResultSet rs = MySql.executeSearch("SELECT * FROM `driver_status`");
//
//            Vector v = new Vector();
//            v.add("Select Working Status");
//
//            while (rs.next()) {
//                v.add(rs.getString("status_name"));
//            }
//            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
//            jComboBox1.setModel(dcm);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private void employeeStatus() {
//        try {
//
//            ResultSet rs = MySql.executeSearch("SELECT * FROM `employment_status`");
//            Vector v = new Vector();
//            v.add("Select Employment Status");
//
//            while (rs.next()) {
//                v.add(rs.getString("status_name"));
//            }
//            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
//            jComboBox3.setModel(dcm);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    private void genarateDriverId() {

        long mTime = System.currentTimeMillis();
        int customId = (int) (mTime % 1000000); // Get the last 6 digits
        String formattedId = String.format("%04d", customId); // Format to ensure it's always 6 digits

        String customText = "99";
        String finalId = customText + formattedId;

        jLabel2.setText(finalId);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 10, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("1234567");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Driver ID", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
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
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "License Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4);

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Registration Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Driver  Registration");

        jPanel1.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehicle Type", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(jComboBox2);

        jComboBox3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Driver Route", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.add(jComboBox3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Driver ID", "Driver Name", "Email", "Mobile No", "Vehical Reg No", "Licence No", "Vehical Type", "Employment Status", "Route"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        jButton1.setText("Add New Driver ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Update Driver ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Remove  ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int Did = Integer.parseInt(jLabel2.getText()); // Assuming you auto-generate this or use AUTO_INCREMENT
        String name = jTextField1.getText();
        String email = jTextField2.getText();
        String mobile = jTextField3.getText(); // This is 'contact'
        String lId = jTextField4.getText();    // License ID
        String VehRegNo = jTextField5.getText(); // Vehicle Registration No
        String VehType = jComboBox2.getSelectedItem().toString(); // Vehicle Type (e.g., Car, Truck) 
        String route = jComboBox3.getSelectedItem().toString();
        int vehicleTypeId = 0;
        int routeTypeId = 0;

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter driver name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!name.matches("^[A-Za-z]+( [A-Za-z]+)*$")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters and spaces", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact number must be exactly 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter license number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (VehRegNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter vehicle registration number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Get vehicle_type_id from vehicle_types table
                ResultSet rs1 = MySql.executeSearch("SELECT type_id FROM vehicle_types WHERE type_name='" + VehType + "'");
                if (rs1.next()) {
                    vehicleTypeId = rs1.getInt("type_id");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid vehicle type selected", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                ResultSet rs2 = MySql.executeSearch("SELECT Id FROM route WHERE name='" + route + "'");
                if (rs2.next()) {
                    routeTypeId = rs2.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Route selected", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Check for duplicate driver
                ResultSet rs = MySql.executeSearch("SELECT * FROM drivers WHERE email='" + email + "' OR contact='" + mobile + "'");
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Driver already exists", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    // Default statuses (you may replace these with selections)
                    int driverStatusId = 1;     // Available
                    int employmentStatusId = 1; // Active

                    MySql.executeIUD("INSERT INTO drivers (name, contact, vehicle_type_id, license_number, email, vehicle_registration, status_id, employment_status_id,route_id) "
                            + "VALUES ('" + name + "', '" + mobile + "', '" + vehicleTypeId + "', '" + lId + "', '" + email + "', '" + VehRegNo + "', '" + driverStatusId + "', '" + employmentStatusId + "', '" + routeTypeId + "')");

                    JOptionPane.showMessageDialog(this, "New Driver Added", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear all fields
                    jLabel2.setText("Auto");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jComboBox2.setSelectedIndex(0);
                    loadDrivers(); // Refresh the table
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int Did = Integer.parseInt(jLabel2.getText()); // Driver ID from label
        String name = jTextField1.getText().trim();
        String email = jTextField2.getText().trim();
        String mobile = jTextField3.getText().trim();
        String lId = jTextField4.getText().trim();    // License Number
        String VehRegNo = jTextField5.getText().trim(); // Vehicle Registration No
        String VehType = jComboBox2.getSelectedItem().toString(); // Vehicle Type
        String route = jComboBox3.getSelectedItem().toString();
        int vehicleTypeId = 0;
        int routeTypeId = 0;

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter driver name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!name.matches("^[A-Za-z]+( [A-Za-z]+)*$")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters and spaces", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact number must be exactly 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter license number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (VehRegNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter vehicle registration number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Get vehicle_type_id
                ResultSet rs1 = MySql.executeSearch("SELECT type_id FROM vehicle_types WHERE type_name='" + VehType + "'");
                if (rs1.next()) {
                    vehicleTypeId = rs1.getInt("type_id");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid vehicle type selected", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                ResultSet rs2 = MySql.executeSearch("SELECT Id FROM route WHERE name='" + route + "'");
                if (rs2.next()) {
                    routeTypeId = rs2.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Route selected", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Update driver data
                MySql.executeIUD("UPDATE drivers SET name='" + name + "', contact='" + mobile + "', vehicle_type_id='" + vehicleTypeId
                        + "', license_number='" + lId + "', email='" + email + "', route_id='" + routeTypeId + "', vehicle_registration='" + VehRegNo
                        + "' WHERE driver_id='" + Did + "'");

                JOptionPane.showMessageDialog(this, "Driver details updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                jButton1.setEnabled(Boolean.TRUE);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
//                jComboBox1.setVisible(false);
//                jComboBox3.setVisible(false);
                // Clear fields
                jLabel2.setText("Auto");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jComboBox2.setSelectedIndex(0);
                loadDrivers(); // Refresh driver table
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2) {
            if (Ms != null) {

                Ms.getDriver_id().setText(String.valueOf(jTable1.getValueAt(selectedRow, 0)));
                Ms.getDriverName().setText(String.valueOf(jTable1.getValueAt(selectedRow, 1)));
                Ms.getDriverContact().setText(String.valueOf(jTable1.getValueAt(selectedRow, 3)));
                this.dispose();
            }

            jLabel2.setText(jTable1.getValueAt(selectedRow, 0).toString());
            jTextField1.setText(jTable1.getValueAt(selectedRow, 1).toString());
            jTextField2.setText(jTable1.getValueAt(selectedRow, 2).toString());
            jTextField3.setText(jTable1.getValueAt(selectedRow, 3).toString());
            jTextField4.setText(jTable1.getValueAt(selectedRow, 4).toString());
            jTextField5.setText(jTable1.getValueAt(selectedRow, 5).toString());
            String selectedValue1 = jTable1.getValueAt(selectedRow, 6).toString();
            jComboBox2.setSelectedItem(selectedValue1);
            String selectedValue3 = jTable1.getValueAt(selectedRow, 8).toString();
            jComboBox3.setSelectedItem(selectedValue3);
            String selectedValue2 = jTable1.getValueAt(selectedRow, 7).toString();
            jButton1.setEnabled(Boolean.FALSE);
            jButton2.setEnabled(Boolean.TRUE);
            jButton3.setEnabled(Boolean.TRUE);

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int Did = Integer.parseInt(jLabel2.getText()); // Driver ID from label
        String name = jTextField1.getText().trim();
        String email = jTextField2.getText().trim();
        String mobile = jTextField3.getText().trim();
        String lId = jTextField4.getText().trim(); // License Number
        String VehRegNo = jTextField5.getText().trim(); // Vehicle Registration No
        String VehType = jComboBox2.getSelectedItem().toString(); // Vehicle Type

        int vehicleTypeId = 0;
        int employmentStatusId = 0;

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter driver name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!name.matches("^[A-Za-z]+( [A-Za-z]+)*$")) {
            JOptionPane.showMessageDialog(this, "Name must contain only letters and spaces", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter contact number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!mobile.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Contact number must be exactly 10 digits", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter license number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (VehRegNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter vehicle registration number", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                // Get vehicle_type_id
                ResultSet rs1 = MySql.executeSearch("SELECT type_id FROM vehicle_types WHERE type_name='" + VehType + "'");
                if (rs1.next()) {
                    vehicleTypeId = rs1.getInt("type_id");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid vehicle type selected", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Get current employment status of the driver
                ResultSet rsStatus = MySql.executeSearch("SELECT employment_status_id FROM drivers WHERE driver_id='" + Did + "'");
                if (rsStatus.next()) {
                    int currentStatus = rsStatus.getInt("employment_status_id");
                    // Toggle status: 1 -> 2, 2 -> 1
                    employmentStatusId = (currentStatus == 1) ? 2 : 1;
                } else {
                    JOptionPane.showMessageDialog(this, "Driver not found", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update driver data
                MySql.executeIUD("UPDATE drivers SET name='" + name + "', contact='" + mobile + "', vehicle_type_id='" + vehicleTypeId
                        + "', license_number='" + lId + "', email='" + email + "', vehicle_registration='" + VehRegNo
                        + "', employment_status_id='" + employmentStatusId + "' WHERE driver_id='" + Did + "'");

                JOptionPane.showMessageDialog(this, "Driver details updated and status Status Changed", "Success", JOptionPane.INFORMATION_MESSAGE);
                jButton1.setEnabled(Boolean.TRUE);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                // Clear fields
                jLabel2.setText("Auto");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);

                loadDrivers(); // Refresh driver table

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
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
                new DriverReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
