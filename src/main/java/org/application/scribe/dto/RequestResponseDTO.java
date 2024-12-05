package org.application.scribe.dto;

import org.application.scribe.object.AppUser;
import org.application.scribe.object.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestResponseDTO {
    private Request request;
    private AppUser appUser;
}
