/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organisation.Organisation;
import Business.UserAccount.UserAccount;
import Interface.Security.SecurityStaffWAJPanel;
import javax.swing.JPanel;

/**
 *
 * @author ankit
 */
public class SecurityStaffRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organisation organization, Enterprise enterprise, Ecosystem business) {
        return new SecurityStaffWAJPanel(userProcessContainer, account, organization, enterprise, business);
    }
    
     @Override
    public String toString() {
        return RoleType.SecurityStaff.getValue();
    }
    
}
