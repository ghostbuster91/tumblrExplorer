package pl.ghostbuster.tumblrexplorer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.EditText
import pl.ghostbuster.tumblrexplorer.extensions.addOnTextChangedListener
import pl.ghostbuster.tumblrexplorer.extensions.find

class HomeActivity : AppCompatActivity() {

    private val inputEditText by find<EditText>(R.id.home_activity_input)
    private val resultsContainer by find<RecyclerView>(R.id.home_activity_results_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        inputEditText.addOnTextChangedListener {
            Log.i("textWatcher", "textChanged")
        }
    }
}