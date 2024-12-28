package  com.ekhonni.backend.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "order_collections")
public class OrderCollection implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull @NotBlank
    private int quantity;
    @ManyToOne @JoinColumn @NotNull @NotBlank @Valid
    private Order order;
    @ManyToOne @JoinColumn @NotNull @NotBlank @Valid
    private Food food;

    public OrderCollection(){}

    public OrderCollection(int quantity, Order order, Food food) {
        this.quantity = quantity;
        this.order = order;
        this.food = food;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderCollection{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", order=" + order +
                ", food=" + food +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCollection)) return false;

        OrderCollection orderCollection = (OrderCollection) o;

        return getId().equals(orderCollection.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
