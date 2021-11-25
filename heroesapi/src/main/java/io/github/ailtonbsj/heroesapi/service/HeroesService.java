package io.github.ailtonbsj.heroesapi.service;

import io.github.ailtonbsj.heroesapi.document.Heroes;
import io.github.ailtonbsj.heroesapi.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroesService {
    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }

    public Flux<Heroes> findAll() {
        return Flux.fromIterable(
                this.heroesRepository.findAll()
        );
    }

    public Mono<Heroes> findHeroById(String id) {
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }

    public Mono<Heroes> save(Heroes heroes) {
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }

    public Mono<Boolean> deleteHeroById(String id) {
        heroesRepository.deleteById(id);
        return Mono.justOrEmpty(true);
    }
}
