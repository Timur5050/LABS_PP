import Menus.Menu;


public class Main {
    private static Menu menu = new Menu();

    public static void setMenu(Menu newMenu) {
        menu = newMenu;
    }

    public static void main(String[] args) {
        menu.menu();
    }
}