package subway.domain.station;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(String name) {
        return this.name.equals(name);
    }
}
