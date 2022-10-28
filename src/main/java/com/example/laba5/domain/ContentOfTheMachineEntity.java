package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "content_of_the_machine", schema = "laba1", catalog = "")
public class ContentOfTheMachineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "vendingMachine_id", referencedColumnName = "id", nullable = false)
    private VendingMachineEntity vendingMachineByVendingMachineId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity productId;

    public void setProductId(ProductEntity product) {
        this.productId = product;
    }

    public ProductEntity getProductId() { return productId;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentOfTheMachineEntity that = (ContentOfTheMachineEntity) o;
        return id == that.id && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }

    public VendingMachineEntity getVendingMachineByVendingMachineId() {
        return vendingMachineByVendingMachineId;
    }

    public void setVendingMachineByVendingMachineId(VendingMachineEntity vendingMachineByVendingMachineId) {
        this.vendingMachineByVendingMachineId = vendingMachineByVendingMachineId;
    }


}
