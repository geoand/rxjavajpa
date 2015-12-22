package geoand.rxjavajpa.book.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by gandrianakis on 22/12/2015.
 */
@Entity
@ToString
@EqualsAndHashCode
class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id

    String isbn
}
