package uz.intellisoft.hosman.model

data class BaseResponse<T>(
    val success:Boolean,
    val data:T,
    val message: String,
    val error_code:Int
)

