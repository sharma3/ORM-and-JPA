/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Combos.findById", query = "select cb from Combos cb where cb.id = :id "),
    @NamedQuery(name = "Combos.findByAll", query = "select cb from Combos cb "),
    @NamedQuery(name = "Combos.findByName", query = "select cb from Combos cb where cb.combo_name = :combo_name ")
})

public class Combos extends Entities implements Serializable {

    @ManyToMany(mappedBy = "combo", cascade = CascadeType.PERSIST)
    private List<Products> products = new ArrayList<>();

    public Combos() {
    }
    
    public List<Products> getProducts() {
        return products;
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

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Combos{" + "name=").append(combo_name).append('}');
        return sb.toString();
    }
}
