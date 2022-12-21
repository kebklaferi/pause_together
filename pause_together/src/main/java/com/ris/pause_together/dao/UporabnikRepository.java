package com.ris.pause_together.dao;

import com.ris.pause_together.models.Uporabnik;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UporabnikRepository extends CrudRepository<Uporabnik, Long> {

    @Query(value = "select u.username from uporabniki u", nativeQuery = true)
    List<String> poisciVseUpoUN();

    @Query(value = "select u.* from uporabniki u", nativeQuery = true)
    List<Uporabnik> vrniUporabnike();

    @Query(value = "select u.* from uporabniki u" +
            " inner join seznami s on u.id = s.uporabnik_id" +
            " where length(u.username) < 10 and length(u.geslo) > 10" +
            " group by u.id" +
            " having count(*) = (" +
            " select count(*) as st from seznami s" +
            " inner join uporabniki u on u.id = s.uporabnik_id" +
            " group by u.id" +
            " having st > 0" +
            ");", nativeQuery = true)
    List<Uporabnik> upoPoizvedbaA();

    @Query(value = "select u.* from uporabniki u " +
            "where u.id not in (select s.uporabnik_id from seznami s) " +
            "and isnull(u.email) and u.geslo < 5 " +
            "group by u.id;", nativeQuery = true)
    List<Uporabnik> upoPoizvedbaB();

 /*
    @Query(value = "", nativeQuery = true)
    List<Uporabnik> upoPoizvedbaB();

     */
}
