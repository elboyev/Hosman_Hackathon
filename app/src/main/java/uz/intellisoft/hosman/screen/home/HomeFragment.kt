package uz.intellisoft.hosman.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.intellisoft.hosman.R
import uz.intellisoft.hosman.api.Api
import uz.intellisoft.hosman.model.BaseResponse
import uz.intellisoft.hosman.model.OfferModel

class HomeFragment : Fragment() {

    var offers: List<OfferModel> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit=Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://osonsavdo.sd-group.uz/api").build()

        val api = retrofit.create(Api::class.java)

        api.getOffers(object : Callback<BaseResponse<List<OfferModel>>>{
            override fun onResponse(
                call: Call<BaseResponse<List<OfferModel>>>,
                response: Response<BaseResponse<List<OfferModel>>>
            ) {
                offers=response.body()!!.data
                if (response.isSuccessful && response.body()!!.success){

                    carouselView.setImageListener { position, imageView ->
                        Glide.with(imageView).load("http://osonsavdo.sd-group.uz/images/${offers[position].image}").into(imageView)
                    }
                    carouselView.pageCount=offers.count()
                }else
                    Toast.makeText(requireActivity(),response.body()!!.message,Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<BaseResponse<List<OfferModel>>>, t: Throwable) {
                Toast.makeText(requireActivity(),t.localizedMessage,Toast.LENGTH_LONG).show()
            }
        })


    }
    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}