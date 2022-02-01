package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Long> {
}
