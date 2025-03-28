package lt.viko.eif.mjurevicius.ndassignment1.menu;

import lt.viko.eif.mjurevicius.ndassignment1.Utility.Randomizer;
import lt.viko.eif.mjurevicius.ndassignment1.model.FoodItem;
import lt.viko.eif.mjurevicius.ndassignment1.model.FoodMenu;
import lt.viko.eif.mjurevicius.ndassignment1.model.Foodorder;
import lt.viko.eif.mjurevicius.ndassignment1.service.ClientFileSender;
import lt.viko.eif.mjurevicius.ndassignment1.service.ClientPaymentProcessor;
import lt.viko.eif.mjurevicius.ndassignment1.service.XMLTransformationService;

import java.util.List;
import java.util.Scanner;

public class FoodSelectionMenu {
    private boolean startAgain = false;
    private ClientFileSender clientFileSender;

    //Main screen
    private void foodItemFrontMenuDisplay(List<FoodMenu> foodMenuList)
    {
        System.out.println("Please select menu you want to order from:");
        for (int i = 0; i < foodMenuList.size(); i++) {
            System.out.println((i + 1) + ") " + foodMenuList.get(i).getMenuName());
        }
        System.out.println("S) See your order.");
        System.out.println("F) Finalize order.");
        System.out.println("C) Clear order.");
        System.out.println("Q) Exit the menu.");
    }

    public void foodItemFrontMenuSelection(List<FoodItem> foodItemOrder,  List<FoodMenu> foodMenuList)
    {
        Scanner input = new Scanner(System.in);
        String choice = "";
        do {
            if (startAgain) {
                foodItemOrder.clear();
                startAgain = false;
            }
            foodItemFrontMenuDisplay(foodMenuList);
            choice = input.nextLine();
            try {
                int selectedMenu = Integer.parseInt(choice) - 1;
                if (selectedMenu >= 0 && selectedMenu < foodMenuList.size()) {
                    foodItemSelectFromMenuFull(foodMenuList.get(selectedMenu), foodItemOrder);
                } else {
                    System.out.println("Invalid menu selection.");
                }
            }  catch (NumberFormatException e) {
                if (choice.equalsIgnoreCase("S")) {
                    showMyOrderMenuDisplay(foodItemOrder);
                } else if (choice.equalsIgnoreCase("F")) {
                    if (foodItemOrder.isEmpty()) {
                        System.out.println("There are no items in your order.");
                    } else {
                        finalizationSelectionMenu(foodItemOrder);
                    }
                }
                else if (choice.equalsIgnoreCase("C")) {
                    System.out.println("Your order has been cleared.");
                    foodItemOrder.clear();
                }
                else if (choice.equalsIgnoreCase("Q")){
                    System.out.println("Exiting.");
                }
                else {
                    System.out.println("Invalid selection.");
                }
            }

        } while(!choice.equalsIgnoreCase("Q"));
    }



    //Display menu

    private void foodItemSelectFromMenuDisplay(FoodMenu foodMenu)
    {
        System.out.println("Input a number of item you want to get:");
        System.out.println(foodMenu.toStringForClient());
        System.out.println("E) Exit the menu.");
    }

    public void foodItemSelectFromMenuFull(FoodMenu foodMenu, List<FoodItem> foodItemOrder){
        Scanner input = new Scanner(System.in);
        String choice = "";
        do  {
            foodItemSelectFromMenuDisplay(foodMenu);
            choice = input.nextLine();
            try {
                int selectedItem = Integer.parseInt(choice) - 1;
                foodItemSelectFromMenuPicker(foodMenu.getFoodItems(), foodItemOrder, selectedItem);
            }  catch (NumberFormatException e) {
                if (!choice.equalsIgnoreCase("E")) {
                    System.out.println("Invalid selection.");
                }
            }
        } while (!choice.equalsIgnoreCase("E"));
    }

    private void foodItemSelectFromMenuPicker(List<FoodItem> foodItemMenu, List<FoodItem> foodItemOrder, int index)
    {
        if (index >= foodItemMenu.size() || index < 0) {
            System.out.println("Invalid selection.");
        }
        else {
            foodItemOrder.add(foodItemMenu.get(index));
            System.out.println("New item added to your order.");
        }
    }

    //My Order menu


    public void showMyOrderMenuDisplay(List<FoodItem> foodItemOrder)
    {
        if (foodItemOrder.isEmpty()) {
            System.out.println("There are no items in your order.");
        }
        else {
            System.out.println("Items in your order:\n");
            for (int i = 0; i < foodItemOrder.size(); i++) {
                System.out.print((i + 1) + ")" + foodItemOrder.get(i).toStringForClient());
            }
            System.out.println(" ");
        }
    }

    //Finalization menu

    public void finalizationSelectionMenu(List<FoodItem> foodItemOrder)
    {
        int table = 0;
        Scanner input = new Scanner(System.in);
        String choice = "";
        do {
            finalizationTableSelectionMenuDisplay();
            choice = input.nextLine().toLowerCase();
            switch  (choice) {
                case "1":
                    table  = Randomizer.randomInt(1, 20);
                    finalizeOrder(table, foodItemOrder);
                    break;
                case "2":
                    table  = Randomizer.randomInt(21, 30);
                    finalizeOrder(table, foodItemOrder);
                    break;
                case "3":
                    table  = Randomizer.randomInt(21, 30);
                    finalizeOrder(table, foodItemOrder);
                    break;
                case "4":
                    table  = -1;
                    finalizeOrder(table, foodItemOrder);
                    break;
                case "b":
                    System.out.println("Returning to the previous menu.");
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while(!choice.equals("b") && !startAgain);
    }

    public void finalizationTableSelectionMenuDisplay()
    {
        System.out.println("Which table would you like to choose?");
        System.out.println("1) Small table (1-2 people)");
        System.out.println("2) Medium table (1-4 people)");
        System.out.println("3) Large table (1-8 people - Recommended for 4 or more people)");
        System.out.println("4) Order to go");
        System.out.println("B) Back");
    }

    public  void finalizeOrder(int tableNumber, List<FoodItem> foodItemOrder)
    {
        Foodorder foodorder = new Foodorder(tableNumber, foodItemOrder);
        System.out.println("There are items in your order:");
        for (int i = 0; i < foodItemOrder.size(); i++) {
            System.out.print((i + 1) + ")" + foodItemOrder.get(i).toStringForClient());
        }
        System.out.println("Total sum of your order: " + foodorder.getTotalSum());
        System.out.println("(Sum without PVM: " + foodorder.getBaseSum() + ")");
        System.out.println("Do you want to finalize the order? (Y/N)");
        Scanner input = new Scanner(System.in);
        String choice = "";
        do {
            choice = input.nextLine().toLowerCase();
            switch (choice)
                {
                case "y":
                    System.out.println("PAYMENT MENU TO IMPLEMENT!");
                    boolean paymentPassed = ClientPaymentProcessor.paymentProcess(foodorder.getTotalSum());
                    if (paymentPassed) {
                        foodorder.setStatus("Paid");
                        System.out.println("Payment successfully received, please enjoy your order!");
                    } else {
                        foodorder.setStatus("Finished");
                        System.out.println("Payment failed.");
                    }
                    String fileName = foodorder.formName();
                    XMLTransformationService.transform(foodorder, fileName);
                    clientFileSender.fileSend(fileName);
                    startAgain = true;
                    break;
                case "n":
                    System.out.println("Returning.");
                    startAgain = true;
                    break;
                    default:
                    System.out.println("Invalid selection.");
                    break;
                }
        } while (!choice.equalsIgnoreCase("N") && !startAgain);
    }
}
