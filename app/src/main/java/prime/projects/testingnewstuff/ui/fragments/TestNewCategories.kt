package prime.projects.testingnewstuff.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import prime.projects.testingnewstuff.R
import prime.projects.testingnewstuff.data.TestingCoffeeMenu
import prime.projects.testingnewstuff.data.TestingCoffeeMenuItem
import prime.projects.testingnewstuff.databinding.FragmentTestNewCategoriesBinding
import prime.projects.testingnewstuff.events.CatItemClickListener
import prime.projects.testingnewstuff.ui.adapter.TestingStuffOneAdapter
import java.io.IOException
import java.nio.charset.Charset


class TestNewCategories : Fragment(), CatItemClickListener {

    private var binding: FragmentTestNewCategoriesBinding ?= null

    private lateinit var adapter: TestingStuffOneAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val testNewCatBinding = FragmentTestNewCategoriesBinding.inflate(inflater, container, false)
        binding = testNewCatBinding
        return testNewCatBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonString = gettingCatsInformation()!!
        val gson = Gson()
        val categoryThings = gson.fromJson(jsonString, TestingCoffeeMenu::class.java)
        adapter = TestingStuffOneAdapter(requireActivity(), categoryThings, this)
        binding?.apply {
            categoryFragment = this@TestNewCategories
            testingOneAdapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun gettingCatsInformation(): String? {
        val json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val catsJSONFile = resources.openRawResource(R.raw.jarrod_coffee_menu)
            val size = catsJSONFile.available()
            val buffer = ByteArray(size)
            catsJSONFile.read(buffer)
            catsJSONFile.close()
            json = String(buffer, charset)
        }catch (e: IOException){
            e.printStackTrace()
            return null
        }
        return json
    }

    override fun onItemClicked(testingCoffeeMenuItem: TestingCoffeeMenuItem) {
        for (cats in 1..7){
            if (cats == 1){
                findNavController().navigate(R.id.action_testNewCategories_to_testingNewInnerCategories)
                break
            }
        }
    }


}