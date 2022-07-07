package sample;

import java.util.Scanner;

public class Console {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            String strCmd = scan.nextLine().toUpperCase();

            switch (strCmd) {

                case "A" :
                    break;
                case "B" :
                    break;
                case "Q" :
                    scan.close();
                    return;
                default:
                    break;
            }
        }
    }    
    
}
