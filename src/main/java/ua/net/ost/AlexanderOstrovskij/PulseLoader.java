package ua.net.ost.AlexanderOstrovskij;

import ua.net.ost.AlexanderOstrovskij.exceptions.PulseReadErrorException;

import java.util.Properties;

public interface PulseLoader {
    public String loadPulse(String path) throws PulseReadErrorException;
}
