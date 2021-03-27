import java.util.*;
import java.util.stream.Collectors;

public class Manager {
    private List<WeatherEssence> weatherEssences;


    public Manager(List<WeatherEssence> weatherEssences) {
        this.weatherEssences = weatherEssences;
    }


    public Double averageTemperature() {
        return weatherEssences.stream().mapToDouble((weatherEssences) -> weatherEssences.getTemperature()).average().getAsDouble();
    }


    public Double averageHumidity() {

        return weatherEssences.stream().mapToDouble((weatherEssence) -> weatherEssence.getHumidity()).average().getAsDouble();
    }


    public Double averageSpeed() {
        return weatherEssences.stream().mapToDouble((weatherEssence) -> weatherEssence.getSpeed()).average().getAsDouble();
    }


    public WeatherEssence maxTempDay() {
        Double maxTemperature = weatherEssences.stream().mapToDouble((weatherEssence) -> weatherEssence.getTemperature()).max().getAsDouble();
        return weatherEssences.stream().filter((weatherEssence) -> weatherEssence.getTemperature().equals(maxTemperature)).findFirst().get();
    }


    public WeatherEssence minHumidityDay() {
        Double minHumidity = weatherEssences.stream().mapToDouble((weatherEssence) -> weatherEssence.getHumidity()).min().getAsDouble();
        return weatherEssences.stream().filter((weatherEssence) -> weatherEssence.getHumidity().equals(minHumidity)).findFirst().get();
    }


    public WeatherEssence maxSpeedDay() {
        Double maxSpeed = weatherEssences.stream().mapToDouble((weatherEssence) -> weatherEssence.getSpeed()).max().getAsDouble();

        return weatherEssences.stream().filter((weatherEssence) -> weatherEssence.getSpeed().equals(maxSpeed)).findFirst().get();
    }


    public String frequentDirection() {
        List<String> directions = weatherEssences.stream().map((weatherEssence) -> {
            double direction = weatherEssence.getDirection();
            if (direction >= 315 | direction <= 45){
                return "N";
            }else if(direction >= 45 & direction < 135){
                return "E";
            }else if(direction >= 135 & direction <= 225){
                return "S";
            }else {
                return "W";
            }
        }).collect(Collectors.toList());
        TreeMap<String, Long> treeMap = new TreeMap<>();
        treeMap.put("N", directions.stream().filter(direction -> direction.equals("N")).count());
        treeMap.put("E", directions.stream().filter(direction -> direction.equals("E")).count());
        treeMap.put("S", directions.stream().filter(direction -> direction.equals("S")).count());
        treeMap.put("W", directions.stream().filter(direction -> direction.equals("W")).count());
        Collection<Long> values = treeMap.values();
        Long maxValue = values.stream().mapToLong(x -> x).max().getAsLong();
        Set<String> keySet = treeMap.keySet();
        return keySet.stream().filter(key -> treeMap.get(key).equals(maxValue)).findFirst().get();
    }

}
