package org.application.scribe.repository;

import org.application.scribe.object.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, String> {
    // Additional query methods can be defined here if needed
}
