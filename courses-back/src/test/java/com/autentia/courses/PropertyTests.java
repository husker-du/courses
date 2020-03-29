package com.autentia.courses;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class PropertyTests {
    @Value("${secret.property}")
    private String property;

    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        assertEquals("caribou", this.property);
    }
}

