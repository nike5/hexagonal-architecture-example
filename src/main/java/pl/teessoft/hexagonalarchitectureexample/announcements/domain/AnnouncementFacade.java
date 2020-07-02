package pl.teessoft.hexagonalarchitectureexample.announcements.domain;

import lombok.RequiredArgsConstructor;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

import static java.util.Objects.requireNonNull;

@RequiredArgsConstructor
public class AnnouncementFacade {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementPublisher publisher;

    public String create(final AnnouncementDto announcementDto) {
        requireNonNull(announcementDto);
        AnnouncementDto save = this.announcementRepository.save(announcementDto);
        Announcement announcement = Announcement.of(save);

        this.publisher.publish(announcement);

        return announcement.getId();
    }

    public AnnouncementDto get(final String announcementId) {
        return this.announcementRepository.get(announcementId);
    }
}
