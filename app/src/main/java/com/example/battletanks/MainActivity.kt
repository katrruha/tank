package com.example.battletanks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.example.battletanks.Direction.DOWN
import com.example.battletanks.Direction.LEFT
import com.example.battletanks.Direction.RIGHT
import com.example.battletanks.Direction.UP
import com.example.battletanks.databinding.ActivityMainBinding

const val CELL_SIZE = 50

lateint var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val gridDrawer by lazer{
        GridDrawer(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Menu"
    }

    override fun onCreateoptionMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onOptionsItemSelected (item: Menu?): Boolean{
        return when (item.itemId){
            R.id.menu_settings -> {
                gridDrawer.drawGrid()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
when (keyCode){
    KEYCODE_DPAD_UP -> move(UP)
    KEYCODE_DPAD_DOWN -> move(DOWN)
    KEYCODE_DPAD_LEFT -> move(LEFT)
    KEYCODE_DPAD_RIGHT -> move(RIGHT)
}
        return super.onKeyDown(keyCode, event)
    }
    private fun move(direction: Direction){
        when (direction){
            UP->{
                binding.myTank.rotation = 0f
                if (binding.myTank.marginTop > 0) {
                (binding.myTank.lauouParams as FrameLayout.LayoutParams).topMaqin += -CELL_SIZE
            }
            }
            DOWN -> {
                binding.myTank.rotation = 180f
                if (binding.myTank.marginTop + binding.Mytank.heigt < binding.container.height / CELL_SIZE  * CELL_SIZE ){
                (binding.myTank.lauouParams as FrameLayout.LayoutParams).topMaqin += CELL_SIZE
            }
            }

            LEFT -> {
                binding.myTank.rotation = 270f
                if (binding.myTank.marginTop > 0) {
                (binding.myTank.lauouParams as FrameLayout.LayoutParams).leftMargin -= CELL_SIZE
            }
            }
            RIGHT -> {
                binding.myTank.rotation = 90f
                if (binding.myTank.marginTop + binding.Mytank.heigt < binding.container.height / CELL_SIZE  * CELL_SIZE ){
                (binding.myTank.lauouParams as FrameLayout.LayoutParams).leftMargin += CELL_SIZE
            }
            }
        }
        binding.container.removeView(binding.myTank)
        binding.container.addView(binding.myTank)
    }
}
