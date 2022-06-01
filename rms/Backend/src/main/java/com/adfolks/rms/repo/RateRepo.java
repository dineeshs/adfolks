package com.adfolks.rms.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adfolks.rms.domain.RateEntity;

@Repository
public interface RateRepo extends CrudRepository<RateEntity, Long> {

}
