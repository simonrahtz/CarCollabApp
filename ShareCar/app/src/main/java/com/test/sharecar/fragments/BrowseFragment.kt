package com.test.sharecar.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.sharecar.DataCache
import com.test.sharecar.R
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

        //imageViews display pre loaded images from resource folder
        binding.car1Image.setImageResource(R.drawable.mazda_626)
        binding.car2Image.setImageResource(R.drawable.jeep)
        //set 3rd car to default image when user hasn't uploaded car image
        binding.car3Image.setImageResource(R.drawable.ic_car)
        binding.car3text.text = DataCache.currentCar[0]?.make

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}