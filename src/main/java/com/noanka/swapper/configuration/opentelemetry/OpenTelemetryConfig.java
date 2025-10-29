package com.noanka.swapper.configuration.opentelemetry;

import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig {

    private OpenTelemetrySdk openTelemetrySdk;

    @Bean
    public OpenTelemetrySdk openTelemetrySdk(SdkTracerProvider provider) {
        this.openTelemetrySdk = OpenTelemetrySdk.builder()
                .setTracerProvider(provider)
                .build();
        return openTelemetrySdk;
    }

    @PreDestroy
    public void shutdownOpenTelemetry() {
        if (openTelemetrySdk != null) {
            openTelemetrySdk.getSdkTracerProvider().shutdown();
            System.out.println("OpenTelemetry shut down cleanly.");
        }
    }
}
