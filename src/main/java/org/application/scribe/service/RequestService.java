package org.application.scribe.service;
import org.application.scribe.object.User;
import org.application.scribe.object.Request;
import org.application.scribe.repository.RequestRepository;
import org.application.scribe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Optional<Request> getRequestById(String id) {
        return requestRepository.findById(id);
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public User findUserByContact(String contact) {
        return userRepository.findByContact(contact);
    }

    public Request createRequestWithUser(Request request, User user) {
        User existingUser = findUserByContact(user.getContact());
        if (existingUser != null) {
            request.setUser(existingUser);
        } else {
            existingUser = userRepository.save(user);
            request.setUser(existingUser);
        }
        return requestRepository.save(request);
    }

    public Request updateRequest(String id, Request requestDetails) {
        Request request = requestRepository.findById(id).orElseThrow();
        request.setExamDate(requestDetails.getExamDate());
        request.setExamName(requestDetails.getExamName());
        request.setExamTime(requestDetails.getExamTime());
        request.setVenue(requestDetails.getVenue());
        request.setUser(requestDetails.getUser());
        return requestRepository.save(request);
    }

    public void deleteRequest(String id) {
        requestRepository.deleteById(id);
    }
}