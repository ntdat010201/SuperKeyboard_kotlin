package com.example.superkeyboardkotlin.fragment.setting

import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.databinding.DialogShowKeyboardBinding
import com.example.superkeyboardkotlin.databinding.FragmentSettingBinding
import com.example.superkeyboardkotlin.fragment.setting.adapter.GroupFeaturesAdapter
import com.example.superkeyboardkotlin.fragment.setting.model.Feature
import com.example.superkeyboardkotlin.fragment.setting.model.GroupFeatures
import com.example.superkeyboardkotlin.fragment.setting.viewmodel.GroupFeaturesViewModel

class SettingFragment : Fragment() {

    private lateinit var binding: FragmentSettingBinding
    private val viewModel: GroupFeaturesViewModel by lazy {
        ViewModelProvider(this)[GroupFeaturesViewModel::class.java]
    }
    private var dialog: Dialog? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        binding.groupFeaturesViewModel = GroupFeaturesViewModel()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.initData()
        dialog = showKeyBoardLayout()
        setObserve()
        initListener()
    }


    private fun setObserve() {

        viewModel.listGroupFeatures.observe(this@SettingFragment) { list ->
            if (list.isEmpty()) {
                viewModel.listGroupFeatures.value = getData()
            }
            setListGroupFeatures(list)
        }

        viewModel.isShowKeyboard.observe(this@SettingFragment) { isShow ->
            if (isShow) {
                dialog?.show()
            } else {
                dialog?.dismiss()
            }
        }
    }

    private fun getData(): ArrayList<GroupFeatures> {
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

    private fun setListGroupFeatures(listGroupFeatures: ArrayList<GroupFeatures>) {
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

    private fun initListener() {
        binding.showKeyboard.setOnClickListener {
            viewModel.showKeyBoardLayout()
        }
    }

    private fun showKeyBoardLayout(): Dialog {
        val showKeyboardBinding = DialogShowKeyboardBinding.inflate(LayoutInflater.from(requireContext()))

        val dialog = Dialog(requireContext()).apply {
            setContentView(showKeyboardBinding.root)
        }

        dialog.window?.apply {
            setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            setDimAmount(0.5f)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        showKeyboardBinding.apply {
            icClose.setOnClickListener { view ->
                dialog.dismiss()
            }

            TelexType.setOnClickListener { view ->
                switchBtn.visibility = VISIBLE
                inputFastTitle.visibility = VISIBLE

                val tw  = view as TextView
                tw.setBackgroundResource(R.drawable.background_btn_key_type_selected)
                tw.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                VniType.setBackgroundResource(R.drawable.background_btn_key_type_not_selected)
                VniType.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            }

            VniType.setOnClickListener { view ->
                switchBtn.visibility = INVISIBLE
                inputFastTitle.visibility = INVISIBLE

                val tw  = view as TextView
                tw.setBackgroundResource(R.drawable.background_btn_key_type_selected)
                tw.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

                TelexType.setBackgroundResource(R.drawable.background_btn_key_type_not_selected)
                TelexType.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue))
            }

            inputText.requestFocus()
            dialog.window?.let { WindowCompat.getInsetsController(it, inputText).show(WindowInsetsCompat.Type.ime()) }
        }

        return dialog
    }

//    private fun setListenerForDialog(binding: ViewBinding) {
//        when (binding) {
//            is DialogShowKeyboardBinding -> {
//
//               // binding.TelexType.setOnClickListener { view ->
////                    val tw = view as TextView
////                    tw.setBackgroundResource(R.drawable.background_btn_key_type_selected)
////                    tw.setTextColor(resources.getColor(R.color.white))
//                  //  Toast.makeText(requireContext(), "Telex is clicked!", Toast.LENGTH_SHORT).show()
//                //}
//            }
//        }
    //}
}