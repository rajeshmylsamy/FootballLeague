package com.starnw.football.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Rajesh Mylsamy
 */

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {
    String country_name;
    int league_id;
    String league_name;
    int team_id;
    String team_name;
    int overall_league_position;
}
