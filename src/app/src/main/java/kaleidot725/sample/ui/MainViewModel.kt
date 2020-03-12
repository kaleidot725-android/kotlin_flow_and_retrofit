package kaleidot725.sample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kaleidot725.sample.data.entity.User
import kaleidot725.sample.data.repository.UserRepository

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    val user: LiveData<User> = userRepository.getUser("kaleidot725").asLiveData()
}