package prime.projects.testingnewstuff.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import prime.projects.testingnewstuff.R
import prime.projects.testingnewstuff.data.TestingImages
import prime.projects.testingnewstuff.databinding.FragmentTestNewHomeBinding
import prime.projects.testingnewstuff.ui.adapter.TestingStuffImageAdapter
import java.io.IOException
import java.nio.charset.Charset

class TestNewHome : Fragment() {

    private var binding: FragmentTestNewHomeBinding?= null

    private lateinit var adapter: TestingStuffImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeBinding = FragmentTestNewHomeBinding.inflate(inflater, container, false)
        binding = homeBinding
        // Inflate the layout for this fragment
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jsonString = getImageData()!!
        val gson = Gson()
        val homeImages = gson.fromJson(jsonString, TestingImages::class.java)
        adapter = TestingStuffImageAdapter(requireActivity(), homeImages)

        binding?.apply {
            testingHomeFragment = this@TestNewHome
            testingHomeImageAdapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun getImageData(): String? {
        val json: String?
        val charset: Charset = Charsets.UTF_8
        try {
            val imageFILE = resources.openRawResource(R.raw.jarrod_home_images)
            val size = imageFILE.available()
            val buffer = ByteArray(size)
            imageFILE.read(buffer)
            imageFILE.close()
            json = String(buffer, charset)
        } catch (e: IOException){
            e.printStackTrace()
            return null
        }

        return json
    }

    fun goToMenuLaunch(){
        findNavController().navigate(R.id.action_testNewHome_to_testNewCategories)
    }


}