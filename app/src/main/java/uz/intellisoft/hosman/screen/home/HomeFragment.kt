package uz.intellisoft.hosman.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import uz.intellisoft.hosman.R
class HomeFragment : Fragment() {

    var images = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.pageCount=images.count()
        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(images[position])
        }
    }
    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}