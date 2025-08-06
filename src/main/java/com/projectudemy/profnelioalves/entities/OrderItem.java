package com.projectudemy.profnelioalves.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projectudemy.profnelioalves.entities.PK.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // Initialize the composite key

    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(order Order, Product product, Integer quantity, Double price) {
        id.setOrder(Order);
        id.setProduct(product);
       // id = new OrderItemPK(); // Ensure id is initialized
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public order getOrder(){
        return id.getOrder();
    } 

    public void setOrder(order Order){
        id.setOrder(Order);
    }

    public Product getProduct(){
        return id.getProduct();
    } 

    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}
