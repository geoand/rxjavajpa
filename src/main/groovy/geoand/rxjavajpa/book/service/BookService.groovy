package geoand.rxjavajpa.book.service

import geoand.rxjavajpa.book.model.Book
import rx.Observable

/**
 * Created by gandrianakis on 22/12/2015.
 */
interface BookService {

    Observable<List<Book>> findAll()

}