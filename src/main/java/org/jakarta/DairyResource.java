package org.jakarta;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;
import org.jakarta.dto.CreateDairyProduct;
import org.jakarta.dto.DairyProductResponse;
import org.jakarta.entity.DairyProduct;
import org.jakarta.exceptions.NotFound;
import org.jakarta.maper.DairyMapper;

import java.util.List;
import java.util.Objects;


@Path("dairies")
@Log
public class DairyResource {



    private DairyProductRepository repository;

    @Inject
    public DairyResource(DairyProductRepository dairyProductRepository) {
        this.repository = dairyProductRepository;
    }

    public DairyResource(){

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DairyProductResponse> getDairyProducts() {
        return repository.findAll()
                .map(DairyProductResponse::new)
                .filter(Objects::nonNull)
                .toList();

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DairyProductResponse getOneDP(@PathParam("id") Long id) {
        return repository.findById(id).map(DairyProductResponse::new).orElseThrow(
                () -> new NotFound("Dairy product with id " + id + " not found")
        );
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNewDairyProduct(CreateDairyProduct dairyProduct) {
        if (dairyProduct == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Product cannot be null")
                    .build();
        }

        DairyProduct newDairyProduct = DairyMapper.map(dairyProduct);

        newDairyProduct = repository.save(newDairyProduct);
        return Response.status(Response.Status.CREATED)
                .header("Location", "/api/dairies" + newDairyProduct.getId())
                .build();
    }


}
