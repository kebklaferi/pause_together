package com.ris.pause_together.dao;

import com.ris.pause_together.models.Profil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//CrudRepository<TIP, ID>; razred ponuja metode za delo z pb
public interface ProfilRepository extends CrudRepository<Profil, Long> {
    @Query("select p from Profil p where p.id = ?1")
    List<Profil> vrniPoId(int id);
}
