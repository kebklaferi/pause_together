package com.ris.pause_together.dao;

import com.ris.pause_together.models.Profil;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//CrudRepository<TIP, ID>; razred ponuja metode za delo z pb
public interface ProfilRepository extends CrudRepository<Profil, Long> {
    @Query("select p from Profil p where p.id = ?1")
    List<Profil> vrniPoId(int id);

    @Transactional
    @Modifying
    @Query(value = "update Profil p set p.ime = ?1 where p.id = ?2", nativeQuery = true)
    int spremeniProfil(String novo, Integer id);
}
