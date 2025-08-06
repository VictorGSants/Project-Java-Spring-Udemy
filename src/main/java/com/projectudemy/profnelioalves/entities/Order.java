package com.projectudemy.profnelioalves.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projectudemy.profnelioalves.entities.enuns.OrderStatus;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "tb_order")
public class order implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    // This annotation formats the date to a specific pattern
    // and sets the timezone to GMT
    private Instant moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    // This annotation indicates that this field is a foreign key
    // and it references the User entity
    private User client;


    @OneToMany(mappedBy = "id.order")
    // This annotation indicates that this field is a one-to-many relationship
    private Set<OrderItem> itens = new HashSet<>();

    public order() {}

    public order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setStatus(OrderStatus orderStatus) {
        if (orderStatus == null) {
            throw new IllegalArgumentException("OrderStatus cannot be null");
            
        }
        this.orderStatus = orderStatus.getCode();
    }

    public void setClient(User client) {
        this.client = client;
    }
    public Set<OrderItem> getItens() {
        return itens;
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
        order other = (order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}
