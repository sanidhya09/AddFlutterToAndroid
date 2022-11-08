package com.sandy.addtoandroid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openFlutterModule(view: View) {
        val books = mutableListOf<Api.Book>()
        val book = Api.Book()
        book.title = "Sandy"
        book.subtitle = "Kumar"
        val thumbnail = Api.Thumbnail()
        thumbnail.url = "http"
        book.thumbnail = thumbnail
        books.add(book)

        startActivityForResult(
            FlutterBookActivity
                .withBook(this, books[0]), 0
        )
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

        }
    }


}