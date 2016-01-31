package pl.ghostbuster.tumblrexplorer.usecase

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.extensions.addOnTextChangedListener
import pl.ghostbuster.tumblrexplorer.common.extensions.find
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrApi
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrService
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HomeActivity : AppCompatActivity() {

    private val tumblrService = TumblrService(TumblrApi.get())
    private val inputEditText by find<EditText>(R.id.home_activity_input)
    private val resultsContainer by find<RecyclerView>(R.id.home_activity_results_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        inputEditText.addOnTextChangedListener(onTextChanged)
    }

    private val onTextChanged = { text: String ->
        Log.i("textWatcher", "textChanged")
        if (text.isNotEmpty()) {
            tumblrService.call(text)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(onSuccess, onError)
        }
    }

    private val onSuccess: (TumblrResponseWrapper) -> Unit = {
        Log.i("api", "success" + it.posts.first().id)
    }

    private val onError: (Throwable) -> Unit = {
        Log.i("api", "error", it)
    }
}