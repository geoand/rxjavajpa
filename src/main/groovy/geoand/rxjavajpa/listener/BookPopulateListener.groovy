package geoand.rxjavajpa.listener

import geoand.rxjavajpa.book.model.Book
import geoand.rxjavajpa.book.repository.BookRepository
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

import org.springframework.context.event.EventListener as EventListener

/**
 * Created by gandrianakis on 22/12/2015.
 */
@Component
@Profile("dev")
@Slf4j
class BookPopulateListener {

    final BookRepository bookRepository

    @Autowired
    BookPopulateListener(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @EventListener
    public void populate(ContextRefreshedEvent event) {
        ["123456789", "987654321"].collect {bookRepository.save(new Book(isbn: it))} .each {it.get()}

        log.info("Populated database with dummy data")
    }
}
