/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Jay
 */
@Entity
public class Customer extends Person implements Serializable{

    
    
    @ManyToMany
    @JoinTable(name = "marketing_tree",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    
    private List<Members> member = new ArrayList<>();

    public Customer() {
    }
    
    private String memberref_code;
    public String getMemberref_code() {
        return memberref_code;
    }
    public void setMemberref_code(String memberref_code) {
        this.memberref_code = memberref_code;
    }
    public List<Members> getMembers() {
        return member;
    }

}
