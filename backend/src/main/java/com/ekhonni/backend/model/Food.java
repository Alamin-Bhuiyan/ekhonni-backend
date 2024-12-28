package  com.ekhonni.backend.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foods")
public class Food implements Serializable{
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull @NotBlank
    private String img;
    @NotNull @NotBlank
    private String title;
    @NotNull @NotBlank
    private double price;
    @NotNull @NotBlank
    private boolean available;
    private String description;
    @ManyToOne @JoinColumn @NotNull @NotBlank @Valid
    private Category category;
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private Set<OrderCollection> orderCollections = new HashSet<>();

    public Food() {}

    public Food(String img, String title, double price, boolean available, String description, Category category) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.available = available;
        this.description = description;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderCollection> getOrderCollections() {
        return orderCollections;
    }

    public void setOrderCollections(Set<OrderCollection> orderCollections) {
        this.orderCollections = orderCollections;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;

        Food food = (Food) o;

        return getId().equals(food.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
