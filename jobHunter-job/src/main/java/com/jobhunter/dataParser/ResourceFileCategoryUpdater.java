package com.jobhunter.dataParser;

import com.jobhunter.config.Config;
import com.jobhunter.dataParser.extractor.FileExtractor;
import com.jobhunter.dataParser.parser.FileParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceFileCategoryUpdater implements CategoryUpdater {

    private final ResourceLoader resourceLoader;
    private final FileExtractor extractor;
    private final FileParser parser;

    @Override
    @SneakyThrows
    public void update() {

        String path = Config.Job.pathToCategoriesFile();
        log.info("Start parsing categories file from resources: [{}]", path);
        File file = resourceLoader.getResource("classpath:" + path).getFile();
        if (!file.exists())
            throw new FileNotFoundException("Categories file not found. Path = [" + file.getAbsolutePath() + "]");
        parser.parse(file);
        log.info("Successfully parsed and saved categories data into db");

    }

}
