package pl.ghostbuster.tumblrexplorer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import pl.ghostbuster.tumblrexplorer.extensions.find

class HomeActivity : AppCompatActivity() {

    private val inputEditText by find<EditText>(R.id.home_activity_input)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
    }
}