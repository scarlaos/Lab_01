public class product {
    private String IDNum;
    private String name;
    private String description;
    private int quantity;
    private double cost;
    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) { product.IDSeed = IDSeed; }
    public static int getIDSeed() { return IDSeed; }

    // Full constructor
    public product(String IDNum, String name, String description, double cost, int quantity) {
        this.IDNum = IDNum;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = quantity;
    }

    public product(String name, String description, double cost, int quantity) {
        this.IDNum = genIDNum();
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.quantity = quantity;
    }

    private String genIDNum(){
        String newID = "" + IDSeed;
        while(newID.length()<8) newID = "0" + newID;
        IDSeed++;
        return newID;
    }

    public String getIDNum() { return IDNum; }
    public void setIDNum(String IDNum) { this.IDNum = IDNum; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Output methods
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%d", IDNum, name, description, cost, quantity);
    }

    public String toJSON() {
        return String.format("{\"id\":\"%s\",\"name\":\"%s\",\"description\":\"%s\",\"cost\":%.2f,\"quantity\":%d}",
                IDNum, name, description, cost, quantity);
    }

    public String toXML() {
        return String.format("<product><ID>%s</ID><Name>%s</Name><Description>%s</Description><Cost>%.2f</Cost><Quantity>%d</Quantity></product>",
                IDNum, name, description, cost, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
