import javax.swing.text.html.parser.Entity;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите название контакта или номер:");
            String goodNames = scanner.nextLine();
            // LIST - вывод списка
            if (goodNames.equals("LIST")) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + "|" + entry.getValue());
                }
//                printMap(map);
                continue;
                //Ввели номер
            } else if(goodNames.equals("BREAK")) {
                break;
            } else if (goodNames.matches("[0-9]+")) {
                if (map.containsValue(goodNames)) { //Проверка на телефон
                    System.out.println("Такой контакт найден:");
                    for(Map.Entry<String, String> entry: map.entrySet()) {
                        if (entry.getValue().equals(goodNames)) {
                            // get key
                            System.out.println(entry.getKey() + "|" + goodNames);
                        } else {
                            continue;
                        }
                    }

                } else {
                    System.out.println("Введите имя: ");
                    String scannerNumber = scanner.nextLine();
                    if (scannerNumber.matches(".+")) {
                        map.put(scannerNumber, goodNames);
                    } else {
                        System.out.println("Вы ввели неверный формат номера. Повторите попытку");
                        continue;
                    }
                }
                //Ввели имя
            } else if (goodNames.matches(".+")) {
                if (map.containsKey(goodNames)) { //Проверка на имя
                    System.out.println("Такой контакт найден:");
                    System.out.println(goodNames + "|" + map.get(goodNames));
                } else {
                    System.out.println("Введите номер: ");
                    String scannerNumber = scanner.nextLine();
                    if (scannerNumber.matches("\\d+")) {
                        map.put(goodNames, scannerNumber);
                    } else {
                        System.out.println("Вы ввели неверный формат номера. Повторите попытку");
                        continue;
                    }
                }
            }
            // LIST - вывод списка (этот метод относиться к LIST)
//    private static void printMap(TreeMap<String, String> map) {
//        Set<String> keys = map.keySet();
//        for (String key : keys){
//            System.out.println(key + "|" + map.get(key));
//        }
//    }
        }
    }
}
