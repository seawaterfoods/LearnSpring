package com.joe.designpattern.singletonpattern;

public enum EnumChocolateBoiler {
    INSTANCE;
    private boolean empty;
    private boolean boiled;


    private EnumChocolateBoiler(){
//        代碼開始時鍋爐是空的
        empty = true;
        boiled = false;
        System.out.println("Get singleton!");
    }

    public void fill(){
//        在鍋爐內填入原料時，鍋爐必須是空的，一但填入原料，
//        就把empty跟boiled標誌設置好。
        if (isEmpty()){
            empty = false;
            boiled = false;
            //在鍋爐中填滿巧克力和牛奶的混和物
        }
    }

    public void boil(){
//      煮混合物時，鍋爐必須是滿的，並且是沒煮過的，
//      一但煮沸後，就把boiled標誌設為true。
        if (!isEmpty()&&!isBoiled()){
//            將爐內物煮沸
            boiled = true;
        }
    }

    public void drain(){
//        鍋爐排出時，必須是滿的(不可以是空的)而且是煮過的，
//        排出完畢後，把empty標誌設回true。
        if (!isEmpty() && isBoiled()){
//            排出煮沸的巧克力和牛奶
            empty =true;
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public boolean isBoiled(){
        return boiled;
    }

    @Override
    public String toString() {
        return "EnumChocolateBoiler{" +
                "empty=" + empty +
                ", boiled=" + boiled +
                '}';
    }
}
