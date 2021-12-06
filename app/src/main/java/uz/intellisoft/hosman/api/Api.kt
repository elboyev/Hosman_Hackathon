package uz.intellisoft.hosman.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import uz.intellisoft.hosman.model.BaseResponse
import uz.intellisoft.hosman.model.OfferModel

interface Api {

    @GET("get_offers")
    fun getOffers(param: Callback<BaseResponse<List<OfferModel>>>): Call<BaseResponse<List<OfferModel>>>

}