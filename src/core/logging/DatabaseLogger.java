package core.logging;

public class DatabaseLogger implements BaseLogger{

    @Override
    public void Logger(String logData) {

        System.out.println(logData + " is logged in database.");
    }
}
