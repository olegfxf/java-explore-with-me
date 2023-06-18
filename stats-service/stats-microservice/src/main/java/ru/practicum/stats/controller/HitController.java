package ru.practicum.stats.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.HitDto;
import ru.practicum.stats.dto.ViewStats;
import ru.practicum.stats.model.Stats;
import ru.practicum.stats.service.HitServiceImpl;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class HitController {
    private final HitServiceImpl hitService;

    @Autowired
    public HitController(HitServiceImpl hitService) {
        this.hitService = hitService;
    }

    @PostMapping("/hit")
    public HitDto save(@RequestBody Stats stats) {
        log.debug("Поступил запрос на создание события {}", stats);
        return hitService.save(stats);
    }

    @GetMapping("/stats")
    public List<ViewStats> getStats(@RequestParam String start,
                                    @RequestParam String end,
                                    @RequestParam(required = false) Optional<List<String>> uris,
                                    @RequestParam(defaultValue = "false") boolean unique) {
        log.debug("Поступил запрос на предоставление статистики");
        return hitService.getStats(start, end, uris, unique);
    }

}
