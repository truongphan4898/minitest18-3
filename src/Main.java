import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Manager manager=new Manager(scanner);
        do{
            System.out.println("menu");
            System.out.println("1.Nhập danh sách bột");
            System.out.println("2.Nhập danh sách thịt");
            System.out.println("3.Chỉnh sửa sản phẩm bột theo mã bột");
            System.out.println("4.Chỉnh sửa sản phẩm thịt theo mã thịt");
            System.out.println("5.Xoá sản phẩm theo mã  ");
            System.out.println("6.Tính giá sản phẩm và chênh lệch giá");
            System.out.println("7.Sắp xếp các sản phẩm theo giá");
            System.out.println("8.Hiển thị danh sách sản phẩm");
            System.out.println("9.Thoát");
            System.out.println("Tính năng muốn thực hiện: ");
            int num=Integer.parseInt(scanner.nextLine());
            switch (num){
                case 1:
                    manager.addCrispyFlour();
                    break;
                case 2:
                    manager.addMeat();
                    break;
                case 3:
                    manager.updateCrispyFlour();
                    break;
                case 4:
                    manager.updateMeat();
                    break;
                case 5:
                    manager.deleteMaterial();
                    break;
                case 6:
                    manager.sumPrice(manager.materials);
                    break;
                case 7:
                    manager.sortMaterialByCost();
                    break;
                case 8:
                    manager.displayMaterial();
                    break;

                case 9:
                    System.exit(9);
            }
        }
        while (true);
    }
}

