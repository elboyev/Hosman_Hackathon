package uz.intellisoft.hosman.screen.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.intellisoft.hosman.R

class SearchFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_maps, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SearchFragment()
    }
}