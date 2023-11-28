package com.example.notes;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyApiTest {

    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("http://localhost:8080/books") // Módosítsd az URL-t az általad használt erőforrásra
                .then()
                .statusCode(200); // Az elvárt státuszkódot itt állítsd be helyesen
    }



    @Test
    public void testGetBook() {
        // Az API végpontja, amely lekéri a könyvet
        String endpoint = "/addBook";

        // GET kérés küldése
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);

        // Válasz ellenőrzése
        assertEquals(200, response.getStatusCode());

        // Válasz tartalmának ellenőrzése
        Book book = response.as(Book.class);
        assertEquals(1, book.getId());
        assertEquals("The Great Gatsby", book.getTitle());
        assertEquals("F. Scott Fitzgerald", book.getAuthor());
        // További ellenőrzések...
    }

    @Test
    public void testCreateBook() {
        // Az API végpontja, amely létrehozza a könyvet
        String endpoint = "/addBook";

        // Létrehozandó könyv objektum
        Book newBook = new Book();
        newBook.setTitle("New Book");
        newBook.setAuthor("John Doe");
        // További tulajdonságok...

        // POST kérés küldése
        Response response = given()
                .contentType(ContentType.JSON)
                .body(newBook)
                .when()
                .post(endpoint);

        // Válasz ellenőrzése
        assertEquals(201, response.getStatusCode());

        // Létrehozott könyv visszakapása
        Book createdBook = response.as(Book.class);

        // Visszakapott könyv ellenőrzése
        assertEquals("New Book", createdBook.getTitle());
        assertEquals("John Doe", createdBook.getAuthor());
        // További ellenőrzések...
    }

    // További teszteseteket itt lehetne hozzáadni a módosításhoz és törléshez
}
