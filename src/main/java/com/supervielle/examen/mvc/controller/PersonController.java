package com.supervielle.examen.mvc.controller;

import com.supervielle.examen.exception.CustomErrorResponse;
import com.supervielle.examen.exception.NotFoundException;
import com.supervielle.examen.model.Person;
import com.supervielle.examen.mvc.request.PersonRequest;
import com.supervielle.examen.service.PersonService;
import com.supervielle.examen.service.PersonServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
    @Operation(summary = "Get creditcards by type and document or cuit")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the creditcards", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request. Invalid paremeter supplied", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Credit cards not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unexpected system error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))})})

    public ResponseEntity<Person> createPerson(PersonRequest personRequest){
        return ResponseEntity.ok(personService.createPerson(personRequest));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    // https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
    @Operation(summary = "Get Person by personPK")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the creditcards", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request. Invalid paremeter supplied", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Credit cards not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unexpected system error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))})})

    public ResponseEntity<List<Person>> getPerson(PersonRequest personRequest){

        return ResponseEntity.ok(personService.getPersons(personRequest));
    }

    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    // https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
    @Operation(summary = "Get creditcards by type and document or cuit")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the creditcards", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request. Invalid paremeter supplied", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Credit cards not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unexpected system error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))})})

    public ResponseEntity<Person> updatePerson(PersonRequest personRequest){

        return ResponseEntity.ok(personService.updatePerson(personRequest));
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    // https://www.dariawan.com/tutorials/spring/documenting-spring-boot-rest-api-springdoc-openapi-3/
    @Operation(summary = "Get creditcards by type and document or cuit")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the creditcards", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request. Invalid paremeter supplied", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Credit cards not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unexpected system error", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CustomErrorResponse.class))})})

    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public void deletePerson(PersonRequest personRequest) throws NotFoundException {
        if (!personService.deletePerson(personRequest)) {
            throw new NotFoundException();
        }
    }
}
