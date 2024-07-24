package com.scAppiRest.SCAppi.Repositories;

import com.scAppiRest.SCAppi.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
