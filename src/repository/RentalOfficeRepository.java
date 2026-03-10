package repository;
import model.RentalOffice;
import java.util.ArrayList;

public class RentalOfficeRepository implements IRentalOfficeRepository{

    private ArrayList<RentalOffice>rentalOffics;
    private static RentalOfficeRepository rentalOfficeRepository;

    private RentalOfficeRepository(){
        rentalOffics = new ArrayList<>();
    }

    public static RentalOfficeRepository getRentalOfficeRepository(){
        if(rentalOfficeRepository == null){
            rentalOfficeRepository = new RentalOfficeRepository();
        }
        return rentalOfficeRepository;
    }

    public void add(RentalOffice rentalOffice){
        rentalOffice.setId((nextIdAvailable()));
        rentalOffics.add(rentalOffice);
    }

    public void update(RentalOffice rentalOffice) {
        rentalOffics.set(rentalOffics.indexOf(findById(rentalOffice.getId())),rentalOffice);
    }

    public ArrayList findAll(){
        return rentalOffics;
    }

    public void deleteById(long id){
        for (RentalOffice rentalOffice : rentalOffics) {
            if (rentalOffice.getId() == id) {
                rentalOffics.remove(rentalOffice);
                break;
            }
        }
    }

    public Long nextIdAvailable(){
        if(!rentalOffics.isEmpty()){
            return rentalOffics.get(rentalOffics.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public RentalOffice findById(long id) {
        for (RentalOffice rentalOffice : rentalOffics) {
            if(rentalOffice.getId() == id){
                return rentalOffice;
            }
        }
        return null;
    }

    public void cleanUp(){
        rentalOffics = new ArrayList<>();
    }

}
