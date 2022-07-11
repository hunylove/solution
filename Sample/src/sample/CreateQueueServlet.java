package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CreateQueueServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String queueName = null;

        if (request.getPathInfo() != null && request.getPathInfo().split("/").length > 0) {
            String pathInfo = request.getPathInfo().split("/")[1];

            if (pathInfo != null && pathInfo.length() > 0) {
                queueName = pathInfo;
            }
        }

        String strBody = getBody(request);
        JsonElement jsonElement = JsonParser.parseString(strBody);
        int queueSize = jsonElement.getAsJsonObject().get("QueueSize").getAsInt();

        response.setStatus(200);
        response.getWriter().write("{\"Result\":\"OK\"}");
    }

    public String getBody(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try {
            InputStream is = request.getInputStream();
            if (is != null) {
                br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                char[] charBuffer = new char[2048];
                int byteRead;
                while ((byteRead = br.read(charBuffer)) > 0) {
                    sb.append(charBuffer, 0, byteRead);
                }
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

        return sb.toString();
    }
}
