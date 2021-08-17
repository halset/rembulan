package net.sandius.rembulan.env;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 */
public class SystemResourceFinder implements ResourceFinder {

    private static final ResourceFinder INSTANCE = new SystemResourceFinder();

    @Override
    public InputStream findResource(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    /**
     * 
     * @return
     */
    public static ResourceFinder getInstance() {
        return INSTANCE;
    }

}
