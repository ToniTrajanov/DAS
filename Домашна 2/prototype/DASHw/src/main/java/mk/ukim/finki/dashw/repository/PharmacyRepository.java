package mk.ukim.finki.dashw.repository;

import mk.ukim.finki.dashw.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}
