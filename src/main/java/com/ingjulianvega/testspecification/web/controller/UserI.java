package com.ingjulianvega.testspecification.web.controller;

import com.ingjulianvega.testspecification.web.model.ApiError;
import com.ingjulianvega.testspecification.web.model.User;
import com.ingjulianvega.testspecification.web.model.UserDto;
import com.ingjulianvega.testspecification.web.model.UserList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface UserI {

    @Operation(summary = "Endpoint to get the list of users", description = "Returns a list of users", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = UserList.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserList> get();


    @Operation(summary = "Endpoint to get the information of a  user given the id", description = "Returns a user", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The operation was successful.", content = @Content(schema = @Schema(implementation = UserDto.class))),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<UserDto> getById(@Parameter(in = ParameterIn.PATH, description = "The user id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);

    @Operation(summary = "Endpoint to create a user", description = "Creates a new user", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - server error", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Void> create(@Parameter(in = ParameterIn.DEFAULT, description = "Name of the new marital staus", required = true, schema = @Schema()) @NotNull @Valid @RequestBody User body);


    @Operation(summary = "Endpoint to update the information of a user given the id", description = "Updates a user", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - error de server, it'll show a generic user message", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateById(@Parameter(in = ParameterIn.PATH, description = "The user id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id,
                                    @Parameter(in = ParameterIn.DEFAULT, description = "Name of the new marital staus", required = true, schema = @Schema()) @NotNull @Valid @RequestBody User body);


    @Operation(summary = "Endpoint to delete a user", description = "Deletes a user", tags = {"user"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The operation was successful."),

            @ApiResponse(responseCode = "400", description = "400 - business error", content = @Content(schema = @Schema(implementation = ApiError.class))),

            @ApiResponse(responseCode = "500", description = "500 - error de server, it'll show a generic user message", content = @Content(schema = @Schema(implementation = ApiError.class)))})
    @RequestMapping(value = "/{id}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteById(@Parameter(in = ParameterIn.PATH, description = "The user id", required = true, schema = @Schema()) @NotNull @PathVariable("id") UUID id);


}
