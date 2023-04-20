package prime.projects.testingnewstuff.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import prime.projects.testingnewstuff.data.MenuItem
import prime.projects.testingnewstuff.databinding.IinerCategoryItemsBinding
import prime.projects.testingnewstuff.events.TestingMenuItemClickListener

class TestingInnerAdapter(
    private val context: Context,
    private val list: ArrayList<MenuItem>,
    private val listening: TestingMenuItemClickListener
): RecyclerView.Adapter<TestingInnerAdapter.CatInnerViewHolder>() {

    private lateinit var binding: IinerCategoryItemsBinding

    class CatInnerViewHolder(private var innerItems: IinerCategoryItemsBinding): RecyclerView.ViewHolder(innerItems.root){
        fun bind(currentItem: MenuItem, listener:TestingMenuItemClickListener){
            innerItems.testingInnerCoffeeMenuItem = currentItem
            innerItems.catInnerItemClicked = listener
            innerItems.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatInnerViewHolder {
        val inflater = LayoutInflater.from(context)
        val innerBinding = IinerCategoryItemsBinding.inflate(inflater, parent, false)
        binding = innerBinding
        return CatInnerViewHolder(innerBinding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CatInnerViewHolder, position: Int) {
        holder.bind(list[position], listening)
    }

}