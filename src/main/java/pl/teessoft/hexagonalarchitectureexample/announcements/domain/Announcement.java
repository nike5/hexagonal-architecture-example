package pl.teessoft.hexagonalarchitectureexample.announcements.domain;

import lombok.Builder;
import lombok.Getter;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

@Getter
@Builder
class Announcement {
    private final String id;
    private final String authorId;
    private final String title;
    private final String description;

    static Announcement of(final AnnouncementDto dto) {
        return Announcement.builder()
                .title(dto.getTitle())
                .id(dto.getAnnouncementId())
                .description(dto.getDescription())
                .authorId(dto.getAuthorId())
                .build();
    }
}
