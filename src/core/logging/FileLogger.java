package core.logging;

public class FileLogger implements BaseLogger{

    @Override
    public void Logger(String logData) {

        System.out.println(logData + " is logged in file.");
    }
}
