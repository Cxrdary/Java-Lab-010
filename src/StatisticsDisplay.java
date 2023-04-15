public class StatisticsDisplay implements Display {
    private WeatherStation weatherStation;
    private float temperatureMin;
    private float temperatureMax;
    private float temperatureTotal;
    private int numReadings;

    public StatisticsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.registerDisplay(this);
    }

    public void update() {
        float temperature = weatherStation.getTemperature();
        temperatureTotal += temperature;
        numReadings++;

        if (temperature < temperatureMin) {
            temperatureMin = temperature;
        }

        if (temperature > temperatureMax) {
            temperatureMax = temperature;
        }

        display();
    }

    public void display() {
        float temperatureAverage = temperatureTotal / numReadings;
        System.out.printf("Temperature: Min=%.2fF, Max=%.2fF, Avg=%.2fF%n", temperatureMin, temperatureMax, temperatureAverage);
    }
}