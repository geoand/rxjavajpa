package geoand.rxjavajpa.book.repository

import geoand.rxjavajpa.book.model.Book
import org.springframework.data.repository.Repository
import org.springframework.scheduling.annotation.Async

import java.util.concurrent.CompletableFuture

/**
 * Created by gandrianakis on 22/12/2015.
 */
interface BookRepository extends Repository<Book, Long>{

    @Async
    CompletableFuture<List<Book>> findAll()

    @Async
    CompletableFuture<List<Book>> findByIsbn(String lastName)

    @Async
    CompletableFuture<Book> save(Book customer)
}
