package com.jobhunter.service.external;

import com.jobhunter.config.Config;
import com.jobhunter.dto.geo.CityResponse;
import com.jobhunter.dto.geo.CountryResponse;
import com.jobhunter.dto.geo.RegionResponse;
import com.jobhunter.exception.InvalidRequestParamException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.jobhunter.enums.ECode.INVALID_REQUEST_PARAM;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private static final Integer port = Config.Port.geo();
    private final WebClient webClient;

    private Object getLocation(LocationType locationType, Integer id) {
        String url = "http://localhost:" + port + "/api/v1/" + locationType.toString().toLowerCase() + "/" + id;

        Class<?> clazz = (locationType == LocationType.City) ? CityResponse.class : (locationType == LocationType.Region ? RegionResponse.class : CountryResponse.class);

        return webClient.get()
                .uri(url)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError
                        , response -> Mono.error(new InvalidRequestParamException(INVALID_REQUEST_PARAM, locationType + " with id = [" + id + "] not found")
                        ))
                .onStatus(
                        HttpStatusCode::is5xxServerError
                        , response -> Mono.error(new InvalidRequestParamException(
                                INVALID_REQUEST_PARAM
                                , "Unknown error of geo service"))
                )
                .bodyToFlux(clazz)
                .blockFirst();
    }

    public CityResponse getCity(Integer cityId) {
        return (CityResponse) getLocation(LocationType.City, cityId);
    }

    public RegionResponse getRegion(Integer regionId) {
        return (RegionResponse) getLocation(LocationType.Region, regionId);
    }

    public CountryResponse getCountry(Integer countryId) {
        return (CountryResponse) getLocation(LocationType.Country, countryId);
    }

    private enum LocationType {
        City, Country, Region
    }

}
