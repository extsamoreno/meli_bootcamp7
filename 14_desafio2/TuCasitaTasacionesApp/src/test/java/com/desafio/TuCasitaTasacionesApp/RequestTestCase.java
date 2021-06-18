package com.desafio.TuCasitaTasacionesApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public abstract class RequestTestCase {

    public ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;

    protected void assertRequestWithBody(
            String method,
            String endpoint,
            String body,
            Integer expectedStatusCode
    ) throws Exception {
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint)
                        .content(body)
                        .contentType(APPLICATION_JSON)
                )
                .andExpect(status().is(expectedStatusCode));
    }

    protected void assertRequest(
            String method,
            String endpoint,
            Integer expectedStatusCode
    ) throws Exception {
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint)
                )
                .andExpect(status().is(expectedStatusCode));
    }

    protected void assertRequestWithContent(String method,
                                            String endpoint,
                                            Integer expectedStatusCode,
                                            String expectedResponse
    ) throws Exception{
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint)
                )
                .andExpect(status().is(expectedStatusCode)).andExpect(response);
    }

    protected void doRequest(
            String method,
            String endpoint,
            Integer expectedStatusCode,
            String expectedContent
    ) throws Exception {
        mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint)
                );
    }

    protected String doRequestWithBody(
            String method,
            String endpoint,
            String body,
            Integer expectedStatusCode
    ) throws Exception {
        return mockMvc
                .perform(request(HttpMethod.valueOf(method), endpoint)
                        .content(body)
                        .contentType(APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
    }


}
