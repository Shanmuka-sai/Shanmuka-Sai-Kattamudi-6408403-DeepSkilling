package com.cognizant.orm_compare.hibernate;

import com.cognizant.orm_compare.model.Employee;
import com.cognizant.orm_compare.util.HibernateUtil;
import org.hibernate.*;

public class EmployeeHibernateService {

    public Integer addEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            session.persist(employee);
            employeeID = employee.getId(); 
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace(); 
        } finally {
            session.close(); 
        }

        return employeeID;
    }
}

