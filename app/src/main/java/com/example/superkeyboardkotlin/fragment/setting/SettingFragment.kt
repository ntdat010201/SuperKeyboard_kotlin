package com.example.superkeyboardkotlin.fragment.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Group
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.databinding.FragmentSettingBinding
import com.example.superkeyboardkotlin.fragment.setting.adapter.GroupFeaturesAdapter
import com.example.superkeyboardkotlin.fragment.setting.model.Feature
import com.example.superkeyboardkotlin.fragment.setting.model.GroupFeatures
import com.example.superkeyboardkotlin.fragment.setting.viewmodel.GroupFeaturesViewModel

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding
    private lateinit var viewModel: GroupFeaturesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        val groupFeaturesViewModel = GroupFeaturesViewModel()
        binding.groupFeaturesViewModel = groupFeaturesViewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel = ViewModelProvider(this).get(GroupFeaturesViewModel::class.java)
        viewModel.listGroupFeaturesLiveData.value = initData()

        viewModel.listGroupFeaturesLiveData.observe(this) { listGroupFeatures ->
            initUi(listGroupFeatures)
        }
    }

    private fun initUi(listGroupFeatures: ArrayList<GroupFeatures>) {

        binding.listGroupFeatures.apply {
            layoutManager = LinearLayoutManager(requireContext()).apply {
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
            }
            setHasFixedSize(true)
            adapter = GroupFeaturesAdapter(
                requireContext(),
                listGroupFeatures
            )
        }


    }
    private fun initData(): ArrayList<GroupFeatures> {
        return ArrayList<GroupFeatures>().apply {
            add(
                GroupFeatures(
                    requireContext().getString(R.string.account_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.account_feature_name),
                            requireContext().getString(R.string.account_feature_description),
                            R.drawable.account_feature_img,
                        )
                    )
                )
            )
            add(
                GroupFeatures(
                    requireContext().getString(R.string.keyboard_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.keyboard_layout_feature_name),
                            requireContext().getString(R.string.keyboard_layout_feature_description),
                            R.drawable.keyboard_layout_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.key_feature_name),
                            requireContext().getString(R.string.key_feature_description),
                            R.drawable.key_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.sound_and_animation_feature_name),
                            requireContext().getString(R.string.sound_and_animation_feature_description),
                            R.drawable.sound_and_animation_feature_img,
                        )
                    )
                )
            )
            add(
                GroupFeatures(
                    requireContext().getString(R.string.key_type_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.key_type_feature_name),
                            requireContext().getString(R.string.key_type_feature_description),
                            R.drawable.key_type_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.language_feature_name),
                            requireContext().getString(R.string.language_feature_description),
                            R.drawable.language_feature_img,
                        )
                    )
                )
            )
            add(
                GroupFeatures(
                    requireContext().getString(R.string.clever_keyboard_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.suggest_key_feature_name),
                            requireContext().getString(R.string.suggest_key_feature_description),
                            R.drawable.suggest_key_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.auto_correct_feature_name),
                            requireContext().getString(R.string.auto_correct_feature_description),
                            R.drawable.auto_correct_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.swipe_key_feature_name),
                            requireContext().getString(R.string.swipe_key_feature_description),
                            R.drawable.swipe_key_feature_img,
                        )
                    )
                )
            )
            add(
                GroupFeatures(
                    requireContext().getString(R.string.note_and_type_fast_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.type_fast_feature_name),
                            requireContext().getString(R.string.type_fast_feature_description),
                            R.drawable.type_fast_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.note_feature_name),
                            requireContext().getString(R.string.note_feature_description),
                            R.drawable.note_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.clipboard_feature_name),
                            requireContext().getString(R.string.clipboard_feature_description),
                            R.drawable.clipboard_feature_img,
                        )
                    )
                )
            )
            add(
                GroupFeatures(
                    requireContext().getString(R.string.application_group_features_name),
                    arrayListOf(
                        Feature(
                            requireContext().getString(R.string.info_and_feed_back_feature_name),
                            requireContext().getString(R.string.info_and_feed_back_feature_description),
                            R.drawable.info_and_feed_back_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.upgrade_feature_name),
                            requireContext().getString(R.string.upgrade_feature_description),
                            R.drawable.upgrade_feature_img,
                        ),
                        Feature(
                            requireContext().getString(R.string.reset_settings_feature_name),
                            requireContext().getString(R.string.reset_settings_feature_description),
                            R.drawable.reset_settings_feature_img,
                        )
                    )
                )
            )
        }
    }
}