package cn.hopever.platform.utils.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by Donghui Huo on 2016/10/31.
 */
public class FileUtil {
    public static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    public static String readFile(File file){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = reader.readLine()) != null)
                builder.append(line);
        } catch (IOException e) {
            logger.warn("file open problem:" + e );
        } finally {
            closeQuietly(reader);
        }
        return builder.toString();
    }

    private static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ignored) {
                logger.warn("file close problem:" +ignored );
            }
        }
    }

}
