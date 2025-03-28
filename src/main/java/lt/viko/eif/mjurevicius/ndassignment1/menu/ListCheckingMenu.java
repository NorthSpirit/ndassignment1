package lt.viko.eif.mjurevicius.ndassignment1.menu;

import lt.viko.eif.mjurevicius.ndassignment1.Utility.Parser;
import lt.viko.eif.mjurevicius.ndassignment1.model.FoodItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ListCheckingMenu {
    List<FoodItem> foodItems;

    public ListCheckingMenu(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    private String foodItemList(Scanner input)
    {
        System.out.println("Input number of item to remove from order.");
        System.out.println("Items in your order:");
        for (int i = 0; i < foodItems.size(); i++) {
            System.out.println((i + 1) + ")" + foodItems.get(i).toString());
        }
        System.out.println("E) Exit the menu.");
        return input.nextLine();
    }

    public void showMenu()
    {
        Scanner input = new Scanner(System.in);
        String userChoice = "";
        Parser parser = new Parser();
        do {
            int chosenItem = parser.tryParseInt(userChoice) - 1;
            if (chosenItem >= 0 && chosenItem < foodItems.size()) {
                foodItems.remove(chosenItem);
            }
        } while (!userChoice.equals("E"));
    }
}
