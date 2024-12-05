package org.application.scribe.dto;

import org.application.scribe.object.AppUser;
import org.application.scribe.object.Request;
import lombok.Data;

@Data
public class RequestUserDTO {
    private Request request;
    private AppUser appUser;
}
