import java.util.Date;

public class WeatherEssence {
    private Date date;
    private Double temperature;
    private Double humidity;
    private Double speed;
    private Double direction;

    public WeatherEssence() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }

    public WeatherEssence(Date date, Double temperature, Double humidity, Double speed, Double direction) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "WeatherEssence{" +
                "date=" + date +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}
