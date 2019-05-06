package hancock.julie.testapp.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import hancock.julie.testapp.adapters.PageAdapter
import hancock.julie.testapp.R
import hancock.julie.testapp.models.Model
import hancock.julie.testapp.models.PageObj
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_pages.layoutManager = LinearLayoutManager(this)
        val data = createData()
        rv_pages.adapter = PageAdapter(data, { pageItem: PageObj -> pageItemClicked(pageItem) })
    }


    private fun pageItemClicked(pageItem : PageObj) {
//        Toast.makeText(this, "Clicked: ${pageItem.name}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, PageActivity::class.java)
        intent.putExtra("name",pageItem.name)
        startActivity(intent)
    }

    private fun createData() : List<PageObj> {
        val json = application.assets.open("m.json").bufferedReader().use { it.readText() }
        Model.readJSON(json)
        return Model.singleton.pages
    }

}