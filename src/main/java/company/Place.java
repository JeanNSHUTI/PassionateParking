package company;

//import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* Class Place to represent a place in parking.
* Size size_place : size of place
* Vehicle vehicle : if the place isn't free the have a vehicle.
* bool free: if place free, free=true.
*/
public class Place {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int place_id;
    private Size size_place;
    private Vehicle vehicle;
    private boolean free;
    private Date arrival;
    private Date departure;

    //Constructor
    public Place(Size size) {
        this.vehicle = new NoVehicle();
        this.size_place = size;
        this.free = true;
        this.place_id = count.incrementAndGet();
        this.arrival = null;
    }

    //Check free.
    public boolean isFree() {
        return this.free;
    }

    //Getter.
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Date getDeparture() {
        return this.departure;
    }

    public Date getArrival() {
        return this.arrival;
    }

    public Size getSizePlace() {
        return size_place;
    }

    //Setter for free or busy.
    public void setBusy(Vehicle vehicle) {
        this.free = false;
        this.vehicle = vehicle;
    }

    public void setFree() {
        this.free = true;
    }

    //Return Price.
    public double getPrice(){
        double price = 0;
        return price;
    }

    //Setter departure and arrival date.
    public void setArrival(){
        Date date = new Date();
        this.arrival = date;
    }

    public void setArrival(Date date) {
        Date compare_date = new Date(0);
        if (date.toString().equals(compare_date.toString())) {
            this.arrival = new Date(0);
        } else {
            this.arrival = date;
        }
    }

    public void setDeparture() {
        Date date = new Date();
        this.departure = date;
    }

    public void setDeparture(Date date){
        Date compare_date = new Date(0);
        if (date.toString().equals(compare_date.toString())){
            this.departure = new Date(0);
        } else {
            this.departure = date;
        }
    }
    @Override
    public String toString(){
        String construct = "place id: " + this.place_id+ ", free: " + this.free + ", vehicle: " +
                this.vehicle.toString();
        return construct;
    }
}
