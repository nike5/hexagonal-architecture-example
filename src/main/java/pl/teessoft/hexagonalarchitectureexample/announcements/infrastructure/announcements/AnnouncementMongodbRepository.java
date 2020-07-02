package pl.teessoft.hexagonalarchitectureexample.announcements.infrastructure.announcements;

import lombok.RequiredArgsConstructor;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.AnnouncementRepository;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

@RequiredArgsConstructor
class AnnouncementMongodbRepository implements AnnouncementRepository {
    private final AnnouncementDatabaseModelRepository announcementDatabaseModelRepository;

    public AnnouncementDto save(AnnouncementDto announcementDto) {
        AnnouncementDatabaseModel model = AnnouncementDatabaseModel.of(announcementDto);
        AnnouncementDatabaseModel entity = announcementDatabaseModelRepository.save(model);
        return entity.fromEntity();
    }

    public AnnouncementDto get(String announcementId) {
        AnnouncementDatabaseModel entity = announcementDatabaseModelRepository.findById(announcementId).orElseThrow();
        return entity.fromEntity();
    }
}
