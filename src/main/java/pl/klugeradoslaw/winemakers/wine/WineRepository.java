package pl.klugeradoslaw.winemakers.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
}