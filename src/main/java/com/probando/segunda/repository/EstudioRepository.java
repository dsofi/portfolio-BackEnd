
package com.probando.segunda.repository;

import com.probando.segunda.model.Estudio;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository <Estudio, Long> {
    
    @Modifying
    @Query("UPDATE Estudio e SET e.orden = :orden WHERE e.id = :id")
    @Transactional
    void updateOrden(@Param("id") Long id, @Param("orden") int orden);
    
    @Query("SELECT e FROM Estudio e ORDER BY e.orden ASC")
    List<Estudio> findAllOrdered();

}
