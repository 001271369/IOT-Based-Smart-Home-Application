/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Admin;

import Business.Customer.Customer;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ajaygoel
 */
public class ManageCustomerWAJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCustomerWAJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    Ecosystem business;

    ManageCustomerWAJPanel(JPanel userProcessContainer, Enterprise enterprise,Ecosystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        this.business=business;
        populate_table();
    }
    
    public void populate_table()
    {
        DefaultTableModel dtm = (DefaultTableModel) CustomerJTable.getModel();
        dtm.setRowCount(0);
        
        for(Network n:business.getNetworkDirectory())
        {
            for(Customer c:n.getCustomerDirectory().getCustList())
            {
                Object Row[]= new Object[4];
                Row[0]=c;
                Row[1]=c.getLast_name();
                Row[2]=c.getMobile_no();
                Row[3]=c.getHouse_no();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BackJBtn = new javax.swing.JButton();
        ViewCustomerBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CustomerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Mobile No", "House No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CustomerJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 67, 641, 81));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Manage Customer Work Area JPanel");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 11, -1, -1));

        BackJBtn.setText("<< Back");
        BackJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackJBtnActionPerformed(evt);
            }
        });
        add(BackJBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 181, -1, -1));

        ViewCustomerBtn.setText("View Customers");
        ViewCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewCustomerBtnActionPerformed(evt);
            }
        });
        add(ViewCustomerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 181, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BackJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackJBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_BackJBtnActionPerformed

    private void ViewCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewCustomerBtnActionPerformed
        // TODO add your handling code here:

        int SelectedRow = CustomerJTable.getSelectedRow();
        if(SelectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table first","Warning", JOptionPane.WARNING_MESSAGE);
        }
        else{
            Customer cr = (Customer)CustomerJTable.getValueAt(SelectedRow,0);
            ViewCustomerJPanel vpanel = new ViewCustomerJPanel(userProcessContainer,cr,business);
            userProcessContainer.add("viewCustomer",vpanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);

        }

    }//GEN-LAST:event_ViewCustomerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackJBtn;
    private javax.swing.JTable CustomerJTable;
    private javax.swing.JButton ViewCustomerBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
