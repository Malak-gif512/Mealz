package com.example.mealz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rv:RecyclerView=findViewById(R.id.category_rv)

        viewModel.getMeals()
        val mealsAdapter = MealsAdapter()

        lifecycleScope.launch {
            viewModel.categories.collect {
                mealsAdapter.submitList(it?.categories)
                rv.adapter = mealsAdapter
            }
        }

    }
}