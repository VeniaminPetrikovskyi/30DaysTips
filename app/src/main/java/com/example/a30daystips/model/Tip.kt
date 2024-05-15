package com.example.a30daystips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.a30daystips.R

data class Tip(
    val day: Int,
    @StringRes val summary: Int,
    @DrawableRes val image: Int,
    @StringRes val desc: Int
)

val tipsList: List<Tip> = listOf(
    Tip(1, R.string.summary1, R.drawable.gym1, R.string.desc1),
    Tip(2, R.string.summary2, R.drawable.gym2, R.string.desc2),
    Tip(3, R.string.summary3, R.drawable.gym3, R.string.desc3),
    Tip(4, R.string.summary4, R.drawable.gym4, R.string.desc4),
    Tip(5, R.string.summary5, R.drawable.gym1, R.string.desc5),
    Tip(6, R.string.summary6, R.drawable.gym2, R.string.desc6),
    Tip(7, R.string.summary7, R.drawable.gym3, R.string.desc7),
    Tip(8, R.string.summary8, R.drawable.gym4, R.string.desc8),
    Tip(9, R.string.summary9, R.drawable.gym1, R.string.desc9),
    Tip(10, R.string.summary10, R.drawable.gym2, R.string.desc10),
    Tip(11, R.string.summary11, R.drawable.gym3, R.string.desc11),
    Tip(12, R.string.summary12, R.drawable.gym4, R.string.desc12),
    Tip(13, R.string.summary13, R.drawable.gym1, R.string.desc13),
    Tip(14, R.string.summary14, R.drawable.gym2, R.string.desc14),
    Tip(15, R.string.summary15, R.drawable.gym3, R.string.desc15),
    Tip(16, R.string.summary16, R.drawable.gym4, R.string.desc16),
    Tip(17, R.string.summary17, R.drawable.gym1, R.string.desc17),
    Tip(18, R.string.summary18, R.drawable.gym2, R.string.desc18),
    Tip(19, R.string.summary19, R.drawable.gym3, R.string.desc19),
    Tip(20, R.string.summary20, R.drawable.gym4, R.string.desc20),
    Tip(21, R.string.summary21, R.drawable.gym1, R.string.desc21),
    Tip(22, R.string.summary22, R.drawable.gym2, R.string.desc22),
    Tip(23, R.string.summary23, R.drawable.gym3, R.string.desc23),
    Tip(24, R.string.summary24, R.drawable.gym4, R.string.desc24),
    Tip(25, R.string.summary25, R.drawable.gym1, R.string.desc25),
    Tip(26, R.string.summary26, R.drawable.gym2, R.string.desc26),
    Tip(27, R.string.summary27, R.drawable.gym3, R.string.desc27),
    Tip(28, R.string.summary28, R.drawable.gym4, R.string.desc28),
    Tip(29, R.string.summary29, R.drawable.gym1, R.string.desc29),
    Tip(30, R.string.summary30, R.drawable.gym2, R.string.desc30)
)