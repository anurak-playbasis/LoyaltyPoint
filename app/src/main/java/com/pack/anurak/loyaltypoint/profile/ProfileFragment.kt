package com.pack.anurak.loyaltypoint.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pack.anurak.loyaltypoint.MainActivity
import com.pack.anurak.loyaltypoint.R

class ProfileFragment :Fragment() {
    private lateinit var profileModel: ProfileModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).setActionBarTitle(getString(R.string.title_profile))
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileModel = ViewModelProviders.of(this).get(ProfileModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile,container,false)
        val text: TextView = root.findViewById(R.id.text_profile)
        profileModel.text.observe(this,Observer{
            text.text = it
        })
        return root
    }
}