package hancock.julie.testapp

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_page.*

class PageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)
        if(savedInstanceState != null){
            val v = savedInstanceState.get("name")

            Toast.makeText(this, "Clicked: ${v}", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "yikes", Toast.LENGTH_SHORT).show()

        }


    }

}
