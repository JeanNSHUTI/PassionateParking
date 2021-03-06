package test;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import company.*;

public class ParkingTest {

    @Test
    public void AddPlaceTest() {

        //creation of a parking singleton
        Parking parking = Parking.getInstance();
        //creation of a size object in order to have a parameter for the place
        Size size = new Size(1,2);
        Place place = new Place(size);
        //test of length of the places array (array telling how many places are in total)
        Assert.assertEquals("should be 0",0, parking.getPlaces().size());
        //adding a place to the list
        parking.addPlace(place);
        //test the newly changed places array
        Assert.assertEquals("should be 1",1, parking.getPlaces().size());
        //now testing the array listing how many busy and free places are in the parking

        parking.reset();
    }

    @Test
    public void GetEmptyPlaceTest() {

        //creation of a parking singleton
        Parking parking = Parking.getInstance();
        Size size = new Size(1,2);
        Place place = new Place(size);
        place.setFree();
        parking.addPlace(place);

        //Verify that the place added is free
        Assert.assertEquals("should be 1",1, parking.getEmptyPlace().size());
        Assert.assertEquals("should be 0",0, parking.getBusyPlaces().size());
        int totalsize = parking.getEmptyPlace().size() + parking.getBusyPlaces().size();
        //test if sum of both arrays equals the size of the total places array
        Assert.assertEquals("should be true",parking.getPlaces().size(), totalsize);

        parking.reset();
    }

    @Test
    public void GetBusyPlaceTest() {

        //creation of a parking singleton
        Parking parking = Parking.getInstance();
        Size size = new Size(1,2);
        Place place = new Place(size);
        place.setFree();
        parking.addPlace(place);

        //Car creation in order to occupy a place
        Size carsize = new Size(190,450);
        Car car = new Car("ABC123", carsize);
        parking.getPlaces().get(0).setBusy(car);
        //retest the busy and free lists
        Assert.assertEquals("should be 1",0, parking.getEmptyPlace().size());
        Assert.assertEquals("should be 1",1, parking.getBusyPlaces().size());

        int totalsize = parking.getEmptyPlace().size()+parking.getBusyPlaces().size();
        Assert.assertEquals("should be true",parking.getPlaces().size(), totalsize);

        parking.reset();
    }
}
