package com.example.todoapp

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var recView :RecyclerView
    var task = ArrayList<String>()
    lateinit var addButton :View




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView = findViewById(R.id.recView)
        addButton = findViewById(R.id.floatingActionButton)
        recView.adapter=RecyclerViewAdapter(task)
        recView.layoutManager = LinearLayoutManager(this)


        addButton.setOnClickListener{
            showDialog()
        }
    }

    fun showDialog() {

        val builder = AlertDialog.Builder(this)
        //  set title for alert dialog
        builder.setTitle("New Item")

       val input = EditText(this)
        input.hint = "Enter an Item "
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)


        //performing positive action
        builder.setPositiveButton("Add") { dialogInterface, which ->

            var UserInput = input.text.toString()
            task.add(UserInput)
            recView.adapter=RecyclerViewAdapter(task)
            recView.layoutManager = LinearLayoutManager(this)
            recView.adapter!!.notifyDataSetChanged()


        }
        builder.setNegativeButton("CANCEL"){dialogInterface, which ->}
        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
       // alertDialog.setCancelable(false)
        alertDialog.show()
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemsDeleted = 0
        when(item.itemId) {
            R.id.delete -> {


                Toast.makeText(this, "Hello there!", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}