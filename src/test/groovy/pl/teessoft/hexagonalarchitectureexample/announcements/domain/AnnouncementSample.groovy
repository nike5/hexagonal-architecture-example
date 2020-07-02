package pl.teessoft.hexagonalarchitectureexample.announcements.domain

import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto

trait AnnouncementSample {
    final AnnouncementDto regular = create("REGULAR", "REGULAR JAVA DEVELOPER", "1")
    final AnnouncementDto senior = create("SENIOR", "SENIOR JAVA DEVELOPER", "2")

    private static create(final String title, final String description, final String author) {
        return AnnouncementDto.builder()
                .authorId(author)
                .description(description)
                .title(title)
                .build()
    }
}
