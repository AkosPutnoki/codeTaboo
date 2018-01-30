package com.codecool.javaee.dojo;

import java.io.Serializable;

public final class LineItemKey implements Serializable{

    private static final long serialVersionUID = 1562260205094677677L;
    private int customerOrder;
    private int itemId;

    public LineItemKey(){}

    public LineItemKey(int customerOrder, int itemId) {
        setCustomerOrder(customerOrder);
        setItemId(itemId);
    }

    public int getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(int customerOrder) {
        this.customerOrder = customerOrder;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "" + getCustomerOrder() + " - " + getItemId();
    }

}
