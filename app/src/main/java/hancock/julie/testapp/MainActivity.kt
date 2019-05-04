package hancock.julie.testapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import hancock.julie.testapp.models.Model
import hancock.julie.testapp.models.PageObj
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_pages.layoutManager = LinearLayoutManager(this)
        var testData = createTestDataPage()
        rv_pages.adapter = PageAdapter(testData, { pageItem : PageObj -> pageItemClicked(pageItem) })
    }


    private fun pageItemClicked(pageItem : PageObj) {
        Toast.makeText(this, "Clicked: ${pageItem.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,PageActivity::class.java)
        var b = Bundle()
        b.putString("name", pageItem.name)
        intent.putExtras(b)
        startActivity(intent)
    }

    private fun createTestDataPage() : List<PageObj> {
        val json = application.assets.open("m.json").bufferedReader().use { it.readText() }
        Model.readJSON(json)
        return Model.singleton.pages
    }

}