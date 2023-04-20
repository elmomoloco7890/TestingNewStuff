package prime.projects.testingnewstuff.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import prime.projects.testingnewstuff.R
import prime.projects.testingnewstuff.data.AllMenuItems
import prime.projects.testingnewstuff.data.MenuItem
import prime.projects.testingnewstuff.data.TestingCoffeeMenu
import prime.projects.testingnewstuff.databinding.FragmentTestingNewInnerCategoriesBinding
import prime.projects.testingnewstuff.events.TestingMenuItemClickListener
import prime.projects.testingnewstuff.ui.adapter.TestingInnerAdapter
import java.io.IOException
import java.nio.charset.Charset


class TestingNewInnerCategories : Fragment(), TestingMenuItemClickListener {

    private var binding: FragmentTestingNewInnerCategoriesBinding ?= null

    private lateinit var adapter: TestingInnerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val innerItemBinding = FragmentTestingNewInnerCategoriesBinding.inflate(inflater, container, false)
        binding = innerItemBinding
        return innerItemBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonString = getMenuItems()!!
        val gson = Gson()
        val menuItemsArray = gson.fromJson(jsonString, AllMenuItems::class.java)
        adapter = TestingInnerAdapter(requireActivity(), menuItemsArray, this)

        binding?.apply {
            innerCategoryFragment = this@TestingNewInnerCategories
            testingInnerAdapter = adapter
        }
    }

    private fun getMenuItems(): String? {
        val json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val menuItemJSONFile = resources.openRawResource(R.raw.jarrod_coffee_menu)
            val size = menuItemJSONFile.available()
            val buffer = ByteArray(size)
            menuItemJSONFile.read(buffer)
            menuItemJSONFile.close()
            json = String(buffer, charset)
        } catch (e: IOException){
            e.printStackTrace()
            return null
        }

        return json

    }

    override fun onItemClicked(menuItem: MenuItem) {
        for (items in 1..20){
            if(items == 1){
                //add the details action here
                break
            }
        }
    }


}