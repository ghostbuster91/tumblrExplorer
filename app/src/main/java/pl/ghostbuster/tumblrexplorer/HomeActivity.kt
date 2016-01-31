package pl.ghostbuster.tumblrexplorer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import pl.ghostbuster.tumblrexplorer.extensions.find

class HomeActivity : AppCompatActivity() {

    private val inputEditText by find<EditText>(R.id.home_activity_input)
    private val resultsContainer by find<RecyclerView>(R.id.home_activity_results_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        inputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i("textWatcher", "textChanged")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}