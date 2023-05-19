package sample;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;

public class HttpClientSample {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = null;

        try {
            httpClient = new HttpClient();
            httpClient.setFollowRedirects(false);
            httpClient.start();

            Request request = httpClient.newRequest("http://127.0.0.1:8080/CREATE");
            request.method(HttpMethod.GET);
            request.timeout(5000, TimeUnit.MILLISECONDS);
            request.param("name", "value");

            ContentResponse response = request.send();
            if (response.getStatus() != HttpStatus.OK_200) {
                System.out.println("Http Status Code() Invalid. " + response.getStatus());
            }

        } catch (Exception e) {
            if (httpClient != null)
                httpClient.stop();
        }
       
    }
}
