package com.example.characters.presentation

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

class CharacterPresenter(
    val model: CharacterContract.Model,
    private val characterView: CharacterContract.View
): CharacterContract.Presenter {

    lateinit var disposable: Disposable

    override fun getCharacters() {
        disposable = model.getAllCharacterss()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                characterView.updateCharacters(it)
            },{
                Log.e(TAG, it.localizedMessage)
            })
    }

    override fun clear() {
        disposable.dispose()
    }

    companion object {
        const val TAG = "CharacterPresenter"
    }
}
