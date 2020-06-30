package com.starnw.football.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.starnw.football.model.Country;
import com.starnw.football.model.Standing;
import com.starnw.football.model.StandingResponse;
import com.starnw.football.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StandingsService {

    @Autowired
    DataService dataService;

    public StandingsService(DataService dataService) {
        this.dataService = dataService;
    }

    public List<StandingResponse> getStandings(String countryName, String leagueName, String teamName) throws JsonProcessingException {

        Map<String, Integer> countries = new HashMap<>();
        dataService.getCountry().stream().forEach(country -> countries.put(country.getCountry_name(), country.getCountry_id()));

        List<Standing> standings = dataService.getStandings();
        return standings.stream()
                .filter(standing -> standing.getCountry_name().equals(countryName))
                .filter(standing -> standing.getLeague_name().equals(leagueName))
                .filter(standing -> standing.getTeam_name().equals(teamName))
                .map(standing -> new StandingResponse(StringUtils.formatName(countries.get(standing.getCountry_name()),standing.getCountry_name())
                        ,StringUtils.formatName(standing.getLeague_id(), standing.getLeague_name())
                        ,StringUtils.formatName(standing.getTeam_id(), standing.getTeam_name())
                        ,standing.getOverall_league_position()))
                .collect(Collectors.toList());

    }

    public List<StandingResponse> getAllStandings() throws JsonProcessingException {
        return dataService.getStandings().stream()
                .map(standing -> new StandingResponse(standing.getCountry_name(), standing.getLeague_name(), standing.getTeam_name(), standing.getOverall_league_position()))
                .collect(Collectors.toList());
    }



}
