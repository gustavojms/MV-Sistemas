package com.mv.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "TB_COFFEE")
public class CoffeeDay implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coffeeDate", nullable = false)
    private LocalDate coffeeDate;

    @ManyToMany
    @JoinTable(name = "tb_user_coffee",
            joinColumns = @JoinColumn(name = "coffee_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "tb_coffee_item",
            joinColumns = @JoinColumn(name = "coffee_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ItemOption> items = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCoffeeDate() {
        return coffeeDate;
    }

    public void setCoffeDate(LocalDate coffeDate) {
        this.coffeeDate = coffeDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<ItemOption> getItems() {
        return items;
    }

    public void setItems(List<ItemOption> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeDay coffeDay = (CoffeeDay) o;
        return Objects.equals(id, coffeDay.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CoffeDay{" +
                "id=" + id +
                ", coffeeDate=" + coffeeDate +
                ", users=" + users +
                ", items=" + items +
                '}';
    }
}
