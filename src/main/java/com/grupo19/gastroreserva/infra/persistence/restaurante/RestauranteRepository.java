package com.grupo19.gastroreserva.infra.persistence.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface RestauranteRepository {
    RestauranteEntity save(RestauranteEntity entity);
    Optional<RestauranteEntity> findById(Long id);
    List<RestauranteEntity> findAll();
    void delete(RestauranteEntity entity);
=======
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
>>>>>>> 004733093263bbc291e9cab8410a02c3a5238b5e
}