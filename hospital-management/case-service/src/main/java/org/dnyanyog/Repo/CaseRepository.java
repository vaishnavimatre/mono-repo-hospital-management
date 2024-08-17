package org.dnyanyog.Repo;


import java.util.List;


import org.dnyanyog.Entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
@Component
public interface CaseRepository extends JpaRepository<Cases, Long> {
	
}