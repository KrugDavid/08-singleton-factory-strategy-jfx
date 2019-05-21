package ohm.softa.a08.services;

import ohm.softa.a08.api.OpenMensaAPI;
import ohm.softa.a08.model.Meal;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class OpenMensaAPIService {
    private static OpenMensaAPIService ourInstance = new OpenMensaAPIService();

    private static OpenMensaAPI mensaApiInstance;

    public static OpenMensaAPIService getInstance() {

    	if(ourInstance==null)
    		ourInstance = new OpenMensaAPIService();
    	return ourInstance;
    }

    private OpenMensaAPIService() {
		var retrofit = new Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("http://openmensa.org/api/v2/")
			.build();

		mensaApiInstance = retrofit.create(OpenMensaAPI.class);
    }

	public static OpenMensaAPI getMensaApiInstance() {
		return mensaApiInstance;
	}
}
