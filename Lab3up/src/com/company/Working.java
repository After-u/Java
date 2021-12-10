package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Working {

    protected static void change_the_Product(ArrayList<Cakes> cakesArrayList, ArrayList<Eclock> eclockArrayList, BufferedReader reader) throws IOException {
        System.out.println("All products: ");
        show_all_products(cakesArrayList, eclockArrayList);
        boolean stop_while = true;
        while (stop_while == true) {
            System.out.println("Which product you want to change: ");
            System.out.println("""
                    1)Cakes
                    2)Eclocks
                    3)Exit the main menu""");
            switch (reader.readLine()) {
                case "1" -> {
                    if (cakesArrayList.isEmpty()) {
                        System.out.println("There is nothing to change in cakes!!!");
                        break;
                    }
                    String change_article = "";
                    while (true) {
                        System.out.println("Enter the article number: ");
                        String temp = reader.readLine();
                        if (temp.matches("[0-9]{5}")) {
                            change_article = temp;
                        } else {
                            System.out.println("Your article number is wrong!");
                            continue;
                        }
                        break;
                    }
                    for (int i = 0; i < cakesArrayList.size(); i++) {
                        if (change_article.equals(cakesArrayList.get(i).getArticle_number())) {
                            edit_any_tovar(cakesArrayList.get(i),reader);
                            break;
                        }
                    }
                }
                case "2" -> {
                    if (eclockArrayList.isEmpty()) {
                        System.out.println("There is nothing to change in Eclocks");
                        break;
                    }
                    String change_article = "";
                    while (true) {
                        System.out.println("Enter the article number: ");
                        String temp = reader.readLine();
                        if (temp.matches("[0-9]{5}")) {
                            change_article = temp;
                        } else {
                            System.out.println("Your article number is wrong!");
                            continue;
                        }
                        break;
                    }
                    for (int i = 0; i < eclockArrayList.size(); i++) {
                        if (change_article.equals(eclockArrayList.get(i).getArticle_number())) {
                            edit_any_tovar(eclockArrayList.get(i),reader);
                            break;
                        }
                    }
                }
                case "3" -> {
                    stop_while = false;
                }
                default -> System.out.println("Wrong number");
            }
        }
    }

    protected static void enter_the_Product(ArrayList<Cakes> cakesArrayList, ArrayList<Eclock> eclockArrayList, BufferedReader reader) throws IOException {
        int type = chooseTovarType(reader);
        if(type == 1){
            eclockArrayList.add((Eclock) create_any_Tovar(reader,type));
        }
        else if(type==2){
            cakesArrayList.add((Cakes) create_any_Tovar(reader,type));
        }
        else System.out.println("No such type of cars!");
    }

    protected static void show_all_products(ArrayList<Cakes> cakesArrayList, ArrayList<Eclock> eclockArrayList) {
        System.out.println("Cakes: ");
        if (cakesArrayList.isEmpty()) {
            System.out.println("Nothing here!");
        }
        for (Cakes cakes : cakesArrayList) {
            cakes.show_info();
            System.out.println("=======");
        }

        System.out.println("\nEclocks: ");
        if (eclockArrayList.isEmpty()) {
            System.out.println("Nothing here!");
            return;
        }
        for (Eclock eclock : eclockArrayList) {
            eclock.show_info();
            System.out.println("=======");
        }
    }

    protected static void cheapest_thing(ArrayList<Cakes> cakesArrayList, ArrayList<Eclock> eclockArrayList) {
        int cheap = 1000000000;
        String article = "";
        if (cakesArrayList.isEmpty()) {
            System.out.println("Nothing to calculate in cakes!!!");
        } else {
            for (Cakes cakes : cakesArrayList) {
                if (cheap > cakes.getPrice()) {
                    cheap = cakes.getPrice();
                    article = cakes.getArticle_number();
                }
            }
        }

        if (eclockArrayList.isEmpty()) {
            System.out.println("Nothing to calculate in Eclocks!!!");
        } else {
            for (Eclock eclocks : eclockArrayList) {
                if (cheap > eclocks.getPrice()) {
                    cheap = eclocks.getPrice();
                    article = eclocks.getArticle_number();
                }
            }


        }
        System.out.println("The cheapest product is №" + article + " his price is " + cheap + "$");
    }

    protected static void override_goodstuff(ArrayList<Cakes> cakesArrayList, ArrayList<Eclock> eclockArrayList, BufferedReader reader) throws IOException {
        System.out.println("All products: ");
        show_all_products(cakesArrayList, eclockArrayList);
        boolean stop_while = true;
        while (stop_while == true) {
            System.out.println("About what product you want to read an opinion: ");
            System.out.println("""
                    1)Cakes
                    2)Eclocks
                    3)Exit the main menu""");
            switch (reader.readLine()) {
                case "1" -> {
                    if (cakesArrayList.isEmpty()) {
                        System.out.println("There is nothing in cakes!!!");
                        break;
                    }
                    String change_article = "";
                    while (true) {
                        System.out.println("Enter the article number: ");
                        String temp = reader.readLine();
                        if (temp.matches("[0-9]{5}")) {
                            change_article = temp;
                        } else {
                            System.out.println("Your article number is wrong!");
                            continue;
                        }
                        break;
                    }
                    for (int i = 0; i < cakesArrayList.size(); i++) {
                        if (change_article.equals(cakesArrayList.get(i).getArticle_number())) {
                            System.out.println("Opinion about Product Eclock №" + cakesArrayList.get(i).getArticle_number());
                            cakesArrayList.get(i).good_staff();
                            break;
                        }
                    }
                }
                case "2" -> {
                    if (eclockArrayList.isEmpty()) {
                        System.out.println("There is nothing in Eclocks");
                        break;
                    }
                    String change_article = "";
                    while (true) {
                        System.out.println("Enter the article number: ");
                        String temp = reader.readLine();
                        if (temp.matches("[0-9]{5}")) {
                            change_article = temp;
                        } else {
                            System.out.println("Your article number is wrong!");
                            continue;
                        }
                        break;
                    }
                    for (int i = 0; i < eclockArrayList.size(); i++) {
                        if (change_article.equals(eclockArrayList.get(i).getArticle_number())) {
                            System.out.println("Opinion about Product Eclock №" + eclockArrayList.get(i).getArticle_number());
                            eclockArrayList.get(i).good_staff();
                            break;
                        }
                    }
                }
                case "3" -> {
                    stop_while = false;
                }
            }
        }

    }

    /*private static Cakes creat_Product_Cakes(BufferedReader reader) throws IOException{
        String name;
        while (true){
            System.out.println("Enter the name of product: ");
            String temp = reader.readLine();
            if(temp.matches("[A-Za-z]+")){
                name = temp;
            } else{
                System.out.println("Only words in name!!!");
                continue;
            }
            break;
        }

        String article;
        while (true){
            System.out.println("Enter the article number (5 numbers): ");
            String temp = reader.readLine();
            if (temp.matches("[0-9]{5}")){
                article=temp;
            } else {
                System.out.println("Your article number is wrong!");
                continue;
            }
            break;
        }

        int price;
        while (true){
            System.out.println("Enter price: ");
            try {
                price = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException|IOException ignored){
                System.out.println("Price should be a number!!!");
                continue;
            }

            if (!Integer.toString(price).matches("[1-9][0-9]*")) {
                System.out.println("Only integer in price!");
                continue;
            }
            break;
        }

        String type_of_cake;
        while (true){
            System.out.println("Enter the type of cake: ");
            String temp = reader.readLine();
            if (temp.matches("[A-Za-z]+")){
                type_of_cake=temp;
            }else{
                System.out.println("Only words in type of cake");
                continue;
            }
            break;
        }
        Cakes newCakes = new Cakes();
        newCakes.setTovar(name,article,price);
        newCakes.setType_of_cake(type_of_cake);
        return newCakes;
    }*/

    /*private static Eclock creat_Product_Eclock(BufferedReader reader) throws IOException{
        String name;
        while (true){
            System.out.println("Enter the name of product: ");
            String temp = reader.readLine();
            if(temp.matches("[A-Za-z]+")){
                name = temp;
            } else{
                System.out.println("Only words in name!!!");
                continue;
            }
            break;
        }

        String article;
        while (true){
            System.out.println("Enter the article number (5 numbers) : ");
            String temp = reader.readLine();
            if (temp.matches("[0-9]{5}")){
                article=temp;

            } else {
                System.out.println("Your article number is wrong!");
                continue;
            }
            break;
        }

        int price;
        while (true){
            System.out.println("Enter price: ");
            try {
                price = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException|IOException ignored){
                System.out.println("Price should be a number!!!");
                continue;
            }

            if (!Integer.toString(price).matches("[1-9][0-9]*")) {
                System.out.println("Only integer in price!");
                continue;
            }
            break;
        }

        double diagonal;
        while (true) {
            System.out.print("Enter diagonal: \n");
            try {
                diagonal = Double.parseDouble(reader.readLine());
                if (diagonal < 0) {
                    System.out.print("Diagonal sholdnt be negative");
                    continue;
                } else {
                    break;
                }

            } catch (NumberFormatException | IOException ignored) {
                System.out.print("Diagonal should be double");
            }
        }

        Eclock newClock= new Eclock();
        newClock.setTovar(name,article,price);
        newClock.setDisplay_diagonal(diagonal);
        return newClock;
    }*/

    private static Object create_any_Tovar(BufferedReader reader, int type) throws IOException {
        String name;
        while (true) {
            System.out.println("Enter the name of product: ");
            String temp = reader.readLine();
            if (temp.matches("[A-Za-z]+")) {
                name = temp;
            } else {
                System.out.println("Only words in name!!!");
                continue;
            }
            break;
        }

        String article;
        while (true) {
            System.out.println("Enter the article number (5 numbers): ");
            String temp = reader.readLine();
            if (temp.matches("[0-9]{5}")) {
                article = temp;
            } else {
                System.out.println("Your article number is wrong!");
                continue;
            }
            break;
        }

        int price;
        while (true) {
            System.out.println("Enter price: ");
            try {
                price = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException | IOException ignored) {
                System.out.println("Price should be a number!!!");
                continue;
            }

            if (!Integer.toString(price).matches("[1-9][0-9]*")) {
                System.out.println("Only integer in price!");
                continue;
            }
            break;
        }
        switch (type) {
            case 1 :
                double diagonal = 0;
                while (true) {
                    System.out.print("Enter diagonal: \n");
                    try {
                        diagonal = Double.parseDouble(reader.readLine());
                        if (diagonal < 0) {
                            System.out.print("Diagonal sholdnt be negative");
                            continue;
                        } else {
                            break;
                        }

                    } catch (NumberFormatException | IOException ignored) {
                        System.out.print("Diagonal should be double");
                    }

                }
                Eclock newEclock = new Eclock();
                newEclock.setTovar(name, article, price);
                newEclock.setDisplay_diagonal(diagonal);

                System.out.println("New Eclock is entered!\n");
                return newEclock;

            case 2 :
                String type_of_cake;
                while (true) {
                    System.out.println("Enter the type of cake: ");
                    String temp = reader.readLine();
                    if (temp.matches("[A-Za-z]+")) {
                        type_of_cake = temp;
                    } else {
                        System.out.println("Only words in type of cake");
                        continue;
                    }
                    break;
                }
                Cakes newCakes = new Cakes();
                newCakes.setTovar(name, article, price);
                newCakes.setType_of_cake(type_of_cake);
                System.out.println("New Cakes is entered!\n");
                return newCakes;


            default :
                System.exit(1);
            return 0;
        }

    }

    private static void edit_any_tovar(Object tovar, BufferedReader reader) throws IOException{
    System.out.println("What we gona change in [" + ((Tovar)tovar).getArticle_number() + "] ?");
    boolean whileBool = true;
    while(whileBool){
        if(tovar instanceof Eclock){
            System.out.println("1)Name - [" + ((Eclock) tovar).getName() + "]" +
                    "\n2)Article number - [" + ((Eclock) tovar).getArticle_number() + "]" +
                    "\n3)Price - [" + ((Eclock) tovar).getPrice() + "$]" +
                    "\n4)Display diagonal - [" + ((Eclock) tovar).getDisplay_diagonal() + "]" +
                    "\n5)Exit the previous menu");
        }else{
            System.out.println("1)Name - [" + ((Cakes) tovar).getName() + "]" +
                    "\n2)Article number - [" + ((Cakes) tovar).getArticle_number() + "]" +
                    "\n3)Price - [" + ((Cakes) tovar).getPrice() + "$]" +
                    "\n4)Type of the cake - [" + ((Cakes) tovar).getType_of_cake() + "]" +
                    "\n5)Exit the previous menu");
        }
        String what_to_edit = reader.readLine();
        if (what_to_edit.matches("[1-3]")){
            edit_tovar_first(what_to_edit,tovar,reader);
        } else {
            if (tovar instanceof Eclock){
                switch (what_to_edit){
                    case "4"->{
                        double diagonal;
                        while (true) {
                            System.out.print("Enter diagonal: \n");
                            try {
                                diagonal = Double.parseDouble(reader.readLine());
                                if (diagonal < 0) {
                                    System.out.print("Diagonal cant be negative");
                                    continue;
                                } else {
                                    break;
                                }

                            } catch (NumberFormatException | IOException ignored) {
                                System.out.print("Diagonal should be double");
                            }
                        }
                        ((Eclock) tovar).setDisplay_diagonal(diagonal);
                        }
                        case "5"->{
                            whileBool=false;
                    }
                    default -> {
                        System.out.println("No such parameter!");
                    }
                }
            } else{
                switch (what_to_edit){
                    case "4" -> {
                        String type_of_cake;
                        while (true) {
                            System.out.println("Enter the type of cake: ");
                            String temp = reader.readLine();
                            if (temp.matches("[A-Za-z]+")) {
                                type_of_cake = temp;
                            } else {
                                System.out.println("Only words in type of cake");
                                continue;
                            }
                            break;
                        }
                        ((Cakes) tovar).setType_of_cake(type_of_cake);
                    }
                    case "5" ->{
                        whileBool=false;
                    }
                    default -> {
                        System.out.println("No such parameter!");
                    }
                }

            }
        }
    }
    }

    private static void edit_tovar_first(String punct, Object tovar, BufferedReader reader)throws  IOException{
        switch (punct){
            case "1" -> {
                String name;
                System.out.println("Enter the new name for product: ");
                while (true) {
                    System.out.println("Enter the name of product: ");
                    String temp = reader.readLine();
                    if (temp.matches("[A-Za-z]+")) {
                        name = temp;
                    } else {
                        System.out.println("Only words in name!!!");
                        continue;
                    }
                    break;
                }
                ((Tovar) tovar).setName(name);
            }
            case "2" -> {
                String article;
                while (true) {
                    System.out.println("Enter the new article number (5 numbers): ");
                    String temp = reader.readLine();
                    if (temp.matches("[0-9]{5}")) {
                        article = temp;
                    } else {
                        System.out.println("Your article number is wrong!");
                        continue;
                    }
                    break;
                }
                ((Tovar) tovar).setArticle_number(article);
            }
            case "3" -> {
                int price;
                while (true) {
                    System.out.println("Enter the new price: ");
                    try {
                        price = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException | IOException ignored) {
                        System.out.println("Price should be a number!!!");
                        continue;
                    }

                    if (!Integer.toString(price).matches("[1-9][0-9]*")) {
                        System.out.println("Only integer in price!");
                        continue;
                    }
                    break;
                }
                ((Tovar) tovar).setPrice(price);
            }
        }
    }

    private static int chooseTovarType (BufferedReader reader){
            while (true) {
                System.out.println("What element you want to create:\n");
                System.out.println("1. Eclock\n2. Cakes");
                try {
                    return Integer.parseInt(reader.readLine());
                } catch (NumberFormatException | IOException ignored) {
                    System.out.println("Wrong number format!");
                }
            }
        }
    }

