package hancock.julie.testapp

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hancock.julie.testapp.models.PageObj
import kotlinx.android.synthetic.main.part_list_item.view.*

class PageAdapter (val pageItemList: List<PageObj>, val clickListener: (PageObj) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.part_list_item, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PageViewHolder).bind(pageItemList[position], clickListener)
    }

    override fun getItemCount() = pageItemList.size

    class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(page: PageObj, clickListener: (PageObj) -> Unit) {
            itemView.tv_page_name.text = page.name
            itemView.setOnClickListener { clickListener(page)}
        }
    }
}