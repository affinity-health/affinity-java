package com.affinity.api;

import com.affinity.api.resources.orders.requests.ListOrdersRequest;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JavaSmokeTest {
    @Test
    void sendsAuthVersionAndPagination() throws Exception {
        var failure = new AtomicReference<Throwable>();
        var server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext("/v1/orders", exchange -> {
            try {
                assertEquals("GET", exchange.getRequestMethod());
                assertEquals("synthetic-key", exchange.getRequestHeaders().getFirst("x-affinity-api-key"));
                assertEquals("2026-09-28", exchange.getRequestHeaders().getFirst("Affinity-Version"));
                assertTrue(exchange.getRequestURI().getQuery().contains("startingAfter=ord_cursor"));
                assertTrue(exchange.getRequestURI().getQuery().contains("limit=2"));
            } catch (Throwable error) { failure.set(error); }
            byte[] body = "{\"object\":\"list\",\"data\":[],\"hasMore\":false,\"url\":\"/v1/orders\"}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            exchange.getResponseBody().write(body);
            exchange.close();
        });
        server.start();
        try {
            var client = AffinityClient.builder().apiKey("synthetic-key").affinityVersion("2026-09-28")
                .url("http://127.0.0.1:" + server.getAddress().getPort()).maxRetries(0).build();
            var page = client.orders().listOrders(ListOrdersRequest.builder().startingAfter("ord_cursor").limit(2).build());
            assertTrue(page.getData().isEmpty());
            assertFalse(page.getHasMore());
            if (failure.get() != null) throw new AssertionError(failure.get());
        } finally { server.stop(0); }
    }
}
