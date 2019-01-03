package ormas.aditya.com.ormascibiru;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("index.php")
    Call<List<Ormas>> getBuah(
            @Query("item_type") String item_type
    );
}
