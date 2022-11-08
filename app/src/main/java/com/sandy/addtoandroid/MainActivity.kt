package com.sandy.addtoandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openFlutterModule(view: View) {
        val books = mutableListOf<Api.Book>()
        val book = Api.Book()
        val findViewById = findViewById<EditText>(R.id.etName)
        book.title = findViewById.text.toString()
        book.subtitle = "Kumar"
        val thumbnail = Api.Thumbnail()
        thumbnail.url = "http"
        book.thumbnail = thumbnail
        books.add(book)
        findViewById.setText("")
        startActivityForResult(FlutterBookActivity.withBook(this, books[0]), 0)
    }

    // Callback when the Flutter activity started with 'startActivityForResult' above returns.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // The Flutter activity may cancel the edit. If so, don't update anything.
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                throw RuntimeException("The FlutterBookActivity returning RESULT_OK should always have a return data intent")
            }
            val returnedBook = FlutterBookActivity.getBookFromResultIntent(data)
            //Toast.makeText(this, returnedBook.title, Toast.LENGTH_LONG).show()
            findViewById<TextView>(R.id.txtName).text = returnedBook.title
        }
    }


}