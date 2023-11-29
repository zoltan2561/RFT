package com.example.notes;

import com.example.notes.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookControllerAPITests {

    @BeforeAll
    public static void setUp() {
        String baseUrl = System.getenv("BASE_URL"); // Olvasd be a környezeti változót
        if (baseUrl == null) {
            baseUrl = "http://localhost:8080"; // Alapértelmezett érték, ha nincs környezeti változó beállítva
        }
        RestAssured.baseURI = baseUrl;
    }



    @Test
    public void testAddBook() {
        // Az API végpontja, amely létrehozza a könyvet
        String endpoint = "/books/add"; //

        // Létrehozandó könyv objektum
        Book newBook = new Book();
        newBook.setTitle("Teszt Könyv");
        newBook.setAuthor("Teszt Elek");


        // POST kérés küldése
        Response response = given()
                .contentType(ContentType.JSON)
                .body(newBook)
                .when()
                .post(endpoint);

        // Válasz ellenőrzése
        assertEquals(404, response.getStatusCode()); //


    }



}
