
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET


interface ApiService{
    @GET("data/getspecificdata/1/1")
    fun fetchData(): Call<List<DataResponse>>
}

data class DataResponse(
   val count: List<CountItem>
)

data class CountItem(
    @SerializedName("COUNT(*)") val count: Int
)