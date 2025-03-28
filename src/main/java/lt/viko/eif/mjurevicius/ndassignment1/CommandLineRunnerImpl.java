package lt.viko.eif.mjurevicius.ndassignment1;

import lt.viko.eif.mjurevicius.ndassignment1.db.FoodMenuRepository;
import lt.viko.eif.mjurevicius.ndassignment1.menu.FoodSelectionMenu;
import lt.viko.eif.mjurevicius.ndassignment1.model.FoodItem;
import lt.viko.eif.mjurevicius.ndassignment1.model.FoodMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final FoodMenuRepository foodMenuRepository;

    public CommandLineRunnerImpl(FoodMenuRepository foodMenuRepository) {this.foodMenuRepository = foodMenuRepository;}

    @Override
    public void run(String... args) throws Exception {
        foodMenuRepository.findAll();

        List<FoodMenu> foodMenuList = foodMenuRepository.findAll();
        List<FoodItem> foodItems = new ArrayList<>();

        FoodSelectionMenu foodSelectionMenu = new FoodSelectionMenu();
        foodSelectionMenu.foodItemFrontMenuSelection(foodItems, foodMenuList);

    }
}
