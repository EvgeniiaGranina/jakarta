package org.jakarta;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.java.Log;
import org.jakarta.dto.DairyProductResponse;


@Path("dairies")
@Log
public class DairyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DairyProductResponse firstTest(){
        return new DairyProductResponse("Ost", 123);
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
