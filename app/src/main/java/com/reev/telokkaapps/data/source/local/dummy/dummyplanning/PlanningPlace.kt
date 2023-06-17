package com.reev.telokkaapps.data.source.local.dummy.dummyplanning

import android.os.Parcelable
import com.reev.telokkaapps.data.source.local.dummy.dummyplace.Place
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanningPlace (
    val place: Place,
    val title: String,
    val desc: String,
    val date: String
) : Parcelable