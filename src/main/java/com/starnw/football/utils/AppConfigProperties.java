package com.starnw.football.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rajesh Mylsamy
 */


@Data
@Configuration
@ConfigurationProperties(prefix ="app.football.league.data.server")
public class AppConfigProperties {
    private String url;
    private String leagueId;
    private String apiKey;

    public String getServerUrl() {
        return url + "?league_id=" + leagueId + "&APIkey=" + apiKey;
    }
}
