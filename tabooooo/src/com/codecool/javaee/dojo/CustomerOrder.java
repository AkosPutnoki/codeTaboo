package com.codecool.javaee.dojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.TemporalType.TIMESTAMP;


@Entity
@Table(name="JPA_ORDER_CUSTOMERORDER")
@NamedQuery(name="findAllOrders",
            query="SELECT co FROM CustomerOrder co " + "ORDER BY co.orderId")
public class CustomerOrder {
    @Id
    private Integer orderId;

    @Temporal(TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(cascade = ALL, mappedBy = "customerOrder")
    private Collection<LineItem> lineItems;

    public CustomerOrder() {
        this.lastUpdate = new Date();
        this.lineItems = new ArrayList<>();
    }

    public CustomerOrder(Integer orderId) {
        this.orderId = orderId;
        this.lastUpdate = new Date();
        this.lineItems = new ArrayList<>();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Collection<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Collection<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        this.getLineItems().add(lineItem);
    }

    public double calculateSum() {
        double amount = 0;
        Collection<LineItem> items = getLineItems();
        for (LineItem item: items) {
            Product part = item.getProduct();
            amount += part.getPrice()*item.getQuantity();
        }
        return amount;
    }

    public Integer getNextId() {
        return lineItems.size()+1;
    }

    @Override
    public String toString() {
        return  "orderNumber:" + orderId +
                ", lastUpdate: " + lastUpdate +
                ", lineItems: " + lineItems;
    }
}
