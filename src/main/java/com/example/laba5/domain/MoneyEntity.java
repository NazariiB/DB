package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "money", schema = "laba1", catalog = "")
public class MoneyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private String date;
    @Basic
    @Column(name = "amount_to_earn")
    private int amountToEarn;
    @Basic
    @Column(name = "amount_to_put")
    private Integer amountToPut;
    @ManyToOne
    @JoinColumn(name = "vendingMachine_id", referencedColumnName = "id", nullable = false)
    private VendingMachineEntity vendingMachineByVendingMachineId;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private TeamEntity teamByTeamId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmountToEarn() {
        return amountToEarn;
    }

    public void setAmountToEarn(int amountToEarn) {
        this.amountToEarn = amountToEarn;
    }

    public Integer getAmountToPut() {
        return amountToPut;
    }

    public void setAmountToPut(Integer amountToPut) {
        this.amountToPut = amountToPut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoneyEntity that = (MoneyEntity) o;
        return amountToEarn == that.amountToEarn && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(amountToPut, that.amountToPut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, amountToEarn, amountToPut);
    }

    public VendingMachineEntity getVendingMachineByVendingMachineId() {
        return vendingMachineByVendingMachineId;
    }

    public void setVendingMachineByVendingMachineId(VendingMachineEntity vendingMachineByVendingMachineId) {
        this.vendingMachineByVendingMachineId = vendingMachineByVendingMachineId;
    }

    public TeamEntity getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(TeamEntity teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
