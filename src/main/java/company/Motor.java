package company;

public class Motor extends Vehicle {
    private String motor_type;
    private String license_plate;
    private String type;

    //Constructor.
    public Motor(String license_plate,String motor_type) {
        this.license_plate = license_plate;
        this.motor_type = motor_type;
        this.type = "motor";
    }

    //Getter.
    public String getMotorType() {
        return motor_type;
    }

    public String getLicensePlate() {
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
