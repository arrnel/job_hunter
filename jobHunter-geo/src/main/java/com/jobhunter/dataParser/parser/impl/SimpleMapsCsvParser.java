package com.jobhunter.dataParser.parser.impl;

import com.jobhunter.dataParser.parser.FileParser;
import com.jobhunter.enums.CityType;
import com.jobhunter.model.City;
import com.jobhunter.model.Country;
import com.jobhunter.model.Region;
import com.jobhunter.repository.CityRepository;
import com.jobhunter.repository.CountryRepository;
import com.jobhunter.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

@Service
@RequiredArgsConstructor
public class SimpleMapsCsvParser implements FileParser {

    private final CountryRepository countryRep;
    private final RegionRepository regionRep;
    private final CityRepository cityRep;

    @Override
    public void parse(File file) {
        try (CSVParser parser = CSVParser.parse(file, StandardCharsets.UTF_8, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : parser) {
                String countryName = record.get("country"),
                        regionName = normalizeText(record.get("admin_name")),
                        cityName = record.get("city_ascii"),
                        cityType = record.get("capital"),
                        populationValue = record.get("population");

                Country country = countryRep.findByName(countryName).orElse(null);
                if (country == null) {
                    country = new Country();
                    country.setName(countryName);
                    countryRep.save(country);
                }

                Region region = regionRep.findByNameAndCountry(regionName, country).orElse(null);
                if (region == null) {
                    region = new Region();
                    region.setName(regionName);
                    region.setCountry(country);
                    regionRep.save(region);
                }

                City city = City.builder()
                        .name(cityName)
                        .region(region)
                        .country(country)
                        .cityType(CityType.getEnumByName(cityType).orElse(null))
                        .build();

                if (!populationValue.isEmpty()) {
                    try {
                        city.setPopulation(Long.parseLong(populationValue));
                    } catch (NumberFormatException ex) {
                        city.setPopulation(new BigDecimal(populationValue).longValue());
                    }
                } else {
                    city.setCityType(null);
                }

                cityRep.save(city);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private String normalizeText(String text) {
        return Normalizer.normalize(
                        text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("’", "'")
                .replaceAll("ǁ", "")
                .replaceAll("ı", "l")
                .replaceAll("Ł", "L")
                .replaceAll("ł", "l")
                .replaceAll("ø", "o")
                .replaceAll("Ħ", "H")
                .replaceAll("ħ", "h")
                .replaceAll("æ", "ae")
                .replaceAll("Đ", "D")
                .replaceAll("ð", "d")
                .replaceAll("þ", "b")
                .replaceAll("đ", "d")
                .replaceAll("ə", "a");
    }

}
