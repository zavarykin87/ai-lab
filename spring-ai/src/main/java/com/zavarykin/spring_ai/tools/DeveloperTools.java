package com.zavarykin.spring_ai.tools;

import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class DeveloperTools {

    private static final Logger log = LoggerFactory.getLogger(DeveloperTools.class);

    @Tool(name = "getCurrentUtcTime", description = "Get the current UTC date and time from the application server")
    public String getCurrentUtcTime() {
        String time = Instant.now().toString();

        log.info("Tool called: getCurrentUtcTime");

        return time;
    }

    @Tool(name = "multiplyIntegers", description = "Multiply two integer numbers exactly")
    public long multiplyIntegers(
            @ToolParam(description = "First integer") long a,
            @ToolParam(description = "Second integer") long b
    ) {
        log.info("Tool called: multiplyIntegers({}, {})", a, b);

        return Math.multiplyExact(a, b);
    }
}

