package ma.enset.restapi.services;

import ma.enset.restapi.models.GoogleBoooksResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleBooksService {

    @GET("v1/volumes")
    Call<GoogleBoooksResponse> searchBooks(@Query("q") String query);


}
