package view;

import controller.CarController;
import controller.ClientController;
import controller.RentalController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalDialog {

    private RentalController rentalController;
    private ClientController clientController;
    private CarController carController;
    private Scanner scanner;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public RentalDialog(){
        rentalController = new RentalController();
        clientController = new ClientController();
        carController = new CarController();
    }

    public void getStarted(){
        do {
            System.out.println("\n************************** Rental Manager ********************************");
            System.out.println("\n\t1. Create Rental.\t\t\t\t4. Search Rental.");
            System.out.println("\n\t2. Remove Rental.\t\t\t\t5. See All Rentals.");
            System.out.println("\n\t3. Update Rental.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    System.out.println(clientController.findAll());
                    System.out.println("Client ID: ");
                    Long idClient = scanner.nextLong();
                    System.out.println(carController.findAll());
                    System.out.println("Car ID: ");
                    Long idCar = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Start Date (dd/MM/yyyy): ");
                    Date startDate = sdf.parse(scanner.nextLine());
                    System.out.println("End Date (dd/MM/yyyy): ");
                    Date endDate = sdf.parse(scanner.nextLine());
                    rentalController.add(idClient, idCar, startDate, endDate);
                } else if (choice == 2) {
                    System.out.println("Rental ID: ");
                    Long id = scanner.nextLong();
                    rentalController.deleteById(id);
                } else if (choice == 3) {
                    System.out.println(rentalController.findAll());
                    System.out.println("Rental ID: ");
                    Long id = scanner.nextLong();
                    System.out.println(clientController.findAll());
                    System.out.println("Client ID: ");
                    Long idClient = scanner.nextLong();
                    System.out.println(carController.findAll());
                    System.out.println("Car ID: ");
                    Long idCar = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Start Date (dd/MM/yyyy): ");
                    Date startDate = sdf.parse(scanner.nextLine());
                    System.out.println("End Date (dd/MM/yyyy): ");
                    Date endDate = sdf.parse(scanner.nextLine());
                    rentalController.update(id, idClient, idCar, startDate, endDate);
                } else if (choice == 4) {
                    System.out.println("Rental ID: ");
                    Long id = scanner.nextLong();
                    System.out.println(rentalController.findById(id));
                } else if (choice == 5) {
                    for (Object rental : rentalController.findAll()) {
                        System.out.println(rental);
                    }
                } else if(choice==0) {
                    break;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (ParseException e) {
                System.err.println("[ERROR] Invalid date format. Use dd/MM/yyyy.");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }
}
