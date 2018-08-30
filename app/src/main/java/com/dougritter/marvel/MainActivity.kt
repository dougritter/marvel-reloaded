package com.dougritter.marvel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dougritter.marvel.core.di.ApplicationComponent
import com.dougritter.marvel.core.platform.KeysRepository
import com.dougritter.marvel.features.characters.CharactersViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (this.application as AndroidApplication).appComponent
    }

    @Inject lateinit var charactersViewModel: CharactersViewModel
    @Inject lateinit var keysRepository: KeysRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent.inject(this)

        print("PRIVATE_KEY" + keysRepository.privateKey)
        print("PUBLIC_KEY" + keysRepository.publicKey)

        charactersViewModel.loadCharacters()


    }
}
