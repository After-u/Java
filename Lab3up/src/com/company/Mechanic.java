package com.company;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

public class Mechanic extends Working{

    protected static void launchMenu() throws IOException{
        ArrayList<Eclock> eclockArrayList = new ArrayList<>();
        ArrayList<Cakes> cakesArrayList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("""
                    1) Enter product
                    2) Change product
                    3) Print all
                    4) Show the cheapest product
                    5) Opinion about product
                    6)Exit""");
            switch (reader.readLine()){
                case "1":
                    enter_the_Product(cakesArrayList,eclockArrayList,reader);
                    break;
                case "2":
                    change_the_Product(cakesArrayList,eclockArrayList,reader);
                    break;
                case "3":
                    show_all_products(cakesArrayList,eclockArrayList);
                    break;
                case "4":
                    cheapest_thing(cakesArrayList,eclockArrayList);
                    break;
                case "5":
                    override_goodstuff(cakesArrayList,eclockArrayList,reader);
                    break;
                case "6":
                    reader.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong number!!");
            }
        }
    }
}
