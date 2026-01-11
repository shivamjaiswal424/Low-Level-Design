package org.example;

public class EmployeeDaoProxy implements EmployeeDao {
    private EmployeeDao employeeDao;
    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {
        this.employeeDao = new EmployeeDaoImpl();
        this.clientRole = clientRole;
    }

    @Override
    public void getEmployeeInfo(int empId) {
        if(clientRole.equals("ADMIN") || clientRole.equals("USER")){
            employeeDao.getEmployeeInfo(empId);
        }
        else{
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee(EmployeeDo obj) {
        if(clientRole.equals("ADMIN")){
            employeeDao.createEmployee(obj);
        }
        else{
            throw new RuntimeException("Access Denied");
        }
    }
}
