package sample01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Sample01 {

    public static void main(String[] args) throws IOException {

        String path = "./INPUT";

        fileSearchAll(path);
    }

    static void fileSearchAll(String path) throws IOException {

        File directory = new File(path);
        File[] files = directory.listFiles();

        String outputFile = null;
        String outputDir = null;
        long fileSize = 0;

        for (File file : files) {
            if (file.isDirectory()) {
                fileSearchAll(file.getPath());
            } else {
                fileSize = file.length();
                if (fileSize > 30 * 1024) {
                    outputDir = file.getParent().replaceFirst("INPUT", "OUTPUT");
                    File outputDirctory = new File(outputDir);
                    if (!outputDirctory.exists()) {
                        outputDirctory.mkdirs();
                    }

                    outputFile = file.getName();

                    copyFile(file.getPath(), outputDir + "/" + outputFile);
                }

                System.out.println(file.getPath() + ": " + fileSize + "bytes");
            }
        }

    }

    static void copyFile(String inputFile, String outputFile) {
        final int BUFFER_SIZE = 512;
        int readLen;

        try {
            InputStream is = new FileInputStream(inputFile);
            OutputStream os = new FileOutputStream(outputFile);

            byte[] buffer = new byte[BUFFER_SIZE];

            while ((readLen = is.read(buffer)) != -1) {
                os.write(buffer, 0, readLen);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
