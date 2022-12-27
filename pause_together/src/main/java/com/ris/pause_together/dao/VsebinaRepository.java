package com.ris.pause_together.dao;

import com.ris.pause_together.models.Vsebina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VsebinaRepository extends CrudRepository <Vsebina, Long> {

    @Query(value = "select v.* from vsebine v where v.leto_izdaje = ?2 and v.ocena >= ?3 and v.avtor = ?1", nativeQuery = true)
    List<Vsebina> vrniPoParametrih(String avtor, Long leto, Long ocena);
}
