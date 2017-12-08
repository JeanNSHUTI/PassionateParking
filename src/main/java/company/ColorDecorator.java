package company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
* Class to implement methods of decorator.
* Color color: color of vehicle.
*/
class ColorDecorator extends Decorator {
    private Color color;
    private final Vehicle vehicle;

    //Constructor.
    ColorDecorator(Vehicle vehicle, Color color) {
        this.vehicle = vehicle;
        this.color = color;
    }

    //Add color to the array of characteristic's vehicle
    @Override
    public List<Object> vehicleCharacteristic() {
        List<Object> list = new ArrayList<Object>(this.vehicle.vehicleCharacteristic());
        list.add(this.color);
        return Collections.unmodifiableList(list);
    }
}
