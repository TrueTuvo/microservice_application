package com.severyn.zabara.microservice_application;

import com.severyn.zabara.microservice_application.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity,Long> {

}
