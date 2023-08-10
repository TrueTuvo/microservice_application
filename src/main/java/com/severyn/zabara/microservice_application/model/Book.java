package com.severyn.zabara.microservice_application.model;

import lombok.Value;

@Value
public class Book {
    Long id;
    String author;
    String title;
    Double price;

}
