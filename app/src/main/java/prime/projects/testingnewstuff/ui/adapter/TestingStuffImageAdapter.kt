package prime.projects.testingnewstuff.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import prime.projects.testingnewstuff.data.TestingImagesItem
import prime.projects.testingnewstuff.databinding.HomeImageListBinding

class TestingStuffImageAdapter(
    private val context: Context,
    private val imageList: ArrayList<TestingImagesItem>
    ): RecyclerView.Adapter<TestingStuffImageAdapter.TestingImageViewHolder>() {

        private lateinit var binding: HomeImageListBinding

        inner class TestingImageViewHolder(private var homeImageItems: HomeImageListBinding):RecyclerView.ViewHolder(homeImageItems.root){
            fun bind(currentItems: TestingImagesItem){
                homeImageItems.testingImages = currentItems
                homeImageItems.executePendingBindings()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestingImageViewHolder {
        val inflater = LayoutInflater.from(context)
        val itemBinding = HomeImageListBinding.inflate(inflater, parent, false)
        return TestingImageViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: TestingImageViewHolder, position: Int) =
        holder.bind(imageList[position])


}