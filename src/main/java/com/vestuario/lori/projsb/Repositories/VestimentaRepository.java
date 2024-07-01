package com.vestuario.lori.projsb.Repositories;

import com.vestuario.lori.projsb.Entities.Vestimenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VestimentaRepository extends JpaRepository<Vestimenta, Long> {
    //ali dentro dos genérics estão os tipo 1: do obj a ser mapeado; 2: do id desse obj



}
