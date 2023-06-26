package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;

public class Main {
    private static Configuration configuration;
    private static void setConfig() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.mariadb.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mariadb://localhost:3306/Database?useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MariaDBDialect");

        settings.put(Environment.SHOW_SQL, "true");

        settings.put(Environment.HBM2DDL_AUTO, "update");

        configuration.setProperties(settings);
        configuration = new Configuration().addAnnotatedClass(employee.class).addAnnotatedClass(department.class).addAnnotatedClass(role.class);
    }

    private static void Fetchrecords(){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query command = session.createQuery("from " + "employee");
        List<employee> emp = command.list();
        for (employee i : emp) {
            System.out.println(i);
        }
        transaction.commit();
    }

    private static void Saveroleid(Integer id,String Name,Integer employeeid){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction  transaction = session.beginTransaction();
        role rol = new role(id, Name);
        employee empl = session.get(employee.class, employeeid);
        empl.setRoleid(rol);
        session.save(rol);
        transaction.commit();
    }

    private static void createdept (Integer id,String Name){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction  transaction = session.beginTransaction();
        department dep = new department(id, Name);
        session.save(dep);
        transaction.commit();
    }

    private static void mapdept (Integer id,Integer id1){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction  transaction = session.beginTransaction();
        employee em = session.get(employee.class, id);
        department de = session.get(department.class, id1);
        em.setDeptid(de);
        transaction.commit();
    }

    private static void updateroleid (Integer id,String name){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction  transaction = session.beginTransaction();
        role ro = session.get(role.class, id);
        ro.setName(name);
        transaction.commit();
    }

    private static void deleterecord (Integer id){
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction  transaction = session.beginTransaction();
        employee em1 = session.get(employee.class, id);
        session.delete(em1);
        transaction.commit();
    }

    public static void main(String[] args) {
        setConfig();
        Fetchrecords();
        Saveroleid(2,"Role",3);
        createdept(3,"Hi");
        mapdept(1,1);
        updateroleid(1,"Hello");
        deleterecord(2);
    }
}