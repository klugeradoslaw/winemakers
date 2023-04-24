package pl.klugeradoslaw.winemakers.wine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Long> {
}