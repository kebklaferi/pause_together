package com.ris.pause_together.dao;

import com.ris.pause_together.models.Profil;
import org.springframework.data.repository.CrudRepository;

//CrudRepository<TIP, ID>; razred ponuja metode za delo z pb
public interface ProfilRepository extends CrudRepository<Profil, Long> {
}
