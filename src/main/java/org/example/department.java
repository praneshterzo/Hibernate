package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
@Entity
public class department {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "deptid")
    private List<employee> emp;
    public department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public department() {

    }

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emp=" + emp +
                '}';
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

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
