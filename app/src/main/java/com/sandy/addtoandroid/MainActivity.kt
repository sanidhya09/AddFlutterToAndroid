package com.sandy.addtoandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


class MainActivity : AppCompatActivity() {
    var flutterEngine: FlutterEngine? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Move this initialization to Application Class
        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)
        // Configure an initial route.
        flutterEngine!!.navigationChannel.setInitialRoute("your/route/here");

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine!!.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)
    }

    fun openFlutterModule(view: View) {
        startActivity(
            FlutterActivity
                .withCachedEngine("my_engine_id")
                .build(this)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        flutterEngine!!.destroy()
    }
}