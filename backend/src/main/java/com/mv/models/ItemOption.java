package com.mv.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_ITEM_OPTION")
public class ItemOption implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemOptionId;

    @Column(name = "item", nullable = false)
    private String item;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOption", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemAssignment> itemAssignments;

    public Long getItemOptionId() {
        return itemOptionId;
    }

    public void setItemOptionId(Long itemOptionId) {
        this.itemOptionId = itemOptionId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
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
        ItemOption that = (ItemOption) o;
        return Objects.equals(item, that.item) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "ItemOption{" +
                "itemOptionId=" + itemOptionId +
                ", item='" + item + '\'' +
                ", itemAssignments=" + itemAssignments +
                '}';
    }
}
