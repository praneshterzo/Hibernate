package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class role {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "roleid")
    private List<employee> emp;

    public role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public role() {
    }

    public List<employee> getEmp() {
        return emp;
    }

    public void setEmp(List<employee> emp) {
        this.emp = emp;
    }

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
    public String toString() {
        return "role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emp=" + emp +
                '}';
    }
}
