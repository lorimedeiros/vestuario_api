package com.vestuario.lori.projsb.Repositories;
import com.vestuario.lori.projsb.DTO.DadosListagemVestimentaDTO;
import com.vestuario.lori.projsb.Entities.Vestimenta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VestimentaRepository extends JpaRepository<Vestimenta, Long> {
    List<Vestimenta> findAllByAtivoTrue();

}
