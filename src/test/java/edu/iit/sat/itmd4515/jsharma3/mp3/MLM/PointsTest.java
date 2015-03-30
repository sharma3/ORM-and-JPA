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
public class PointsTest extends AbstractJPATest {
    
    public PointsTest() {
    }
    
    @Test
    public void testCreate() {
        
        Points pt = new Points();
        pt.setEmail("ja@google.com");
        pt.setPoint("5000");
        
        tx.begin();
        em.persist(pt);
        tx.commit();
        
        assertNotNull(pt.getId());
    }
    @Test
    public void testRead() {
    
        List<Points> cp = em.createNamedQuery("Points.findByAll", Points.class).getResultList();
        assertTrue(cp.size() == 1);
        assertFalse(cp.isEmpty());
    
    }
    @Test
    public void testUpdate() {
    
        Points cp = em.createNamedQuery("Points.findByPoints", Points.class).setParameter("point", "5000").getSingleResult();
        assertNotNull(cp.getId());

        String originalPoints = cp.getPoint();
        String newPoints = "3000";
        tx.begin();
        cp.setPoint(newPoints);
        tx.commit();

        assertNotEquals(originalPoints, cp.getPoint());
        assertTrue(newPoints.equals(cp.getPoint()));

        tx.begin();
        cp.setPoint(originalPoints);
        tx.commit();
    }
    @Test
    @Ignore
    public void testDelete() {
        
        TypedQuery<Points> cb = em.createQuery("select cb from Points cb where cb.email = ?1", Points.class);
        cb.setParameter(1, "jaysharma@google.com");
        Points c = cb.getSingleResult();
        
        assertNotNull(c.getId());
        
        tx.begin();

        em.remove(c);
        tx.commit();

        Points postRemove = em.find(Points.class, 1L);
        assertNull(postRemove);
    }
}