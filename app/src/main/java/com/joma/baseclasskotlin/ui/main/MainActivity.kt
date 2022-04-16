package com.joma.baseclasskotlin.ui.main

import android.content.Intent
import com.joma.baseclasskotlin.R
import com.joma.baseclasskotlin.ui.second.SecondActivity
import com.joma.baseclasskotlin.base.BaseActivity
import com.joma.baseclasskotlin.databinding.ActivityMainBinding
import com.joma.baseclasskotlin.ext.showToast

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate),
    MainAdapter.SelectListener {
    private lateinit var adapter: MainAdapter
    private var list: ArrayList<String> = arrayListOf()
    private var selectedList: ArrayList<String> = arrayListOf()

    override fun initListener() {
        binding.btnForward.setOnClickListener {
            if (selectedList.isNullOrEmpty()) {
                showToast(getString(R.string.emptyList))

            } else {
                resetSelected()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putStringArrayListExtra(getString(R.string.selectKey), selectedList)
                startActivity(intent)
                selectedList.clear()
            }
        }
    }

    private fun resetSelected() {
        for (i in 0..list.lastIndex) {
            adapter.notifyItemChanged(i)
        }
    }

    override fun initView() {
        adapter = MainAdapter(this)
        binding.rvImage.adapter = adapter
        adapter.setImgList(list)
        initList()
    }

    private fun initList() {
        list.add("https://i.imgur.com/DvpvklR.png")
        list.add("https://cdn.urlencoder.org/assets/images/url-fb.png")
        list.add("https://rickandmortyapi.com/api/character/avatar/361.jpeg")
        list.add("https://rickandmortyapi.com/api/character/avatar/1.jpeg")
        list.add("https://rickandmortyapi.com/api/character/avatar/10.jpeg")
        list.add("https://cdn.pixabay.com/user/2019/12/22/16-48-03-254_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2022/03/01/12-32-48-46_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2020/01/20/08-28-52-707_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2022/01/25/03-16-01-988_250x250.jpg")
        list.add("https://cdn.pixabay.com/user/2016/04/25/20-19-38-614_250x250.jpg")
    }

    override fun select(element: String) {
        selectedList.add(element)
    }
}