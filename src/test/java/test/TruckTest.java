package test;

import company.Size;
import company.Truck;
import org.junit.Assert;
import org.junit.Test;

public class TruckTest {

    @Test
    public void TruckTest(){
        //Same as the car but for the truck
        Size trucksize =new Size(190,450);
        Truck truck = new Truck("ABC123",trucksize);
        Assert.assertEquals("Should be ABC123","ABC123",truck.getLicense_plate());
        Assert.assertEquals("should be trucksize",trucksize,truck.getSize_truck());
        Assert.assertEquals("Should be ABC123","ABC123",truck.licensePlate());
        Assert.assertEquals("Should be Truck","Truck",truck.type());
        Assert.assertEquals("Should be 0",0,truck.vehicleCharacteristic().size());
        Assert.assertEquals("Should be Truck","Truck",truck.getType());

    }
}
