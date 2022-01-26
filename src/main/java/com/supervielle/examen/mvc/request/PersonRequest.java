package com.supervielle.examen.mvc.request;

import com.supervielle.examen.model.PersonPk;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Credit cards", description = "Credit cards")
public class PersonRequest {
    private PersonPk personPK;
    private String firstName;
    private String lastName;
}
