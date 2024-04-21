package com.jobhunter.dataParser.extractor.impl;

import com.jobhunter.dataParser.extractor.FileExtractor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ZipExtractor implements FileExtractor {

    @Override
    public File extract(@NonNull File zipFile, @NonNull String fileNameToExtract) {

        try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile.toPath(), getClass().getClassLoader())) {
            Path fileToExtract = fileSystem.getPath(fileNameToExtract);
            Path destinationDir = zipFile.getParentFile().toPath();
            return Files.copy(fileToExtract, destinationDir.resolve(fileNameToExtract)).toFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
