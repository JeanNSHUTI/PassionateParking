package company;

/*
* Truck Class.
* Truck is a Vehicle.
* String license_plate : license plate of the car.
* String type : type of truck.
* Size size_car: the size of truck
*/
public class Truck extends Vehicle {
    private String license_plate;
    private String type;
    private Size size_truck;

    //Constructor
    public Truck(String license_plate, Size size_truck) {
        this.license_plate = license_plate;
        this.type = "Truck";
        this.size_truck = size_truck;
    }

    //Getter.
    public Size getSize_truck() {
        return size_truck;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getType() {
        return type;
    }

    //Override methods of Vehicle interface for the decorator pattern.
    @Override
    public String licensePlate() {
        return license_plate;
    }

    @Override
    public String type() {
        return type;
    }
}
