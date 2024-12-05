package org.application.scribe.controller;

import org.application.scribe.dto.RequestResponseDTO;
import org.application.scribe.object.Request;
import org.application.scribe.object.User;
import org.application.scribe.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping("/all")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestResponseDTO> getRequestById(@PathVariable String id) {
        Optional<Request> requestOptional = requestService.getRequestById(id);
        if (requestOptional.isPresent()) {
            Request request = requestOptional.get();
            User user = request.getUser(); // Get the associated user
            RequestResponseDTO responseDTO = new RequestResponseDTO(request, user);
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody RequestUserDTO requestUserDTO) {
        Request request = requestUserDTO.getRequest();
        User user = requestUserDTO.getUser();
        Request savedRequest = requestService.createRequestWithUser(request, user);
        return ResponseEntity.ok(savedRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> updateRequest(@PathVariable String id, @RequestBody Request requestDetails) {
        return ResponseEntity.ok(requestService.updateRequest(id, requestDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable String id) {
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}