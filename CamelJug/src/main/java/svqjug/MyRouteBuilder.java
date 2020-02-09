package svqjug;

import org.apache.camel.builder.RouteBuilder;

/**
 * A Camel Java DSL Router
 */
public class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {
        restConfiguration()
            .producerComponent("http")
            .host("https://api.meetup.com")
            .port(443);

        from("timer:foo?period=5000")
            .to("rest:get:svqjug/events/267875506/attendance?consumerComponentName=jetty")
            .log("${body}");
    }
}
