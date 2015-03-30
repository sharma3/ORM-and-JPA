/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jay
 */
public class MembersTest extends AbstractJPATest {
    
    public MembersTest() {
        
    }
    
    @Test
    public void testCreate() {

        Members m =new Members();
        m.setAdmin_member(true);
        m.setBirthDate(new GregorianCalendar(1979, 11, 25).getTime());
        m.setEmail("sharma@google.com");
        m.setFirstName("Viral");
        m.setLastName("Mehta");
        m.setPassword("7895");
        m.setReferance_code("viral3");
        
        tx.begin();
        em.persist(m);
        tx.commit();
        
        assertNotNull(m.getId());

    
    }
    @Test
    public void testRead() {
        
        List<Members> cp = em.createNamedQuery("Members.findByAll", Members.class).getResultList();
        assertTrue(cp.size() == 1);
        assertFalse(cp.isEmpty());
    }
    
    @Test
    public void testUpdate() {
       
        Members cp = em.createNamedQuery("Members.findByReferance", Members.class).setParameter("referance_code", "viral3").getSingleResult();
        assertNotNull(cp.getId());

        String originalName = cp.getReferance_code();
        String newName = "viral2";
        tx.begin();
        cp.setReferance_code(newName);
        tx.commit();

        assertNotEquals(originalName, cp.getReferance_code());
        assertTrue(newName.equals(cp.getReferance_code()));

        tx.begin();
        cp.setReferance_code(originalName);
        tx.commit();
   
    }
    @Test
    @Ignore
    public void testDelete() {
       
        TypedQuery<Members> cb = em.createQuery("select cb from Members cb where cb.referance_code = ?1", Members.class);
        cb.setParameter(1, "jsharma3");
        Members c = cb.getSingleResult();
        
        assertNotNull(c.getId());
        
        tx.begin();
        for(Customer d : c.getCustomer()){
            em.remove(d);
        }
        em.remove(c);
        tx.commit();

        Members postRemove = em.find(Members.class, 1L);
        assertNull(postRemove);
     
    
    }
}
