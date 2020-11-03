package creditCardValidator;

//Requires dependencies located in /WebContent/WEB-INF/lib/...
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/validates")
public class Validate {

	//GET method that validates a credit card using an instance of the Luhn class 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String validateCard(@QueryParam("card_num") String cardNum) {
	//eg) localhost:8080/CreditCardValidatorAPI/v1/validates?card_num={cardNum}

		System.out.println("GET method is called!");
		Luhn checkLuhn = new Luhn();

		//Add data to the JSON object
		JsonObject response = Json.createObjectBuilder()
			.add("Card Number", cardNum)
			.add("Valid", checkLuhn.luhnAlgorithm(cardNum))
			.build();

		//Returns JSON response in String format
		return response.toString();
		
	}

}