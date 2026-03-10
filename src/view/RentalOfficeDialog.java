package view;

import controller.RentalOfficeController;
import controller.RentalOfficeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalOfficeDialog {
    
    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;

    public RentalOfficeDialog(){
        rentalOfficeController = new RentalOfficeController();
        addInitialRental();
    };
    public void getStarted(){
        do {
            System.out.println("\n************************** Client Manager ********************************");
            System.out.println("\n\t1. Create Client.\t\t\t\t4. Search Client.");
            System.out.println("\n\t2. Remove Client.\t\t\t\t5. See All Clients.");
            System.out.println("\n\t3. Update Client.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("address: ");
                    String address = scanner.nextLine();
                    System.out.println("freeForDelivery: ");
                    int freeForDelivery = scanner.nextInt();
                    rentalOfficeController.add(address,freeForDelivery);
                } else if (choice == 2) {
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    rentalOfficeController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("adrress: ");
                    String address = scanner.nextLine();
                    System.out.println("Surname: ");
                    int freeForDelivery = scanner.nextInt();
                    rentalOfficeController.update((long) id, address , freeForDelivery);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    //System.out.println(rentalOfficeController.findByDni(dni));
                } else if (choice == 5) {
                    for (Object client : rentalOfficeController.findAll()) {
                        System.out.println(client);

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

    public void addInitialRental(){
        rentalOfficeController.add("87896685P", 23);
        rentalOfficeController.add("99687554K", 23);
        rentalOfficeController.add("12345678A", 4);
        rentalOfficeController.add("56789012B", 6);
        rentalOfficeController.add("34567890C", 86);
        rentalOfficeController.add("78901234D", 56);
    }
}
