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
public class CombosTest extends AbstractJPATest{
    
    public CombosTest() {
    }
     
    @Test
    public void testCreate() {
        
        Combos cb = new Combos();
        cb.setCombo_name("Beer");
        cb.setCombo_items("Root,Corona,Miller");
        cb.setCombo_price("$10");
        cb.setSaving("$1.15");
        cb.setCombo_availibility("10");
        
        tx.begin();
        em.persist(cb);
        tx.commit();
        
        assertNotNull(cb.getId());
    
    }
    @Test
    public void testRead() {
        List<Combos> cbs = em.createNamedQuery("Combos.findByAll", Combos.class).getResultList();
        assertTrue(cbs.size() == 1);
        assertFalse(cbs.isEmpty());
    }
    @Test
    public void testUpdate() {
        
        Combos r = em.createNamedQuery("Combos.findByName", Combos.class).setParameter("combo_name", "Beer").getSingleResult();
        assertNotNull(r.getId());

        String originalName = r.getCombo_name();
        String newName = "Liqour";
        tx.begin();
        r.setCombo_name(newName);
        tx.commit();

        assertNotEquals(originalName, r.getCombo_name());
        assertTrue(newName.equals(r.getCombo_name()));

        tx.begin();
        r.setCombo_name(originalName);
        tx.commit();
    
    }
    @Test
    @Ignore
    public void testDelete() {
        
     TypedQuery<Combos> cb = em.createQuery("select cb from Combos cb where cb.combo_name = ?1", Combos.class);
        cb.setParameter(1, "Coke");
        Combos c = cb.getSingleResult();
        
        assertNotNull(c.getId());
        
        tx.begin();
        em.remove(c);
        tx.commit();

        Combos postRemove = em.find(Combos.class, 1L);
        assertNull(postRemove);
       
    }
}
