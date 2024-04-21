package com.jobhunter.dataParser;

import com.jobhunter.dataParser.downloader.FileDownloader;
import com.jobhunter.dataParser.extractor.FileExtractor;
import com.jobhunter.dataParser.parser.FileParser;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleMapsRegionParser implements LocationUpdater {

    private final FileDownloader downloader;
    private final FileExtractor extractor;
    private final FileParser parser;

    @Override
    public void update() {

        log.info("Parse location data from https://simplemaps.com/data/world-cities");

        File file = downloader.download();
        log.info("Successfully downloaded file from external resource: {}", file.getAbsolutePath());

        file = extractor.extract(file, "worldcities.csv");
        log.info("Successfully extracted csv file from archive: {}", file.getAbsolutePath());

        parser.parse(file);
        log.info("Successfully parsed and saved location data into db");

    }

}
