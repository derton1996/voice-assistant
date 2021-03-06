package org.sibsutis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FSFileLoader extends FileLoader {
    private final String basePath;

    public FSFileLoader(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public InputStream newStream(String filename) throws IOException {
        return new FileInputStream(new File(basePath, filename));
    }
}
