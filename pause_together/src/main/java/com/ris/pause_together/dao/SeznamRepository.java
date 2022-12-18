package com.ris.pause_together.dao;

import com.ris.pause_together.models.Profil;
import com.ris.pause_together.models.Seznam;
import org.springframework.data.repository.CrudRepository;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {
}
