package company;

/*
 * Car Class.
 * Car is a Vehicle.
 * String license_plate : license plate of the car.
 * String type : type of car.
 * Size size_car: the size of car.
 */
public class NoVehicle extends Vehicle {
    private String type;

    //Constructor.
    public NoVehicle() {
        this.type = "None";
    }

    public String getType() {
        return type;
    }

    //Override methods of Vehicle interface for the decorator pattern.
    @Override
    public String licensePlate() {
        return "None";
    }

    @Override
    public String type() {
        return type;
    }

}