package kaleidot725.sample.data.repository

import android.util.Log
import kaleidot725.sample.data.entity.User
import kaleidot725.sample.data.entity.nullUser
import kaleidot725.sample.data.service.QiitaService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserRepository(private val service: QiitaService) {
    fun getUser(userId: String): Flow<User> {
        return flow {
            try {
                emit(service.getUser(userId).execute().body())
            } catch (e: Exception) {
                Log.e("UserRepository", "getUser error", e)
                emit(nullUser)
            }
        }.flowOn(Dispatchers.IO)
    }
}