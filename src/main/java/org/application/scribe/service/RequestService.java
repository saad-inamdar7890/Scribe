package org.application.scribe.service;
import org.application.scribe.object.AppUser;
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

    public AppUser findUserByContact(String contact) {
        return userRepository.findByContact(contact);
    }

    public Request createRequestWithUser(Request request, AppUser appUser) {
        AppUser existingAppUser = findUserByContact(appUser.getContact());
        if (existingAppUser != null) {
            request.setAppUser_id(existingAppUser);
        } else {
            existingAppUser = userRepository.save(appUser);
            request.setAppUser_id(existingAppUser);
        }
        return requestRepository.save(request);
    }

    public Request updateRequest(String id, Request requestDetails) {
        Request request = requestRepository.findById(id).orElseThrow();
        request.setExamDate(requestDetails.getExamDate());
        request.setExamName(requestDetails.getExamName());
        request.setExamTime(requestDetails.getExamTime());
        request.setVenue(requestDetails.getVenue());
        request.setAppUser_id(requestDetails.getAppUser_id());
        return requestRepository.save(request);
    }

    public void deleteRequest(String id) {
        requestRepository.deleteById(id);
    }
}