package weatherscheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import weatherscheduler.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> { }
