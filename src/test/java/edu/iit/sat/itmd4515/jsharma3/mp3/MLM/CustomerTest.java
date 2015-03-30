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
public class CustomerTest extends AbstractJPATest {
    
    public CustomerTest() {
    }
    @Test
    public void testCreate() {
        
        Customer c =new Customer();
        c.setBirthDate(new GregorianCalendar(1933, 11, 25).getTime());
        c.setEmail("par@google.com");
        c.setFirstName("Panth");
        c.setLastName("Shah");
        c.setPassword("abc123");
        c.setMemberref_code("panth3");
        
        Customer c1 =new Customer();
        c1.setBirthDate(new GregorianCalendar(1996, 11, 25).getTime());
        c1.setEmail("jay@google.com");
        c1.setFirstName("Anuj");
        c1.setLastName("Sheth");
        c1.setPassword("xyz123");
        c1.setMemberref_code("anuj3");
        
        tx.begin();
        em.persist(c);
        em.persist(c1);
        tx.commit();
        
        assertNotNull(c.getId());
        assertNotNull(c1.getId());
    }
    @Test
    public void testRead() {
        
        List<Customer> cp = em.createNamedQuery("Customer.findByAll", Customer.class).getResultList();
        assertTrue(cp.size() >= 1);
        assertFalse(cp.isEmpty());
    
        for (Customer r : cp) {
            System.out.println(r.toString());

            for (Members s : r.getMembers()) {
                System.out.println("\t"+s.toString());
            }
        }
    }
    @Test
    public void testUpdate() {
        
        Customer cp = em.createNamedQuery("Customer.findByRFcode", Customer.class).setParameter("memberref_code", "panth3").getSingleResult();
        assertNotNull(cp.getId());

        String originalName = cp.getMemberref_code();
        String newName = "jsharma2";
        tx.begin();
        cp.setMemberref_code(newName);
        tx.commit();

        assertNotEquals(originalName, cp.getMemberref_code());
        assertTrue(newName.equals(cp.getMemberref_code()));

        tx.begin();
        cp.setMemberref_code(originalName);
        tx.commit();
    
    }
    @Test
    @Ignore
    public void testDelete() {
        
        
        TypedQuery<Customer> cb = em.createQuery("select cb from Customer cb where cb.memberref_code = ?1", Customer.class);
        cb.setParameter(1, "jsharma3");
        Customer c = cb.getSingleResult();
        
        assertNotNull(c.getId());
        
        tx.begin();
        em.remove(c);
        tx.commit();

        Customer postRemove = em.find(Customer.class, 1L);
        assertNull(postRemove);
     
    
    }    
}
