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
        File file = downloader.download();
        file = extractor.extract(file, "worldcities.csv");
        parser.parse(file);
    }

}
