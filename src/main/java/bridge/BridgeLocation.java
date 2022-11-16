package bridge;

import java.util.Arrays;

public enum BridgeLocation {
    UP(1, "U"),
    DOWN(0, "D");

    private final int locationNumber;
    private final String location;

    BridgeLocation(int locationNumber, String location) {
        this.locationNumber = locationNumber;
        this.location = location;
    }

    public static BridgeLocation createLocation(int locationNumber) {
        return Arrays.stream(values())
                .filter(locationValue -> locationValue.locationNumber == locationNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 정보입니다."));
    }

    public static BridgeLocation createLocation(String location) {
        return Arrays.stream(values())
                .filter(locationValue -> locationValue.location.equals(location))
                .findFirst()
                .orElseThrow();
    }

    public String getLocation() {
        return location;
    }
}
