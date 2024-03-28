package business.entity;

import business.config.InputMethods;

import java.util.regex.Pattern;

public class Department {
    private static int nextID =1;
    private int departmentId;
    private String departmentName;

    public Department() {
    }

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void inputDataDepartment(){
        this.departmentId = nextID++;


        System.out.println("Nhap ten phong ban ");
        this.departmentName = InputMethods.getString();
    }

    public void displayDataDepartment(){
        System.out.printf(" ID department : %-3d | Name department: %-7s \n",departmentId,departmentName);
    }
}
