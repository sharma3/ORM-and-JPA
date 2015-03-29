/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Jay
 */
@Entity
public class Customer extends Person implements Serializable{

    public Customer() {
    }
    private String memberref_id;
    public String getMemberref_id() {
        return memberref_id;
    }
    public void setMemberref_id(String memberref_id) {
        this.memberref_id = memberref_id;
    }


}
