package com.api.approaches.repositories;

import com.api.approaches.entities.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    @Query(nativeQuery = true,
            value =
                    "select * from influencer i where i.status_influencer != 3 and i.id = ?1")
    Influencer findInfluencerById(Long id);

    @Query(nativeQuery = true,
            value =
                    "select * from influencer i where i.email = ?1")
    Influencer findInfluencerByEmail(String email);

    @Query(nativeQuery = true,
            value =
                    "select * from influencer i where i.status_influencer != 3")
    List<Influencer> findAllInfluencers();
}
