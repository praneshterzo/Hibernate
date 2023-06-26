package org.example;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class employee {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private department deptid;

    @ManyToOne(cascade=CascadeType.ALL)
    private role roleid;
    private int salary;
    public employee(){}
    public employee(int id, String name, department deptid, role roleid, int salary) {
        this.id = id;
        this.name = name;
        this.deptid = deptid;
        this.roleid = roleid;
        this.salary = salary;
    }

    public static void setroleiD(role rol) {
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptid=" + deptid +
                ", roleid=" + roleid +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public department getDeptid() {
        return deptid;
    }

    public role getRoleid() {
        return roleid;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeptid(department deptid) {
        this.deptid = deptid;
    }

    public void setRoleid(role roleid) {
        this.roleid = roleid;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
