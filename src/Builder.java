import java.util.Date;

public class Builder {
    private static WeatherEssence weatherEssence;

    public Builder() {
        weatherEssence = new WeatherEssence();
    }

    public WeatherEssence build(){
        return weatherEssence;
    }

    public Builder date(Date date) {
        weatherEssence.setDate(date);
        return this;
    }

    public Builder temperature(Double temperature){
        weatherEssence.setTemperature(temperature);
        return this;
    }

    public Builder speed(Double speed){
        weatherEssence.setSpeed(speed);
        return this;
    }

    public Builder humidity(Double humidity){
        weatherEssence.setHumidity(humidity);
        return this;
    }

    public Builder direction(Double direction){
        weatherEssence.setDirection(direction);
        return this;
    }
}
