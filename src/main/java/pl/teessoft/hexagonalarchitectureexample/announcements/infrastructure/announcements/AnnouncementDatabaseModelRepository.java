package pl.teessoft.hexagonalarchitectureexample.announcements.infrastructure.announcements;

import org.springframework.data.mongodb.repository.MongoRepository;

interface AnnouncementDatabaseModelRepository extends MongoRepository<AnnouncementDatabaseModel, String> {
}
