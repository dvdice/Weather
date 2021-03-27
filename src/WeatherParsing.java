import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WeatherParsing {

    private File srcFile;

    public WeatherParsing(File srcFile) {
        this.srcFile = srcFile;
    }

    public List<WeatherEssence> readFile() throws Exception {
        List<WeatherEssence> weatherEssences = new ArrayList<>();
        Scanner scanner = new Scanner(srcFile);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] splittedArray = str.split(",");
            if (isNeededPart(splittedArray)){
                WeatherEssence weatherEssence = deserialization(splittedArray);
                weatherEssences.add(weatherEssence);
            }
        }

        return weatherEssences;
    }

    public boolean isNeededPart(String[] splittedArray){
        String firstPart = splittedArray[0];
        char symbol = firstPart.charAt(0);
        return symbol >= '0' & symbol <= '9';
    }

    private WeatherEssence deserialization(String[] splittedArray) throws Exception {
        WeatherEssence weatherEssence;
        Builder builder = new Builder();
        if(splittedArray.length < 5){
            return null;
        }else{
            String dateString = splittedArray[0];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmm");
            Date date = simpleDateFormat.parse(dateString);

            Double temperature = Double.parseDouble(splittedArray[1]);
            Double humidity = Double.parseDouble(splittedArray[2]);
            Double speed = Double.parseDouble(splittedArray[3]);
            Double direction = Double.parseDouble(splittedArray[4]);
            weatherEssence = builder
                    .date(date)
                    .temperature(temperature)
                    .humidity(humidity)
                    .speed(speed)
                    .direction(direction)
                    .build();
        }



        return weatherEssence;
    }


}
