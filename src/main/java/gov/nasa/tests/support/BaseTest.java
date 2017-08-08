package gov.nasa.tests.support;

import gov.nasa.tests.support.api.ApiService;
import gov.nasa.tests.support.config.NasaApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = { "classpath:spring-test-config.xml" })
public class BaseTest extends AbstractTestNGSpringContextTests{

    @Autowired
    protected ApiService apiService;

    @Autowired
    protected NasaApiConfig nasaApiConfig;
}
