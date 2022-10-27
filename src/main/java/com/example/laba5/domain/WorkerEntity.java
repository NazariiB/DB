package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "worker", schema = "laba1", catalog = "")
public class WorkerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idworkers")
    private int idworkers;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "sallery")
    private String sallery;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private TeamEntity teamByTeamId;

    public int getIdworkers() {
        return idworkers;
    }

    public void setIdworkers(int idworkers) {
        this.idworkers = idworkers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSallery() {
        return sallery;
    }

    public void setSallery(String sallery) {
        this.sallery = sallery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return idworkers == that.idworkers && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(position, that.position) && Objects.equals(sallery, that.sallery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idworkers, name, surname, phoneNumber, position, sallery);
    }

    public TeamEntity getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(TeamEntity teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }
}
