package kaleidot725.sample

import kaleidot725.sample.data.repository.UserRepository
import kaleidot725.sample.data.service.QiitaService
import kaleidot725.sample.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://qiita.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(QiitaService::class.java)
    }

    single {
        UserRepository(get())
    }

    viewModel {
        MainViewModel(get())
    }
}
