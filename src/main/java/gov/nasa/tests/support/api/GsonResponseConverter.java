package gov.nasa.tests.support.api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GsonResponseConverter {

    public GsonResponseConverter() {
        super();
    }

    public GsonHttpMessageConverter gsonHttpMessageConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }
}
