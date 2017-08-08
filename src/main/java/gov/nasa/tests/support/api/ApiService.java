package gov.nasa.tests.support.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.Reporter;

import java.util.Map;

@Component
@Scope("prototype")
public class ApiService implements RestCalls {

    @Autowired
    private ConfiguredRestService configuredRestService;

    public ApiService() {
        super();
    }

    @Override
    public <T> T getResponse(String endpointUrl, Class<T> returnType, Map<String, String> params) {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(endpointUrl).buildAndExpand(params);
        RequestEntity<?> requestEntity = new RequestEntity(HttpMethod.GET, uriComponents.toUri());
        Reporter.log(requestEntity.getUrl().toString());
        if(!returnType.equals(String.class)){
            configuredRestService.getMessageConvertersForJsonFormat();
        }
        return configuredRestService.exchange(requestEntity, returnType).getBody();
    }

    @Override
    public <T> HttpStatus getStatusCode(String endpointUrl, Class<T> returnType, Map<String, String> params) {

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(endpointUrl).buildAndExpand(params);
        RequestEntity<?> requestEntity = new RequestEntity(HttpMethod.GET, uriComponents.toUri());
        Reporter.log(requestEntity.getUrl().toString());
        if(!returnType.equals(String.class)){
            configuredRestService.getMessageConvertersForJsonFormat();
        }
        return configuredRestService.exchange(requestEntity, returnType).getStatusCode();
    }
}
