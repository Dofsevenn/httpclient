import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

class HttpClient {


    private String host;

    public HttpClient(String host) {
        this.host = host;
    }

    public static void main(String[] args) throws IOException {
        new HttpClient("urlecho.appspot.com").executeRequest();
    }

    private void executeRequest() throws IOException {
        try(Socket socket = new Socket(host, 80)) {

            socket.getOutputStream().write("GET /echo?status=200&Content-Type=text%2Fhtml&body=Hello%20world! HTTP/1.1\r\n"
                    .getBytes());
            socket.getOutputStream().write(("Host:" + host + "\r\n").getBytes());
            socket.getOutputStream().write("connection: close\r\n".getBytes());
            socket.getOutputStream().write("\n\r".getBytes());
            socket.getOutputStream().flush();

            InputStream input = socket.getInputStream();
            int c;
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
