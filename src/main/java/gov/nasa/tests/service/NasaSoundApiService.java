package gov.nasa.tests.service;

import gov.nasa.tests.support.BaseTest;
import gov.nasa.tests.pojo.Sounds;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("nasaSoundApiService")
@Scope("prototype")
public class NasaSoundApiService extends BaseTest {


    public Sounds getResponse() {
        Map<String, String> vars = new HashMap<String, String>();
        return apiService.getResponse(nasaApiConfig.getUrlWithParamOne(), Sounds.class, vars);
    }

    public String getResponseAsString(String keyOne, String keyOneValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyOneValue", keyOneValue);
        return apiService.getResponse(nasaApiConfig.getUrlWithParamOne(), String.class, vars);
    }

    public Sounds getResponse(String keyOne, String keyOneValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyOneValue", keyOneValue);
        return apiService.getResponse(nasaApiConfig.getUrlWithParamOne(), Sounds.class, vars);
    }

    public Sounds getResponse(String keyOne, String keyOneValue, String keyTwo, String keyTwoValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyTwo", keyTwo);
        vars.put("keyOneValue", keyOneValue);
        vars.put("keyTwoValue", keyTwoValue);
        return apiService.getResponse(nasaApiConfig.getUrlWithParamTwo(), Sounds.class, vars);
    }

    public Sounds getResponse(String keyOne, String keyOneValue, String keyTwo, String keyTwoValue, String keyThree, String keyThreeValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyTwo", keyTwo);
        vars.put("keyThree", keyThree);
        vars.put("keyOneValue", keyOneValue);
        vars.put("keyTwoValue", keyTwoValue);
        vars.put("keyThreeValue", keyThreeValue);
        return apiService.getResponse(nasaApiConfig.getUrlWithParamThree(), Sounds.class, vars);
    }

    public HttpStatus getResponseCode() {
        Map<String, String> vars = new HashMap<String, String>();
        return apiService.getStatusCode(nasaApiConfig.getUrlWithParamOne(), Sounds.class, vars);
    }

    public HttpStatus getResponseCode(String keyOne, String keyOneValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyOneValue", keyOneValue);
        return apiService.getStatusCode(nasaApiConfig.getUrlWithParamOne(), Sounds.class, vars);
    }

    public HttpStatus getResponseCode(String keyOne, String keyOneValue, String keyTwo, String keyTwoValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyTwo", keyTwo);
        vars.put("keyOneValue", keyOneValue);
        vars.put("keyTwoValue", keyTwoValue);
        return apiService.getStatusCode(nasaApiConfig.getUrlWithParamTwo(), Sounds.class, vars);
    }

    public HttpStatus getResponseCode(String keyOne, String keyOneValue, String keyTwo, String keyTwoValue, String keyThree, String keyThreeValue) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("keyOne", keyOne);
        vars.put("keyTwo", keyTwo);
        vars.put("keyThree", keyThree);
        vars.put("keyOneValue", keyOneValue);
        vars.put("keyTwoValue", keyTwoValue);
        vars.put("keyThreeValue", keyThreeValue);
        return apiService.getStatusCode(nasaApiConfig.getUrlWithParamThree(), Sounds.class, vars);
    }
}
