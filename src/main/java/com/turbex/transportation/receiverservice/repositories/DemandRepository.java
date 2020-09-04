package com.turbex.transportation.receiverservice.repositories;

import com.turbex.transportation.receiverservice.entities.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Long> {
}
