/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Market;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organisation.Grocery.GroceryOrganisation;
import Business.Organisation.Organisation;
import Business.Organisation.RetailerOrganisation;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ajaygoel
 */
public class ManageGroceryEmployeesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageGroceryEmployeesJPanel
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    GroceryOrganisation organization;
    Enterprise enterprise;
    Ecosystem business;
    RetailerOrganisation retailerOrganisation;

    ManageGroceryEmployeesJPanel(JPanel userProcessContainer, UserAccount account, Organisation organisation1, Enterprise enterprise, Ecosystem business) {
        
        
    }

    ManageGroceryEmployeesJPanel(JPanel userProcessContainer, UserAccount account, GroceryOrganisation organization, Enterprise enterprise, Ecosystem business, RetailerOrganisation retailerOrganisation) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.business=business;
        this.enterprise=enterprise;
        this.retailerOrganisation= retailerOrganisation;
        populate_table();
    }

    
    
       public void populate_table() {
        DefaultTableModel dtm = (DefaultTableModel) orderListJTbl.getModel();
        dtm.setRowCount(0);
        for (WorkRequest wr : retailerOrganisation.getWorkQueue().getReqList()) {
            if (wr.getStatus().equals("Automatically generated for Retailer") || wr.getStatus().equals("Automatically completed by Retailer")) {
                Object Row[] = new Object[6];
                Row[0] = wr.getMessage();
                Row[1] = wr.getGroceryProduct();
                Row[2] = wr.getSender();
                Row[3] = wr.getStatus();
                Row[4] = wr.getRequestDate();
                Row[5] = wr.getResolveDate();

                dtm.addRow(Row);
            }

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

        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderListJTbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Manage Retailer Transactions");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 193, 31));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        orderListJTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Product", "Sender", "Status", "Requested Date", "Resolved Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderListJTbl);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 680, 140));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Order Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderListJTbl;
    // End of variables declaration//GEN-END:variables
}
