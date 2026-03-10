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
    }

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
                    System.out.println("License Plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println("Model ID: ");
                    Long idModel = scanner.nextLong();
                    System.out.println("Office ID: ");
                    Long idRentalOffice = scanner.nextLong();
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
                    System.out.println("License Plate: ");
                    String licensePlate = scanner.nextLine();
                    System.out.println("Model ID: ");
                    Long idModel = scanner.nextLong();
                    System.out.println("Office ID: ");
                    Long idRentalOffice = scanner.nextLong();
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
                    System.err.println("error!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("error");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void addInitialCars(){
        carController.add("1234ABC", (long) 1, (long) 1);
        carController.add("5678DEF", (long) 2, (long) 2);
        carController.add("9012GHI", (long) 3, (long) 3);

    }
}
