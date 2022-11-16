package com.bosonit.examenJPAcascada.CabeceraFra.Repository;



import com.bosonit.examenJPAcascada.CabeceraFra.Model.CabeceraFra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraFraRepository extends JpaRepository<CabeceraFra,Integer> {
}

