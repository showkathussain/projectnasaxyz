package gov.nasa.tests.support.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:nasaapi.properties", ignoreResourceNotFound = true)

public class NasaApiConfig {

    @Value("${INTEGRATION.NASA.API.ENDPOINT.PARAM.ONE}")
    private String urlWithParamOne;

    @Value("${INTEGRATION.NASA.API.ENDPOINT.PARAM.TWO}")
    private String urlWithParamTwo;

    @Value("${INTEGRATION.NASA.API.ENDPOINT.PARAM.THREE}")
    private String urlWithParamThree;


    public String getUrlWithParamOne() {
        return urlWithParamOne;
    }

    public String getUrlWithParamTwo() {
        return urlWithParamTwo;
    }

    public String getUrlWithParamThree() {
        return urlWithParamThree;
    }
}
