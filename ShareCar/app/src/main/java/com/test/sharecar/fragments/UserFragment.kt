package com.test.sharecar.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.sharecar.activities.UserCarsActivity
import com.test.sharecar.databinding.FragmentUserBinding


class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null

    // this property only exist between viewCreated and viewDestroyed
    private val binding: FragmentUserBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tableLayout.setOnClickListener {
            val intent = Intent(requireActivity(), UserCarsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}