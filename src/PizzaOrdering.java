import java.util.ArrayList;
import java.util.Scanner;

public class PizzaOrdering {
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
            System.out.println("Order added: " + pizzaType + " x " + quantity);
        } else {
            System.out.println("Quantity must be positive");
        }
    }

    public static void updateOrder(ArrayList<Integer> quantities, int quantityIndex , int newQty) {
        if (quantityIndex >= 0 && quantityIndex < quantities.size()){
            if (newQty > 0){
                quantities.set(quantityIndex, newQty);
                System.out.println("Order updated");
            } else {
                System.out.println("Quantity must be positive");
            }
        } else {
            System.out.println("Invalid update");
        }
    }

    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int orderIndex) {
        if (orderIndex >= 0 && orderIndex < quantities.size()) {
            System.out.println("Removed order: " + pizzas.get(orderIndex));
            pizzas.remove(orderIndex);
            quantities.remove(orderIndex);
        } else {
            System.out.println("Invalid remove");
        }
    }

    public static void printOrders (ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        if (pizzas.isEmpty()) {
            System.out.println(" No current orders.");
        } else {
            System.out.println("---- Current Orders ----");
            for (int i = 0; i < pizzas.size(); i++) {
                int numbering = i + 1;
                System.out.println(numbering + ". " + pizzas.get(i) + " x " + quantities.get(i));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Pizza Ordering");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Order");
        System.out.println("5. Exit");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter pizza type: ");
                    String type = scan.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = scan.nextInt();
                    addOrder(pizzas, quantities, type, qty);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int updateOrderIndex = scan.nextInt();
                    System.out.print("New quantity: ");
                    int newQty = scan.nextInt();
                    updateOrder(quantities, updateOrderIndex-1, newQty);
                    break;
                case 3:
                    System.out.print("Enter order index to remove: ");
                    int removeOderIndex = scan.nextInt();
                    removeOrder(pizzas, quantities, removeOderIndex-1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    System.out.println("Thank you");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
}