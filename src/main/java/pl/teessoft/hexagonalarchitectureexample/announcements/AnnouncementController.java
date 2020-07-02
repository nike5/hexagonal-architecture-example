package pl.teessoft.hexagonalarchitectureexample.announcements;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.AnnouncementFacade;
import pl.teessoft.hexagonalarchitectureexample.announcements.domain.dto.AnnouncementDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("announcements")
class AnnouncementController {
    private final AnnouncementFacade facade;

    @PostMapping
    ResponseEntity<String> create(@NonNull AnnouncementDto announcementDto) {
        final String response = facade.create(announcementDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("{announcementId}")
    ResponseEntity<AnnouncementDto> get(@PathVariable String announcementId) {
        final AnnouncementDto announcementDto = facade.get(announcementId);

        return ResponseEntity.ok(announcementDto);
    }
}
