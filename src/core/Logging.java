package core;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
    Logger logger = Logger.getLogger(this.getClass().getName());
    FileHandler fh;

    public Logging() {
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:\\Users\\maierr\\PycharmProjects\\LinkedList\\src\\core\\List.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();

            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
