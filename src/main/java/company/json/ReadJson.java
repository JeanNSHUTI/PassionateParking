package company.json;

import javafx.util.converter.DateTimeStringConverter;
import company.*;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.*;

public class ReadJson {

    public static void main(String[] args){

        String file = "Parking.json";
        List<Place> all = new ArrayList<Place>();
        JsonReader jsonReader;
        JsonArray jsonArray;
        JsonObject jsonObject;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            jsonReader = Json.createReader(fileInputStream);
            try
            {
                jsonArray = jsonReader.readArray();
                List<Place> places = getPlaces(jsonArray);
                for (Place place:places){
                    System.out.println(place.toString());
                    System.out.println("____________________________");
                }
            }
            catch (javax.json.JsonException j){
                jsonObject = jsonReader.readObject();
                String[] data = new String[]{"length","width","price","free"};
                for (String info:data)
                {
                    String result = jsonObject.get(info).toString();
                    System.out.println(info+": "+result);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.toString());
            System.out.println("File not found");
        }
    }
    public static List<Place> getPlaces(JsonArray jsonArray)
    {
        List<Place> places = new ArrayList<Place>();
        String arrivalValue;
        String departureValue;
        Date arrivalTime;
        Date departureTime;

        // We have an array of places
        // for loop on all the places
        for (int i = 0;i<jsonArray.size();i++){
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            JsonArray widthlength = jsonObject.getJsonArray("size");
            // get width and length as strings
            String width = widthlength.get(0).toString();
            String length = widthlength.get(1).toString();
            //make new Size object
            Size size = new Size(Integer.parseInt(length),Integer.parseInt(width));
            Place place = new Place(size);
            if (jsonObject.get("free").toString().equals("true")){
                place.setFree();
            }
            // get arrival and departure times
            arrivalValue = jsonObject.get("arrival").toString();
            departureValue = jsonObject.get("departure").toString();
            DateTimeStringConverter datetime = new DateTimeStringConverter();

            //check if they are values or just null
            try {
                arrivalTime = datetime.fromString(arrivalValue);
            }
            catch(Exception e)
            {
                arrivalTime = new Date(0);
            }
            try {
                departureTime = datetime.fromString(departureValue);
            }
            catch (Exception e){
                departureTime = new Date(0);
            }

            // get json string for vehicle
            JsonValue vehicle = jsonObject.get("vehicle");
            String vehicle_string = vehicle.toString();
            // split by ",", then by ":" and remove {} and [] when necessary
            String[] comma_split = vehicle_string.split(",");
            // initialize objects and values
            Vehicle vehicle1 = new Car(" ", new Size(0,0));
            String license_plate = vehicle1.licensePlate();
            Size size4 = null;
            for (int k = 0;k < comma_split.length;k++){
                comma_split[k] = comma_split[k].replace("{","")
                        .replace("}","")
                        .replace("\"","");
                if (comma_split[k].contains("[") && !comma_split[k].contains("]")){
                    comma_split[k] = comma_split[k]+","+comma_split[k+1];
                    comma_split[k+1] = "";
                    k++;
                }
                String[] key_value = comma_split[k].split(":");
                switch(key_value[0]){
                    case "license plate":
                        if (key_value[1].equals(" ")) {
                            place.setFree();
                        }
                        license_plate = key_value[1];
                        break;
                    case "size":
                        String size2 = key_value[1];
                        size2 = size2.replace("[","")
                                .replace("]","");
                        String[] size3 = size2.split(",");
                        size4 = new Size(Integer.parseInt(size3[0]),Integer.parseInt(size3[1]));
                        break;
                    case "type":
                        Size size1 = new Size(0,0);
                        if (size4 == null){
                            size4 = size1;
                        }
                        switch (key_value[1]){
                            case "car":
                                vehicle1 = new Car(license_plate,size4);
                                break;
                            case "truck":
                                vehicle1 = new Truck(license_plate,size4);
                                break;
                            case "motor":
                                vehicle1 = new Motor(license_plate,"");
                                break;
                        }
                        break;
                    case "caract":
                        break;
                    default:
                        //

                }
            }

            if (vehicle1.licensePlate().equals("") || vehicle1.licensePlate().equals(" ")){
                place.setBusy(vehicle1);
                place.setFree();
            }
            else {
                place.setBusy(vehicle1);
            }

            place.setArrival(arrivalTime);
            place.setDeparture(departureTime);
            places.add(place);
        }
        return places;

    }
}

