import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    private static final String path = "src/table.csv";

    public static void main(String[] args) throws Exception{

        doWrite(path, "res.txt");

    }
    private static void doWrite(String filePath, String endFilePath) throws Exception {
        WeatherParsing weatherParsing = new WeatherParsing(new File(Paths.get(filePath).toUri()));
        List<WeatherEssence> weatherEssencesList = weatherParsing.readFile();
        Manager manager = new Manager(weatherEssencesList);

        File file = new File(endFilePath);
        if(!file.exists()){
            file.createNewFile();
        }
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println("Average temperature " + manager.averageTemperature());
        printWriter.println("Average humidity " + manager.averageHumidity());
        printWriter.println("Average speed " + manager.averageSpeed());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd, HH");

        WeatherEssence maxTempDay = manager.maxTempDay();
        Date maxTempDate = maxTempDay.getDate();
        printWriter.println("Max temperature is " + maxTempDay.getTemperature() + "on " + simpleDateFormat.format(maxTempDate));

        WeatherEssence minHumidityDay = manager.minHumidityDay();
        Date minHumidityDate = minHumidityDay.getDate();
        printWriter.println("Min humidity is " + minHumidityDay.getHumidity() + "on " + simpleDateFormat.format(minHumidityDate));

        WeatherEssence maxSpeedDay = manager.maxSpeedDay();
        Date maxSpeedDate = maxSpeedDay.getDate();
        printWriter.println("Max speed is " + maxSpeedDay.getHumidity() + "on " + simpleDateFormat.format(maxSpeedDate));

        printWriter.println("The most frequent wind direction is " + manager.frequentDirection());


        printWriter.flush();
        printWriter.close();
    }
}
