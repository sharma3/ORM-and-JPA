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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Points.findById", query = "select pt from Points pt where pt.id = :id "),
    @NamedQuery(name = "Points.findByAll", query = "select pt from Points pt "),
    @NamedQuery(name = "Points.findByEmail", query = "select pt from Points pt where pt.email = :email "),
    @NamedQuery(name = "Points.findByPoints", query = "select pt from Points pt where pt.point = :point ")
})
public class Points extends Entities implements Serializable{

    
 
    @OneToOne(mappedBy = "pnt")
    private List<Members> member = new ArrayList<>();


    
    public Points() {
    }
    
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    private String point;
    public String getPoint() {
        return point;
    }
    public void setPoint(String point) {
        this.point = point;
    }
    
    public List<Members> getMembers() {
        return member;
    }
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Members{" + "email=").append(email).append('}');
        return sb.toString();
    }
 
}
