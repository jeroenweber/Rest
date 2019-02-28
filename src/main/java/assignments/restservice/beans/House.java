package assignments.restservice.beans;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class House {
    private static int counter;
    private static Map<Integer, House> houses = new HashMap<>();

    private int id;

    @NotNull(message = "The Street name should not be null")
    private String street;

    @NotNull(message = "The number should not be null")
    private String number;

    @NotNull(message = "The postal code should not be null")
    private String postalCode;

    @NotNull(message = "The city should not be null")
    private String city;

    public static List<House> getAll() {
        return new ArrayList<>(houses.values());
    }

    public static House findHouseByID(int id) {
        return houses.get(id);
    }

    public static House putHouse(House house) {
        if (house.getId() == 0) house.setId(++counter);
        return putHouse(house.getId(), house);
    }

    public static House putHouse(int id, House house) {
        if (house.getId() != id && house.getId() != 0) return null;
        houses.put(id, house);
        return house;
    }

    public static void deleteHouse(int id) {
        houses.remove(id);
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
