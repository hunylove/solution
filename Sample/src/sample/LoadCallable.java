package sample;

import java.util.concurrent.Callable;

public class LoadCallable implements Callable<String> {

    private String type;

    private String value;

    public void setContext(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String call() throws Exception {
        try {
            String printStr = type + value;
            return printStr;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
}
