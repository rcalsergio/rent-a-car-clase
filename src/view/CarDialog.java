package view;

import controller.CarController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDialog {

    private CarController carController;
    private Scanner scanner;

    public CarDialog(){
        carController = new CarController();;
    }

    public void getStarted(){
        do {
            System.out.println("\n************************** RentalOffice Manager ********************************");
            System.out.println("\n\t1. Create car.\t\t\t\t4. Search car.");
            System.out.println("\n\t2. Remove car.\t\t\t\t5. See All cars.");
            System.out.println("\n\t3. Update car\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Matricula: ");
                    String matricula = scanner.nextLine();
                    System.out.println("idModelo: ");
                    Long modelId = (long) scanner.nextInt();
                    System.out.println("ID de la oficina");
                    Long officeId = (long) scanner.nextInt();
                    carController.add(matricula, modelId,officeId);
                } else if (choice == 2) {
                    System.out.println("Car ID: ");
                    int id = scanner.nextInt();
                    carController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(carController.findAll());
                    System.out.println("car ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("LicensePlate: ");
                    String license = scanner.nextLine();
                    System.out.println("IdModel: ");
                    Long idModel = scanner.nextLong();
                    System.out.println("Id rentalOffice");
                    Long rental = scanner.nextLong();
                    carController.update((long) id, license, idModel,rental);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Id: ");
                    Long id = scanner.nextLong();
                    //System.out.println(carController.findById(id));
                } else if (choice == 5) {
                    for (Object rentalOffice : carController.findAll()) {
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




    public void addInitialCar(){
        carController.add("Cambados", 3L,1L);

    }
}
