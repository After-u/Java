package com.company;

public abstract class Tovar {
    private String name="[NONE]";
    private String article_number="[NONE]";
    private int price = 0;

    Tovar(){}

    Tovar(String name, String article_number, int price){
        this.name=name;
        this.article_number=article_number;
        this.price=price;
    }

    public abstract void good_staff();

    public void show_info(){
        System.out.println("=Product "+ article_number + " information=");
        System.out.println("Name: " + name);
        System.out.println("Article number: " + article_number);
        System.out.println("Price: " + price + "$");
    }

    public void setTovar(String name, String article_number,int price){
        this.name=name;
        this.article_number=article_number;
        this.price=price;
    }

    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    public String getArticle_number(){return article_number;}
    public void setArticle_number(String article_number) {this.article_number = article_number;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
}
