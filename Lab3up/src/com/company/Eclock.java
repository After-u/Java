package com.company;

public class Eclock extends Tovar {

    private double display_diagonal=0;
    Eclock(){

    }

    Eclock(int display_diagonal){this.display_diagonal=display_diagonal;}

    @Override
    public void good_staff(){System.out.println("Oh this is good product! Oh god i m late!!");}

    @Override
    public void show_info(){
        super.show_info();
        System.out.println("Display diagonal: " + display_diagonal + " dm");
    }

    protected double getDisplay_diagonal() {return display_diagonal;}

    protected void setDisplay_diagonal(double display_diagonal) {this.display_diagonal = display_diagonal;}
}
