package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

/*        list.addInBeginning("Head");
        list.addInBeginning(333);
        list.addInBeginning(333);
        list.addInBeginning(333);
        list.addInBeginning(333);
        list.addInEnd(245);
        list.addInEnd(111);
        list.addInEnd("How are you?");
        list.addInEnd("Tail");
        list.printAllDirectOrder();
        System.out.println("");
        list.remove(333);
        list.printAllDirectOrder();
        System.out.println("print");
        list.printAllReverseOrder();*/


        System.out.println("1). Проверим добавление значений в начало списка и в конец, а также вывод всех значений на печать:");
        list.addInBeginning(333);
        list.addInBeginning("Head");
        list.addInEnd(245);
        list.addInEnd(111);
        list.addInEnd("How are you?");
        list.addInEnd("Tail");
        list.printAllDirectOrder();

        System.out.println("2). Извлечение значения из начала списка без его удаления из списка:");
        Object i = list.extValueFromTheBeginningWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную");
        System.out.println("Значение осталось в списке:");
        list.printAllDirectOrder();

        System.out.println("3). Извлечение значения из начала списка с удалением его из списка:");
        i = list.extValueFromTheBeginningWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAllDirectOrder();

        System.out.println("4). Извлечение значения c конца списка без его удаления:");
        i = list.extValueFromTheEndWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение осталось в списке:");
        list.printAllDirectOrder();

        System.out.println("5). Извлечение значения с конца списка с удалением его из списка:");
        i = list.extValueFromTheEndWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAllDirectOrder();

        System.out.println("6). Определим, является ли список пустым, или нет:");
        System.out.println("Список пуст? - " + (list.empty()? "Да!":"Нет!" ));

        System.out.println("7). Определим, содержит ли список заданное значение, или нет:");
        System.out.println("Содержит ли список значенеие 245? - " + (list.searchValue(245)? "Да!\n":"Нет!\n") +
                "А значение 777? - " + (list.searchValue(777)? "Да!":"Нет!"));

       System.out.println("8). Удалим заданное значение из списка, например 245: ");
        list.remove(245);
        list.printAllDirectOrder();
        System.out.println("Удалим несуществующее значение из списка, например 7776: ");
        list.remove(7776);
        System.out.println("Ничего не произошло.");

        System.out.println("9). Проверим метод, который добавляет все значения (100,200,300) заданного массива в начало списка. Порядок значений дол-\n" +
                "жен сохраняться — первое значение массива должно стать первым значением списка:");
        list.addAllArrayValuesToTheBeginning(100,200,300);
        list.printAllDirectOrder();



        System.out.println("10). Проверим метод, который добавляет все значения (1,2,3) заданной коллекции в начало списка с сохранением порядка:");
        List<Object> test = new ArrayList<>();
        Collections.addAll(test,1,2,3);
        list.addAllCollectionValuesToTheBeginning(test);
        list.printAllDirectOrder();

        System.out.println("11). Проверим метод, который добавляет все значения (400,500,600) заданного массива в конец списка с сохранением порядка:");
        list.addAllArrayValuesToTheEnd(400,500,600);
        list.printAllDirectOrder();

        System.out.println("12). Проверим метод, который добавляет все значения (11,22,33) заданной коллекции в конец списка с сохранением порядка:");
        List<Object> test2 = new ArrayList<>();
        Collections.addAll(test2,11,22,33);
        list.addAllCollectionValuesToTheEnd(test2);
        list.printAllDirectOrder();


        System.out.println("13). Проверим метод, который поглощает список другим списком с добавлением значений второго в начало\n" +
                "первого списка; после поглощения второй список очистится:");
        System.out.println("Создадим и заполним новый список, выведем значение нового списка:");
        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.addInBeginning("Hello!");
        list2.printAllDirectOrder();
        System.out.println("Теперь поглотим новым списком старый список и выведем новый список на печать:");
        list2.absorbingTheListToTheTop(list);
        list2.printAllDirectOrder();
        System.out.println("Проверим осталось ли что то в старом списке:");
        list.printAllDirectOrder();
        System.out.println("------пусто-----");
        System.out.println();

        System.out.println("14). Проверим метод, который поглощает список другим списком с добавлением значений второго в конец\n" +
                "первого списка, после поглощения второй список очистится:");
        System.out.println("Добавим START в наш пустой список:");
        list.addInBeginning("START");
        list.printAllDirectOrder();
        System.out.println("Поглотим предыдущим, оставшимся пустым, списком второй список и выведем на печать:");
        list.absorbingTheListToTheEnd(list2);
        list.printAllDirectOrder();
        System.out.println("Проверим осталось ли что то в списке:");
        list2.printAllDirectOrder();
        System.out.println("------пусто-----");
        System.out.println();

        System.out.println("15). Проверим метод, печатающий значения списка в обратном порядке:");
        list.printAllReverseOrder();
    }

}