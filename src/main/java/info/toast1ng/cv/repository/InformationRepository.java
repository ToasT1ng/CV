package info.toast1ng.cv.repository;

import info.toast1ng.cv.entities.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {
    @Query("select i from Information i where i.greetingOrNot = false ")
    List<Information> findAllByGreetingOrNotFalse();

    @Query("select i from Information i where i.greetingOrNot = true ")
    Information findGeeting();
}
