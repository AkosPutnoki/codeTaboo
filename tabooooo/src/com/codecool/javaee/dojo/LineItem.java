package com.codecool.javaee.dojo;

import javax.persistence.*;

@Entity
@Table(name = "JPA_ORDER_LINEITEM")
@IdClass(LineItemKey.class)
@NamedQueries({@NamedQuery(name = "findLineItemsByOrderId", query = "SELECT l FROM LineItem l " +
"WHERE l.customerOrder.orderId = :orderId " + "ORDER BY l.itemId")})
public class LineItem {
    @Id
    private int itemId;

    private int quantity;

    @JoinColumn(name = "PRODUCTID")
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "ORDERID")
    private CustomerOrder customerOrder;

    public LineItem(){
    }

    public LineItem(CustomerOrder order, int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.customerOrder = customerOrder;
        this.itemId = order.getNextId();
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public String toString() {
        return "itemId: " + itemId + " quantity: " + quantity + " product: " + product;
    }
}
