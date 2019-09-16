package com.liu.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.base.captain.dp2px
import com.base.captain.round
import com.base.captain.utils.LToast
import com.base.captain.utils.delayLife
import com.base.captain.widget.LLoadingDialog
import kotlinx.android.synthetic.main.activity_ma.*
import org.jetbrains.anko.startActivity


class MaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ma)
        btnList.setOnClickListener {
            startActivity<MainActivity>()
        }
        btnMvvm.setOnClickListener {
            startActivity<MvvmActivity>()
        }
        ivImg.round(this.dp2px(10))
        val dialog=LLoadingDialog(this)
        dialog.window?.decorView?.systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        dialog.window?.decorView?.setOnSystemUiVisibilityChangeListener {
            var uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    //布局位于状态栏下方
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    //全屏
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    //隐藏导航栏
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            uiOptions = uiOptions or 0x00001000
            dialog.window?.decorView?.systemUiVisibility = uiOptions
        }
        ivImg.setOnClickListener {
            dialog.show()
            delayLife(2000){
                dialog.dismiss()
                LToast.show("")
            }
        }
    }
}
