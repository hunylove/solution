package sample05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Sample05 {
    
    public static void main(String[] args) throws ParseException {
        
        LocalDateTime now = LocalDateTime.now();
        String strDT = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

        System.out.println(strDT);

        long ct = System.currentTimeMillis();
        String strCT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(ct);

        System.out.println(strCT);

        String strTime = "2022-06-13 22:05:49.097";
        Date dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(strTime);

        System.out.println(dt);
    
    }

}
