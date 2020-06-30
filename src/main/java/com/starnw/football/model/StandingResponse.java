package com.starnw.football.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Rajesh Mylsamy
 */

@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StandingResponse {
    @JsonProperty(value = "Country ID & Name")
    String country;

    @JsonProperty(value = "League ID & Name")
    String league;

    @JsonProperty(value = "Team ID & Name")
    String team;

    @JsonProperty(value = "Overall League Position")
    int overall_league_position;

}
