package geoand.rxjavajpa.book.controller

import geoand.rxjavajpa.Application
import geoand.rxjavajpa.book.model.Book
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gandrianakis on 22/12/2015.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = Application)
@WebAppConfiguration
class BookControllerTest {

    @Autowired
    private WebApplicationContext wac

    private MockMvc mockMvc

    @Before
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
    }

    @Test
    @Sql("/test-books.sql")
    void getAll() {
        mockMvc.perform(get('/book'))
            .andExpect(status().isOk())
            .andExpect(request().asyncResult([new Book(id: 1, isbn:"123456789"), new Book(id: 2, isbn:"987654321")]))
    }
}
