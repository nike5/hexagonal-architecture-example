package pl.teessoft.hexagonalarchitectureexample.announcements

import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.AnnouncementFacade
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.AnnouncementSample
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/*
    TODO change implementation to mongodb embedded
 */
//@DataMongoTest
@SpringBootTest
class AnnouncementControllerSpec extends Specification implements AnnouncementSample {

    @Autowired
    WebApplicationContext webApplicationContext
    @Autowired
    AnnouncementFacade facade;
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    def "should return a details of announcement"() {
        given: "create announcements"
            facade.create(regular)
            facade.create(senior)

        when: "I go to the /announcements/{announcementId}"
            def resultActions = mockMvc.perform(get("/announcements/$regular.title"))

        then: "I see announcement details"
            resultActions.andExpect(status().isOk())
                .andExpect(content().json("""
                {
                    "content": [
                        {"title":"$regular.title", "description":"$regular.description", "authorId": "$regular.authorId"}
                    ]
                }"""))
    }
}
