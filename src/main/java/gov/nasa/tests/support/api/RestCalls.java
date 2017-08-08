package gov.nasa.tests.support.api;

import org.springframework.http.HttpStatus;

import java.util.Map;

public interface RestCalls {

    <T> T getResponse(String endpointUrl, Class<T> returnType, Map<String, String> params);

    <T> HttpStatus getStatusCode(String endpointUrl, Class<T> returnType, Map<String, String> params);
}
