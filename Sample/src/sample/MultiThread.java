package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThread {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futures = new ArrayList<>();

        for (int idx = 0; idx < 5; idx++) {
            LoadCallable loadCallable = new LoadCallable();
            loadCallable.setContext("type"+idx, "value");

            futures.add(executorService.submit(loadCallable));
        }

        String result;

        for (Future<String> future : futures) {
            result = future.get();

            if (result.isEmpty() == false) {
                System.out.println(result);
            }
        }

        executorService.shutdown();
    }
}
