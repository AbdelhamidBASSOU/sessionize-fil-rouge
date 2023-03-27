package Sessionize.repository;

import Sessionize.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventReposiroty extends JpaRepository<Event,Long> {

}
