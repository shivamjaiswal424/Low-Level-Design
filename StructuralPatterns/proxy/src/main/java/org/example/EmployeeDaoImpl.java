package org.example;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void getEmployeeInfo(int empId) {
        System.out.println("Fetching employee info for ID: " + empId);
    }

    @Override
    public void createEmployee(EmployeeDo obj) {
        System.out.println("Creating employee: " + obj);
    }
}
