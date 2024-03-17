import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class Meat extends Material implements Discount{
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight*getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().minusDays(7);
    }

    @Override
    public double getRealMoney() {
        return getAmount()*97/100;
    }

    @Override
    public String toString() {
        return "Meat{" + "id: "+ super.getId()+", name: "+ super.getName()+", manufacturingDate: "+ super.getManufacturingDate()+". cost: "+super.getCost()+
                " weight: " + weight +
                '}';

    }
}
