package geoand.rxjavajpa.book.controller

import geoand.rxjavajpa.book.model.Book
import geoand.rxjavajpa.book.service.BookService
import geoand.rxjavajpa.util.ObservableToDeferredResult
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import rx.Observable as Observable

/**
 * Created by gandrianakis on 22/12/2015.
 */
@RestController
@RequestMapping("book")
@CompileStatic
class BookController {

    final BookService bookService
    final ObservableToDeferredResult observableToDeferredResult

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService

        observableToDeferredResult = new ObservableToDeferredResult()
    }

    @RequestMapping(method = RequestMethod.GET)
    Observable<List<Book>> all() {
        return bookService.findAll()
    }
}
