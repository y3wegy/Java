package com.jdk.nio.network;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class NioClientTest {
    @Test
    void testClientConnect() throws IOException {
        NioClient client = new NioClient();
        client.initClient("localhost",8000);
        client.listen();
    }
}