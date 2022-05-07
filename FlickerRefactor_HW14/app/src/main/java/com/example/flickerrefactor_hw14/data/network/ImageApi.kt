package com.example.flickerrefactor_hw14.data.network


import com.example.flickerrefactor_hw14.data.model.PhotoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ImageApi {

    @GET("services/rest")
    fun loadImages(@Query("api_key") api_key:String ,
                   @Query("user_id") user_id:String ,
                   @Query("method") method:String ,
                   @Query("extras") extras:String ,
                   @Query("format") format:String ,
                   @Query("nojsoncallback") nojsoncallback:String ,
                   @Query("per_page") per_page:String ,
                   @Query("page") page:String ):Call<PhotoModel>

    @GET("services/rest")
    fun loadSearches(@Query("api_key") api_key:String ,
                     @Query("user_id") user_id:String ,
                     @Query("method") method:String ,
                     @Query("extras") extras:String ,
                     @Query("format") format:String ,
                     @Query("nojsoncallback") nojsoncallback:String ,
                     @Query("per_page") per_page:String ,
                     @Query("page") page:String ,
                     @Query("text") text:String ): Call<PhotoModel>

    @GET("services/rest")
    fun getImage(@QueryMap map: Map<String, String> = mapOf<String,String>(
        "api_key" to "1c04e05bce6e626247758d120b372a73"
        ,"method" to "flickr.photos.getPopular"
        ,"user_id" to  "34427466731@N01"
        ,"extras" to "url_s"
        ,"format" to "json"
        ,"nojsoncallback" to "1"
        , "per_page" to "30") ) : Call<PhotoModel>
}