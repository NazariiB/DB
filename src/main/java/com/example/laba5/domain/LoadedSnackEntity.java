package com.example.laba5.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "loaded_snack", schema = "laba1", catalog = "")
//@IdClass(LoadedSnackEntityPK.class)
public class LoadedSnackEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "reloading_snack_machines_id", referencedColumnName = "id", nullable = false)
    private VendingMachineEntity reloadingSnackMachinesId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity productId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VendingMachineEntity getReloadingSnackMachinesId() {
        return reloadingSnackMachinesId;
    }

    public void setReloadingSnackMachinesId(VendingMachineEntity reloadingSnackMachinesId) {
        this.reloadingSnackMachinesId = reloadingSnackMachinesId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
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
        LoadedSnackEntity that = (LoadedSnackEntity) o;
        return id == that.id && reloadingSnackMachinesId == that.reloadingSnackMachinesId && productId == that.productId && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reloadingSnackMachinesId, productId, quantity);
    }
}
