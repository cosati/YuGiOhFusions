package com.alexandrecosati.YuGiOhFusions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alexandrecosati.YuGiOhFusions.dao.CardDAO;
import com.alexandrecosati.YuGiOhFusions.dao.FusionDAO;
import com.alexandrecosati.YuGiOhFusions.entities.Card;
import com.alexandrecosati.YuGiOhFusions.entities.Fusion;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cards")
public class CardResource {
	
	private final CardDAO cardDao = new CardDAO();
	private final FusionDAO fusionDao = new FusionDAO();

    @Path("/{id}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCardById(@PathParam("id") int id) {
    	Card card = cardDao.findById(id);
        return Response.status(Response.Status.OK)
        		.header("Access-Control-Allow-Origin", "*")
        		.header("strict-origin-when-cross-origin", "*")
        		.entity(card).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCards() {
        return Response.status(Response.Status.OK)
        		 .header("Access-Control-Allow-Origin", "*")
        		 .header("strict-origin-when-cross-origin", "*")
        		 .entity(cardDao.findAllCards()).build();
    }
    
    @Path("/fusions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFusions(@QueryParam("cardId") final List<Integer> cardId) {    	
    	Set<Fusion> fusions = new HashSet<>();
    	for (Integer first : cardId) {
    		List<Integer> temp = new ArrayList<>(cardId);
    		temp.remove(first);
    		fusions.addAll(fusionDao.fetchFusions(first, temp));
    	}
    	//fusions.addAll(fusionDao.fetchFusions(cardId));
    	return Response.status(Response.Status.OK)
    			.header("Access-Control-Allow-Origin", "*")
    			.header("strict-origin-when-cross-origin", "*")
    			.entity(fusions).build();
    }
    
    @Path("/monsters")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFusionPossibilities(@QueryParam("cardId") final Integer cardId) {
    	List<Fusion> fusions = fusionDao.findCardFusions(cardId);
    	return Response.status(Response.Status.OK)
    			.header("Access-Control-Allow-Origin", "*")
    			.header("strict-origin-when-cross-origin", "*")
    			.entity(fusions).build();
    }
    
}
