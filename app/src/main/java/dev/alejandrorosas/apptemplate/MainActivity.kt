package dev.alejandrorosas.apptemplate

import androidx.annotation.IntDef
import dev.alejandrorosas.core.BaseActivity

const val TAB_ONE = 0
const val TAB_TWO = 1

@IntDef(TAB_ONE, TAB_TWO)
@Retention(AnnotationRetention.SOURCE)
annotation class TAB

class MainActivity : BaseActivity(R.layout.activity_main) {
    @TAB
    fun getTab(): Int = TAB_TWO
}
