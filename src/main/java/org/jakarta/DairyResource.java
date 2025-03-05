package org.jakarta;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;
import org.jakarta.dto.CreateDairyProduct;
import org.jakarta.dto.DairyProductResponse;
import org.jakarta.dto.UpdateDairyProduct;
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

        newDairyProduct = repository.insert(newDairyProduct);
        return Response.status(Response.Status.CREATED)
                .header("Location", "/api/dairies" + newDairyProduct.getId())
                .build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDP(@PathParam("id") Long id, UpdateDairyProduct dairyProduct) {
        var oldDairyProduct = repository.findById(id).orElseThrow(() -> new NotFound("Dairy product with id " + id + " not found"));
        oldDairyProduct.setName(dairyProduct.name());
        oldDairyProduct.setDescription(dairyProduct.description());
        oldDairyProduct.setPrice(dairyProduct.price());
        oldDairyProduct.setBrand(dairyProduct.brand());
        oldDairyProduct.setWeight(dairyProduct.weight());
        repository.update(oldDairyProduct);
        return Response.noContent().build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDPFieldByField(@PathParam("id") Long id, UpdateDairyProduct dairyProduct) {
        var oldDairyProduct = repository.findById(id).orElseThrow(() -> new NotFound("Dairy product with id " + id + " not found"));
        if (dairyProduct.name() != null)
            oldDairyProduct.setName(dairyProduct.name());
        if (dairyProduct.description() != null)
            oldDairyProduct.setDescription(dairyProduct.description());
        if (dairyProduct.price() != 0)
            oldDairyProduct.setPrice(dairyProduct.price());
        if (dairyProduct.brand() != null)
            oldDairyProduct.setBrand(dairyProduct.brand());
        if (dairyProduct.weight() != 0)
            oldDairyProduct.setWeight(dairyProduct.weight());
        repository.update(oldDairyProduct);
        return Response.noContent().build();
    }
}
