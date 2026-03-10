package view;

import controller.RentalOfficeController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalOfficeDialog {

    private RentalOfficeController rentalOfficeController;
    private Scanner scanner;

    public RentalOfficeDialog(){
        rentalOfficeController = new RentalOfficeController();
    };

    public void getStarted(){
        do {
            System.out.println("\n************************** Office Manager ********************************");
            System.out.println("\n\t1. Create Office.\t\t\t\t4. Search Office.");
            System.out.println("\n\t2. Remove Office.\t\t\t\t5. See All Offices.");
            System.out.println("\n\t3. Update Office.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Address: ");
                    String address = scanner.nextLine();
                    System.out.println("FeeForDelivery: ");
                    int feeForDelivery = scanner.nextInt();
                    rentalOfficeController.add(address, feeForDelivery);
                } else if (choice == 2) {
                    System.out.println("Office ID: ");
                    int id = scanner.nextInt();
                    rentalOfficeController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(rentalOfficeController.findAll());
                    System.out.println("Office ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Address: ");
                    String address = scanner.nextLine();
                    System.out.println("FeeForDelivery: ");
                    int feeForDelivery = scanner.nextInt();
                    rentalOfficeController.update((long) id, address, feeForDelivery);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    System.out.println(rentalOfficeController.findById(id));
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
        rentalOfficeController.add("office1", 10);
        rentalOfficeController.add("office2", 20);
        rentalOfficeController.add("office3", 30);

    }
}
