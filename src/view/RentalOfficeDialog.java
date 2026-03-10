package view;

import controller.RentalOfficeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalOfficeDialog {

    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;

    public RentalOfficeDialog(){
        rentalOfficeController = new RentalOfficeController();
        addInitialRentalOffices();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** RentalOffice Manager ********************************");
            System.out.println("\n\t1. Create RentalOffice.\t\t\t\t4. Search RentalOffice.");
            System.out.println("\n\t2. Remove RentalOffice.\t\t\t\t5. See All RentalOffices.");
            System.out.println("\n\t3. Update RentalOffice.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("PricePerDay: ");
                    int pricePerDay = scanner.nextInt();
                    rentalOfficeController.add(name, pricePerDay);
                } else if (choice == 2) {
                    System.out.println("RentalOffice ID: ");
                    int id = scanner.nextInt();
                    rentalOfficeController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("RentalOffice ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("PricePerDay: ");
                    int pricePerDay = scanner.nextInt();
                    rentalOfficeController.update((long) id, name, pricePerDay);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    String dni = scanner.nextLine();
                    //System.out.println(rentalOfficeController.findByName(dni));
                } else if (choice == 5) {
                    for (Object rentalOffice : rentalOfficeController.findAll()) {
                        System.out.println(rentalOffice);

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

    public void addInitialRentalOffices(){
        rentalOfficeController.add("Vigolandia", 60);
        rentalOfficeController.add("Pontemerda", 100);
        rentalOfficeController.add("Villaviciosa de Arousa", 130);

    }
}
