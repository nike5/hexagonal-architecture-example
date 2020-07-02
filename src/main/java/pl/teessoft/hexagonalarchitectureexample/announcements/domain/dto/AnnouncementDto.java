package pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class AnnouncementDto {
    private final String announcementId;
    private final String authorId;
    private final String title;
    private final String description;
}
