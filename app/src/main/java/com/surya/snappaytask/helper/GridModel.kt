package com.surya.snappaytask.helper

class GridModel(var days_left: String, var imgid: Int) {
    fun getDays(): String {
        return days_left
    }

    fun setDays(days: String) {
        this.days_left = days
    }

    fun getImgId(): Int {
        return imgid
    }

    fun setImgId(img: Int) {
        this.imgid = img
    }
}
