package business.entity;

import business.config.InputMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String email;
    private String address;
    private Gender gender;

    private Date birthday;
    private float basicSalary;
    private float allowanceSalary;
    private float rate;
    private Department department;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String email, String address, Gender gender, Date birthday, float basicSalary, float allowanceSalary, float rate, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.basicSalary = basicSalary;
        this.allowanceSalary = allowanceSalary;
        this.rate = rate;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Department getDepartment() {
        return department;
    }
    private void calTotalSalary(){
        float totalSalary = this.basicSalary * this.rate + this.allowanceSalary;
    }

    public void setDepartmentID(Department department) {
        this.department = department;
    }

    private boolean existByEmail(String email, List<Employee> employees) {

        for (Employee p : employees) {
            if (!p.email.equals(email)) {
                continue;
            }
            return true;
        }
        return false;
    }


    public void inputDataEmployee(List<Employee> employees, List<Department> departments) throws ParseException {
        inputemployeeID();
        inputName();
        inputemail(employees);
        inputadress();
        if (inputgender()) return;

        inputbirthday();
        inputsalary();
        inputsalaryallow();
        inputrate();
        department(departments);


    }

    private void inputrate() {
        System.out.println("nhap he so luong");
        this.rate = InputMethods.getFloat();
    }

    private void inputsalaryallow() {
        System.out.println("nhap luong phu cap");
        this.allowanceSalary = InputMethods.getFloat();
    }

    private void inputsalary() {
        System.out.println("nhap lương co ban");
        this.basicSalary = InputMethods.getFloat();
    }

    private void inputbirthday() throws ParseException {
        System.out.println("nhap ngay sinh");
        this.birthday = sdf.parse(InputMethods.getString());
    }

    private void department(List<Department> departments) {
        if (!departments.isEmpty()) {
            System.out.println("danh sach phong ban ");
            for (int i = 0; i < departments.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, departments.get(i).getDepartmentName());
            }
            while (true) {
                System.out.println("nhap vao phong ban");
                int index = InputMethods.getInteger();
                if (index >= 1 && index <= departments.size()) {
                    this.department = departments.get(index - 1);
                    break;
                } else {
                    System.err.println("nhap khong chinh xac phong ban ");
                    System.err.println("vui long chon lai");
                }
            }
        }
    }

    private boolean inputgender() {
        System.out.println("nhap gioi tinh");
        byte choice = InputMethods.getByte();
        switch (choice) {
            case 1:
                this.gender = Gender.MALE;
                return true;
            case 2:
                this.gender = Gender.FEMALE;
                return true;
            case 3:
                this.gender = Gender.OTHER;
                return true;
            default:
                System.out.println("nhập lại giới tính");
                break;
        }
        return false;
    }

    private void inputadress() {
        System.out.println("nhap dia chi");
        this.address = InputMethods.getString();
    }

    private void inputemail(List<Employee> employees) {
        System.out.println("nhap vào email");
        String regaxEmail = "^(.+)@(\\S+)$";
        while (true) {
            if (email.matches(regaxEmail)) {
                if (!existByEmail(email, employees)) {
                    this.email = email;
                    break;
                }
                System.err.println("email đã tồn tại");
            }
        }
    }

    private void inputName() {
        System.out.println("nhap vao ten nhan vien");
        this.employeeName = InputMethods.getString();
    }

    private void inputemployeeID() {
        System.out.println("nhap vao employeeID");
        this.employeeId = InputMethods.getInteger();
    }

    public void displayDataEmployee() {
        System.out.printf("mã nv: %-4d | tên Nv : %-5s | email: %-15s| đia chỉ : %-10s | gioi tinh : %-5s | ngay sinh : %-8s| ");

    }
}

