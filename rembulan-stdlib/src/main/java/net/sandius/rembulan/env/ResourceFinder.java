package net.sandius.rembulan.env;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 */
public interface ResourceFinder {

    /**
     * @param fileName a String with the file name.
     * @return a InputStream with the file content or null.
     * @throws IOException
     */
    public InputStream findResource(String fileName) throws IOException;

}
