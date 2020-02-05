package com.userAuth.controller;

import com.userAuth.payload.LoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {

    private HttpHeaders httpHeaders = new HttpHeaders();

    private TestRestTemplate restTemplate = new TestRestTemplate();

    String accessToken;

    @Test
    public void should_sign_in_successfully() throws Exception {
        LoginRequest loginRequest = new LoginRequest("deepak001", "hash@123");
        HttpEntity<LoginRequest> signUpEntity = new HttpEntity<>(loginRequest, httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:9090" + ("/api/auth/signin"), HttpMethod.POST, signUpEntity, String.class);

        Assert.assertTrue(response.getBody().contains("{\"accessToken\":"));
        Assert.assertTrue(response.getBody().contains("\"tokenType\":\"Bearer\"}"));
    }


    @Test
    public void should_return_user_List() throws Exception {
        LoginRequest loginRequest = new LoginRequest("deepak001", "hash@123");
        ResponseEntity<String> response = getStringResponseEntity(loginRequest);
        ResponseEntity<String> response1 = this.getStringResponseEntityApi();
        Assert.assertEquals(200, response1.getStatusCode().value());
        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void should_throw_forbiden() throws Exception {
        LoginRequest loginRequest = new LoginRequest("deepak002", "hash@123");
        ResponseEntity<String> response = getStringResponseEntity(loginRequest);
        ResponseEntity<String> response1 = this.getStringResponseEntityApi();
        Assert.assertEquals(403, response1.getStatusCode().value());
        Assert.assertNotNull(response.getBody());
    }

    private ResponseEntity<String> getStringResponseEntityApi() {
        httpHeaders.add("Authorization", "Bearer " + accessToken);
        HttpEntity<?> object = new HttpEntity<>(null, httpHeaders);
        return restTemplate.exchange(
                "http://localhost:9090"+"/api/auth/list", HttpMethod.GET, object, String.class);
    }

    private ResponseEntity<String> getStringResponseEntity(LoginRequest loginRequest) {
        HttpEntity<LoginRequest> signUpEntity = new HttpEntity<>(loginRequest, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:9090" + ("/api/auth/signin"), HttpMethod.POST, signUpEntity, String.class);
        JsonParser jsonParser = new JacksonJsonParser();
        accessToken = String.valueOf(jsonParser.parseMap(response.getBody()).get("accessToken"));
        return response;
    }
}
