package com.umc.second_week.ui.main.external.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.umc.second_week.databinding.FragmentCourseBinding
import com.umc.second_week.ui.main.external.course.adapt.CourseAdapter
import com.umc.second_week.data.local.CourseDao
import com.umc.second_week.data.local.CourseDatabase

class CourseFragment : Fragment(), CourseAdapter.ItemClickListener {

    private var _binding: FragmentCourseBinding? = null
    private val binding: FragmentCourseBinding get() = _binding!!

    // ViewModel
    private lateinit var courseGraduateBoardViewModel: CourseGraduateBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        // Dao
        val dao : CourseDao = CourseDatabase.getInstance(requireContext())!!.courseDao
        val repository = CourseRepository(dao)
        val factory = CourseGraduateBoardViewModelFactory(repository)
        courseGraduateBoardViewModel = ViewModelProvider(this.requireActivity(), factory).get(
            CourseGraduateBoardViewModel::class.java)

        binding.lifecycleOwner = this
        binding.graduateboard = courseGraduateBoardViewModel

        binding.recyclerview.adapter = CourseAdapter(this)
//        binding.recyclerview.setHasFixedSize(true)

//        courseGraduateBoardViewModel.courses.observe(viewLifecycleOwner, Observer {
//            Log.d("wwwww","fff"+courseGraduateBoardViewModel.courses.value.toString())
////            binding.recyclerview.adapter = CourseAdapter(this)
//        })

        return binding.root
    }

    private fun displayCourseList(){
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(view: View, position: Int) {
    }

    override fun onItemLongClick(view: View, position: Int) {
    }
}