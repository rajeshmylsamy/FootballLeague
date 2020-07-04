package com.starnw.football.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starnw.football.model.Country;
import com.starnw.football.model.Standing;
import com.starnw.football.utils.AppConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

/**
 * @author Rajesh Mylsamy
 */

@Service
public class DataService {

    @Autowired
    private AppConfigProperties appConfigProperties;

    @Autowired
    RestApiService restApiService;

    private String STANDING_ACTION = "get_standings";
    private String COUNTRY_ACTION = "get_countries";

    public List<Standing> getStandings() throws JsonProcessingException {
        String url = appConfigProperties.getServerUrl() + "&action=" + STANDING_ACTION;
        Standing[] standings = restApiService.getCall(url, Standing[].class);
        return Arrays.asList(standings);
    }


    public List<Country> getCountry() throws JsonProcessingException {
        String url = appConfigProperties.getServerUrl() + "&action=" + COUNTRY_ACTION;
        Country[] countries = restApiService.getCall(url, Country[].class);
        return Arrays.asList(countries);
    }
}








