package co.com.meli.quasarfire.repository;

import co.com.meli.quasarfire.entity.SatelliteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuasarFireRepository extends JpaRepository<SatelliteEntity,String> {
}
