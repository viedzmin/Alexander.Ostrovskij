package ua.net.ost.AlexanderOstrovskij.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pulse {

        public Pulse() {}
        @JsonIgnoreProperties(ignoreUnknown = true)
        public class PulseContent {
            String outputValue;
            public String getOutputValue() {
                return outputValue;
            }

            public void setOutputValue(String outputValue) {
                this.outputValue = outputValue;
            }
        }

        PulseContent pulse;

    public PulseContent getPulse() {
        return pulse;
    }

    public void setPulse(PulseContent pulse) {
        this.pulse = pulse;
    }
}
