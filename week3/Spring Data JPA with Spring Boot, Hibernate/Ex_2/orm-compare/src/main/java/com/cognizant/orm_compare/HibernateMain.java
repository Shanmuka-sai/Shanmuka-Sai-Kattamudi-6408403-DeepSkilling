package  com.cognizant.orm_compare;

import com.cognizant.orm_compare.hibernate.EmployeeHibernateService;
import  com.cognizant.orm_compare.model.Employee;

public class HibernateMain {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("John");
        emp.setDepartment("HR");

        EmployeeHibernateService service = new EmployeeHibernateService();
        Integer id = service.addEmployee(emp);

        System.out.println("Hibernate: Employee added with ID = " + id);
    }
}
