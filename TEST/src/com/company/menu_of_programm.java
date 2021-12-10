package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class menu_of_programm {
    protected static void launch_menu() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Здравствуйте!!");
        boolean while_stop = true;
        while(while_stop){
            System.out.println("1. Считать информацию с файла"+
                    "\n2. Выход");

            switch (reader.readLine()){
                case "1"->{
                read_menu(reader);
                }
                case "2"->{
                    System.out.println("До свидания!!!");
                    while_stop=false;
                }
                default -> {
                    System.out.println("Такого пункта в меню нет!!!");
                }
            }
        }
    }

    protected static void read_menu(BufferedReader reader) throws IOException{
        System.out.println("Что бы вы хотели сделать?");
        boolean while_stop=true;
        while (while_stop){
            System.out.println("1. Вывести результат работы программы в консоль" +
                    "\n2. Вывести результат работы программы в файл" +
                    "\n3. Выход");
            switch (reader.readLine()){
                case "1"-> {
                    boolean stopper = true;

                    while (stopper) {
                        try {
                            System.out.print("Введите название файла, который хотитет обработать(Формат \".txt\"): ");
                            String inFileName = reader.readLine();
                            File f = new File("C:\\Users\\Олег\\IdeaProjects\\TEST\\" + inFileName);
                            if ((inFileName.substring((inFileName.length() - 4)).equals(".txt")) && f.isFile()) {
                                new CSVFile(inFileName, null);
                                stopper=false;
                            } else {
                                System.out.println("Файл должен быть записан в таком формате: file.txt");
                            }
                        } catch (StringIndexOutOfBoundsException e){
                            System.out.println("Имя файла должно содержать больше 4 символов!");
                        }
                    }
                }
                case "2"-> {
                    boolean rez = true;
                    while (rez) {

                        System.out.print("Введите название файла, который хотитет обработать(Формат \".txt\"): ");
                        String inFileName = reader.readLine();
                        File f = new File("C:\\Users\\Олег\\IdeaProjects\\TEST\\" + inFileName);

                        try {

                            if ((inFileName.substring((inFileName.length() - 4)).equals(".txt")) && f.isFile()) {
                                System.out.print("Введите название файла, который будет результирующим: ");
                                String outFileName = reader.readLine();
                                if (outFileName.substring((outFileName.length() - 4)).equals(".csv")) {
                                    new CSVFile(inFileName, outFileName);
                                    rez = false;
                                } else {
                                    System.out.println("Формат файла должен быть \".csv\"");
                                }
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                            System.out.println("Имя файла должно содержать название и разрешение \"csv\"!");
                        }
                    }
                }
                case "3"->{
                    while_stop=false;
                }
                default -> {
                    System.out.println("Такого пункта в меню нет!!!");
                }
            }
        }
    }

}
