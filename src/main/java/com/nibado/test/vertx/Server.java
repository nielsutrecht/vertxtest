package com.nibado.test.vertx;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

public class Server extends Verticle {
    private final Logger logger = Logger.getLogger(this.getClass());

    public Server() {
        BasicConfigurator.configure();
    }

    @Override
    public void start() {
        logger.info("Starting");
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            public void handle(final HttpServerRequest req) {
                logger.info("Got response");
                req.response().end("hello world!");
            }
        }).listen(8080);
    }
}