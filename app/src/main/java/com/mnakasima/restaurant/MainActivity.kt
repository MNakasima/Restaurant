package com.mnakasima.restaurant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_view.view.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var listFoods = arrayListOf<Food>()
    var adapter:FoodAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFood()
        adapter = FoodAdapter(this, listFoods)
        gvListFood.adapter = adapter

    }

    fun loadFood(){
        listFoods.add(Food("Coffee", "Coffe with no sugar pls", R.drawable.coffee_pot))
        listFoods.add(Food("Espresso", "Machine coffee", R.drawable.espresso))
        listFoods.add(Food("French Fries", "Cracked", R.drawable.french_fries))
        listFoods.add(Food("Honey", "Save the bees", R.drawable.honey))
        listFoods.add(Food("Strawberry", "Cold and Fresh", R.drawable.strawberry_ice_cream))
        listFoods.add(Food("Sugar Cubes", "Do not throw it in the coffee lol", R.drawable.sugar_cubes))
    }

    class FoodAdapter:BaseAdapter{

        var context:Context?=null
        var listFoods = arrayListOf<Food>()

        constructor(context:Context,listFoods:ArrayList<Food>):super(){
            this.context=context
            this.listFoods=listFoods
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val food = this.listFoods[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_view, null)
            foodView.ivFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            foodView.setOnClickListener{
                var intent = Intent(context, FoodDetails::class.java)
                intent.putExtra("name", food.name)
                intent.putExtra("description", food.description)
                intent.putExtra("image", food.image!!)
                context!!.startActivity(intent)
            }

            return foodView

        }

        override fun getItem(position: Int): Any {
            return listFoods[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listFoods.size
        }

    }

}
