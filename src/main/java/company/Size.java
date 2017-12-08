package company;

/*
* Class Size.
* Size of vehicle.
*/
public class Size {
    private int length;
    private int width;

    //Constructor.
    public Size(int width, int length) {
        this.width = width;
        this.length = length;
    }

    //Getter.
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
