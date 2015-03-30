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
        
        Customer c =new Customer();
        c.setBirthDate(new GregorianCalendar(1989, 11, 25).getTime());
        c.setEmail("param@google.com");
        c.setFirstName("Param");
        c.setLastName("Saini");
        c.setPassword("doc123");
        c.setMemberref_code("jsharma3");
        
        Customer c1 =new Customer();
        c1.setBirthDate(new GregorianCalendar(1989, 11, 25).getTime());
        c1.setEmail("ajay@google.com");
        c1.setFirstName("Ajay");
        c1.setLastName("Shah");
        c1.setPassword("imp123");
        c1.setMemberref_code("jsharma3");
        
        Company cm = new Company();
        cm.setName("Pepsico");
        cm.setProductName("Sprite");
        cm.setProductType("Soda");
        
        Combos cb = new Combos();
        cb.setCombo_name("Soda");
        cb.setCombo_items("CocoCola,Sprite,Pepsi");
        cb.setCombo_price("$5");
        cb.setSaving("$1.10");
        cb.setCombo_availibility("5");
        
        Products pc = new Products();
        pc.setProduct_name("Pepsi");
        pc.setProduct_weight("350ml");
        pc.setProduct_price("$1.90");
        pc.setProduct_availibility("15");
        pc.setProduct_type("Soda");
        
        Products pc1 = new Products();
        pc1.setProduct_name("Sprite");
        pc1.setProduct_weight("350ml");
        pc1.setProduct_price("$1.90");
        pc1.setProduct_availibility("30");
        pc1.setProduct_type("Soda");
        
        Products pc2 = new Products();
        pc2.setProduct_name("CocoCola");
        pc2.setProduct_weight("350ml");
        pc2.setProduct_price("$1.90");
        pc2.setProduct_availibility("5");
        pc2.setProduct_type("Soda");
        
        Points pt = new Points();
        pt.setEmail("jaysharma@google.com");
        pt.setPoint("2000");
        
        cm.getProducts().add(pc);
        pc.setCompany(cm);
        cm.getProducts().add(pc1);
        pc1.setCompany(cm);        
        cm.getProducts().add(pc2);
        pc2.setCompany(cm);
      /*  
        pt.getMembers().add(m);
        m.setPnt(pt);
        */
        cb.getProducts().add(pc);
        pc.getCombos().add(cb);
        cb.getProducts().add(pc1);
        pc1.getCombos().add(cb);
        cb.getProducts().add(pc2);
        pc2.getCombos().add(cb);
        
        m.getCustomer().add(c);
        c.getMembers().add(m);
        m.getCustomer().add(c1);
        c1.getMembers().add(m);
       
        em.persist(m);
        em.persist(cm);
        em.persist(c);
        em.persist(c1);
        em.persist(cb);
        em.persist(pc);
        em.persist(pc1);
        em.persist(pc2);
        em.persist(pt);
        tx.commit();   
    }
    
    @After
    public void tearDown(){
        em.close();
    }

    private void removeTestData() {
        
        tx.begin();

        for(Products p : em.createNamedQuery("Products.findAll", Products.class).getResultList()){
            em.remove(p);
        }

        for(Members m : em.createNamedQuery("Members.findAll", Members.class).getResultList()){
            em.remove(m);
        }

        for(Customer c : em.createNamedQuery("Customer.findAll", Customer.class).getResultList()){
            em.remove(c);
        }

        for(Combos cb : em.createNamedQuery("Combos.findAll", Combos.class).getResultList()){
            em.remove(cb);
        }
        
        for(Points pt : em.createNamedQuery("Points.findAll", Points.class).getResultList()){
            em.remove(pt);
        }
        
        for(Company cm : em.createNamedQuery("Company.findAll", Company.class).getResultList()){
            em.remove(cm);
        }

        tx.commit();
    
    }
}
