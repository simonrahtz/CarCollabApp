package com.test.sharecar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.sharecar.databinding.FragmentBrowseBinding


class BrowseFragment : Fragment() {

    private var _binding: FragmentBrowseBinding? = null

    // this property only exist between viewCreated and viewDestroyed
    private val binding: FragmentBrowseBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrowseBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}