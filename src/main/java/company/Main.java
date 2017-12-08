package company;

public class Main {
    public static void main (String[] args){
        Parking park = Parking.getInstance();
        Size size = new Size(190, 450);
        Place place = new Place(size);
        Color color = new Color("black");
        Color color2 = new Color("black");

        //Example to decorate a vehicle.
        Vehicle vehicle = new ColorDecorator(new ColorDecorator(new Car("ABC",  size),
                color), color2);
        System.out.print(vehicle.vehicleCharacteristic());
    }
}