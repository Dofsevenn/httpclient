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
        client.executeRequest();
        assertEquals(200, client.getStatusCode());
    }

    @Test
    void shouldReadFailureStatusCode() throws IOException {
        HttpClient client = new HttpClient("urlecho.appspot.com", "/echo?status=401");
        client.executeRequest();
        assertEquals(401, client.getStatusCode());
    }
}
