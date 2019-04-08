package com.gioppl.testmt.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.gioppl.testmt.R
import com.gioppl.testmt.view.activity.WaterActivity
import ezy.ui.view.BannerView
import java.util.*


class One : BaseFragment() {
    private var im_table:ImageView?=null
    //轮播图
    var banner1: BannerView<Any>? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
                return inflater.inflate(R.layout.fragment_one, container, false);
//        return null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
        initRollImage()
    }
    var titles = arrayOf("公告1", "公告2", "公告3", "公告4", "公告5", "公告6")
    val list = ArrayList<BannerItem>()
    val urls = arrayOf(//750x500
            "https://s2.mogucdn.com/mlcdn/c45406/170422_678did070ec6le09de3g15c1l7l36_750x500.jpg",
            "https://s2.mogucdn.com/mlcdn/c45406/170420_1hcbb7h5b58ihilkdec43bd6c2ll6_750x500.jpg",
            "http://s18.mogucdn.com/p2/170122/upload_66g1g3h491bj9kfb6ggd3i1j4c7be_750x500.jpg",
            "http://s18.mogucdn.com/p2/170204/upload_657jk682b5071bi611d9ka6c3j232_750x500.jpg")
    init {
        for (i in urls.indices) {
            val item = BannerItem()
            item.image = urls[i]
            item.title = titles[i]

            list.add(item)
        }
    }
    private fun initRollImage() {

        banner1 = activity!!.findViewById(R.id.banner1) as BannerView<Any>
        banner1!!.setViewFactory(BannerViewFactory())
        banner1!!.setDataList(list as List<Any>)
        banner1!!.start()
    }
    class BannerViewFactory : BannerView.ViewFactory<BannerItem> {
        override fun create(item: BannerItem, position: Int, container: ViewGroup): View {
            val iv = ImageView(container.context)
            val options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA)
            Glide.with(container.context.applicationContext).load(item.image).apply(options).into(iv)
            return iv
        }
    }
    class BannerItem {
        var image: String? = null
        var title: String? = null

        override fun toString(): String {
            return title!!
        }
    }
    override fun initView() {
        im_table=activity!!.findViewById(R.id.im_table)
        im_table!!.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                startActivity(Intent(activity, WaterActivity::class.java))
            }
        })
    }

    override fun initData() {

    }
}
