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
public class Combos extends Entities implements Serializable {

    public Combos() {
    }
 
    private String combo_name;
    public String getCombo_name() {
        return combo_name;
    }
    public void setCombo_name(String combo_name) {
        this.combo_name = combo_name;
    }

    private String combo_price;
    public String getCombo_price() {
        return combo_price;
    }
    public void setCombo_price(String combo_price) {
        this.combo_price = combo_price;
    }
    
    private String combo_items;
    public String getCombo_items() {
        return combo_items;
    }
    public void setCombo_items(String combo_items) {
        this.combo_items = combo_items;
    }

    private String combo_availibility;
    public String getCombo_availibility() {
        return combo_availibility;
    }
    public void setCombo_availibility(String combo_availibility) {
        this.combo_availibility = combo_availibility;
    }

    private String saving;
    public String getSaving() {
        return saving;
    }
    public void setSaving(String saving) {
        this.saving = saving;
    }

   
}
