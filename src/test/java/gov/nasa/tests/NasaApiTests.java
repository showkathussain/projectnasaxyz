package gov.nasa.tests;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import gov.nasa.tests.support.BaseTest;
import gov.nasa.tests.pojo.Sounds;
import gov.nasa.tests.service.NasaSoundApiService;
import gov.nasa.tests.support.library.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.HttpServerErrorException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;
import java.io.FileReader;

/****************************************************************************
    HTTP REQUEST - GET https://api.nasa.gov/planetary/sounds

    QUERY PARAMETERS

    Parameter	Type	    Default	    Description
    q	        string	    None	    Search text to filter results
    limit	    int	        10	        number of tracks to return
    api_key	    string	    DEMO_KEY	api.nasa.gov key for expanded usage

 ----------------------------- VALIDATIONS ----------------------------------

 1.	Test Search
    a.	With valid api key
        i.	Data Value & Default
        ii.	Response code
    b.	With invalid api key
        i.	Data Value & Default
        ii.	Response code
 2.	Test API Key
        i.	Data Value & Default
        ii.	Response code
 3.	Test Limit
    a.	With valid api key
        i.	Data Value & Default
        ii.	Response code
    b.	With invalid api key
        i.	Data Value & Default
        ii.	Response code
 4.	Test Search with Limit
    a.	With valid api key
        i.	Data Value & Default
        ii.	Response code
    b.	With invalid api key
        i.	Data Value & Default
        ii.	Response code
 5.	Test Schema
    a.	Keys
    b.	Type

 *******************************************************************************/

public class NasaApiTests extends BaseTest {

    @Autowired
    @Qualifier("nasaSoundApiService")
    protected NasaSoundApiService nasaSoundApiService;

    JsonReader jsonReader;
    Sounds sounds;
    int responseCode;
    SoftAssert softAssert;
    String apiKey;
    int limitNumTestData;
    String searchValue;

    @Test(groups = {"limitTestValue", "regression"}, description = "")
    public void limitTestValue() {
        softAssert = new SoftAssert();
        for (int x = 0; x < getTestData().getTestDataSet().getLimit().length; x++) {
            apiKey = getTestData().getTestDataSet().getApiKey()[0].getValue();
            limitNumTestData = getTestData().getTestDataSet().getLimit()[x].getValue();

            //passing limit values from test data json file
            sounds = nasaSoundApiService.getResponse("api_key", apiKey, "limit", Integer.toString(limitNumTestData));
            if (!(limitNumTestData < 0)) {
                softAssert.assertEquals(limitNumTestData, sounds.getCount());
                softAssert.assertEquals(limitNumTestData, sounds.getResults().length);
            } else {
                softAssert.assertEquals(10, sounds.getCount());
                softAssert.assertEquals(10, sounds.getResults());
            }

            //calling endpoint without limit parameter
            sounds = nasaSoundApiService.getResponse("api_key", apiKey);
            softAssert.assertEquals(10, sounds.getCount());
            softAssert.assertEquals(10, sounds.getResults().length);

        }
        softAssert.assertAll();
    }

    @Test(groups = {"limitTestResponseCode", "regression"}, description = "")
    public void limitTestResponseCode() {
        softAssert = new SoftAssert();
        for (int x = 0; x < getTestData().getTestDataSet().getLimit().length; x++) {
            apiKey = getTestData().getTestDataSet().getApiKey()[0].getValue();
            limitNumTestData = getTestData().getTestDataSet().getLimit()[x].getValue();

            //passing limit values from test data json file
            responseCode = nasaSoundApiService.getResponseCode("api_key", apiKey, "limit", Integer.toString(limitNumTestData)).value();
            softAssert.assertEquals(getTestData().getTestDataSet().getLimit()[x].getResponseCode(), responseCode);
        }

        try {
            //passing null value to limit
            responseCode = nasaSoundApiService.getResponseCode("api_key", apiKey, "limit", null).value();
            if(responseCode == 200){
                softAssert.assertTrue(true);
            }
        } catch (HttpServerErrorException exc) {
            if (exc.getStatusCode().is5xxServerError()) {
                softAssert.assertFalse(true);
            }
        }

        try {
            //passing string value to limit
            responseCode = nasaSoundApiService.getResponseCode("api_key", apiKey, "limit", "string").value();
            if(responseCode == 200){
                softAssert.assertTrue(true);
            }
        } catch (HttpServerErrorException exc) {
            if (exc.getStatusCode().is5xxServerError()) {
                softAssert.assertFalse(true);
            }
        }

        //passing limit without api key
        responseCode = nasaSoundApiService.getResponseCode("limit", Integer.toString(10)).value();
        if (responseCode == 403) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertFalse(false);
        }

        for(int y=0;y < getTestData().getTestDataSet().getApiKey().length; y++){
            //passing api key value from test data with limit
            responseCode = nasaSoundApiService.getResponseCode("api_key", getTestData().getTestDataSet().getApiKey()[y].getValue(), "limit", Integer.toString(10)).value();
            softAssert.assertEquals(getTestData().getTestDataSet().getApiKey()[y].getResponseCode(), responseCode);
        }

        softAssert.assertAll();
    }


    @Test(groups = {"apiKeyTestResponseCode", "regression"}, description = "")
    public void apiKeyTestResponseCode() {
        softAssert = new SoftAssert();
        for(int y=0;y < getTestData().getTestDataSet().getApiKey().length; y++){
            //passing api key value from test data
            responseCode = nasaSoundApiService.getResponseCode("api_key", getTestData().getTestDataSet().getApiKey()[y].getValue()).value();
            softAssert.assertEquals(getTestData().getTestDataSet().getApiKey()[y].getResponseCode(), responseCode);
        }

        //passing no api key
        responseCode = nasaSoundApiService.getResponseCode().value();
        if (responseCode == 403) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertFalse(false);
        }

        softAssert.assertAll();
    }

    @Test(groups = {"searchTestValue", "regression"}, description = "")
    public void searchTestValue(){
        softAssert = new SoftAssert();
        apiKey = getTestData().getTestDataSet().getApiKey()[0].getValue();

        for (int x = 0; x < getTestData().getTestDataSet().getSearch().length; x++) {

            //passing search value from test data
            if(getTestData().getTestDataSet().getSearch()[x].getType().contains("shows all")){
                sounds = nasaSoundApiService.getResponse("api_key", apiKey, "q", getTestData().getTestDataSet().getSearch()[x].getValue());
                if(!(sounds.getCount() > 10)){
                    softAssert.assertFalse(true);
                } else {
                    softAssert.assertTrue(false);
                }
            }

            //passing search value from test data
            if(getTestData().getTestDataSet().getSearch()[x].getType().contains("valid data")){
                sounds = nasaSoundApiService.getResponse("api_key", apiKey, "q", getTestData().getTestDataSet().getSearch()[x].getValue());
                if(!(sounds.getCount() == 3)){
                    softAssert.assertFalse(true);
                } else {
                    softAssert.assertTrue(false);
                }
            }

            //passing search value from test data
            if(getTestData().getTestDataSet().getSearch()[x].getType().contains("invalid number") || getTestData().getTestDataSet().getSearch()[x].getType().contains("special character")){
                sounds = nasaSoundApiService.getResponse("api_key", apiKey, "q", getTestData().getTestDataSet().getSearch()[x].getValue());
                if(!(sounds.getCount() == 0)){
                    softAssert.assertFalse(true);
                } else {
                    softAssert.assertTrue(false);
                }
            }
        }

        softAssert.assertAll();
    }

    @Test(groups = {"searchTestResponseCode", "regression"}, description = "")
    public void searchTestResponseCode(){
        softAssert = new SoftAssert();

        for (int x = 0; x < getTestData().getTestDataSet().getSearch().length; x++) {
            apiKey = getTestData().getTestDataSet().getApiKey()[0].getValue();

            //passing search values from test data json file
            responseCode = nasaSoundApiService.getResponseCode("api_key", apiKey, "q", getTestData().getTestDataSet().getSearch()[x].getValue()).value();
            softAssert.assertEquals(getTestData().getTestDataSet().getSearch()[x].getResponseCode(), responseCode);
        }

        //passing search value without api key
        responseCode = nasaSoundApiService.getResponseCode("q", "jfk").value();
        if (responseCode == 403) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertFalse(false);
        }

        for(int y=0;y < getTestData().getTestDataSet().getApiKey().length; y++){
            //passing api key value from test data with valid search
            responseCode = nasaSoundApiService.getResponseCode("api_key", getTestData().getTestDataSet().getApiKey()[y].getValue(), "q", "jfk").value();
            softAssert.assertEquals(getTestData().getTestDataSet().getApiKey()[y].getResponseCode(), responseCode);
        }
        softAssert.assertAll();
    }

    @Test(groups = {"searchTestWithLimitValue", "regression"}, description = "")
    public void searchTestWithLimitValue(){
        softAssert = new SoftAssert();
        apiKey = getTestData().getTestDataSet().getApiKey()[0].getValue();

        for(int x = 0; x < getTestData().getTestDataSet().getSearchWithLimit().length; x++){
            limitNumTestData = getTestData().getTestDataSet().getSearchWithLimit()[x].getLimit();
            searchValue = getTestData().getTestDataSet().getSearchWithLimit()[x].getSearch();

            sounds = nasaSoundApiService.getResponse("api_key", apiKey, "q", searchValue, "limit", Integer.toString(limitNumTestData));

            if(getTestData().getTestDataSet().getSearchWithLimit()[x].getType().contains("valid data - scenario 1")){
                if(sounds.getCount() == limitNumTestData){
                    softAssert.assertTrue(true);
                } else {
                    softAssert.assertFalse(false);
                }
            }

            if(getTestData().getTestDataSet().getSearchWithLimit()[x].getType().contains("valid data - scenario 2")){
                if(sounds.getCount() == limitNumTestData){
                    softAssert.assertTrue(true);
                } else {
                    softAssert.assertFalse(false);
                }
            }

            if(getTestData().getTestDataSet().getSearchWithLimit()[x].getType().contains("invalid data")){
                if(!(sounds.getCount() == limitNumTestData)){
                    softAssert.assertFalse(true);
                } else {
                    softAssert.assertTrue(false);
                }
            }
        }
        softAssert.assertAll();
    }

    @Test(groups = {"searchTestWithLimitResponseCode", "regression"}, description = "")
    public void searchTestWithLimitResponseCode(){
        softAssert = new SoftAssert();

        for(int x = 0; x < getTestData().getTestDataSet().getSearchWithLimit().length; x++) {
            limitNumTestData = getTestData().getTestDataSet().getSearchWithLimit()[x].getLimit();
            searchValue = getTestData().getTestDataSet().getSearchWithLimit()[x].getSearch();

            //passing values from test data json file
            responseCode = nasaSoundApiService.getResponseCode("api_key", getTestData().getTestDataSet().getApiKey()[0].getValue(), "q", searchValue, "limit", Integer.toString(limitNumTestData)).value();
            softAssert.assertEquals(getTestData().getTestDataSet().getSearchWithLimit()[x].getResponseCode(), responseCode);
        }

        //passing search and limit without api key
        responseCode = nasaSoundApiService.getResponseCode("q", "", "limit", "20").value();
        if (responseCode == 403) {
            softAssert.assertTrue(true);
        } else {
            softAssert.assertFalse(false);
        }

        for(int y=0;y < getTestData().getTestDataSet().getApiKey().length; y++){
            //passing api key value from test data with limit & search
            responseCode = nasaSoundApiService.getResponseCode("api_key", getTestData().getTestDataSet().getApiKey()[y].getValue(), "q", "", "limit", "20").value();
            softAssert.assertEquals(getTestData().getTestDataSet().getApiKey()[y].getResponseCode(), responseCode);
        }
        softAssert.assertAll();
    }

    @Test(groups = {"validateJsonSchemaAndDataTypeBySerializingAndDeserializing", "regression"}, description = "")
    public void validateJsonSchemaAndDataTypeBySerializingAndDeserializing() {
        softAssert = new SoftAssert();

        String responseDataAsString = nasaSoundApiService.getResponseAsString("api_key",  getTestData().getTestDataSet().getApiKey()[0].getValue());
        Sounds responseDataAsObject = nasaSoundApiService.getResponse("api_key",  getTestData().getTestDataSet().getApiKey()[0].getValue());

        String responseDataAfterConversionFromObject = new Gson().toJson(responseDataAsObject);

        System.out.println("responseDataAsString : " + responseDataAsString);
        System.out.println("responseDataAfterConversionFromObject : " + responseDataAfterConversionFromObject);

        softAssert.assertEquals(responseDataAsString, responseDataAfterConversionFromObject);
        softAssert.assertAll();
    }

    public Data getTestData() {
        Gson gson = new Gson();
        try {
            jsonReader = new JsonReader(
                    new FileReader("src/test/resources/testdataset.json"));
        } catch (FileNotFoundException exc) {
            exc.getMessage();
        }
        Data testDataSet = gson.fromJson(jsonReader, Data.class);
        return testDataSet;
    }
}
