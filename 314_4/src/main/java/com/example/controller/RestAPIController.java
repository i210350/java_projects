package com.example.controller;

import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;


@RestController
@RequestMapping("/users")
public class RestAPIController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String getUsers() throws JsonProcessingException, JSONException {
        String url = "http://91.241.64.178:7081/api/users";

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        List<String> cookies = response.getHeaders().get("Cookie");
        if (cookies == null) {
            cookies = response.getHeaders().get("Set-Cookie");
        }
        String cookie = cookies.get(cookies.size() - 1);
        int start = cookie.indexOf('=');
        int end = cookie.indexOf(';');

        String strSessionId = cookie.substring(start + 1, end);
        System.out.println(strSessionId);

        headers.add("Cookie", "JSESSIONID=" + strSessionId);

        //POST
        User newUser = new User(3L,"James", "Brown", (byte) 33);
        HttpEntity<User> entity = new HttpEntity<>(newUser, headers);
        ResponseEntity<String> postResponse = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println(postResponse);
        String stringOut ="";
        stringOut += postResponse.getBody();


        ///PUT
        User editUser = new User(3L,"Thomas", "Shelby", (byte) 27);
        ResponseEntity<String> putResponse = restTemplate.exchange(url , HttpMethod.PUT, entity,
                                                                    String.class, Long.toString(editUser.getId()));
        System.out.println(putResponse);
        stringOut += putResponse.getBody();

        ///DELETE
        url = url + "/" + editUser.getId();
        ResponseEntity<String> deleteResponse = restTemplate.exchange(url , HttpMethod.DELETE, entity, String.class);
        stringOut += deleteResponse.getBody();

        return "code:    " + stringOut;
    }


}
