package com.joe.designpattern.compositepattern;

public class MenuTestDrive {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU","Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU","Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU","Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU","Dessert of course!");

        MenuComponent allMenus =new Menu("ALL MENUS","All menus combined");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

//        Add menuItem
        dinerMenu.add(new MenuItem("Veggie Burger and Air Fries","素漢堡配全麥麵包,生菜,番茄跟炸薯條",true,3.99));
        dinerMenu.add(new MenuItem("Soup of the day","一碗例湯加上少許鹽",true,3.69));
        dinerMenu.add(new MenuItem("Burrito","一份墨西哥捲餅,包含班豆,沙沙醬跟酪梨調味醬",true,4.29));

        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("APPLE PIE","一份蘋果派，阿波普露~",true,1.59));

        cafeMenu.add(new MenuItem("素食BLT","素培根,生菜,番茄用軟皮麵包做",true,2.99));
        cafeMenu.add(new MenuItem("BLT","培根,生菜,番茄",false,2.99));
        cafeMenu.add(new MenuItem("例湯","一份例湯,配土豆沙拉",false,3.29));
        cafeMenu.add(new MenuItem("熱狗","熱狗,酸菜,上等起士",false,3.05));

        pancakeHouseMenu.add(new MenuItem("K&B 煎餅早餐","蛋,新鮮蔬菜跟吐司",true,2.99));
        pancakeHouseMenu.add(new MenuItem("Regular 煎餅早餐","蛋跟香腸",false,2.99));
        pancakeHouseMenu.add(new MenuItem("藍莓煎餅","新鮮藍莓與藍莓糖漿與薄煎餅",true,3.49));
        pancakeHouseMenu.add(new MenuItem("鬆餅","鬆餅，可選草莓或藍莓",true,3.59));


        Waitress waitress = new Waitress(allMenus);

        waitress.printMenu();

        waitress.printVegetarianMenu();
    }
}
