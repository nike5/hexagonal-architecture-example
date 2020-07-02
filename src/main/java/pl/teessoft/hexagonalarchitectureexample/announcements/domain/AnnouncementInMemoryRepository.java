package pl.teessoft.hexagonalarchitectureexample.announcements.domain;

import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class AnnouncementInMemoryRepository implements AnnouncementRepository {
    private final ConcurrentHashMap<String, Announcement> map = new ConcurrentHashMap<>();

    public AnnouncementDto save(AnnouncementDto announcementDto) {
        requireNonNull(announcementDto);
        this.map.put(announcementDto.getTitle(), Announcement.of(announcementDto));

        return announcementDto;
    }

    public AnnouncementDto get(String announcementId) {
        Announcement announcement = this.map.get(announcementId);
        if (announcement == null) {
            throw new IllegalStateException();
        } else {
            return AnnouncementDto.builder()
                    .description(announcement.getDescription())
                    .authorId(announcement.getAuthorId())
                    .title(announcement.getTitle())
                    .build();
        }
    }
}
