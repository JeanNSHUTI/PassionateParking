package company;

import java.util.List;

/*
* Abstact class to decorate a Vehicle.
* The methods are to overide the vehicle class.
*/
abstract class Decorator extends Vehicle {
    protected Vehicle vehicle;

    @Override
    public String type() {
        return this.vehicle.type();
    }

    @Override
    public String licensePlate() {
        return this.vehicle.licensePlate();
    }

    @Override
    public abstract List<Object> vehicleCharacteristic();
}
