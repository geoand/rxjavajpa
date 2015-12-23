package geoand.rxjavajpa.book.integration

import geoand.rxjavajpa.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.TestRestTemplate
import org.springframework.boot.test.WebIntegrationTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.web.client.RestTemplate

import static org.assertj.core.api.Assertions.assertThat

/**
 * Created by gandrianakis on 23/12/2015.
 */
@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(Application)
@WebIntegrationTest("server.port:0")
class BookApiTest {

    @Value('${local.server.port}')
    int port

    final RestTemplate restTemplate = new TestRestTemplate()

    @Test
    @Sql("/test-books.sql")
    void getAll() {
        final List<Map<String, Object>> response = restTemplate.getForObject("http://localhost:${port}/book", List)
        assertThat(response*.id).containsOnly(1, 2)
        assertThat(response*.isbn).containsOnly("123456789", "987654321")
    }
}
