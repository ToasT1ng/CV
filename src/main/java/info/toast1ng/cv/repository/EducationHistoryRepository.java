package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.EducationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationHistoryRepository extends JpaRepository<EducationHistory, Long> {
}
