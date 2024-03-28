package presentation.run;

import business.config.InputMethods;
import business.implement.DepartmentImplement;
import business.implement.IDesignImplement;

public class rundepartment {

    private static final IDesignImplement designDepartment = new DepartmentImplement();

    public static void displayDepartmentMenu() {
        while (true) {
            System.out.println("**********************DEPARTMENT-MENU************************\n" +
                    "1. Thêm mới phòng ban \n" +
                    "2. Hiển thị thông tin tất cả phòng ban \n" +
                    "3. Sửa tên phòng ban \n" +
                    "4. Xóa phòng ban \n" +
                    "5. Tìm kiếm phòng ban \n" +
                    "0. Quay lại\n");
            System.out.println("nhap vao lua chon cua ban");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    designDepartment.addDepartment();
                    break;
                case 2:
                    designDepartment.displayDepartment();
                    break;
                case 3:
                    designDepartment.updateDepartment();
                    break;
                case 4:
                    designDepartment.deleteDepartment();
                    break;
                case 5:
                    designDepartment.findDepartment();
                    break;
                case 0:
                    System.out.println("ket thuc department");
                    return;
                default:
                    System.out.println("nhap lai lua chon ");
                    break;
            }
        }
    }
}
