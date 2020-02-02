package ru.barsukov.currencyexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = MainPresenter()
        presenter.onViewCreated(this)

        btn_load.setOnClickListener { presenter.onLoadClick() }
    }

    override fun loading(state: Boolean) {
        textView.text = if (state) {
            getString(R.string.load)
        } else {
            getString(R.string.app_name)
        }
    }
}
