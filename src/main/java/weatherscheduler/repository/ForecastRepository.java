package weatherscheduler.repository;
import org.springframework.data.jpa.repository.Query;
import weatherscheduler.entity.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    @Query("SELECT f FROM Forecast f ORDER BY f.date DESC")
    Optional<Forecast> findFirst();
}
