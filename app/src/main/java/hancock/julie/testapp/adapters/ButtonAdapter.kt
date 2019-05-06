package hancock.julie.testapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hancock.julie.testapp.R
import hancock.julie.testapp.models.ButtonObj
import kotlinx.android.synthetic.main.button_list_item.view.*

class ButtonAdapter (val buttonItemList: List<ButtonObj>, val clickListener: (ButtonObj) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //return ButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.button_list_item, parent, false))
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.button_list_item, parent, false)
        return ButtonViewHolder(view)
    }

    override fun getItemCount() = buttonItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ButtonViewHolder).bind(buttonItemList[position], clickListener)
    }

    class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(button: ButtonObj, clickListener: (ButtonObj) -> Unit){
            itemView.tv_button_name.text = button.name
            itemView.setOnClickListener { clickListener(button) }
            //        Glide.with(itemView.context).load(movieModel.moviePicture!!).into(itemView.imageMovie)
        }
    }



}