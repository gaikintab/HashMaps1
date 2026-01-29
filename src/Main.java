import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Address address1 = new Address("Россия", "Пермь");
        Address address2 = new Address("Россия", "Москва");
        Address address3 = new Address("Россия", "Владивосток");
        Address address4 = new Address("Беларусь", "Минск");
        Address address5 = new Address("Польша", "Гданьск");

        int deliveryCost;
        int deliveryCostSum = 0;
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        costPerAddress.put(address1, 1000);
        costPerAddress.put(address2, 200);
        costPerAddress.put(address3, 3500);
        costPerAddress.put(address4, 1900);
        costPerAddress.put(address5, 3500);

        while (true) {
            System.out.print("\nЗАПОЛНЕНИЕ НОВОГО ЗАКАЗА:\nВведите страну (или end для выхода): ");
            String country = scanner.nextLine();
            if (country.equals("end")) break;
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());

            boolean findAddress = false;
            for (Address address : costPerAddress.keySet()) {
                if (address.country.equals(country)) {
                    if (address.city.equals(city)) {
                        findAddress = true;
                        deliveryCost = costPerAddress.get(address) * weight;
                        deliveryCostSum += deliveryCost;
                        System.out.println("Стоимость доставки составит: " + deliveryCost);
                        System.out.println("Общая стоимость всех доставок: " + deliveryCostSum);
                    }
                }
            }
            if (!findAddress) {
                System.out.println("Доставки по этому адресу нет!");
            }
        }
    }
}
