package com.mv.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "TB_COFFEE_DAY")
public class CoffeeDay implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeDayId;

    @Column(name = "coffeeDate", nullable = false)
    private LocalDate coffeeDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coffeeDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAssignment> itemAssignments;

    public Long getCoffeeDayId() {
        return coffeeDayId;
    }

    public void setCoffeeDayId(Long coffeeDayId) {
        this.coffeeDayId = coffeeDayId;
    }

    public LocalDate getCoffeeDate() {
        return coffeeDate;
    }

    public void setCoffeeDate(LocalDate coffeeDate) {
        this.coffeeDate = coffeeDate;
    }

    public List<ItemAssignment> getItemAssignments() {
        return itemAssignments;
    }

    public void setItemAssignments(List<ItemAssignment> itemAssignments) {
        this.itemAssignments = itemAssignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeDay coffeDay = (CoffeeDay) o;
        return Objects.equals(coffeeDayId, coffeDay.coffeeDayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeDayId);
    }

    @Override
    public String toString() {
        return "CoffeeDay{" +
                "coffeeDayId=" + coffeeDayId +
                ", coffeeDate=" + coffeeDate +
                ", itemAssignments=" + itemAssignments +
                '}';
    }
}
