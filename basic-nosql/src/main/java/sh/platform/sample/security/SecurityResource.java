package sh.platform.sample.security;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("security")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SecurityResource {

    @Inject
    private SecurityService service;

    @POST
    public void create(@Valid UserDTO userDTO) {
        service.create(userDTO);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathParam("id") String id) {
        service.delete(id);
    }


    @Path("{id}")
    @PUT
    public void changePassword(@PathParam("id") String id, @Valid UserDTO dto) {
        service.updatePassword(id, dto);
    }

    @Path("roles/{id}")
    @PUT
    @RolesAllowed("ADMIN")
    public void addRole(@PathParam("id") String id, RoleDTO dto){
        service.addRole(id, dto);
    }

    @Path("roles/{id}")
    @DELETE
    @RolesAllowed("ADMIN")
    public void removeRole(@PathParam("id") String id, RoleDTO dto){
        service.removeRole(id, dto);
    }

    @Path("me")
    @GET
    public UserDTO getMe() {
        return service.getUser();
    }

    @Path("users")
    @GET
    @RolesAllowed("ADMIN")
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }
}
