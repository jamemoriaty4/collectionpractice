package business.implement;

import business.config.InputMethods;
import business.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentImplement implements IDesignImplement{

    public  static List<Department> DepartmentList = new ArrayList<>();
    @Override
    public void addDepartment() {
        System.out.println("nhap so luong phong ban can nhap");
        byte count = InputMethods.getByte();
        for (int i =1; i <=count ; i++) {
            System.out.println("Nhập thông tin cho phong ban thứ "+i);
            Department newDepartment = new Department();
            newDepartment.inputDataDepartment();
            DepartmentList.add(newDepartment);
        }

        System.out.println("thêm mơ thanh công "+count+ " phong ban !");

    }

    @Override
    public void displayDepartment() {
        if (DepartmentList.isEmpty()) {
            System.err.println("Danh sách trống");
        } else {
            for (Department i : DepartmentList) {
                i.displayDataDepartment();
            }
        }
    }

    private Department findById(int id){
        for (Department p:DepartmentList){
            if (p.getDepartmentId()==id){
                return p;
            }
        }
        return null;
    }
    @Override
    public void updateDepartment() {
        System.out.println("nhap Id department can sua");
        int id = InputMethods.getInteger();
        Department departmentUpdate= findById(id);

        if (departmentUpdate==null){
            System.err.println("id  ko tìm thấy");
        }else {
            System.out.println("Thông tin cũ là ");
            departmentUpdate.displayDataDepartment();
            System.out.println("Nhập thông tin mơi");
            departmentUpdate.inputDataDepartment();
            System.out.println("đã cap nhạt thành cong");
        }
    }

    @Override
    public void deleteDepartment() {
        System.out.println("nhap Id department can xoa");
        int id = InputMethods.getInteger();
        Department departmentDelete= findById(id);

        if (departmentDelete==null){
            System.err.println("id  ko tìm thấy");
        }else {
            DepartmentList.remove(departmentDelete);
            System.out.println("xoa thanh cong");
        }
    }

    @Override
    public void findDepartment() {
        System.out.println("nhap Id department can tim");
        int id = InputMethods.getInteger();
        Department departmentFind= findById(id);

        if (departmentFind==null){
            System.err.println("id  ko tìm thấy");
        }else {
            departmentFind.displayDataDepartment();
        }
    }
}
