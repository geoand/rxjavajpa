package geoand.rxjavajpa.book.service

import geoand.rxjavajpa.book.model.Book
import geoand.rxjavajpa.book.repository.BookRepository
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable as Observable

/**
 * Created by gandrianakis on 22/12/2015.
 */
@Service
@CompileStatic
class BookServiceImpl implements BookService {

    final BookRepository bookRepository

    @Autowired
    BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @Override
    Observable<List<Book>> findAll() {
        return Observable.from(bookRepository.findAll())
    }
}
