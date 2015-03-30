/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jay
 */
public class ProductsTest extends AbstractJPATest {
    
    public ProductsTest() {
    }
    
    @Test
    public void testCreate() {
        
        Products pc = new Products();
        pc.setProduct_name("Root");
        pc.setProduct_weight("350ml");
        pc.setProduct_price("$1.90");
        pc.setProduct_availibility("15");
        pc.setProduct_type("Beer");
        
        Products pc1 = new Products();
        pc1.setProduct_name("Corona");
        pc1.setProduct_weight("350ml");
        pc1.setProduct_price("$1.90");
        pc1.setProduct_availibility("30");
        pc1.setProduct_type("Beer");
        
        Products pc2 = new Products();
        pc2.setProduct_name("Miller");
        pc2.setProduct_weight("350ml");
        pc2.setProduct_price("$1.90");
        pc2.setProduct_availibility("5");
        pc2.setProduct_type("Beer");
        
        tx.begin();
        em.persist(pc);
        em.persist(pc1);
        em.persist(pc2);
        tx.commit();
        
        assertNotNull(pc.getId());
        assertNotNull(pc1.getId());
        assertNotNull(pc2.getId());
    }
    @Test
    public void testRead() {
        
        List<Products> pc = em.createNamedQuery("Products.findByAll", Products.class).getResultList();
        assertTrue(pc.size() >= 1);
        assertFalse(pc.isEmpty());
        
        for (Products r : pc) {
            System.out.println(r.toString());

            for (Combos s : r.getCombos()) {
                System.out.println("\t"+s.toString());
            }
        }
    }
    @Test
    public void testUpdate() {
        
        Products r = em.createNamedQuery("Products.findByName", Products.class).setParameter("product_name", "Root").getSingleResult();
        assertNotNull(r.getId());

        String originalName = r.getProduct_name();
        String newName = "IPA";
        tx.begin();
        r.setProduct_name(newName);
        tx.commit();

        assertNotEquals(originalName, r.getProduct_name());
        assertTrue(newName.equals(r.getProduct_name()));

        tx.begin();
        r.setProduct_name(originalName);
        tx.commit();

    
    }
    @Test
    @Ignore
    public void testDelete() {
        
        TypedQuery<Products> q = em.createQuery("select r from Products r where r.name = ?1", Products.class);
        q.setParameter(1, "Sprite");
        Products r = q.getSingleResult();
        
        assertNotNull(r.getId());
        
        tx.begin();
        em.remove(r);
        tx.commit();

        Products postRemove = em.find(Products.class, 1L);
        assertNull(postRemove);
        
    }
    
}
