import java.time.LocalDate;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getQuantity()*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        return getAmount()*94/100;
    }

    @Override
    public String toString() {
        return "CrispyFlour{" + "id: "+ super.getId()+", name: "+ super.getName()+", manufacturingDate: "+ super.getManufacturingDate()+". cost: "+super.getCost()+
                "quantity: " + quantity +
                '}';
    }
}
