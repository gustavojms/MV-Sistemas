package com.mv.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_ITEM_ASSIGNMENT")
public class ItemAssignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemAssignmentId;

    @Column(name = "has_brought_item")
    @ColumnDefault("false")
    private Boolean hasBroughtItem;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemOption itemOption;

    @ManyToOne
    @JoinColumn(name = "coffeeDay_id")
    private CoffeeDay coffeeDay;

    public Long getItemAssignmentId() {
        return itemAssignmentId;
    }

    public void setItemAssignmentId(Long itemAssignmentId) {
        this.itemAssignmentId = itemAssignmentId;
    }

    public boolean isHasBroughtItem() {
        return hasBroughtItem;
    }

    public void setHasBroughtItem(boolean hasBroughtItem) {
        this.hasBroughtItem = hasBroughtItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ItemOption getItemOption() {
        return itemOption;
    }

    public void setItemOption(ItemOption itemOption) {
        this.itemOption = itemOption;
    }

    public CoffeeDay getCoffeeDay() {
        return coffeeDay;
    }

    public void setCoffeeDay(CoffeeDay coffeeDay) {
        this.coffeeDay = coffeeDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemAssignment that = (ItemAssignment) o;
        return Objects.equals(itemAssignmentId, that.itemAssignmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemAssignmentId);
    }

    @Override
    public String toString() {
        return "ItemAssignment{" +
                "itemAssignmentId=" + itemAssignmentId +
                ", hasBroughtItem=" + hasBroughtItem +
                ", user=" + user +
                ", itemOption=" + itemOption +
                ", coffeeDay=" + coffeeDay +
                '}';
    }
}
