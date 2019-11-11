package com.mnakasima.restaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.food_view.ivFood
import kotlinx.android.synthetic.main.food_view.tvName

class FoodDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle = intent.extras

        ivFood.setImageResource(bundle!!.getInt("image"))
        tvName.text = bundle!!.getString("name")
        tvDesc.text = bundle!!.getString("description")
    }
}
