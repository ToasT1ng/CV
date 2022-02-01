package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
}
