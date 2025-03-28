package lt.viko.eif.mjurevicius.ndassignment1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "foodmenu")
public class FoodMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String menuName;
    private String menuDescription;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Foodmenu_Fooditem",
            joinColumns = @JoinColumn(name = "foodmenu_id"),
            inverseJoinColumns = @JoinColumn(name = "fooditem_id")
    )
    List<FoodItem> foodItems;

    public FoodMenu() {
    }

    public FoodMenu(int id, String menuName, String menuDescription, List<FoodItem> foodItems) {
        this.id = id;
        this.menuName = menuName;
        this.menuDescription = menuDescription;
        this.foodItems = foodItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    @Override
    public String toString() {
        return "FoodMenu{" +
                "menuName='" + menuName + '\'' +
                ", menuDescription='" + menuDescription + '\'' +
                ", foodItems=" + foodItems +
                '}';
    }

    public String toStringForClient() {
        String returnMe = "\t" + menuName + "\n\t" +
                menuDescription +
                "\nSelection: \n";
        for (int i = 0; i < foodItems.size(); i++) {
            returnMe += (i + 1) + ")" + foodItems.get(i).toStringForClient();
        }
        return returnMe;
    }
}
