package com.bosonit.examenJPAcascada.Cliente.Repository;

import com.bosonit.examenJPAcascada.Cliente.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
