package com.training.restapi.controller;

import static org.junit.Assert.fail;

import java.util.Objects;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JukeboxSettingsControllerTests {

    private static final String MODEL = "model5";
    private static final String SETTINGS_ID = "09809898as8908a0ds9f890adf";
    private static final String OFFSET = "0";
    private static final String LIMIT = "10";
    private static final String JUKEBOXLISTPATH = "/jukeboxlist";
    private static final String LOCALHOST = "http://localhost:";

    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetJukeboxList() {
        String body = restTemplate
                .getForObject(createURLWithPort(JUKEBOXLISTPATH, SETTINGS_ID, MODEL, OFFSET, LIMIT), String.class);
        String expResult = "[{\"id\":\"09809898as8908a0ds9f890adf\",\"model\":\"model5\",\"components\":[{\"name\":\"Name\"}]}]";
        try {
            JSONAssert.assertEquals(expResult, body, false);
        } catch (JSONException e) {
            fail(e.getMessage());
        }
    }

    //create an url to compare with the result of the test
    private String createURLWithPort(String... parameters) {
        StringBuilder sb = new StringBuilder(1024);
        sb.append(LOCALHOST);
        sb.append(port);
        if (Objects.nonNull(parameters)) {
            for (String parameter : parameters) {
                sb.append("/").append(parameter);
            }
        }
        return sb.toString();
    }
}