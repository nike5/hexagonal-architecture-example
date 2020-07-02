package pl.teessoft.hexagonalarchitectureexample.announcements.domain

import spock.lang.Specification

class AnnouncementSpec extends Specification implements AnnouncementSample {
    AnnouncementFacade facade = new AnnouncementConfiguration().announcementFacade();

    def "should show a announcement"() {
        given: "announcement is in the system"
        facade.create(regular)

        expect: "system return the announcement"
        facade.get(regular.title) == regular
    }

    def "should throw exception when asked for a announcement that's not in the system"() {
        when: "system is asked for a announcement that is not present"
            facade.get("some title we don't have")
        then:
        thrown(IllegalStateException)
    }
}
