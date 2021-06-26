package com.tbadhit.crudmakananmvp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbadhit.crudmakananmvp.databinding.ActivityMainBinding
import com.tbadhit.crudmakananmvp.databinding.ContentMainBinding
import com.tbadhit.crudmakananmvp.model.getMakanan.DataItem
import com.tbadhit.crudmakananmvp.ui.main.MainContract
import com.tbadhit.crudmakananmvp.ui.main.MainPresenter
import com.tbadhit.crudmakananmvp.ui.main.MakananAdapter
import com.tbadhit.crudmakananmvp.ui.insert.InsertActivity

class MainActivity : AppCompatActivity(), MainContract.View {

//    private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding

    // 1
    private lateinit var bindingContentMain: ContentMainBinding

    // 2
    private lateinit var mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1.
        val bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)

        // 2.
        bindingContentMain = bindingActivityMain.contentMain
        setContentView(bindingActivityMain.root)
        setSupportActionBar(bindingActivityMain.toolbar)

        // Di ALT + ENTER 'this'nya lalu pilih 'Let MainActivity implement Interface'
        mainPresenter = MainPresenter(this)

//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        bindingActivityMain.fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, InsertActivity::class.java))
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        mainPresenter.getDataMakanan()
        //-------------
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    // 2. (hasil ALT + ENTER 'this')
    override fun showDataMakanan(dataMakanan: List<DataItem?>?) {
        // 3.

        val makananAdapter = MakananAdapter()
        makananAdapter.setDataMakanan(dataMakanan)

        bindingContentMain.rvMakanan.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter = makananAdapter
        }
    }

    // 2. (hasil ALT + ENTER 'this')
    override fun showError(localizedMessage: String?) {
        // 3.
        Toast.makeText(this, localizedMessage, Toast.LENGTH_SHORT).show()
    }

    // 2. (hasil ALT + ENTER 'this')
    override fun showMessage(pesan: String?) {
        // 3.
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.getDataMakanan()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}