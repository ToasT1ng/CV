package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardsRepository extends JpaRepository<Awards, Long> {
}
