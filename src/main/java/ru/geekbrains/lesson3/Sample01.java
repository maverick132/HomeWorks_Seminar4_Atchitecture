package ru.geekbrains.lesson3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Sample01 {

    public static void main(String[] args) {

    }

}

class ReaderService implements Readable{

    private ArrayList<String> lines;

    public Collection<String> readTextFile(File file){

        //ПРЕДУСЛОВИЕ
        if (!file.exists())
            throw new RuntimeException("Файл не существует.");
        if (file.length() > 5000)
            throw new RuntimeException("Размер файла более 5мб. Чтение файла запрещено.");

        //Выполнение основного кода
        try {
            //.......
            //.......
            lines = new ArrayList<>(); // 11 строк текста

            lines.clear(); // 0 строк

            //ИНВАРИАНТ
            validateResult(lines);
            //.......
            //.......
        }
        catch (Exception e){

        }

        //ПОСТУСЛОВИЕ
        if (lines == null)
            throw new RuntimeException("Ошибка чтения файла.");

        return lines;

    }


    private void validateResult(ArrayList<String> lines){
        if (lines.size() == 0)
            throw new RuntimeException("Файл пуст.");
    }

}

class Module1 implements Readable{

    @Override
    public Collection<String> readTextFile(File file) {
        return null;
    }
}

interface Readable{

    /**
     * Считывает данные из текстового файла
     * @param file текстовый файл
     * @throws RuntimeException исключение при обработке текстового файла
     * @return коллекция строк текстового файла
     */
    Collection<String> readTextFile(File file);

}




