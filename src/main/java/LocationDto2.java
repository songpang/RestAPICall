import java.util.List;

public class LocationDto2 {
    private List<LocationInfo2> locationInfo2s;

    public void setLocationInfo2s(List<LocationInfo2> locationInfo2s) {
        this.locationInfo2s = locationInfo2s;
    }

    public List<LocationInfo2> getLocationInfo2s() {
        return locationInfo2s;
    }

    public LocationDto2(List<LocationInfo2> locationInfo2s) {
        this.locationInfo2s = locationInfo2s;
    }
}

class LocationInfo2 {
    private Object locations;

    public void setLocations(Object locations) {
        this.locations = locations;
    }

    public LocationInfo2(Object locations) {
        this.locations = locations;
    }

    public Object getLocations() {
        return locations;
    }
}
