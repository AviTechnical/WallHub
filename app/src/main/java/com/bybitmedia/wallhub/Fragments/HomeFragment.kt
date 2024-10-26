package com.bybitmedia.wallhub.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bybitmedia.wallhub.databinding.FragmentHomeBinding
import com.bybitmedia.wallhub.adapter.BomAdapter
import com.bybitmedia.wallhub.Model.bomModel
import com.bybitmedia.wallhub.Model.catModel
import com.bybitmedia.wallhub.Model.colortoneModel
import com.bybitmedia.wallhub.adapter.CatAdapter
import com.bybitmedia.wallhub.adapter.colortoneAdapter
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)


        db = FirebaseFirestore.getInstance()

        db.collection("bestofmonth").addSnapshotListener { value, error ->

            val listBestofThemonth=ArrayList<bomModel>()

            val data=value?.toObjects(bomModel::class.java)
            listBestofThemonth.addAll(data!!)

            binding.rcvBom.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvBom.adapter= BomAdapter(requireContext(),listBestofThemonth)
        }

        db.collection("thecolortone").addSnapshotListener { value, error ->


            val listThecolortone=ArrayList<colortoneModel>()
            val data=value?.toObjects(colortoneModel::class.java)
            listThecolortone.addAll(data!!)

            binding.rcvTct.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.rcvTct.adapter= colortoneAdapter(requireContext(),listThecolortone)

        }


        db.collection("Categories").addSnapshotListener { value, error ->


            val listOfcategories=ArrayList<catModel>()
            val data=value?.toObjects(catModel::class.java)
            listOfcategories.addAll(data!!)

            binding.rcvCat.layoutManager= GridLayoutManager(requireContext(),2)
            binding.rcvCat.adapter= CatAdapter(requireContext(),listOfcategories)

        }





        return binding.root
    }


}