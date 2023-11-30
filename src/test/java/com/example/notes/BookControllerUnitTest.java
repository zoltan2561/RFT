package com.example.notes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BookControllerUnitTest {
//11111
    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookController controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }





    @Test
    void testSaveBook() throws Exception {
        mockMvc.perform(post("/addBook")
                        .param("title", "Test Book")
                        .param("author", "Test Author"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books"));

        verify(repository, times(1)).save(any(Book.class));
    }

    @Test
    void testDeleteBook() throws Exception {
        mockMvc.perform(get("/deleteBook/{id}", 1L))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/books"));

        verify(repository, times(1)).deleteById(1L);
    }
}
