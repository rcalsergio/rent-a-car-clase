package view;

import controller.CarController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDialog {

    private CarController carController;
    private Scanner scanner;

    public CarDialog(){
        carController = new CarController();
        addInitialCars();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Car Manager ********************************");
            System.out.println("\n\t1. Create Car.\t\t\t\t4. Search Car.");
            System.out.println("\n\t2. Remove Car.\t\t\t\t5. See All Cars.");
            System.out.println("\n\t3. Update Car.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("LicensePlate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println("idModel: ");
                    long idModel = scanner.nextInt();
                    System.out.println("idRentalOffice: ");
                    long idRentalOffice = scanner.nextInt();
                    carController.add(licensePlate, idModel, idRentalOffice);
                } else if (choice == 2) {
                    System.out.println("Car ID: ");
                    int id = scanner.nextInt();
                    carController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(carController.findAll());
                    System.out.println("Car ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("LicensePlate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println("idModel: ");
                    long idModel = scanner.nextInt();
                    System.out.println("idRentalOffice: ");
                    long idRentalOffice = scanner.nextInt();
                    carController.update((long) id, licensePlate, idModel, idRentalOffice);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(carController.findById(id));
                } else if (choice == 5) {
                    for (Object car : carController.findAll()) {
                        System.out.println(car);

                    }
                } else if(choice==0) {
                    break;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void addInitialCars(){
        carController.add("3645GFD", 1L, 2L);
        carController.add("5654DFS", 2L, 1L);
        carController.add("2548FHP", 1L, 1L);

    }
}
