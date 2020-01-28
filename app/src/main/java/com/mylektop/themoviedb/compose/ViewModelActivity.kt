package com.mylektop.themoviedb.compose

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by MyLektop on 28/01/2020
 */
@SuppressLint("Registered")
open class ViewModelActivity : AppCompatActivity() {
    protected inline fun <reified T : ViewDataBinding> binding(resId: Int): Lazy<T> =
        lazy { DataBindingUtil.setContentView<T>(this, resId) }
}