package company;

import java.util.List;
import java.util.Collections;

//Abstract class Vehicle.
public abstract class Vehicle {
    public abstract String licensePlate();
    public abstract String type();
    public List<Object> vehicleCharacteristic() {
        return Collections.emptyList();
    }
}

