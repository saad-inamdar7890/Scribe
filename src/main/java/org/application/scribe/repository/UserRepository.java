package org.application.scribe.repository;

import org.application.scribe.object.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {
    AppUser findByContact(String contact); // Method to find user by contact
}
