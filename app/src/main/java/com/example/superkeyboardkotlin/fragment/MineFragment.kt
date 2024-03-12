package com.example.superkeyboardkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.superkeyboardkotlin.adapter.CategoryShopAdapter
import com.example.superkeyboardkotlin.adapter.RcvMineAdapter
import com.example.superkeyboardkotlin.databinding.FragmentMineBinding
import com.example.superkeyboardkotlin.viewmodel.DataRcvShopViewModel
import com.example.superkeyboardkotlin.viewmodel.RcvMineViewModel


class MineFragment : Fragment() {
    private lateinit var binding: FragmentMineBinding

    private lateinit var rcvMineAdapter : RcvMineAdapter
    private lateinit var rcvMineViewModel : RcvMineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMineBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        initView()
        return binding.root
    }

    private fun initData() {

    }

    private fun initView() {
        binding.rcvMine.apply {
            val gridLayoutManager =
                GridLayoutManager(context, 2)
            layoutManager = gridLayoutManager
            isFocusable = false

            rcvMineViewModel =
                ViewModelProvider(requireActivity())[RcvMineViewModel::class.java]
            rcvMineViewModel.getListMineLiveData().observe(viewLifecycleOwner) { data ->

                val rcvMineAdapter = RcvMineAdapter(data)
                adapter = rcvMineAdapter
            }
        }

    }

}