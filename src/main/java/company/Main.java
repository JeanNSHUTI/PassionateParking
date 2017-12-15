package company;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main (String[] args){
        Parking park = Parking.getInstance();
        Size size = new Size(190, 450);

        //Example to decorate a vehicle.
        Color color = new Color("black");
        Color color2 = new Color("black");
        Vehicle vehicle = new ColorDecorator(new ColorDecorator(new Car("ABC",  size), color), color2);

        for (int j = 0; j < 2; j++) {
            Place place = new Place(size);
            park.addPlace(place);
        }

        for (int j = 0; j < 2; j++) {
            Place place = new Place(size);
            place.setBusy(vehicle);
            park.addPlace(place);
        }

        Place place = new Place(size);
        Date date_test = new Date();
        place.setArrival(date_test);
        place.setDeparture(date_test);
        System.out.print(place.getArrival());
        System.out.print(place.getDeparture());

        ArrayList<Place> place_array = park.getPlaces();
        String test = place_array.get(0).toString();
        System.out.print("\nALL PLACES\n");
        System.out.print(place_array);

        System.out.print("\nEMPTY PLACES\n");
        System.out.print(park.getEmptyPlace());

        System.out.print("\nBUSY PLACES\n");
        System.out.print(park.getBusyPlaces());
        //System.out.print(vehicle.vehicleCharacteristic());
    }
}