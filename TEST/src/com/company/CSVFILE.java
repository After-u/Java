package com.company;

import java.io.*;
import java.util.*;

class CSVFile {

    final Map<String, Integer> mapWords = new HashMap<>();//Объявляем шабон mapWords
    private List<Map.Entry<String, Integer>> listWords;//Список с шаблоном
    private int count;//Счетчик

    CSVFile(String inFileName, String outFileName) throws IOException {///Конструктор

        read_from_file(inFileName);
        if(outFileName==null){
        showWords(listWords,count);
        }else {
            File file = new File(outFileName);
            try (PrintWriter writer = new PrintWriter(file.getAbsoluteFile())) {
                write_words_to_file(listWords, count, writer);
                System.out.println("\n\tФайл успешно записан!");

            }
        }
    }

    private void read_from_file(String inFileName) throws IOException {///Функция считывающая и подсчитывающая количество слов в из файла

        try (Reader reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(inFileName)))) {///Поток ввода из файла
            StringBuilder builder = new StringBuilder();//Cоздаем класс String builedr для создания строк
            int currentSymbol;

            while ((currentSymbol = reader.read()) != -1) {
                char charSymbol = (char) currentSymbol;
                    builder.append(charSymbol);

                    if (Character.isLetterOrDigit(charSymbol) || charSymbol == '\'') {
                    } else if (builder.length() > 0) {
                    addedMap(mapWords, builder.toString());
                    count++;
                    builder.delete(0, builder.length());
                }
            }

            if (builder.length() > 0) {
                addedMap(mapWords, builder.toString());
                count++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("\n\tФайл не найден!");
        }

        listWords = sortedMap(mapWords);
    }

    private void addedMap(Map<String, Integer> map, String word) {
        int pass = 1;
        Integer curPass = map.get(word);
        if (curPass != null) {
            pass += curPass;
        }
        map.put(word, pass);
    }

    private List<Map.Entry<String, Integer>> sortedMap(Map<String, Integer> map) {///Метод сортирующий список по убыванию
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int rs = o2.getValue().compareTo(o1.getValue());
            if (rs == 0) {
                rs = o1.getKey().compareTo(o2.getKey());
            }
            return rs;
        });
        return list;
    }

    private void write_words_to_file(List<Map.Entry<String, Integer>> list, int numbersOfLines, PrintWriter writer) {///Функция записывающая данные в файл

        writer.printf("%s" + ";" + "%s" + ";" + "%s%n", "Слово", "Количество", "Процентаж");///Вывод загаловков
        for (Map.Entry<String, Integer> aList : list) {
            writer.printf("%s" + ";" + "%s" + ";" + "%.3f%n", aList.getKey(), aList.getValue(), (100.0f * aList.getValue() / numbersOfLines));///Вывод данных
        }
    }

    private void showWords(List<Map.Entry<String, Integer>> list, int numbersOfLines) {///Вывод в консоль

        System.out.printf("%s" +   "%s" +   "%s%n", "Слово      ", "Количество      ", "Процентаж");///Вывод загаловков
        for (Map.Entry<String, Integer> aList : list) {///Перебираем все значения шаблона
            System.out.printf("\t\b%-22s%-14s%.3f%n", aList.getKey(), aList.getValue(), (100.0f * aList.getValue() / numbersOfLines));///Вывод элементов
        }
        System.out.printf("\n\tОбщее количество строк:" + numbersOfLines + "\n");
    }
}
