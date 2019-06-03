package com.jdk.nio.network;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class NioServerTest {
    @Test
    void testServer() throws IOException {
        NioServer server = new NioServer();
        server.initServer(8000);
        server.listen();
    }
}