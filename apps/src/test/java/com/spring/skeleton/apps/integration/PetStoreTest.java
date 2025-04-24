package com.spring.skeleton.apps.integration;

import com.spring.skeleton.apps.ApplicationStub;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PetStoreTest extends ApplicationStub {

    @Test
    void testGetPets() throws Exception {
        mvc.perform(get("/api/v1/pets")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name").value("Helios"))
            .andExpect(jsonPath("$[0].type").value("Cat"))
            .andExpect(jsonPath("$[0].age").value(3))
            .andExpect(jsonPath("$[1].name").value("Fluffy"))
            .andExpect(jsonPath("$[1].type").value("Dog"))
            .andExpect(jsonPath("$[1].age").value(4));
    }
}
