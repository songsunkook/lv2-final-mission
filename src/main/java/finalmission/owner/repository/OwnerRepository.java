package finalmission.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import finalmission.owner.domain.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
