package com.reev.telokkaapps.data.source.local.dummy.dummyplace

class PlanningPlace {
    data class PlanningPlace (
        val place: Place,
        val title: String,
        val desc: String,
        val date: String
    )
}