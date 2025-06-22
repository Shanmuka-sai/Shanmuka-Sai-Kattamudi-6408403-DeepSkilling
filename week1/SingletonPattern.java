public class Logger {
    private Logger() {
    }

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    public void log(String message) {
        System.out.println("Logging: " + message);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("System started.");
        logger.log("User logged in.");
        logger.log("Process completed.");
    }
}
