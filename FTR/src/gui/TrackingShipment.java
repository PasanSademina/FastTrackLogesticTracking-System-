/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import static java.awt.SystemColor.text;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySql;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author cnn
 */
public class TrackingShipment extends javax.swing.JFrame {

    /**
     * Creates new form TrackingShipment
     */
    public TrackingShipment() {
        initComponents();
        loadShipments();
        LoadPriority();
        LoadDslot();
        LoadStatus();
    }

    private void setLabelState(JLabel label, String text, Color color) {
        label.setText(text);
        label.setForeground(color);
    }

    public void loadFilteredShipments() {
        try {
            String keyword = jTextField1.getText().trim();
            String priority = jComboBox1.getSelectedItem().toString();
            String status = jComboBox2.getSelectedItem().toString();
            String slot = jComboBox3.getSelectedItem().toString();

            String baseQuery = "SELECT s.shipment_id, c.name AS customer_name, d.name AS driver_name, "
                    + "s.sender_name, s.sender_address, s.receiver_name, s.receiver_address, "
                    + "s.contents, s.estimated_delivery, s.actual_delivery, s.pickup_time, "
                    + "ds.SlotName AS delivery_slot, s.weight, pl.level_name AS priority_level, "
                    + "ss.status_name AS shipment_status "
                    + "FROM shipments s "
                    + "LEFT JOIN customers c ON s.customer_id = c.customer_id "
                    + "LEFT JOIN drivers d ON s.driver_id = d.driver_id "
                    + "LEFT JOIN shipment_status ss ON s.status_id = ss.status_id "
                    + "LEFT JOIN priority_levels pl ON s.priority_id = pl.priority_id "
                    + "LEFT JOIN delivery_slots ds ON s.delivery_slot_id = ds.slot_id ";

            // Dynamic WHERE clause
            List<String> filters = new ArrayList<>();

            if (!keyword.isEmpty()) {
                filters.add("(s.shipment_id LIKE '%" + keyword + "%' "
                        + "OR c.name LIKE '%" + keyword + "%' "
                        + "OR d.name LIKE '%" + keyword + "%')");
            }

            if (!priority.equalsIgnoreCase("Select Priority")) {
                filters.add("pl.level_name = '" + priority + "'");
            }

            if (!status.equalsIgnoreCase("Select Shipment Status")) {
                filters.add("ss.status_name = '" + status + "'");
            }

            if (!slot.equalsIgnoreCase("Select Time Slot")) {
                filters.add("ds.SlotName = '" + slot + "'");
            }

            String whereClause = filters.isEmpty() ? "" : "WHERE " + String.join(" AND ", filters);
            String finalQuery = baseQuery + whereClause + " ORDER BY s.shipment_id ASC";

            ResultSet rs = MySql.executeSearch(finalQuery);
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
                v.add(rs.getString("delivery_slot"));
                v.add(rs.getString("weight"));
                v.add(rs.getString("priority_level"));
                v.add(rs.getString("shipment_status"));
                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadStatus() {
        try {

            ResultSet rs = MySql.executeSearch("SELECT * FROM `shipment_status`");

            Vector v = new Vector();
            v.add("Select Shipment Status");

            while (rs.next()) {
                v.add(rs.getString("status_name"));
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
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
            jComboBox3.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadShipments() {
        try {
            ResultSet rs = MySql.executeSearch(
                    "SELECT s.shipment_id, c.name AS customer_name, d.name AS driver_name, "
                    + "s.sender_name, s.sender_address, s.receiver_name, s.receiver_address, "
                    + "s.contents, s.estimated_delivery, s.actual_delivery, s.pickup_time, "
                    + "s.delivery_slot_id, s.weight, pl.level_name, st.status_name "
                    + "FROM shipments s "
                    + "LEFT JOIN customers c ON s.customer_id = c.customer_id "
                    + "LEFT JOIN drivers d ON s.driver_id = d.driver_id "
                    + "LEFT JOIN shipment_status st ON s.status_id = st.status_id "
                    + "LEFT JOIN priority_levels pl ON s.priority_id = pl.priority_id"
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
                v.add(rs.getString("level_name"));
                v.add(rs.getString("status_name"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading shipments: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tracking Shipments");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tracking Filteration Section", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "shipment id", "Customer Name", "Driver Name", "Sender Name", "Sender Address", "Receiver Name", "Receiver Address", "contents", "Estimated Date", "Actual Date", "Pickup Time", "Delivery slot id", "Weight", "Priority", "Shipment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Priority Level", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBox1);

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shipment Status", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBox2);

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivery Slot", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBox3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
            .addComponent(jTextField1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Package Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(4, 2, 10, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Shipment  ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Status", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sender Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recipient Name", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel5);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Origin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel7);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destination", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel6);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weight", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel4.add(jLabel8);

        jPanel3.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivery Progress", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.setLayout(new java.awt.GridLayout(3, 2, 10, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order Processed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Package In Transit", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arrived at Facility", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Out for Delivery ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Delivered", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel13);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Completion Of Work", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.add(jLabel15);

        jPanel3.add(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        int selectedRow = jTable1.getSelectedRow();
        if (evt.getClickCount() == 2) {
            // set for info
            jLabel2.setText(jTable1.getValueAt(selectedRow, 0).toString());
            jLabel3.setText(jTable1.getValueAt(selectedRow, 14).toString());
            jLabel4.setText(jTable1.getValueAt(selectedRow, 3).toString());
            jLabel5.setText(jTable1.getValueAt(selectedRow, 5).toString());
            jLabel7.setText(jTable1.getValueAt(selectedRow, 4).toString());
            jLabel6.setText(jTable1.getValueAt(selectedRow, 6).toString());
            String weight = jTable1.getValueAt(selectedRow, 12).toString();
            jLabel8.setText(weight + " KG");
            // set for info
            //Progress
            String status = jTable1.getValueAt(selectedRow, 14).toString();

            switch (status) {
                case "Processed":
                    setLabelState(jLabel9, "Completed", Color.GREEN);
                    setLabelState(jLabel10, "Incompleted", Color.RED);
                    setLabelState(jLabel11, "Incompleted", Color.RED);
                    setLabelState(jLabel12, "Incompleted", Color.RED);
                    setLabelState(jLabel13, "Incompleted", Color.RED);
                    break;

                case "Transit":
                    setLabelState(jLabel9, "Completed", Color.GREEN);
                    setLabelState(jLabel10, "Completed", Color.GREEN);
                    setLabelState(jLabel11, "Incompleted", Color.RED);
                    setLabelState(jLabel12, "Incompleted", Color.RED);
                    setLabelState(jLabel13, "Incompleted", Color.RED);
                    break;

                case "Arrived To Facility":
                    setLabelState(jLabel9, "Completed", Color.GREEN);
                    setLabelState(jLabel10, "Completed", Color.GREEN);
                    setLabelState(jLabel11, "Completed", Color.GREEN);
                    setLabelState(jLabel12, "Incompleted", Color.RED);
                    setLabelState(jLabel13, "Incompleted", Color.RED);
                    break;

                case "Out for delivery":
                    setLabelState(jLabel9, "Completed", Color.GREEN);
                    setLabelState(jLabel10, "Completed", Color.GREEN);
                    setLabelState(jLabel11, "Completed", Color.GREEN);
                    setLabelState(jLabel12, "Completed", Color.GREEN);
                    setLabelState(jLabel13, "Incompleted", Color.RED);
                    break;

                case "Delivered":
                    setLabelState(jLabel9, "Completed", Color.GREEN);
                    setLabelState(jLabel10, "Completed", Color.GREEN);
                    setLabelState(jLabel11, "Completed", Color.GREEN);
                    setLabelState(jLabel12, "Completed", Color.GREEN);
                    setLabelState(jLabel13, "Completed", Color.GREEN);
                    break;

                default:
                    setLabelState(jLabel9, "Incompleted", Color.RED);
                    setLabelState(jLabel10, "Incompleted", Color.RED);
                    setLabelState(jLabel11, "Incompleted", Color.RED);
                    setLabelState(jLabel12, "Incompleted", Color.RED);
                    setLabelState(jLabel13, "Incompleted", Color.RED);
                    break;
            }
            // Count how many labels are marked as "Completed"
            int completedSteps = 0;

            if ("Completed".equals(jLabel9.getText())) {
                completedSteps++;
            }
            if ("Completed".equals(jLabel10.getText())) {
                completedSteps++;
            }
            if ("Completed".equals(jLabel11.getText())) {
                completedSteps++;
            }
            if ("Completed".equals(jLabel12.getText())) {
                completedSteps++;
            }
            if ("Completed".equals(jLabel13.getText())) {
                completedSteps++;
            }

// Calculate percentage
            int percentage = (completedSteps * 100) / 5; // total of 5 steps

// Update jLabel15 with the percentage
            jLabel15.setText("Completion: " + percentage + "%");

// Optional: Color feedback
            if (percentage == 100) {
                jLabel15.setForeground(Color.GREEN);
            } else if (percentage >= 50) {
                jLabel15.setForeground(Color.ORANGE);
            } else {
                jLabel15.setForeground(Color.RED);
            }

            //Progress
        }
    }                                    

    private void jTextField1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {                                                   

        loadFilteredShipments();
    }                                                  

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            

    }                                           

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                     

        loadFilteredShipments();
    }                                    

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {                                            

        loadFilteredShipments();


    }                                           

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        loadFilteredShipments();
    }                                           

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        loadFilteredShipments();

    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackingShipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   

}
