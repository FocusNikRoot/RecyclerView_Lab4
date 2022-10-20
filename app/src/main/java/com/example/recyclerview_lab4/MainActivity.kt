package com.example.recyclerview_lab4

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface CellClickListener {
    fun onCellClickListener(color: String)
}

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("HEEEEEEEERE", Color.WHITE.toString())
        Log.v("HEEEEEEEERE2", Color.BLACK.toString())
        Log.v("HEEEEEEEERE3", Color.RED.toString())

        val recyclerView: RecyclerView = findViewById(R.id.rView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList(), this)

    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()
        val listOfColors = generateColors()
        val colorsName = listOf("WHITE", "BLACK", "YELLOW", "GREEN", "BLUE")

        for (i in 0..4) {
            val model = Model(
                generateColors()[i].getMyColorHex(),
                generateColors()[i].getMyColorName(),
                "${colorsName[i]}",
                "")
            list.add(model)
        }
        return list
    }

    private fun generateColors() : ArrayList<ColorData> {
        val listOfColors = arrayListOf<ColorData>()

        listOfColors.add(ColorData("white", Color.WHITE))
        listOfColors.add(ColorData("black", Color.BLACK))
        listOfColors.add(ColorData("yellow", Color.YELLOW))
        listOfColors.add(ColorData("green", Color.GREEN))
        listOfColors.add(ColorData("blue", Color.BLUE))

        return listOfColors
    }

    override fun onCellClickListener(color: String) {
        Toast.makeText(applicationContext, "IT,S $color", Toast.LENGTH_SHORT).show()
    }
}

class ColorData(colorName: String, colorHex: Int) {
    private lateinit var colorName: String
    private var colorHex: Int = 0

    init {
        this.colorName = colorName
        this.colorHex = colorHex
    }

    fun getMyColorHex() : Int {
        return this.colorHex
    }

    fun getMyColorName() : String {
        return this.colorName
    }

}
