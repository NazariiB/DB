package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reloading_snacks_machine", schema = "laba1", catalog = "")
public class ReloadingSnacksMachineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "time_reloading")
    private String timeReloading;
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

    public String getTimeReloading() {
        return timeReloading;
    }

    public void setTimeReloading(String timeReloading) {
        this.timeReloading = timeReloading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReloadingSnacksMachineEntity that = (ReloadingSnacksMachineEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(timeReloading, that.timeReloading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeReloading);
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
