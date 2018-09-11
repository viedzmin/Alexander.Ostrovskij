package ua.net.ost.AlexanderOstrovskij;

import java.util.Properties;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import ua.net.ost.AlexanderOstrovskij.exceptions.HttpWrongStatusException;
import ua.net.ost.AlexanderOstrovskij.exceptions.PulseReadErrorException;
import ua.net.ost.AlexanderOstrovskij.model.Pulse;

import javax.ws.rs.core.MediaType;

public class PulseLoaderRestGET implements PulseLoader {

    @Override
    public String loadPulse(String path) throws PulseReadErrorException{

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource(path);

        try{
            // throws various exceptions
            ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                                                 .get(ClientResponse.class);
            try {
                int answerStatus = response.getStatus();
                if (answerStatus != 200) {
                    throw new HttpWrongStatusException("Connection to http server failed. Server code: " + answerStatus);
                }

                // throws exceptions
                Pulse output = response.getEntity(Pulse.class);

                return output.getPulse().getOutputValue();
            } finally {
                response.close();
            }
        } catch (ClientHandlerException | UniformInterfaceException | HttpWrongStatusException e) {
            throw new PulseReadErrorException(e.getMessage(),e);
        }

}
}
