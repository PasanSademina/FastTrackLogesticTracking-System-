/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sun.source.tree.BreakTree;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DriverDetails;
import model.CustomerDetails;
import model.MySql;

/**
 *
 * @author cnn
 */
public class ManageShipments extends javax.swing.JFrame {

    HashMap<String, DriverDetails> DhashMap = new HashMap<>();
    HashMap<String, CustomerDetails> ChashMap = new HashMap<>();

    public JLabel getDriver_id() {
        return jLabel5;
    }

    public JLabel getDriverName() {
        return jLabel6;
    }

    public JLabel getDriverContact() {
        return jLabel7;
    }

    public JLabel getCustomer_id() {
        return jLabel11;
    }

    public JLabel getCustomerName() {
        return jLabel12;
    }

    public JLabel getCustomerContact() {
        return jLabel13;
    }

    public ManageShipments() {
        initComponents();
        LoadDslot();
        LoadPriority();
        genarateShipmentId();
        loadShipments();
    }

    private void reset() {
        jLabel5.setText("");
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel11.setText("");
        jLabel12.setText("");
        jLabel13.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
    }

    private void selectComboItem(javax.swing.JComboBox<?> combo, String name) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            String item = combo.getItemAt(i).toString(); // “1 - Morning”
            if (item.endsWith(name) || item.contains(" - " + name)) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    public void loadShipments() {
        try {
            ResultSet rs = MySql.executeSearch(
                    "SELECT s.shipment_id, c.name AS customer_name, d.name AS driver_name, "
                    + "s.sender_name, s.sender_address, s.receiver_name, s.receiver_address, "
                    + "s.contents, s.estimated_delivery, s.actual_delivery, s.pickup_time, "
                    + "s.delivery_slot_id, s.weight, s.priority_id "
                    + "FROM shipments s "
                    + "LEFT JOIN customers c ON s.customer_id = c.customer_id "
                    + "LEFT JOIN drivers d ON s.driver_id = d.driver_id"
            );

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("shipment_id"));
                v.add(rs.getString("customer_name"));
                v.add(rs.getString("driver_name"));
                v.add(rs.getString("sender_name"));
                v.add(rs.getString("sender_address"));
                v.add(rs.getString("receiver_name"));
                v.add(rs.getString("receiver_address"));
                v.add(rs.getString("contents"));
                v.add(rs.getString("estimated_delivery"));
                v.add(rs.getString("actual_delivery"));
                v.add(rs.getString("pickup_time"));
                v.add(rs.getString("delivery_slot_id"));
                v.add(rs.getString("weight"));
                v.add(rs.getString("priority_id"));

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading shipments: " + e.getMessage());
        }
    }

    private void genarateShipmentId() {

        long mTime = System.currentTimeMillis();
        int customId = (int) (mTime % 1000000); // Get the last 6 digits
        String formattedId = String.format("%04d", customId); // Format to ensure it's always 6 digits

        String customText = "99";
        String finalId = customText + formattedId;

        jLabel14.setText(finalId);

    }

    private void LoadDslot() {
        try {

            ResultSet rs = MySql.executeSearch("SELECT * FROM `delivery_slots`");

            Vector v = new Vector();
            v.add("Select Time Slot");

            while (rs.next()) {
                v.add(rs.getString("SlotName"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox2.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadPriority() {
        try {

            ResultSet rs = MySql.executeSearch("SELECT * FROM `priority_levels`");

            Vector v = new Vector();
            v.add("Select Priority");

            while (rs.next()) {
                v.add(rs.getString("level_name"));
            }
            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox3.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DriverReg drv;
    private CustomerReg crv;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ShipMent Management");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shipments Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assign Driver Shipemnt", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton1.setText("Select Driver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        jLabel2.setText("Driver ID :");
        jPanel5.add(jLabel2);

        jLabel3.setText("Driver Name :");
        jPanel5.add(jLabel3);

        jLabel4.setText("Driver Contact Number :");
        jPanel5.add(jLabel4);

        jPanel6.setLayout(new java.awt.GridLayout(3, 1, 10, 10));
        jPanel6.add(jLabel5);
        jPanel6.add(jLabel6);
        jPanel6.add(jLabel7);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer  Details", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jButton2.setText("Select Customer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel8.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        jLabel8.setText("Customer ID :");
        jPanel8.add(jLabel8);

        jLabel9.setText("Customer Name :");
        jPanel8.add(jLabel9);

        jLabel10.setText("Customer Contact Number :");
        jPanel8.add(jLabel10);

        jPanel9.setLayout(new java.awt.GridLayout(3, 1, 10, 10));
        jPanel9.add(jLabel11);
        jPanel9.add(jLabel12);
        jPanel9.add(jLabel13);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setLayout(new java.awt.GridLayout(6, 1, 10, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Shipment Id"));
        jPanel15.add(jLabel14);

        jDateChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estimated Delivery Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel15.add(jDateChooser1);

        jDateChooser2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual Delivery Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel15.add(jDateChooser2);

        jDateChooser3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pickup Date", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel15.add(jDateChooser3);

        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder("Delivery Slot "));
        jPanel15.add(jComboBox2);

        jComboBox3.setBorder(javax.swing.BorderFactory.createTitledBorder("Priority"));
        jPanel15.add(jComboBox3);

        jPanel18.setLayout(new java.awt.GridLayout(3, 1, 5, 5));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Receiver  Details", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel12.setLayout(new java.awt.GridLayout());

        jPanel13.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Receiver Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jPanel13.add(jTextField5);

        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Receiver  Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jPanel13.add(jTextField6);

        jPanel12.add(jPanel13);

        jPanel18.add(jPanel12);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Senders  Details", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel10.setLayout(new java.awt.GridLayout());

        jPanel11.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Senders Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jPanel11.add(jTextField2);

        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Senders Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jPanel11.add(jTextField3);

        jPanel10.add(jPanel11);

        jPanel18.add(jPanel10);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contents and Wight", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel16.setLayout(new java.awt.GridLayout());

        jPanel17.setLayout(new java.awt.GridLayout(2, 1, 10, 10));

        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Content Of Package", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel17.add(jTextField7);

        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Weight  Of package (Kg)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 13))); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel17.add(jTextField8);

        jPanel16.add(jPanel17);

        jPanel18.add(jPanel16);

        jPanel1.setLayout(new java.awt.GridLayout(2, 0, 10, 0));

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 1));

        jButton3.setBackground(new java.awt.Color(0, 204, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Add New Shipment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setBackground(new java.awt.Color(0, 255, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Update Shipment");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Remove Shipment");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "shipment id", "Customer Name", "Driver Name", "Sender Name", "Sender Address", "Receiver Name", "Receiver Address", "contents", "Estimated Date", "Actual Date", "Pickup Time", "Delivery slot id", "Weight", "Priority id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Shipment Here", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jTextField1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTextField1InputMethodTextChanged(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Reset");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (drv == null || !drv.isDisplayable()) {
            drv = new DriverReg();
            drv.setVisible(true);
            drv.setMs(this);
            drv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        } else {
            drv.toFront();
            drv.requestFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (crv == null || !crv.isDisplayable()) {
            crv = new CustomerReg();
            crv.setVisible(true);
            crv.setCms(this);
            crv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        } else {
            crv.toFront();
            crv.requestFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String shipment_id = jLabel14.getText().trim();
        String customer_id = jLabel11.getText().trim();
        String driver_id = jLabel5.getText().trim();

        String rname = jTextField5.getText().trim();
        String rAddress = jTextField6.getText().trim();
        String sname = jTextField2.getText().trim();
        String sAddress = jTextField3.getText().trim();
        String content = jTextField7.getText().trim();
        String weight = jTextField8.getText().trim();

        Date estd = jDateChooser1.getDate();
        Date actd = jDateChooser2.getDate();
        Date pd = jDateChooser3.getDate();

        Object dslotObj = jComboBox2.getSelectedItem();
        Object priorityObj = jComboBox3.getSelectedItem();

// Validate all required fields
        if (customer_id.isEmpty() || driver_id.isEmpty() || rname.isEmpty() || rAddress.isEmpty()
                || sname.isEmpty() || sAddress.isEmpty() || content.isEmpty() || weight.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (estd == null || actd == null || pd == null) {
            JOptionPane.showMessageDialog(this, "Please select all dates", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (dslotObj == null || priorityObj == null) {
            JOptionPane.showMessageDialog(this, "Please select delivery slot and priority", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validate weight
        double weightValue;
        try {
            weightValue = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid number", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Get selected names
        String selectedSlotName = dslotObj.toString();
        String selectedPriorityName = priorityObj.toString();

// Lookup delivery_slot_id
        String deliverySlotId = "";
        try {
            ResultSet rs = MySql.executeSearch("SELECT slot_id FROM delivery_slots WHERE SlotName = '" + selectedSlotName + "'");
            if (rs.next()) {
                deliverySlotId = rs.getString("slot_id");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid delivery slot selected.", "Error", JOptionPane.ERROR_MESSAGE);
                rs.close();
                return;
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching delivery slot ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

// Lookup priority_id
        String priorityId = "";
        try {
            ResultSet rs2 = MySql.executeSearch("SELECT priority_id FROM priority_levels WHERE level_name = '" + selectedPriorityName + "'");
            if (rs2.next()) {
                priorityId = rs2.getString("priority_id");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid priority selected.", "Error", JOptionPane.ERROR_MESSAGE);
                rs2.close();
                return;
            }
            rs2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching priority ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

// Insert shipment
        try {
            // Check for duplicate shipment ID
            ResultSet rs = MySql.executeSearch("SELECT * FROM shipments WHERE shipment_id = '" + shipment_id + "'");
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Shipment Data Already aded ", "Error", JOptionPane.INFORMATION_MESSAGE);

                // Clear fields
                reset();

            } else {
                String query = "INSERT INTO shipments (shipment_id,customer_id, driver_id, receiver_name, receiver_address, sender_name, sender_address, "
                        + "contents, weight, estimated_delivery, actual_delivery, pickup_time, delivery_slot_id, priority_id, status_id) "
                        + "VALUES ('" + shipment_id + "','" + customer_id + "', '" + driver_id + "', '" + rname + "', '" + rAddress + "', '" + sname + "', '" + sAddress + "', '"
                        + content + "', " + weightValue + ", '" + new java.sql.Date(estd.getTime()) + "', '" + new java.sql.Date(actd.getTime()) + "', '"
                        + new java.sql.Date(pd.getTime()) + "', '" + deliverySlotId + "', '" + priorityId + "', 1)";

                MySql.executeIUD(query);

                JOptionPane.showMessageDialog(this, "Shipment Data added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                genarateShipmentId();
                loadShipments();

                // Clear fields
                reset();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String shipment_id = jLabel14.getText().trim();
        String customer_id = jLabel11.getText().trim();
        String driver_id = jLabel5.getText().trim();

        String rname = jTextField5.getText().trim();
        String rAddress = jTextField6.getText().trim();
        String sname = jTextField2.getText().trim();
        String sAddress = jTextField3.getText().trim();
        String content = jTextField7.getText().trim();
        String weight = jTextField8.getText().trim();

        Date estd = jDateChooser1.getDate();
        Date actd = jDateChooser2.getDate();
        Date pd = jDateChooser3.getDate();

        Object dslotObj = jComboBox2.getSelectedItem();
        Object priorityObj = jComboBox3.getSelectedItem();

// Validate shipment_id exists for update
        if (shipment_id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Shipment ID is required for update", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Check if shipment exists
        try {
            ResultSet checkRs = MySql.executeSearch("SELECT shipment_id FROM shipments WHERE shipment_id = '" + shipment_id + "'");
            if (!checkRs.next()) {
                JOptionPane.showMessageDialog(this, "Shipment with ID " + shipment_id + " not found Or Not Selected Shipment ", "Error", JOptionPane.ERROR_MESSAGE);
                checkRs.close();
                return;
            }
            checkRs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error checking shipment existence: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

// Validate all required fields
        if (customer_id.isEmpty() || driver_id.isEmpty() || rname.isEmpty() || rAddress.isEmpty()
                || sname.isEmpty() || sAddress.isEmpty() || content.isEmpty() || weight.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (estd == null || actd == null || pd == null) {
            JOptionPane.showMessageDialog(this, "Please select all dates", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (dslotObj == null || priorityObj == null) {
            JOptionPane.showMessageDialog(this, "Please select delivery slot and priority", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Validate weight
        double weightValue;
        try {
            weightValue = Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Weight must be a valid number", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            return;
        }

// Get selected names
        String selectedSlotName = dslotObj.toString();
        String selectedPriorityName = priorityObj.toString();

// Lookup delivery_slot_id
        String deliverySlotId = "";
        try {
            ResultSet rs = MySql.executeSearch("SELECT slot_id FROM delivery_slots WHERE SlotName = '" + selectedSlotName + "'");
            if (rs.next()) {
                deliverySlotId = rs.getString("slot_id");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid delivery slot selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching delivery slot ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

// Lookup priority_id
        String priorityId = "";
        try {
            ResultSet rs2 = MySql.executeSearch("SELECT priority_id FROM priority_levels WHERE level_name = '" + selectedPriorityName + "'");
            if (rs2.next()) {
                priorityId = rs2.getString("priority_id");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid priority selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            rs2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching priority ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

// Update shipment
        try {
            String query = "UPDATE shipments SET "
                    + "customer_id = '" + customer_id + "', "
                    + "driver_id = '" + driver_id + "', "
                    + "receiver_name = '" + rname + "', "
                    + "receiver_address = '" + rAddress + "', "
                    + "sender_name = '" + sname + "', "
                    + "sender_address = '" + sAddress + "', "
                    + "contents = '" + content + "', "
                    + "weight = " + weightValue + ", "
                    + "estimated_delivery = '" + new java.sql.Date(estd.getTime()) + "', "
                    + "actual_delivery = '" + new java.sql.Date(actd.getTime()) + "', "
                    + "pickup_time = '" + new java.sql.Date(pd.getTime()) + "', "
                    + "delivery_slot_id = '" + deliverySlotId + "', "
                    + "priority_id = '" + priorityId + "' "
                    + "WHERE shipment_id = '" + shipment_id + "'";

            int rowsAffected = MySql.executeIUD(query);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Shipment updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadShipments();

                // Clear fields
                reset();

                // Reset shipment ID for next operation
                genarateShipmentId();
            } else {
                JOptionPane.showMessageDialog(this, "No shipment was updated. Please check the shipment ID.", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Something went wrong during update: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            reset();
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            try {
               
                jLabel14.setText(jTable1.getValueAt(selectedRow, 0).toString());   // shipment_id

                String customerName = jTable1.getValueAt(selectedRow, 1).toString();
                String driverName = jTable1.getValueAt(selectedRow, 2).toString();

                ResultSet crs = MySql.executeSearch(
                        "SELECT customer_id, phone FROM customers WHERE name = '" + customerName + "'");
                if (crs.next()) {
                    jLabel11.setText(crs.getString("customer_id"));
                    jLabel12.setText(customerName);
                    jLabel13.setText(crs.getString("phone"));
                }

                ResultSet drs = MySql.executeSearch(
                        "SELECT driver_id, contact FROM drivers WHERE name = '" + driverName + "'");
                if (drs.next()) {
                    jLabel5.setText(drs.getString("driver_id"));
                    jLabel6.setText(driverName);
                    jLabel7.setText(drs.getString("contact"));
                }

               
                jTextField2.setText(jTable1.getValueAt(selectedRow, 3).toString()); // sender_name
                jTextField3.setText(jTable1.getValueAt(selectedRow, 4).toString()); // sender_address
                jTextField5.setText(jTable1.getValueAt(selectedRow, 5).toString()); // receiver_name
                jTextField6.setText(jTable1.getValueAt(selectedRow, 6).toString()); // receiver_address
                jTextField7.setText(jTable1.getValueAt(selectedRow, 7).toString()); // contents

                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                jDateChooser1.setDate(sdf.parse(jTable1.getValueAt(selectedRow, 8).toString())); // est_delivery
                jDateChooser2.setDate(sdf.parse(jTable1.getValueAt(selectedRow, 9).toString())); // act_delivery
                jDateChooser3.setDate(sdf.parse(jTable1.getValueAt(selectedRow, 10).toString())); // pickup_time

                String slotId = jTable1.getValueAt(selectedRow, 11).toString();
                ResultSet slotRS = MySql.executeSearch(
                        "SELECT SlotName FROM delivery_slots WHERE slot_id = '" + slotId + "'");
                if (slotRS.next()) {
                    String slotName = slotRS.getString("SlotName");          // e.g. “Morning”
                    selectComboItem(jComboBox2, slotName);                   // selects “1 - Morning”
                }

                String priorityId = jTable1.getValueAt(selectedRow, 13).toString();
                ResultSet prioRS = MySql.executeSearch(
                        "SELECT level_name FROM priority_levels WHERE priority_id = '" + priorityId + "'");
                if (prioRS.next()) {
                    String priorityName = prioRS.getString("level_name"); // e.g. “High”
                    selectComboItem(jComboBox3, priorityName);               // selects “2 - High”
                }

                
                jTextField8.setText(jTable1.getValueAt(selectedRow, 12).toString());

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error loading row data: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {
            String keyword = jTextField1.getText().trim();

            // Inline SQL with LIKE (insecure but direct)
            String query
                    = "SELECT s.shipment_id, c.name AS customer_name, d.name AS driver_name, "
                    + "s.sender_name, s.sender_address, s.receiver_name, s.receiver_address, "
                    + "s.contents, s.estimated_delivery, s.actual_delivery, s.pickup_time, "
                    + "s.delivery_slot_id, s.weight, s.priority_id "
                    + "FROM shipments s "
                    + "LEFT JOIN customers c ON s.customer_id = c.customer_id "
                    + "LEFT JOIN drivers d ON s.driver_id = d.driver_id "
                    + "WHERE s.shipment_id LIKE '%" + keyword + "%' "
                    + "OR c.name LIKE '%" + keyword + "%' "
                    + "OR d.name LIKE '%" + keyword + "%' "
                    + "ORDER BY s.shipment_id ASC";

            ResultSet rs = MySql.executeSearch(query);
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("shipment_id"));
                v.add(rs.getString("customer_name"));
                v.add(rs.getString("driver_name"));
                v.add(rs.getString("sender_name"));
                v.add(rs.getString("sender_address"));
                v.add(rs.getString("receiver_name"));
                v.add(rs.getString("receiver_address"));
                v.add(rs.getString("contents"));
                v.add(rs.getString("estimated_delivery"));
                v.add(rs.getString("actual_delivery"));
                v.add(rs.getString("pickup_time"));
                v.add(rs.getString("delivery_slot_id"));
                v.add(rs.getString("weight"));
                v.add(rs.getString("priority_id"));
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTextField1InputMethodTextChanged
        try {
            String keyword = jTextField1.getText().trim();

            // Inline SQL with LIKE (insecure but direct)
            String query
                    = "SELECT s.shipment_id, c.name AS customer_name, d.name AS driver_name, "
                    + "s.sender_name, s.sender_address, s.receiver_name, s.receiver_address, "
                    + "s.contents, s.estimated_delivery, s.actual_delivery, s.pickup_time, "
                    + "s.delivery_slot_id, s.weight, s.priority_id "
                    + "FROM shipments s "
                    + "LEFT JOIN customers c ON s.customer_id = c.customer_id "
                    + "LEFT JOIN drivers d ON s.driver_id = d.driver_id "
                    + "WHERE s.shipment_id LIKE '%" + keyword + "%' "
                    + "OR c.name LIKE '%" + keyword + "%' "
                    + "OR d.name LIKE '%" + keyword + "%' "
                    + "ORDER BY s.shipment_id ASC";

            ResultSet rs = MySql.executeSearch(query);
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("shipment_id"));
                v.add(rs.getString("customer_name"));
                v.add(rs.getString("driver_name"));
                v.add(rs.getString("sender_name"));
                v.add(rs.getString("sender_address"));
                v.add(rs.getString("receiver_name"));
                v.add(rs.getString("receiver_address"));
                v.add(rs.getString("contents"));
                v.add(rs.getString("estimated_delivery"));
                v.add(rs.getString("actual_delivery"));
                v.add(rs.getString("pickup_time"));
                v.add(rs.getString("delivery_slot_id"));
                v.add(rs.getString("weight"));
                v.add(rs.getString("priority_id"));
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField1InputMethodTextChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String shipment_id = jLabel14.getText().trim();

// Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this shipment?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Check for dependencies
            ResultSet rs = MySql.executeSearch("SELECT * FROM notifications WHERE shipment_id = '" + shipment_id + "'");
            if (rs.next()) {
                rs.close();
                JOptionPane.showMessageDialog(this, "Cannot delete shipment due to existing dependencies.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ResultSet rs1 = MySql.executeSearch("SELECT * FROM tracking WHERE shipment_id = '" + shipment_id + "'");
            if (rs1.next()) {
                rs1.close();
                JOptionPane.showMessageDialog(this, "Cannot delete shipment due to existing dependencies.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            rs.close();

            // If no dependencies, proceed with deletion
            String query = "DELETE FROM shipments WHERE shipment_id = '" + shipment_id + "'";
            MySql.executeIUD(query);
            JOptionPane.showMessageDialog(this, "Shipment deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadShipments();

            // Clear fields
            reset();
            genarateShipmentId();

        } catch (Exception e) {
            if (e instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(this, "Cannot delete shipment due to existing dependencies.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Something went wrong: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageShipments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
