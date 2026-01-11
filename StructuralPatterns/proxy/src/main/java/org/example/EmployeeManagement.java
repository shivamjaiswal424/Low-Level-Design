package org.example;


public class EmployeeManagement {
    public static void main(String[] args) {
        System.out.println("===== Proxy Design Pattern =====");
        EmployeeDao userProxyObj=new EmployeeDaoImpl();
        userProxyObj.getEmployeeInfo(1);
        userProxyObj.createEmployee(new EmployeeDo());
    }
}