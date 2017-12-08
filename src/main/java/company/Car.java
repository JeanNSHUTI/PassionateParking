package company;

/*
* Car Class.
* Car is a Vehicle.
* String license_plate : license plate of the car.
* String type : type of car.
* Size size_car: the size of car.
 */
public class Car extends Vehicle {
    private String license_plate;
    private String type;
    private Size size_car;

    //Constructor.
    public Car(String license_plate, Size size_car) {
        this.license_plate = license_plate;
        this.type = "Car";
        this.size_car = size_car;
    }

    //Getter.
    public String getLicensePlate() {
        return license_plate;
    }

    public String getType() {
        return type;
    }

    public Size getSizeCar() {
        return size_car;
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
