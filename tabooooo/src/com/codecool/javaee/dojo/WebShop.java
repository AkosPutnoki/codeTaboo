package com.codecool.javaee.dojo;

import javax.persistence.*;
import java.util.List;

public class WebShop {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager();

        Product product1 = new Product("stuff", 42.0);
        Product product2 = new Product("thingy", 17.0);
        CustomerOrder order = new CustomerOrder(213);
        LineItem lineItem1 = new LineItem(order, 3, product1);
        order.addLineItem(lineItem1);
        LineItem lineItem2 = new LineItem(order, 1, product2);
        order.addLineItem(lineItem2);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(order);
        transaction.commit();

        List<CustomerOrder> orders = em.createNamedQuery("findAllOrders").getResultList();
        System.out.println(orders);
        System.out.println("The order sum is: " + order.calculateSum());
    }
}
