package com.example.Employee.dao;

import com.example.Employee.entities.Employee;
import com.example.Employee.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    public void create(Employee employee) {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        System.out.println("Успешно создан: " + employee.toString());
    }

    public List<Employee> read() {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Employee> employees = session.createQuery("FROM Employee").list();
        employees = employees.stream().filter(employee -> employee.getName().startsWith("A")).collect(Collectors.toList());
        session.close();
        System.out.println("Найдено: " + employees.size() + " сотрудников");
        return employees;
    }

    public void update(Employee employee) {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        Employee emp = session.load(Employee.class, employee.getId());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно изменено " + employee.toString());
    }

    public void delete(Integer id) {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        Employee emp = findByID(id);
        session.delete(emp);
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно удалено " + emp.toString());
    }

    public Employee findByID(Integer id) {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        Employee emp = session.load(Employee.class, id);
        session.close();
        return emp;
    }

    public void deleteAll() {
        Session session = HibernateUtil.getCurrentSessionFromConfig();
        session.beginTransaction();
        Query query = session.createQuery("DELETE from Employee ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Успешно удалены все записи в Employee.");
    }
}
