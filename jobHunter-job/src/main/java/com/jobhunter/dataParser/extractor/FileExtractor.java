package com.jobhunter.dataParser.extractor;

import java.io.File;

public interface FileExtractor {
    File extract(File file, String fileNameToExtract);
}
