package test;

import company.Car;
import company.Place;
import company.Size;
import org.junit.Assert;
import org.junit.Test;

public class PlaceTest {
    @Test
    public void PlaceTest(){
        //array of test for the Place class methods
        //creation of the vatious objects needed for the place
        Size size = new Size(1,2);
        Place place = new Place(size);
        Size carsize = new Size(190,450);
        Car car = new Car("ABC123",carsize);
        //Test if at the beginnig the place is free
        Assert.assertEquals("should be true", true,place.isFree());
        //occupy the spot
        place.setBusy(car);
        //test if the spot is not free anymore
        Assert.assertEquals("should be false", false,place.isFree());
        //test which vehicle is stored on the place
        Assert.assertEquals("should work", car, place.getVehicle());
        //test the place's price
        Assert.assertEquals( 0, place.getPrice(),0.001);
        //freeing the place
        place.setFree();
        //test if the place is free indeed
        Assert.assertEquals("should be true", true ,place.isFree());
        //test if the place size parameter
        Assert.assertEquals("Should be true",size,place.getSizePlace());
    }
}
