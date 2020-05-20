package com.atos.roomdbmigration

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.atos.mobilehealthcareagent.database.AppDatabase
import com.atos.mobilehealthcareagent.database.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db: AppDatabase = AppDatabase.getAppDatabase(this) as AppDatabase

        CoroutineScope(Dispatchers.IO).launch {

            val user = User()
            user.firstName="Raj"
            user.lastName="Sar"
            user.age=20

           var valu:LongArray?=db.userDao()?.insertAll(user)
            Log.i("returned index", valu.toString())

            db.userDao()?.all

        }

    }
}
