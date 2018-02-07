package test;

import company.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PlaceTest {
    @Test
    public void SetTest(){
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

    @Test
    public void SetDateTest(){
        Parking parking = Parking.getInstance();
        Size size = new Size(190, 450);

        for (int j = 0; j < 2; j++) {
            Place place = new Place(size);
            parking.addPlace(place);
        }
        Date date_test = new Date();
        parking.getPlaces().get(0).setArrival(date_test);
        parking.getPlaces().get(0).setDeparture(date_test);

        //test if arrival date was set correctly
        Assert.assertEquals("Should be today's date",date_test ,parking.getPlaces().get(0).getArrival());
        //test if departure date was set correctly
        Assert.assertEquals("Should be today's date",date_test ,parking.getPlaces().get(0).getDeparture());
    }
}
