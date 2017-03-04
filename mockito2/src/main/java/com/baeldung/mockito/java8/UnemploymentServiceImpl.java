package com.baeldung.mockito.java8;

import java.util.Optional;

public class UnemploymentServiceImpl implements UnemploymentService {
    private final JobService jobService;
    
    public UnemploymentServiceImpl(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public boolean personIsEntitledToUnemploymentSupport(Person person) {
        return !jobService.findCurrentJobPosition(person)
          .isPresent();
    }

    @Override
    public Optional<JobPosition> searchJob(Person person, String searchString) {
        return jobService.listJobs(person)
          .filter((j) -> j.getTitle().contains(searchString))
          .findFirst();
    }
}
