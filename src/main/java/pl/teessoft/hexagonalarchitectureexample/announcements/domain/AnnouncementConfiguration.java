package pl.teessoft.hexagonalarchitectureexample.announcements.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AnnouncementConfiguration {

    AnnouncementFacade announcementFacade() {
        return this.announcementFacade(new AnnouncementInMemoryRepository());
    }

    @Bean
    AnnouncementFacade announcementFacade(final AnnouncementRepository announcementRepository) {
        AnnouncementPublisher publisher = new AnnouncementPublisher();
        return new AnnouncementFacade(announcementRepository, publisher);
    }
}
