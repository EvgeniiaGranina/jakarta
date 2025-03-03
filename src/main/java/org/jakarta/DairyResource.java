package org.jakarta;

import jakarta.inject.Inject;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.java.Log;
import org.jakarta.dto.DairyProductResponse;
import org.jakarta.entity.DairyProduct;

import java.time.LocalDate;


@Path("dairies")
@Log
public class DairyResource {

    @Inject
    private Repository repository;




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DairyProductResponse firstTest(){
        return new DairyProductResponse("Ost", 123, "Mild", LocalDate.of(2025, 03, 02), "Arla", 1000.30);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public DairyProductResponse create (DairyProduct dairyProduct){

        repository.saveDairyProduct(dairyProduct);
        return new DairyProductResponse("Ost", 123, "Mild", LocalDate.of(2025, 03, 02), "Arla", 1000.30);
    }

//    private DairyRepository repository;
//
//    @Inject
//    public DairyResource(DairyRepository repository) {
//        this.repository = repository;
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public DairyResponse getDairy() {
//        return new DairyResponse("Milk", 23);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public DairyResponse create(DairyProduct dairy) {
//        repository.save(dairy);
//        return new DairyResponse("Ost", 140);
//    }
//
//    @GET
//    @Path("many")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Dairies test() {
//        java.util.List<DairyResponse> dairyList = new ArrayList<DairyResponse>();
//        dairyList.add(new DairyResponse("Milk", 23));
//        dairyList.add(new DairyResponse("Ost", 135));
//        return new Dairies(dairyList, 2);
//    }
//
//    public record Dairies(List<DairyResponse> values, int totalProduct) {
//
//    }

}
