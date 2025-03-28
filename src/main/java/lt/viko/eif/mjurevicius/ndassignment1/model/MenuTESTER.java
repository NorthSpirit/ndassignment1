package lt.viko.eif.mjurevicius.ndassignment1.model;

import java.util.List;

public class MenuTESTER {
    List<FoodItem> foodItemlistMain = List.of(
            new FoodItem(1, "Chicken breast", 14.25f, 0.09f),
            new FoodItem(2, "Beef Steak", 32.50f, 0.09f),
            new FoodItem(3, "Salmon Steak", 16.50f, 0.09f)
    );

    List<FoodItem> foodItemlistSoup = List.of(
            new FoodItem(4, "Borch Soup", 6.25f, 0.09f),
            new FoodItem(5, "Creamy Tomato and Basil Soup", 7.70f, 0.09f),
            new FoodItem(6, "Salmon Soup", 12.50f, 0.09f)
    );

    List<FoodItem> foodItemlistDrinks = List.of(
            new FoodItem(7, "Coca-Cola", 2.50f, 0.09f),
            new FoodItem(8, "Sprite", 2.50f, 0.09f),
            new FoodItem(9, "Orange Juice", 3.50f, 0.09f),
            new FoodItem(10, "Beer", 5.00f, 0.21f)
    );

    List<FoodItem> foodItemlistSnacks = List.of(
            new FoodItem(11, "French Fries", 3.50f, 0.09f),
            new FoodItem(12, "Garlic Bread", 4.00f, 0.09f),
            new FoodItem(13, "Mozzarella Sticks", 5.50f, 0.09f),
            new FoodItem(14, "Chicken Wings", 6.75f, 0.09f)
    );

    public List<FoodItem> getFoodItemlistMain() {
        return foodItemlistMain;
    }

    public void setFoodItemlistMain(List<FoodItem> foodItemlistMain) {
        this.foodItemlistMain = foodItemlistMain;
    }

    public List<FoodItem> getFoodItemlistSoup() {
        return foodItemlistSoup;
    }

    public void setFoodItemlistSoup(List<FoodItem> foodItemlistSoup) {
        this.foodItemlistSoup = foodItemlistSoup;
    }

    public List<FoodItem> getFoodItemlistDrinks() {
        return foodItemlistDrinks;
    }

    public void setFoodItemlistDrinks(List<FoodItem> foodItemlistDrinks) {
        this.foodItemlistDrinks = foodItemlistDrinks;
    }

    public List<FoodItem> getFoodItemlistSnacks() {
        return foodItemlistSnacks;
    }

    public void setFoodItemlistSnacks(List<FoodItem> foodItemlistSnacks) {
        this.foodItemlistSnacks = foodItemlistSnacks;
    }
}
