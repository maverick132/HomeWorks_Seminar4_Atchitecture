package ru.geekbrains.lesson3;

import java.util.ArrayList;

public class Sample02 {

    public static void main(String[] args) {

    }

}

/**
 * Информация о детали
 */
class ComponentInfo{

    private int id;
    private String description;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ComponentInfo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("#%d - %s", id, description);
    }
}

class FactoryProvider{
    private ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++){
            components.add(new ComponentInfo(900000 + i, String.format("component description %d", 900000 + i)));
        }
        for (int i = 0; i < 5; i++){
            components.add(new ComponentInfo(1000 + i, String.format("component description %d", 1000 + i)));
        }
    }

    public ComponentInfo getComponentInfo(int id){

        //ПРЕДУСЛОВИЕ
        if (id <= 0)
            throw new RuntimeException("Некорректный номер детали.");

        if (String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но устарела и более не выпускается.");

        // Выполнение основной подпрограммы ...
        ComponentInfo componentInfo  = null;
        for (ComponentInfo component : components){
            if (component.getId() == id){
                componentInfo = component;
            }
        }

        //ПОСТУСЛОВИЕ
        if (componentInfo == null)
            throw new RuntimeException("Деталь не найдена.");

        return componentInfo;
    }

}



class DealerProvider{

    private final FactoryProvider factoryProvider;

    public DealerProvider(FactoryProvider factoryProvider){
        this.factoryProvider = factoryProvider;
    }

    public ComponentInfo getComponent(int id){

        //ПРЕДУСЛОВИЕ


        //TODO: В рамках контрактного программирования, мы не проверяем ПЕРЕДАВАЕМЫЕ (в другой модуль) данные
        // Выполнение основной подпрограммы ...
        /*if (id <= 0 || String.valueOf(id).length() < 6)
            throw new RuntimeException("Некорректный номер детали.");*/
        ComponentInfo component =  factoryProvider.getComponentInfo(id);
        // ...
        // ...
        //component.Set ...
        component = null;



        //ПОСТУСЛОВИЕ
        if (component == null){
            throw new RuntimeException("Деталь не найдена.");
        }


        return component;

    }

}