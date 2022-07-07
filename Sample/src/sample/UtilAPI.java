package sample;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UtilAPI {
    
    public static void main(String[] args) throws ParseException {

        // 현재 날짜, 시각 문자열 가져오기
        LocalDateTime now = LocalDateTime.now();
        String strDT = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

        System.out.println(strDT);

        long ct = System.currentTimeMillis();
        String strCT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(ct);

        System.out.println(strCT);

        // 문자열 날짜, 시각 => Date 타입으로 변경
        String strTime = "2022-06-13 22:05:49.097";
        Date dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(strTime);

        System.out.println(dt);

        // 시간 차이 계산
        String start = "20220331142310";
        String end = "20220331142420";
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dd1 = sf.parse(start);
        Date dd2 = sf.parse(end);
        long diff = dd2.getTime() - dd1.getTime();

        System.out.println(diff/1000);

        // 10진수 4자리로 출력
        int a = 14;
        System.out.println(String.format("%04d", a));

        // 16진수 출력
        System.out.println(String.format("%02X %02x", a, a));

        // 소수점 출력
        double b = 12.345678;
        System.out.println(String.format("%08.3f", b));

        // 위치로 자르기
        String strTest = "My book | You pen | His desk";
        System.out.println(strTest.substring(10));
        System.out.println(strTest.substring(10, 18));

        // Delimiter 사용하여 자르기
        String[] words = strTest.split("\\| ");
        for (String item : words)
            System.out.println(item);

        // String -> Byte Array
        strTest = "ABCD123";
        byte[] byteTest = new byte[80];
        byteTest = strTest.getBytes(StandardCharsets.UTF_8);
        for (byte by : byteTest)
            System.out.print(by + " ");

        // Byte Array -> String    
        String strTest2 = new String(byteTest);
        System.out.println(strTest2);
    }
}
