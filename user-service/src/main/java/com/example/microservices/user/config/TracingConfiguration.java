package com.example.microservices.user.config;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class TracingConfiguration {
    @Bean
    public Tracer jaegerTracer() {
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        Configuration.SenderConfiguration senderConfig = Configuration.SenderConfiguration.fromEnv().withAgentHost("localhost").withAgentPort(6831);
        Configuration configuration = new Configuration("CUSTOMER-SERVICE").withSampler(samplerConfig).withReporter(reporterConfig);
        return configuration.getTracer();
    }
}