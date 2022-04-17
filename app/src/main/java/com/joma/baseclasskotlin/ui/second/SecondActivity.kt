package com.joma.baseclasskotlin.ui.second

import com.joma.baseclasskotlin.R
import com.joma.baseclasskotlin.base.BaseActivity
import com.joma.baseclasskotlin.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    private var selectedList: ArrayList<Int> = arrayListOf()
    private lateinit var adapter: SecondAdapter

    override fun initView() {
        adapter = SecondAdapter()
        binding.rvSelectedImg.adapter = adapter
        getImage()
    }

    private fun getImage() {
        selectedList =
            (intent.getIntegerArrayListExtra(getString(R.string.selectKey)) as ArrayList<Int>)
        adapter.setSelectList(selectedList)
    }
}