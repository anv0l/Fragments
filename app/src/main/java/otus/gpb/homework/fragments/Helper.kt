package otus.gpb.homework.fragments

import android.content.Context
import android.content.res.Configuration

fun Context.isLandscape() =
    resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
