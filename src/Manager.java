import java.time.LocalDate;
import java.util.*;

public class Manager {
    public List<Material> materials;
    private Scanner scanner;
    public   Manager(Scanner scanner){
        materials =new ArrayList<>();
        this.scanner=scanner;
    }
    public void addCrispyFlour(){
        System.out.println("Số lượng loại bột cần nhập: ");
        int num=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<num;i++){
            System.out.println("Nhập mã bột:");
            String id=scanner.nextLine();
            System.out.println("Nhập tên bột:");
            String name=scanner.nextLine();
            System.out.println("Nhập ngày sản xuất bột:");
            int day =Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tháng sản xuất bột:");
            int month=Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập năm sản xuất bột:");
            int year=Integer.parseInt(scanner.nextLine());
            LocalDate inputDate=LocalDate.of(year,month,day);
            System.out.println("Nhập giá bột:");
            int cost=Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số lượng bột:");
            int quantity=Integer.parseInt(scanner.nextLine());
            CrispyFlour c =new CrispyFlour(id,name,inputDate,cost,quantity);
            materials.add(c);
        }
    }
    public void addMeat() {
        System.out.println("Số lượng loại thịt cần nhập: ");
        int num = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < num; i++) {
            System.out.println("Nhập mã thịt:");
            String id = scanner.nextLine();
            System.out.println("Nhập tên thịt:");
            String name = scanner.nextLine();
            System.out.println("ngày nhập thịt:");
            int day = Integer.parseInt(scanner.nextLine());
            System.out.println("tháng nhập thịt:");
            int month =Integer.parseInt(scanner.nextLine());
            System.out.println("năm nhập thịt:");
            int year = Integer.parseInt(scanner.nextLine());
            LocalDate inputDate = LocalDate.of(year,month,day);
            System.out.println("Nhập giá thịt:");
            int cost = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số cân thịt:");
            int weight=Integer.parseInt(scanner.nextLine());
            Meat m = new Meat(id, name, inputDate, cost, weight);
            materials.add(m);
        }
    }

    public void updateMeat(){
        System.out.println("Nhập mã thịt cần sửa thông tin:");
        String id=scanner.nextLine();
        boolean check=true;
        for (int i=0;i<materials.size();i++){
            if(materials.get(i) instanceof Meat){
                Meat m = (Meat) materials.get(i);
                if(m.getId().equals(id)){
                    System.out.println("Nhập mã thịt mới:"+m.getId());
                    String newId=scanner.nextLine();
                    System.out.println("Nhập tên thịt mới:"+m.getName());
                    String newName=scanner.nextLine();
                    System.out.println("Ngày nhập thịt:");
                    int day =Integer.parseInt(scanner.nextLine());;
                    System.out.println("Tháng nhập thịt:");
                    int month=Integer.parseInt(scanner.nextLine());;
                    System.out.println("Năm nhập thịt:");
                    int year=Integer.parseInt(scanner.nextLine());;
                    LocalDate newInputDate=LocalDate.of(year,month,day);
                    System.out.println("Nhập giá thịt mới:"+m.getCost());
                    int newCost=Integer.parseInt(scanner.nextLine());;
                    System.out.println("Nhập số lượng thịt mới:"+m.getWeight());
                    int newWeight=Integer.parseInt(scanner.nextLine());
                    m.setId(newId);
                    m.setName(newName);
                    m.setManufacturingDate(newInputDate);
                    m.setCost(newCost);
                    m.setWeight(newWeight);
                    System.out.println("chỉnh sửa thành công");
                    check=false;
                    break;

                }
            }
        }
        if(check){
            System.out.println("mã thịt bạn nhập không đúng");
        }
    }
    public void updateCrispyFlour(){
        System.out.println("Nhập mã bột cần sửa thông tin:");
        String id=scanner.nextLine();
        boolean check=true;
        for (int i=0;i<materials.size();i++){
            if(materials.get(i) instanceof CrispyFlour){
                CrispyFlour c = (CrispyFlour) materials.get(i);
                if(c.getId().equals(id)){
                    System.out.println("Nhập mã bột mới:"+c.getId());
                    String newId=scanner.nextLine();
                    System.out.println("Nhập tên bột mới:"+c.getName());
                    String newName=scanner.nextLine();
                    System.out.println("Ngày nhập bột:");
                    int day =Integer.parseInt(scanner.nextLine());;
                    System.out.println("Tháng nhập bột:");
                    int month=Integer.parseInt(scanner.nextLine());;
                    System.out.println("Năm nhập bột:");
                    int year=Integer.parseInt(scanner.nextLine());;
                    LocalDate newInputDate=LocalDate.of(year,month,day);
                    System.out.println("Nhập giá bột mới:"+c.getCost());
                    int newCost=Integer.parseInt(scanner.nextLine());;
                    System.out.println("Nhập số lượng bột mới:"+c.getQuantity());
                    int newQuantity=Integer.parseInt(scanner.nextLine());
                    c.setId(newId);
                    c.setName(newName);
                    c.setManufacturingDate(newInputDate);
                    c.setCost(newCost);
                    c.setQuantity(newQuantity);
                    System.out.println("chỉnh sửa thành công");
                    check=false;
                    break;

                }
            }
        }
        if(check){
            System.out.println("mã bột bạn nhập không đúng");
        }
    }
    public void deleteMaterial(){
        System.out.println("Nhập mã sản phẩm cần xoá:");
        String id=scanner.nextLine();
        boolean check=true;
        for (Material m: materials){
            if(m.getId().equals(id)){
                materials.remove(m);
                check=false;
                System.out.println("Đã xoá thành công");
                break;
            }
        }
        if(check){
            System.out.println("Mã bạn nhập không đúng");
        }
    }

    public void sumPrice(List<Material> materialList) {
        double sumP = 0;
        double sumPriceDiscount = 0;
        for (Material m:materialList) {

            if (m instanceof Meat) {
                Meat meat = (Meat) m;
                sumP += meat.getAmount();
                sumPriceDiscount += meat.getRealMoney();
            }
            if (m instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) m;
                sumP += crispyFlour.getAmount();
                sumPriceDiscount += crispyFlour.getRealMoney();

            }


        }
        System.out.println("Tổng giá của "+materialList.size()+" material là: "+sumP);
        System.out.println( "Giá sau khi discount là: "+sumPriceDiscount);

    }




    public void sortMaterialByCost(){
        materials.sort(Comparator.comparingDouble(Material::getCost));
        for(Material m:materials){
            System.out.println(m);
        }
    }
   public void displayMaterial(){
        if(materials.size()==0){
            System.out.print("List is empty");
        }
        else {
            for(Material m:materials){
            System.out.println(m);
            }
        }
   }

}



