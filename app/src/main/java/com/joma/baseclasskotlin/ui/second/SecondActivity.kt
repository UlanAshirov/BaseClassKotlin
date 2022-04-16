package com.joma.baseclasskotlin.ui.second

import com.joma.baseclasskotlin.R
import com.joma.baseclasskotlin.base.BaseActivity
import com.joma.baseclasskotlin.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity<ActivitySecondBinding>(ActivitySecondBinding::inflate) {
    private var selectedList: ArrayList<String> = arrayListOf()
    private lateinit var adapter: SecondAdapter

    override fun initView() {
        val imgUrl =
            (intent.getStringArrayListExtra(getString(R.string.selectKey)) as ArrayList<String>)
        selectedList.addAll(imgUrl)
        adapter = SecondAdapter()
        binding.rvSelectedImg.adapter = adapter
        adapter.setSelectList(selectedList)
    }
}