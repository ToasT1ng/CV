package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.ThingsDone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingsDoneRepository extends JpaRepository<ThingsDone, Long> {
}
