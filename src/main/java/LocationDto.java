public class LocationDto {
//    private LocationInfo locations;
    private String location;
    private int value;

    public String getLocation() {
        return location;
    }

    public int getValue() {
        return value;
    }

    public LocationDto(String location, int value) {
        this.location = location;
        this.value = value;
    }
}

class LocationInfo {

}
