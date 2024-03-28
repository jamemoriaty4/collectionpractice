package business.implement;

import business.config.InputMethods;
import business.entity.Department;
import business.entity.Employee;

public class EmployeesImplement implements EmployeeImplement{
    @Override
    public void addEmployee() {
        System.out.println("nhap so luong nhan vien can nhap");
        byte count = InputMethods.getByte();
        for (int i =1; i <=count ; i++) {
            System.out.println("nhap thong tin cua nhan vien thư "+i);
            Employee newEmployee = new Employee();
            newEmployee.inputDataEmployee();

        }

        System.out.println("thêm mơ thanh công "+count+ " nhan vien !");
    }

    @Override
    public void displayEmployee() {

    }

    @Override
    public void displayDirectEmployee() {

    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee() {

    }
}
