/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.mp3.MLM;

import java.lang.reflect.Member;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author jay
 */
public abstract class AbstractJPATest {

    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("jsharma3PU");
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        createTestData();
     
    }
    
    private void createTestData (){
        tx.begin();
       
        Members m =new Members();
        m.setAdmin_member(true);
        m.setBirthDate(new GregorianCalendar(1979, 11, 25).getTime());
        m.setEmail("jaysharma@google.com");
        m.setFirstName("Jay");
        m.setLastName("Sharma");
        m.setPassword("1234");
        m.setReferance_code("jsharma3");
        
        Members m1 =new Members();
        m1.setAdmin_member(false);
        m1.setBirthDate(new GregorianCalendar(1993, 11, 25).getTime());
        m1.setEmail("jay@google.com");
        m1.setFirstName("Ajay");
        m1.setLastName("Shah");
        m1.setPassword("5678");
        m1.setReferance_code("ajay007");
        
        Customer c =new Customer();
        c.setBirthDate(new GregorianCalendar(1989, 11, 25).getTime());
        c.setEmail("param@google.com");
        c.setFirstName("Param");
        c.setLastName("Saini");
        c.setPassword("doc123");
        c.setMemberref_id("1");
        
        Customer c1 =new Customer();
        c1.setBirthDate(new GregorianCalendar(1989, 11, 25).getTime());
        c1.setEmail("param@google.com");
        c1.setFirstName("Param");
        c1.setLastName("Saini");
        c1.setPassword("doc123");
        c1.setMemberref_id("2");
        
        Company cm = new Company();
        cm.setName("Pepsi");
        cm.setProductName("Sprite");
        cm.setProductType("Soda");
        
        Combos cb = new Combos();
        cb.setCombo_name("Soda");
        cb.setCombo_items("Sprite,Coco Cola,Pepsi");
        cb.setCombo_price("$5");
        cb.setSaving("$1.10");
        cb.setCombo_availibility("5");
        
        Combos cb1 = new Combos();
        cb1.setCombo_name("Candy");
        cb1.setCombo_items("Sneakers,Kit Kate,Reers");
        cb1.setCombo_price("$3");
        cb1.setSaving("$0.50");
        cb1.setCombo_availibility("2");
        
        Products pc = new Products();
        pc.setProduct_name("Pepsi");
        pc.setProduct_weight("350ml");
        pc.setProduct_price("$1.90");
        pc.setProduct_availibility("15");
        
        Products pc1 = new Products();
        pc1.setProduct_name("Sprite");
        pc1.setProduct_weight("350ml");
        pc1.setProduct_price("$1.90");
        pc1.setProduct_availibility("30");
        
        Products pc2 = new Products();
        pc2.setProduct_name("Coco-Cola");
        pc2.setProduct_weight("350ml");
        pc2.setProduct_price("$1.90");
        pc2.setProduct_availibility("5");
        
        Products pc3 = new Products();
        pc3.setProduct_name("Sneakers");
        pc3.setProduct_weight("10g");
        pc3.setProduct_price("$1.10");
        pc3.setProduct_availibility("25");
        
        Products pc4 = new Products();
        pc4.setProduct_name("Kit-Kate");
        pc4.setProduct_weight("10g");
        pc4.setProduct_price("$1.10");
        pc4.setProduct_availibility("17");
        
        Products pc5 = new Products();
        pc5.setProduct_name("Reers");
        pc5.setProduct_weight("15g");
        pc5.setProduct_price("$1.10");
        pc5.setProduct_availibility("12");
        
        em.persist(m);
        em.persist(m1);
        em.persist(cm);
        em.persist(c);
        em.persist(cb);
        em.persist(cb1);
        em.persist(pc);
        em.persist(pc1);
        em.persist(pc2);
        em.persist(pc3);
        em.persist(pc4);
        em.persist(pc5);
        tx.commit();   
    }
    
    @After
    public void tearDown(){
        em.close();
    }

    private void removeTestData() {
        
        
        tx.begin();
        tx.commit();
    }
}
