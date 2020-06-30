package com.starnw.football.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starnw.football.model.Standing;
import com.starnw.football.model.StandingResponse;
import com.starnw.football.service.StandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rajesh Mylsamy
 */

@RestController
public class StandingsController {

    @Autowired
    private StandingsService standingsService;

    @RequestMapping("/standing")
    public List<StandingResponse> getStandings(@RequestParam(name = "country_name", required = false) String countryName,
                                               @RequestParam(name = "league_name", required = false) String leagueName,
                                               @RequestParam(name = "team_name", required = false) String teamName
    ) throws JsonProcessingException {
        return standingsService.getStandings(countryName, leagueName, teamName);
    }

    @RequestMapping("/standings")
    public List<StandingResponse> getAllStandings() throws JsonProcessingException {
        return standingsService.getAllStandings();
    }




}