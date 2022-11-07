package com.example.laba5.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "work_position", schema = "laba1", catalog = "")
public class WorkerPositionsEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "position")
    private String position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String name) {
        this.position = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerPositionsEntity that = (WorkerPositionsEntity) o;
        return id == that.id && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}