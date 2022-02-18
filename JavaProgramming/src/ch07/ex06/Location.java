package ch07.ex06;

class Location {
    private String cityName;
    private int longitude, latitude;
    public Location(String cityName, int longitude, int latitude) {
        this.cityName = cityName; this.longitude = longitude; this.latitude = latitude;
    }
    String getName() { return cityName; }
    void showInfo() {
        System.out.printf("%-5s%-5d%-5d\n", cityName, longitude, latitude);
    }
}
