package com.example.laba5.domain;

import org.hibernate.cache.spi.support.NaturalIdNonStrictReadWriteAccess;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vending_machine", schema = "laba1", catalog = "")
public class VendingMachineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "vending_machine_model")
    private String vendingMachineModel;
    @Basic
    @Column(name = "max_amount_of_snacks")
    private Integer maxAmountOfSnacks;
    @Basic
    @Column(name = "gps_cordinates")
    private String gpsCordinates;
    @Basic
    @Column(name = "amount_of_snacks")
    private Integer amountOfSnacks;

    @OneToMany(mappedBy = "vendingMachineByVendingMachineId")
    private Collection<MoneyEntity> moniesById;
    @OneToMany(mappedBy = "vendingMachineByVendingMachineId")
    private Collection<ReloadingSnacksMachineEntity> reloadingSnacksMachinesById;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendingMachineModel() {
        return vendingMachineModel;
    }

    public void setVendingMachineModel(String vendingMachineModel) {
        this.vendingMachineModel = vendingMachineModel;
    }

    public Integer getMaxAmountOfSnacks() {
        return maxAmountOfSnacks;
    }

    public void setMaxAmountOfSnacks(Integer maxAmountOfSnacks) {
        this.maxAmountOfSnacks = maxAmountOfSnacks;
    }

    public String getGpsCordinates() {
        return gpsCordinates;
    }

    public void setGpsCordinates(String gpsCordinates) {
        this.gpsCordinates = gpsCordinates;
    }

    public Integer getAmountOfSnacks() {
        return amountOfSnacks;
    }

    public void setAmountOfSnacks(Integer amountOfSnacks) {
        this.amountOfSnacks = amountOfSnacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendingMachineEntity that = (VendingMachineEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(vendingMachineModel, that.vendingMachineModel) && Objects.equals(maxAmountOfSnacks, that.maxAmountOfSnacks) && Objects.equals(gpsCordinates, that.gpsCordinates) && Objects.equals(amountOfSnacks, that.amountOfSnacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vendingMachineModel, maxAmountOfSnacks, gpsCordinates, amountOfSnacks);
    }


    public Collection<MoneyEntity> getMoniesById() {
        return moniesById;
    }

    public void setMoniesById(Collection<MoneyEntity> moniesById) {
        this.moniesById = moniesById;
    }

    public Collection<ReloadingSnacksMachineEntity> getReloadingSnacksMachinesById() {
        return reloadingSnacksMachinesById;
    }

    public void setReloadingSnacksMachinesById(Collection<ReloadingSnacksMachineEntity> reloadingSnacksMachinesById) {
        this.reloadingSnacksMachinesById = reloadingSnacksMachinesById;
    }

}
