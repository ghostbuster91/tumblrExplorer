package pl.ghostbuster.tumblrexplorer.usecase

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import de.greenrobot.event.Subscribe
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.Bus
import pl.ghostbuster.tumblrexplorer.common.extensions.addOnTextChangedListener
import pl.ghostbuster.tumblrexplorer.common.extensions.find
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrApi
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrService
import pl.ghostbuster.tumblrexplorer.usecase.event.OnLinkClickEvent
import pl.ghostbuster.tumblrexplorer.usecase.event.OnVideoClickEvent
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class HomeActivity : AppCompatActivity(), Bus.Passenger {

    private val tumblrService = TumblrService(TumblrApi.get())
    private val inputEditText by find<EditText>(R.id.home_activity_input)
    private val resultsContainer by find<RecyclerView>(R.id.home_activity_results_container)
    private val postsAdapter = TumblrPostsAdapter()

    private var subscription: Subscription? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        resultsContainer.layoutManager = LinearLayoutManager(this)
        resultsContainer.adapter = postsAdapter
        inputEditText.addOnTextChangedListener(onTextChanged)
    }

    private val onTextChanged = { text: String ->
        if (text.isNotEmpty()) {
            subscription?.unsubscribe()
            subscription = tumblrService.call(text)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(onSuccess, onError)
        }
    }

    private val onSuccess: (TumblrResponseWrapper) -> Unit = {
        postsAdapter.setItems(it.posts)
    }

    private val onError: (Throwable) -> Unit = {
        Log.e("api", "error", it)
    }

    override fun onResume() {
        super.onResume()
        Bus.getIn(this)
    }

    override fun onPause() {
        super.onPause()
        subscription?.unsubscribe()
        Bus.getOut(this)
    }

    @Subscribe
    fun onEvent(event: OnVideoClickEvent) {
        startActivityForUrl(event.url)
    }

    @Subscribe
    fun onEvent(event: OnLinkClickEvent) {
        startActivityForUrl(event.linkUrl)
    }

    private fun startActivityForUrl(url: String) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        } catch(ex: Exception) {
            Toast.makeText(this, "error during parsing url", Toast.LENGTH_LONG).show()
        }
    }
}