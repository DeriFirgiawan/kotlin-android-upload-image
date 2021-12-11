import com.example.imageupload.models.BasicResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiUpload {
    @Multipart
    @POST("/api/upload")
    fun uploadImage(
        @Part image: MultipartBody.Part,
    ) : Call<BasicResponse>
}