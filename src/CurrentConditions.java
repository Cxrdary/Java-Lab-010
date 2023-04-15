class CurrentConditions implements Display {
    private WeatherStation weatherStation;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditions(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
    }

    public void update() {
        this.temperature = this.weatherStation.getTemperature();
        this.humidity = this.weatherStation.getHumidity();
        this.pressure = this.weatherStation.getPressure();
        display();
    }

    public void display() {
        System.out.println("Current Conditions:");
        System.out.printf("Temperature: %.2f F\n", temperature);
        System.out.printf("Humidity: %.2f %%\n", humidity);
        System.out.printf("Pressure: %.2f inHg\n", pressure);
    }
}
