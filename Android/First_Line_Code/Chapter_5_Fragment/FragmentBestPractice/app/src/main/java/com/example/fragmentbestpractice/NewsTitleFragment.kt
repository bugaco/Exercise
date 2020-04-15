package com.example.fragmentbestpractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_news_content.*
import kotlinx.android.synthetic.main.news_title_frag.*
import java.lang.StringBuilder

class NewsTitleFragment : Fragment() {

    private var isTwoPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.news_title_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        val layoutManager = LinearLayoutManager(activity)
        newsTitleRecyclerView.layoutManager = layoutManager
        val newsList = getNews()
        val adapter = NewsAdapter(newsList)
        newsTitleRecyclerView.adapter = adapter
    }

    private fun getNews(): List<News> {
        val newsList = ArrayList<News>()
        for (i in 1..50) {
            val news = News(
                "This is news title - $i",
                getRandomLengthContentString("This is news content $i\n")
            )
            newsList.add(news)
        }
        return newsList
    }


    private fun getRandomLengthContentString(str: String): String {
        val n = (2..20).random()
        val builder = StringBuilder().apply {
            repeat(n) {
                append(str)
            }
        }
        return builder.toString()
    }

    inner class NewsAdapter(val newsList: List<News>) :
        RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)

            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                if (isTwoPane) {
                    val fragment = newsContentFrag as NewsContentFragment
                    fragment.refresh(news.title, news.content)
                } else {
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }

            return holder
        }

        override fun getItemCount(): Int = newsList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.newsTitle.text = newsList[position].title
        }

    }
}