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
public class Products extends Entities implements Serializable {

    public Products() {
    }
    
    private String product_name;
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    private String product_price;
    public String getProduct_price() {
        return product_price;
    }
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
    
    private String product_weight;
    public String getProduct_weight() {
        return product_weight;
    }
    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    private String product_availibility;
    public String getProduct_availibility() {
        return product_availibility;
    }
    public void setProduct_availibility(String product_availibility) {
        this.product_availibility = product_availibility;
    }

}
