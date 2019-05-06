package hancock.julie.testapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import hancock.julie.testapp.adapters.ButtonAdapter
import hancock.julie.testapp.R
import hancock.julie.testapp.adapters.GridItemDecoration
import hancock.julie.testapp.models.ButtonObj
import hancock.julie.testapp.models.Model
import kotlinx.android.synthetic.main.activity_page.*

class PageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        val name = intent.getStringExtra("name")
        val page = Model.getPageByName(name)!!
        // page_header.text = page.toString()


//        rv_buttons.layoutManager = LinearLayoutManager(this)
        val data = page.buttons
        rv_buttons.layoutManager = GridLayoutManager(this,4)
        rv_buttons.addItemDecoration(GridItemDecoration(10,4))
        rv_buttons.adapter = ButtonAdapter(data, {buttonItem: ButtonObj -> buttonItemClicked(buttonItem)})

    }


    private fun buttonItemClicked(buttonItem : ButtonObj){
        Toast.makeText(this, "Clicked: ${buttonItem.code}", Toast.LENGTH_SHORT).show()
    }


}
