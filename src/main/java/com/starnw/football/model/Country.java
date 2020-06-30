package com.starnw.football.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rajesh Mylsamy
 */

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    String country_name;
    int country_id;
    String country_logo;
}

