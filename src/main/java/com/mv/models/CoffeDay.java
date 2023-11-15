package com.mv.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "TB_COFFE")
public class CoffeDay implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @JoinTable(name = "tb_user_coffe",
            joinColumns = @JoinColumn(name = "coffe_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ManyToMany
    private Set<User> user = new HashSet<>();

    @JoinColumn(name = "item_id", nullable = false)
    @OneToMany
    private List<ItemOption> item = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<User> getUser() {
        return user;
    }

    public List<ItemOption> getItem() {
        return item;
    }

    public void setItem(List<ItemOption> item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeDay coffeDay = (CoffeDay) o;
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
                ", date=" + date +
                ", user=" + user +
                ", item=" + item +
                '}';
    }
}
