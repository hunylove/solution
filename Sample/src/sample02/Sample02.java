package sample02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample02 {

    public static void main(String[] args) {
        List<Map<String, Object>> studentList = new ArrayList<>();

        read(studentList);

        // 이름으로 오름차순
        Collections.sort(studentList, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = (String) o1.get("name");
                String name2 = (String) o2.get("name");

                return name1.compareTo(name2);
            }
            
        });

        System.out.println("PRINT");
        for (Map<String, Object> student : studentList) {
            System.out.println(student.get("name") + "\t" + student.get("korean") + "\t" + student.get("english") + "\t" + student.get("math"));
        }

        // 국어점수로 내림차순
        Collections.sort(studentList, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = (String) o1.get("name");
                String name2 = (String) o2.get("name");

                Integer korean1 = (Integer) o1.get("korean");
                Integer korean2 = (Integer) o2.get("korean");

                return korean2.compareTo(korean1) == 0 ? name1.compareTo(name2) : korean2.compareTo(korean1);
            }
            
        });

        System.out.println("KOREAN");
        for (Map<String, Object> student : studentList) {
            System.out.println(student.get("name") + "\t" + student.get("korean") + "\t" + student.get("english") + "\t" + student.get("math"));
        }

        // 영어점수로 내림차순
        Collections.sort(studentList, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = (String) o1.get("name");
                String name2 = (String) o2.get("name");

                Integer english1 = (Integer) o1.get("english");
                Integer english2 = (Integer) o2.get("english");

                return english2.compareTo(english1) == 0 ? name1.compareTo(name2) : english2.compareTo(english1);
            }
            
        });

        System.out.println("ENGLISH");
        for (Map<String, Object> student : studentList) {
            System.out.println(student.get("name") + "\t" + student.get("korean") + "\t" + student.get("english") + "\t" + student.get("math"));
        }

        // 수학점수로 내림차순
        Collections.sort(studentList, new Comparator<Map<String, Object>>() {

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                String name1 = (String) o1.get("name");
                String name2 = (String) o2.get("name");

                Integer math1 = (Integer) o1.get("math");
                Integer math2 = (Integer) o2.get("math");

                return math2.compareTo(math1) == 0 ? name1.compareTo(name2) : math2.compareTo(math1);
            }
            
        });

        System.out.println("ENGLISH");
        for (Map<String, Object> student : studentList) {
            System.out.println(student.get("name") + "\t" + student.get("korean") + "\t" + student.get("english") + "\t" + student.get("math"));
        }
    }

    static void read(List<Map<String, Object>> list) {
        String line = null;

        try {
            FileReader fileReader = new FileReader("./INPUT/List_Sample.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            Map<String, Object> map;
            while ((line = bufferedReader.readLine()) != null) {
                String[] infos = line.split("\t");
                map = new HashMap<>();
                map.put("name", infos[0]);
                map.put("korean", Integer.parseInt(infos[1]));
                map.put("english", Integer.parseInt(infos[2]));
                map.put("math", Integer.parseInt(infos[3]));

                list.add(map);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
