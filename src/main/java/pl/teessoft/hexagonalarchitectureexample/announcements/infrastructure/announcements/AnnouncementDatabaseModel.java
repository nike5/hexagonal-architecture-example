package pl.teessoft.hexagonalarchitectureexample.announcements.infrastructure.announcements;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

@Document
@Getter
@Builder
class AnnouncementDatabaseModel {
    @Id
    private final String id;
    private final String authorId;
    private final String title;
    private final String description;

    AnnouncementDto fromEntity() {
        return AnnouncementDto.builder()
                .title(this.title).announcementId(this.getId())
                .authorId(this.getAuthorId())
                .description(this.getDescription())
                .build();
    }

    static AnnouncementDatabaseModel of(AnnouncementDto announcementDto) {
        return AnnouncementDatabaseModel.builder()
                .authorId(announcementDto.getAuthorId())
                .description(announcementDto.getDescription())
                .title(announcementDto.getTitle())
                .build();
    }
}
