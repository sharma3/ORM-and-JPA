/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Members.findByEmail", query = "select m from Members m where m.email = :email ")
})
public class Members extends Person implements Serializable{

    private boolean admin_member;

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

    
}
