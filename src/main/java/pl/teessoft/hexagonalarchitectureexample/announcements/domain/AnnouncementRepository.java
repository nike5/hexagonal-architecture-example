package pl.teessoft.hexagonalarchitectureexample.announcements.domain;

import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

public interface AnnouncementRepository {
    AnnouncementDto save(AnnouncementDto announcementDto);
    AnnouncementDto get(String announcementId);
}
