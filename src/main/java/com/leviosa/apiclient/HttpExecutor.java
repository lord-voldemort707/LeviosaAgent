package com.leviosa.apiclient;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.leviosa.apiclient.exceptions.InvalidResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class HttpExecutor {

    private final CloseableHttpClient httpClient;

    public HttpExecutor(CloseableHttpClient httpClient) {
        this.httpClient = Objects.requireNonNull(httpClient);
    }

    public String get(String endpoint) {
        Objects.requireNonNull(endpoint);
        System.out.println(endpoint);
        HttpGet httpGet = new HttpGet(endpoint);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            validateStatusCode(response.getStatusLine().getStatusCode());
            InputStreamReader responseReader = new InputStreamReader(response.getEntity().getContent(), Charsets.UTF_8);
            String result = CharStreams.toString(responseReader);
            EntityUtils.consume(response.getEntity());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateStatusCode(int statusCode) {
        if(statusCode >= 400 && statusCode <= 500) {
            throw new InvalidResponseException("API returned unexpected status code: " + statusCode);
        }
    }
}
