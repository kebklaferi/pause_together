package com.ris.pause_together.dao;

import com.ris.pause_together.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    @Query(value = "select * from uporabniki u where LENGTH(username) < 10 and LENGTH(geslo) > 10", nativeQuery = true)
    List<Uporabnik> upoPoizvedbaA();

    /*
    @Query(value = "", nativeQuery = true)
    List<Uporabnik> upoPoizvedbaB();

     */
}
