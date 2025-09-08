public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj safeInput = new  SafeInputObj();

        String name = safeInput.getNonZeroLenString("What is your name");
        System.out.println("Your name is: " + name);

        int number = safeInput.getRangedInt("Enter the number of cars in your drive way",0,1000);
        System.out.println("Car: " + number);

        boolean yn = safeInput.getYNConfirm("Do you want to continue? y/n");
        System.out.println("Confirm: " + yn);

        int anyNum = safeInput.getInt("Enter your favorite number");
        System.out.println("Favorite number: " + anyNum);

        double price = safeInput.getDouble("Enter the price");
        System.out.println("Price: " + price);

        double rangedDouble = safeInput.getRangedDouble("enter a ranged double",0,10000);
        System.out.println("Range double: " + rangedDouble);

    }
}
