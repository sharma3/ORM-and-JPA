/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Members.findById", query = "select m from Members m where m.id = :id "),
    @NamedQuery(name = "Members.findByAll", query = "select m from Members m ")
})
public class Members extends Person implements Serializable{

    @ManyToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<Customer> customer = new ArrayList<>();
    private boolean admin_member;
    
    public List<Customer> getCustomer() {
        return customer;
    }

    public boolean isAdmin_member() {
        return admin_member;
    }
    public void setAdmin_member(boolean admin_member) {
        this.admin_member = admin_member;
    }
    
    private String referance_code;
    public String getReferance_code() {
        return referance_code;
    }
    public void setReferance_code(String referance_code) {
        this.referance_code = referance_code;
    }

    public Members() {
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Members{" + "name=").append(referance_code).append('}');
        return sb.toString();
    }
    
}
