package no.kristiania.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HttpClientTest {

    @Test
    void mathShouldWork() {
        assertEquals(4, 2+2);
    }

    @Test
    void shouldReadStatusCode() throws IOException {
        HttpClient client = new HttpClient("urlecho.appspot.com", "/echo");
        HttpClientResponse response = client.executeRequest();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    void shouldReadFailureStatusCode() throws IOException {
        HttpClient client = new HttpClient("urlecho.appspot.com", "/echo?status=401");
        HttpClientResponse response = client.executeRequest();
        assertEquals(401, response.getStatusCode());
    }
}
