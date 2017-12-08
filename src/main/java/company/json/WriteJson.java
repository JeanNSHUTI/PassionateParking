package company.json;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.*;
import company.*;
import java.util.ArrayList;
import java.util.List;


public class WriteJson {
    public static void main(String[] args) throws IOException {
        String file = "Parking.json";
        InputStream fileInputStream = new FileInputStream(file);
        JsonReader jsonReader = Json.createReader(fileInputStream);
        JsonArray array = jsonReader.readArray();
        //read data from json file and save as a list of Place objects
        List<Place> places = ReadJson.getPlaces(array);
        jsonReader.close();

        OutputStream fileOutputStream = new FileOutputStream(file);
        JsonGenerator generator = Json.createGenerator(fileOutputStream);

        //part that creates a new Place object
        Size newSize = new Size(250,600);
        Place newPlace = new Place(newSize);

        //adding the Place object to the list of Place objects
        places.add(newPlace);
        generator.writeStartArray(); //start array
        int index = 1;
        for (Place this_place:places){
            generator.writeStartObject(); // start object
            generator.write("length",this_place.getSizePlace().getLength())
                    .write("width",this_place.getSizePlace().getWidth())
                    .write("price",this_place.getPrice())
                    .write("free", this_place.isFree())
                    .write("index",index);
            generator.writeEnd();
            index ++;
        }
        // add previous objects

        generator.writeEnd(); //end array
        generator.close();
    }
}
