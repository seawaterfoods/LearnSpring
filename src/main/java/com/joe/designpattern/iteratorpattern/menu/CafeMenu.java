package com.joe.designpattern.iteratorpattern.menu;

import com.joe.designpattern.iteratorpattern.item.MenuItem;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu implements Menu{
//    咖啡廳菜單用hashtable儲存的
    Hashtable menuItems = new Hashtable();

//    就跟其他menu依樣，菜單項目在構造器中初始化
    public CafeMenu(){
        addItem("Veggie Burger and Air Fries","素漢堡配全麥麵包,生菜,番茄跟炸薯條",true,3.99);
        addItem("Soup of the day","一碗例湯加上少許鹽",true,3.69);
        addItem("Burrito","一份墨西哥捲餅,包含班豆,沙沙醬跟酪梨調味醬",true,4.29);
    }

//    在這裡創建新的菜單項目,並將它加入菜單列表中
    public void addItem(String name,String description,boolean vegetarian,double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(menuItem.getName(),menuItem);
    }


//    我們在這裡實現了createIterator()方法，注意我們不是取到整個Hashtable的Iterator,而是取到有值部份的Iterator
    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
