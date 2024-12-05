package org.application.scribe.dto;

import org.application.scribe.object.Request;
import org.application.scribe.object.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestResponseDTO {
    private Request request;
    private User user;
}
