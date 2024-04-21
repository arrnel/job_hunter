package com.jobhunter.dataParser.downloader.impl;

import com.jobhunter.config.Config;
import com.jobhunter.dataParser.downloader.FileDownloader;
import com.jobhunter.enums.ECode;
import com.jobhunter.exception.InvalidDownloadLink;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleMapsFileDownloader implements FileDownloader {

    private final RestTemplate restTemplate;

    @Override
    public File download() {

        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        String url = "https://simplemaps.com/static/data/world-cities/basic/simplemaps_worldcities_basicv" + Config.Geo.simpleMapsFileVersion() + ".zip";
        return restTemplate.execute(url, HttpMethod.GET, null, clientHttpResponse -> {

            if (!clientHttpResponse.getStatusCode().is2xxSuccessful())
                throw new InvalidDownloadLink(ECode.INVALID_DOWNLOAD_LINK, "Wrong link: [" + url + "]");

            File folder = Files.createDirectories(Paths.get("src/main/resources/world_cities/world_cities_" + currentTime)).toFile();
            File newFile = new File(folder, "data.zip");
            StreamUtils.copy(clientHttpResponse.getBody(), new FileOutputStream(newFile));
            return newFile;

        });

    }

}
