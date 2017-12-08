package test;

import org.junit.Assert;
import org.junit.Test;
import company.*;


public class MyFirstTest {
    @Test
    public void ParkingTest() {
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

        Assert.assertEquals("should be 1",1, parking.getEmptyPlace().size());
        Assert.assertEquals("should be 1",0, parking.getBusyPlaces().size());
        int totalsize = parking.getEmptyPlace().size()+parking.getBusyPlaces().size();
        //test if sum of both arrays equals the size of the total places array
        Assert.assertEquals("should be true",parking.getPlaces().size(), totalsize);
        //Car creation in order to occupy a place
        Size carsize = new Size(190,450);
        Car car = new Car("ABC123", carsize);
        place.setBusy(car);
        //retest the busy and free lists
        Assert.assertEquals("should be 1",0, parking.getEmptyPlace().size());
        Assert.assertEquals("should be 1",1, parking.getBusyPlaces().size());

        totalsize = parking.getEmptyPlace().size()+parking.getBusyPlaces().size();
        Assert.assertEquals("should be true",parking.getPlaces().size(), totalsize);
    }
    @Test
    public void SizeTest(){
        //test to see if we can access size parameters
        Size size = new Size(1,2);
        Assert.assertEquals("should be 0",2, size.getLength());
        Assert.assertEquals("should be 0",1, size.getWidth());
    }
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
    @Test
    public void ColorTest(){
        //test if the color parameter is correctely stored
        Color color = new Color("green");
        Assert.assertEquals("Should be green", "green",color.getColor());
    }

}
