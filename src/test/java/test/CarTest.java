package test;

import company.Car;
import company.Size;
import org.junit.Assert;
import org.junit.Test;

public class CarTest {
    @Test
    public void CarTest(){
        //creation of the neccesary objects
        Size size = new Size(190,450);
        Car car = new Car("ABC123",size);
        //Test for the licence plate parameter
        Assert.assertEquals("Should be ABC123","ABC123",car.getLicensePlate());
        //test if the size of the car equals the ones we set
        Assert.assertEquals("Should be be size",size,car.getSizeCar());
        Assert.assertEquals("Should be ABC123","ABC123",car.licensePlate());
        Assert.assertEquals("Should be Car","Car",car.type());
        Assert.assertEquals("Should be 0",0,car.vehicleCharacteristic().size());
        Assert.assertEquals("Should be Car","Car",car.getType());


    }
}
