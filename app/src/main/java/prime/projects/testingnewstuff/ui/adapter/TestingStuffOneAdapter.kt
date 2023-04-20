package prime.projects.testingnewstuff.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import prime.projects.testingnewstuff.data.TestingCoffeeMenuItem
import prime.projects.testingnewstuff.databinding.CategoryItemListBinding
import prime.projects.testingnewstuff.events.CatItemClickListener

class TestingStuffOneAdapter(
    private val context: Context,
    private val list: ArrayList<TestingCoffeeMenuItem>,
    private val listeners: CatItemClickListener
    ): RecyclerView.Adapter<TestingStuffOneAdapter.CategoryViewHolder>() {

        private lateinit var binding: CategoryItemListBinding

        class CategoryViewHolder(private var catItems: CategoryItemListBinding):RecyclerView.ViewHolder(catItems.root){
            fun bind(currentItem: TestingCoffeeMenuItem, listener: CatItemClickListener){
                catItems.testingMenuItems = currentItem
                catItems.catItemClicks = listener
                catItems.executePendingBindings()
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(context)
        val catBinding = CategoryItemListBinding.inflate(inflater, parent, false)
        binding = catBinding
        return CategoryViewHolder(catBinding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(list[position], listeners)
}