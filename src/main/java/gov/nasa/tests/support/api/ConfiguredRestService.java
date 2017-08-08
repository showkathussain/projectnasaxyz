package gov.nasa.tests.support.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ConfiguredRestService extends RestTemplate {

    @Autowired
    private GsonResponseConverter gsonConverterConfiguration;


    ConfiguredRestService() {
        super();
    }

    public void getMessageConvertersForJsonFormat() {
        defineMessageConvertersForJsonFormat();
    }

    private void defineMessageConvertersForJsonFormat() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(gsonConverterConfiguration.gsonHttpMessageConverter());
        setMessageConverters(messageConverters);
    }
}
