package com.starnw.football.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starnw.football.model.Country;
import com.starnw.football.model.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rajesh Mylsamy
 */

@Service
public class DataService {

    private String SERVER_NAME = "https://apiv2.apifootball.com/?league_id=148&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";
    private String STANDING_ACTION = "get_standings";
    private String COUNTRY_ACTION = "get_countries";

    @Autowired
    RestApiService restApiService;

    public List<Standing> getStandings() throws JsonProcessingException {
        String url = SERVER_NAME + "&action=" + STANDING_ACTION;
        Standing[] standings = restApiService.getCall(url, Standing[].class);
        return Arrays.asList(standings);
    }


    public List<Country> getCountry() throws JsonProcessingException {
        String url = SERVER_NAME + "&action=" + COUNTRY_ACTION;
        Country[] countries = restApiService.getCall(url, Country[].class);
        return Arrays.asList(countries);
    }
}








