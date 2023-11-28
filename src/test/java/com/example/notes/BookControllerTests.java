package com.example.notes;

import com.example.notes.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookControllerTests {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/books"; // Helyes API végpontot állíts be
    }


    @Test
    public void testAddBook() {
        // Az API végpontja, amely létrehozza a könyvet
        String endpoint = "/books/add"; // Módosítsd a helyes végpontra

        // Létrehozandó könyv objektum
        Book newBook = new Book();
        newBook.setTitle("Teszt Könyv");
        newBook.setAuthor("Teszt Elek");
        // További tulajdonságok...

        // POST kérés küldése
        Response response = given()
                .contentType(ContentType.JSON)
                .body(newBook)
                .when()
                .post(endpoint);

        // Válasz ellenőrzése
        assertEquals(404, response.getStatusCode()); // Módosítsd a helyes státuszkódra

        // További válasz ellenőrzések...
    }



}
