package info.toast1ng.cv.repository;

import info.toast1ng.cv.dto.CareerOrEducationType;
import info.toast1ng.cv.entities.CareerAndEducationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerAndEducationHistoryRepository extends JpaRepository<CareerAndEducationHistory, Long> {
    List<CareerAndEducationHistory> getCareerAndEducationHistoriesByType(CareerOrEducationType type);
}
