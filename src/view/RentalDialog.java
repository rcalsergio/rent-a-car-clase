package view;

import controller.CarController;
import controller.ClientController;
import controller.RentalController;
import controller.RentalOfficeController;
import model.Car;
import model.Client;
import model.RentalOffice;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalDialog {

    private RentalController rentalController;
    private Scanner scanner;
    private ClientController clientController;
    private RentalOfficeController rentalOfficeController;
    private CarController carController;

    public RentalDialog(){
        rentalController = new RentalController();
        clientController = new ClientController();
        rentalOfficeController= new RentalOfficeController();
        carController = new CarController();

    };

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
                    System.out.println("id: ");
                    Long id= scanner.nextLong();
                    System.out.println("startDateYear: ");
                    int year= scanner.nextInt();
                    System.out.println("startDateMonth: ");
                    int month= scanner.nextInt();
                    System.out.println("startDateDay: ");
                    int day= scanner.nextInt();
                    LocalDate startDate= LocalDate.of(year, month, day);

                    System.out.println("endDateYear: ");
                    year= scanner.nextInt();
                    System.out.println("endDateMonth: ");
                    month= scanner.nextInt();
                    System.out.println("endDateDay: ");
                    day= scanner.nextInt();
                    LocalDate endDate= LocalDate.of(year, month, day);

                    System.out.println("CarId: ");
                    Long carId=scanner.nextLong();
                    Car car = carController.findById(carId);

                    System.out.println("ClientId: ");
                    Long clientId=scanner.nextLong();
                    Client client = clientController.findById(clientId);

                    System.out.println("RentalOfficeId: ");
                    Long rentalOfficeId=scanner.nextLong();
                    RentalOffice rentalOffice = rentalOfficeController.findById(rentalOfficeId);

                    rentalController.add(id, startDate, endDate, car, client, rentalOffice);

                } else if (choice == 2) {
                    System.out.println("Rental ID: ");
                    int id = scanner.nextInt();
                    rentalController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println("id: ");
                    Long id= scanner.nextLong();
                    System.out.println("startDateYear: ");
                    int year= scanner.nextInt();
                    System.out.println("startDateMonth: ");
                    int month= scanner.nextInt();
                    System.out.println("startDateDay: ");
                    int day= scanner.nextInt();
                    LocalDate startDate= LocalDate.of(year, month, day);

                    System.out.println("endDateYear: ");
                    year= scanner.nextInt();
                    System.out.println("endDateMonth: ");
                    month= scanner.nextInt();
                    System.out.println("endDateDay: ");
                    day= scanner.nextInt();
                    LocalDate endDate= LocalDate.of(year, month, day);

                    System.out.println("CarId: ");
                    Long carId=scanner.nextLong();
                    Car car = carController.findById(carId);

                    System.out.println("ClientId: ");
                    Long clientId=scanner.nextLong();
                    Client client = clientController.findById(clientId);

                    System.out.println("RentalOfficeId: ");
                    Long rentalOfficeId=scanner.nextLong();
                    RentalOffice rentalOffice = rentalOfficeController.findById(rentalOfficeId);
                    rentalController.update(id, startDate, endDate, car, client, rentalOffice);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
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
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void addInitialRentals(){
        rentalController.add(1L, LocalDate.of(2000, 1, 1),LocalDate.of(2000, 1, 10), carController.findById(1L), clientController.findById(1L), rentalOfficeController.findById(1L));


    }
}