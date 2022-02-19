package info.toast1ng.cv.repository;

import info.toast1ng.cv.dto.HistoryType;
import info.toast1ng.cv.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> getCareerAndEducationHistoriesByType(HistoryType type);
}
