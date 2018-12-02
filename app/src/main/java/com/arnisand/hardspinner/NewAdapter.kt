package com.arnisand.hardspinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class NewAdapter(private val context: Context) : BaseExpandableListAdapter() {

    var mChildList: List<List<String>> = listOf()
    var mGroupList: List<String> = listOf()

    override fun getGroup(index: Int): String = mGroupList[index]

    override fun isChildSelectable(p0: Int, p1: Int): Boolean = false

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var tempView = convertView
        if (tempView == null) {
            tempView = LayoutInflater.from(context).inflate(R.layout.layout_child_view, parent, false)
        }

        val textView = tempView?.findViewById<TextView>(R.id.tv_text)
        textView?.text = mGroupList[groupPosition]
        return tempView
    }

    override fun getChildrenCount(groupPosition: Int): Int = mChildList[groupPosition].count()

    override fun getChild(groupPosition: Int, childPosition: Int): Any? = null // todo get Child

    override fun getGroupId(p0: Int): Long {
        return 0
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        val tempChild = mChildList[groupPosition][childPosition]
        var tempView = convertView
        if (tempView == null) {
            tempView = LayoutInflater.from(context).inflate(R.layout.layout_child_view, parent, false)
        }

        val tv = tempView?.findViewById<TextView>(R.id.tv_text)
        tv?.text = tempChild

        return tempView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return 0
    }

    override fun getGroupCount(): Int = mGroupList.count()


}