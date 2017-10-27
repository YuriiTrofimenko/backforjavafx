/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.backforjavafx.rest;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.backforjavafx.entity.Customer;

/**
 *
 * @author yurii
 */
@Stateless
public class CustomerFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "BackForJavaFxPU")
    private EntityManager em;

    public List<Customer> findAll() {
      return em.createQuery("select c from Customer c").getResultList();
    }

    public List<Customer> findByName(String name) {
        return em.createQuery("select c from Customer c where UPPER(c.name) LIKE :custName").
            setParameter("custName", "%" + name.toUpperCase() + "%").getResultList();
    }
}
