package company;

import java.util.ArrayList;

/*
* Class Parking
* Unique instance, use singleton pattern.
* ArrayList<Place> places : List of the places in the parking.
*/
public class Parking {
    //Create list of places.
    private ArrayList<Place> places = new ArrayList<Place>();

    //Constructor.
    private Parking() {
        this.places = places;
    }

    //Create and set unique instance of Parking class. (Singleton pattern)
    private static class ParkingHolder {
        private static final Parking INSTANCE = new Parking();
    }

    //Methode to get the unique instance of Parking.
    public static Parking getInstance() {
        return ParkingHolder.INSTANCE;
    }

    //Getter.
    public ArrayList<Place> getPlaces() {
        return this.places;
    }

    //Add a place to the Parking.
    public void addPlace(Place place) {
        this.places.add(place);
    }

    //Return a list of empty places in parking
    public ArrayList<Place> getEmptyPlace() {
        ArrayList empty_places = new ArrayList();
        Place place;

        for (int i = 0; i < this.places.size(); i++) {
            place = this.places.get(i);
            if (place.isFree() == true) {
                empty_places.add(this.places.get(i));
            }
        }
        return empty_places;
    }

    //Return a list of busy places in parking.
    public ArrayList<Place> getBusyPlaces() {
        ArrayList busy_places = new ArrayList();
        Place place;

        for (int i = 0; i < this.places.size(); i++) {
            place = this.places.get(i);
            if (place.isFree() == false) {
                busy_places.add(this.places.get(i));
            }
        }
        return busy_places;
    }

    public void reset() {
        this.places.clear();
    }
}
