package com.yusufsezer.resources;

import com.yusufsezer.model.Contact;
import com.yusufsezer.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("Contacts")
@Tag(name = "Contacts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource extends Metadata {

    @Inject
    ContactService contactService;

    @GET
    @Consumes
    @Operation(summary = "Retrieves contact list")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the contact list",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = Contact.class)))
    )
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Retrieves a contact by id")
    @ApiResponse(
            responseCode = "200",
            description = "Returns the contact",
            content = @Content(
                    schema = @Schema(implementation = Contact.class)
            )
    )
    public Contact getContact(
            @Parameter(description = "contact id")
            @PathParam("id") int id) {
        return findContact(id);
    }

    @POST
    @Operation(summary = "Creates a new contact")
    @ApiResponse(
            responseCode = "201",
            description = "A response as creation of contact",
            content = @Content(
                    schema = @Schema(implementation = Contact.class)
            )
    )
    public Response addContact(
            @Parameter(description = "Contact model") Contact contact,
            @Context UriInfo uriInfo) {
        Contact newContact = contactService.addContact(contact);
        String newId = String.valueOf(newContact.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newContact)
                .build();
    }

    @PUT
    @Path("{id}")
    @Operation(summary = "Updates an existing contact")
    @ApiResponse(
            responseCode = "200",
            description = "If contact was updated successfully",
            content = @Content(
                    schema = @Schema(implementation = Contact.class)
            )
    )
    public Contact updateContact(
            @Parameter(description = "Contact id")
            @PathParam("id") int id,
            @Parameter(description = "Contact model") Contact contact) {
        findContact(id);
        return contactService.updateContact(id, contact);
    }

    @DELETE
    @Path("{id}")
    @Operation(summary = "Deletes an existing contact")
    @ApiResponse(
            responseCode = "200",
            description = "If contact was deleted successfully",
            content = @Content(
                    schema = @Schema(implementation = Contact.class)
            )
    )
    public Contact deleteContact(
            @Parameter(description = "Contact id")
            @PathParam("id") int id) {
        findContact(id);
        return contactService.removeContact(id);
    }

    public Contact findContact(int id) {
        if (id < 1) {
            throw new BadRequestException();
        }
        Contact foundContact = contactService.getContact(id);
        if (foundContact == null) {
            throw new NotFoundException();
        }
        if (id != foundContact.getId()) {
            throw new BadRequestException();
        }
        return foundContact;
    }

}
