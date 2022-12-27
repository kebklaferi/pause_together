package com.ris.pause_together.dao;

import com.ris.pause_together.models.Profil;
import com.ris.pause_together.models.Seznam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeznamRepository extends CrudRepository<Seznam, Long> {
    @Query(value = "select s.* from seznami s inner join vsebine v on v.seznam_id = s.id group by s.id", nativeQuery = true)
    List<Seznam> vrniPolneSezname();
}
