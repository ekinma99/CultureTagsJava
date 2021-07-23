import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    Map<String, Runnable> menuMap;
    List<String> menuItemsList;

    public Menu() {
        this.menuMap = new HashMap<>();
        this.menuItemsList = new ArrayList<>();
    }
    
    /**
     * Setup a method to run when a user selects a menu item.
     * Note: calling this method twice on the same menu item replaces
     * the previous runnable.
     * @param menuItem The user's selected menu item
     * @param runOnSelection The action to run upon user selection
     */
    public void onSelect(String menuItem, Runnable runOnSelection) {
        
        // Keep track of the order of menu items
        this.menuItemsList.add(menuItem);

        // Store which method should run upon selection
        this.menuMap.put(menuItem, runOnSelection);
    }

    /**
     * Called when a user selects a menuItem
     * @param selection A number which represents the menu item (Ex: Selecting "1." represents menuItems[0])
     */
    public void select(int selection) {
        String menuItem = this.menuItemsList.get(selection);
        // TODO: Any checking to do here?
        select(menuItem);
    }

    /**
     * Called when a user selects a menuItem
     * @param menuItem The menu item which the user selected
     */
    public void select(String menuItem) {
        
        // Get the action to run which corresponds with the users
        Runnable menuItemToRun = this.menuMap.get(menuItem);

        // Perform the action
        menuItemToRun.run();
    }
}
