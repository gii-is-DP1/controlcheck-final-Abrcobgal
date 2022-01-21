package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CareProvisionRepository extends CrudRepository<CareProvision, Integer> {
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
    
    @Query("SELECT care FROM Care care")
    List<Care> findAllCares();
    @Query("SELECT care FROM Care care WHERE care.compatiblePetTypes=:petTypeName")
    List<Care> findCompatibleCares(@Param("petTypeName") String petTypeName);
    
    @Query("SELECT care FROM Care care WHERE care.name=:name")
    Care findCareByName(@Param("name") String name);
    
    @Query("SELECT CareProvision FROM CareProvision CareProvision WHERE CareProvision.visitId=:visitId")
    List<CareProvision> findCaresProvidedByVisitId(@Param("visitId") Integer visitId);
}
