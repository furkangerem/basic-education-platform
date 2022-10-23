package core.logging;

public class EmailLogger implements BaseLogger{

    @Override
    public void Logger(String logData) {

        System.out.println(logData + " is logged in e-mail.");
    }
}
