package io.jenkins.plugins.sample.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PluginHelper {

    public static HttpResponse<String> postJson(String url, String jsonBody) throws IOException, InterruptedException {

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json") // Set content type for JSON
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody)) // Specify POST and provide the body
                .build();
        HttpClient client = HttpClient.newHttpClient();
        return client.send(postRequest, HttpResponse.BodyHandlers.ofString());

    }

    public static boolean isInvalidField(String field, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(field);
        return !matcher.matches();
    }


}
