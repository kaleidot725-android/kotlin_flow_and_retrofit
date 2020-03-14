package kaleidot725.sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import coil.api.load
import kaleidot725.sample.R
import kaleidot725.sample.appModule
import kaleidot725.sample.databinding.ActivityMainBinding
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule)
        }

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.user.observe(this, Observer {
            binding.userImageView.load(it.profile_image_url)
            binding.userNameValue.text = it.name
            binding.idValue.text = it.id
            binding.organizationValue.text = it.organization
            binding.descriptionValue.text = it.description
        })
    }
}
