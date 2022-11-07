package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "laba1", catalog = "")
public class TeamEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "teamByTeamId")
    private Collection<MoneyEntity> moniesById;
    @OneToMany(mappedBy = "teamByTeamId")
    private Collection<ReloadingSnacksMachineEntity> reloadingSnacksMachinesById;
    @OneToMany(mappedBy = "teamByTeamId")
    private Collection<WorkerEntity> workersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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

    public Collection<WorkerEntity> getWorkersById() {
        return workersById;
    }

    public void setWorkersById(Collection<WorkerEntity> workersById) {
        this.workersById = workersById;
    }
}
