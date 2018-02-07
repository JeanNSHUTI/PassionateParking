package company.json;
import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.io.*;
import company.*;
import java.util.Date;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;

public class WriteJson {
    public static void main(String[] args) throws IOException {
        String file = "Parking.json";
        Date date_test = new Date();
        InputStream fileInputStream = new FileInputStream(file);
        JsonReader jsonReader = Json.createReader(fileInputStream);
        JsonArray array = jsonReader.readArray();
        //read data from json file and save as a list of Place objects
        List<Place> places = ReadJson.getPlaces(array);
        jsonReader.close();

        OutputStream fileOutputStream = new FileOutputStream(file);
        JsonGenerator generator = Json.createGenerator(fileOutputStream);

        //part that creates a new Place object
        Size newSize = new Size(250, 600);
        Place newPlace = new Place(newSize);
        //adding the Place object to the list of Place objects
        places.add(newPlace);
        generator.writeStartArray(); //start array
        int index = 1;
        for (Place this_place : places) {
            generator
                    .writeStartObject()
                        .writeStartArray("size")
                            .write(this_place.getSizePlace().getLength())
                            .write(this_place.getSizePlace().getWidth())
                        .writeEnd()
                        .write("free", this_place.isFree())
                        .write("arrival", date_test.toString())
                        .write("departure", date_test.toString())
                        .writeStartObject("vehicle")
                            .write("license plate", this_place.getVehicle().licensePlate())
                            .write("type", this_place.getVehicle().type())
                            .writeStartArray("size")
                                .write(this_place.getSizePlace().getLength())
                                .write(this_place.getSizePlace().getWidth())
                            .writeEnd()
                            .write("caract",this_place.getVehicle().vehicleCharacteristic().toString())
                        .writeEnd()
                    .write("index", index)
                    .writeEnd();
            index++;
        }
        // add previous objects
        generator.writeEnd(); //end array
        generator.close();
    }
}