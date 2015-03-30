/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jay
 */
public class CompanyTest extends AbstractJPATest {
    
    public CompanyTest() {
        
        
    }
    
    @Test 
    public void testCreate() {
        
        Company cm = new Company();
        cm.setName("Windy");
        cm.setProductName("Root");
        cm.setProductType("Beer");
        
        tx.begin();
        em.persist(cm);
        tx.commit();
        
        assertNotNull(cm.getId());
    
    }
    @Test
    
    public void testRead() {
        
        List<Company> cp = em.createNamedQuery("Company.findByAll", Company.class).getResultList();
        assertTrue(cp.size() == 1);
        assertFalse(cp.isEmpty());
    
        for (Company r : cp) {
            System.out.println(r.toString());

            for (Products p : r.getProducts()) {
                System.out.println("\t"+p.toString());
            }
        }
    }
    @Test
    public void testUpdate() {
       
        Company cp = em.createNamedQuery("Company.findByName", Company.class).setParameter("name", "Windy").getSingleResult();
        assertNotNull(cp.getId());

        String originalName = cp.getName();
        String newName = "Chicago Beverage";
        tx.begin();
        cp.setName(newName);
        tx.commit();

        assertNotEquals(originalName, cp.getName());
        assertTrue(newName.equals(cp.getName()));

        tx.begin();
        cp.setName(originalName);
        tx.commit();
     
    }
    @Test
    @Ignore
    public void testDelete() {
        
        TypedQuery<Company> cb = em.createQuery("select cb from Company cb where cb.name = ?1", Company.class);
        cb.setParameter(1, "Pepsico");
        Company c = cb.getSingleResult();
        
        assertNotNull(c.getId());
        
        tx.begin();
        for(Products d : c.getProducts()){
            em.remove(d);
        }
        em.remove(c);
        tx.commit();

        Company postRemove = em.find(Company.class, 1L);
        assertNull(postRemove);
     
    
    }
}
