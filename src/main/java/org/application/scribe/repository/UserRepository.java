package org.application.scribe.repository;

import org.application.scribe.object.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByContact(String contact); // Method to find user by contact
}
