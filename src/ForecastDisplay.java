class ForecastDisplay implements Display {
    private WeatherStation weatherStation;
    private float lastPressure;
    private float currentPressure;

    public ForecastDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerDisplay(this);
        this.lastPressure = this.weatherStation.getPressure();
        this.currentPressure = this.weatherStation.getPressure();
    }
    public void update() {
        lastPressure = currentPressure;
        currentPressure = this.weatherStation.getPressure();
        display();
    }

    public void display() {
        System.out.print("Forecast: ");

        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
