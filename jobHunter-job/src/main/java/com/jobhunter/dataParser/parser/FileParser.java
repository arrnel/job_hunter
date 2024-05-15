package com.jobhunter.dataParser.parser;

import java.io.File;
import java.io.IOException;

public interface FileParser {

    void parse(File file) throws IOException;

}
