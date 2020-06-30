package com.starnw.FootballLeague;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.starnw.football.model.Country;
import com.starnw.football.model.Standing;
import com.starnw.football.model.StandingResponse;
import com.starnw.football.service.DataService;
import com.starnw.football.service.StandingsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = FootballLeagueApplicationTests.class)
@RunWith(MockitoJUnitRunner.class)
class FootballLeagueApplicationTests {

	private static DataService dataService;

	private static StandingsService standingsService;

	@BeforeAll
	public static void setup() throws JsonProcessingException {

		dataService = Mockito.mock(DataService.class);
		standingsService = new StandingsService(dataService);

		List<Standing> standings = new ArrayList<>();
		standings.add(new Standing("England",148, "Premier League", 2621, "Liverpool", 1));
		standings.add(new Standing("England",148, "Premier League", 2626, "Manchester City", 2));
		standings.add(new Standing("England",148, "Premier League", 2641, "Norwich", 20));

		when(dataService.getStandings()).thenReturn(standings);

		List<Country> countries = new ArrayList<>();
		countries.add(new Country("England",41,""));
		countries.add(new Country("France",46,""));

		when(dataService.getCountry()).thenReturn(countries);

	}

	@Test
	public void testStandingsWithAllArguments() throws JsonProcessingException {
		List<StandingResponse> standingList = standingsService.getStandings("England", "Premier League", "Manchester City");
		Assertions.assertTrue(standingList.get(0).getOverall_league_position() == 2, "All valid Arguments");
	}

	@Test
	public void testStandingsWithMissingArguments() throws JsonProcessingException {
		List<StandingResponse> standingList = standingsService.getStandings("England", null, "Manchester City");
		Assertions.assertTrue(standingList.isEmpty(), "Missing Arguments");
	}

	@Test
	public void testStandingsWithWrongData() throws JsonProcessingException {
		List<StandingResponse> standingList = standingsService.getStandings("England", "Premier2 League2", "Manchester City");
		Assertions.assertTrue(standingList.isEmpty(), "Wrong Arguments");
	}

	@Test
	public void testCountries() throws JsonProcessingException {
		List<Country> countries = dataService.getCountry();
		Assertions.assertTrue(countries.size() == 2, "All valid Arguments");
	}

	@Test
	public void testCountriesForIdLookup() throws JsonProcessingException {
		List<Country> countries = dataService.getCountry();
		countries.stream().filter(country -> country.getCountry_name().equals("France")).forEach(country -> {
			Assertions.assertTrue(country.getCountry_id() == 46, "Country Lookup validation");
		});
	}

}
