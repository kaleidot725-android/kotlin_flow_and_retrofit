package kaleidot725.sample.data.service

import kaleidot725.sample.data.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface QiitaService {
    @GET("/api/v2/users/{user_id}")
    fun getUser(@Path("user_id") user_id: String): Call<User>
}