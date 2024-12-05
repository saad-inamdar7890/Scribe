package org.application.scribe.dto;

import org.application.scribe.object.Request;
import org.application.scribe.object.User;
import lombok.Data;

@Data
public class RequestUserDTO {
    private Request request;
    private User user;
}
