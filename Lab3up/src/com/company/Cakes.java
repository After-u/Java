package com.company;

public class Cakes extends Tovar{
    private String type_of_cake="[NONE]";

    Cakes(){

    }
    Cakes(String type_of_cake){this.type_of_cake=type_of_cake;}

    @Override
    public void good_staff(){System.out.println("This product is good. So tasty!!");}

    @Override
    public void show_info(){
        super.show_info();
        System.out.println("Type of cake: " + type_of_cake);
    }

    protected String getType_of_cake() {return type_of_cake;}
    protected void setType_of_cake(String type_of_cake) {this.type_of_cake = type_of_cake;}
}
