package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sold_products", schema = "laba1", catalog = "")
public class SoldProductsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;
    @Basic
    @Column(name = "time_of_purchase")
    private String timeOfPurchase;
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

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(String timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldProductsEntity that = (SoldProductsEntity) o;
        return id == that.id && Objects.equals(quantity, that.quantity) && Objects.equals(timeOfPurchase, that.timeOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, timeOfPurchase);
    }

    public VendingMachineEntity getVendingMachineByVendingMachineId() {
        return vendingMachineByVendingMachineId;
    }

    public void setVendingMachineByVendingMachineId(VendingMachineEntity vendingMachineByVendingMachineId) {
        this.vendingMachineByVendingMachineId = vendingMachineByVendingMachineId;
    }
}
