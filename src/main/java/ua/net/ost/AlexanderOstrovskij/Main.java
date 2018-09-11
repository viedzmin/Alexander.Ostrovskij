package ua.net.ost.AlexanderOstrovskij;

import ua.net.ost.AlexanderOstrovskij.exceptions.PulseReadErrorException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties config = new Properties();
        try {
            config.load(new FileReader("config/app.properties"));
        } catch (IOException e) {
            System.err.println("Could not read config file, giving up...");
            e.printStackTrace();
            System.exit(1);
        }
        PulseLoader loader = new PulseLoaderRestGET();
        String pulse = "";
        try {
            pulse = loader.loadPulse(config.getProperty("web.RestGetURL"));
        } catch (PulseReadErrorException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.calculate(pulse));
    }
}
