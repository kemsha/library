package com.library.rest.controllers;

import com.jayway.jsonpath.JsonPath;
import com.library.core.model.Movie;
import com.library.core.service.JwtService;
import com.library.core.service.MovieService;
import com.library.core.service.UserService;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

@SpringBootTest
public class MovieControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    @MockBean
    JwtService jwtService;

    @MockBean
    UserService userService;

    @MockBean
    AuthenticationProvider authenticationProvider;

    @Test
    void shouldReturnAllMovies() throws Exception {
        Movie movie = new Movie():
        movie.setTitle("The Godfather");
        movie.setGenre("Thriller");
        movie.setYearOfRelease(1972);

        Mockito.when(movieService.getMovies()).thenReturn(List.of(movie));

        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/movies/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

                String response = result.getResponse().getContentAsString();
        Assertions.assertEquals(1, (Integer) JsonPath.read(response, "$.length()"));
        Assertions.assertEquals("The Godfather", JsonPath.read(response, "$.[0].title"));

    }
}
