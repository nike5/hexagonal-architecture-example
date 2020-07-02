package pl.teessoft.hexagonalarchitectureexample.announcements.infrastructure.announcements;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AnnouncementDatabaseConfiguration {

    @Bean
    AnnouncementMongodbRepository announcementMongodbRepository(final AnnouncementDatabaseModelRepository announcementDatabaseModelRepository) {
        return new AnnouncementMongodbRepository(announcementDatabaseModelRepository);
    }
}
