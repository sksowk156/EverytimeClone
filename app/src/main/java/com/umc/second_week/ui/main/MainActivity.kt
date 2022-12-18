package com.umc.second_week.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.umc.second_week.*
import com.umc.second_week.databinding.ActivityMainBinding
import com.umc.second_week.ui.main.internal.InternalFragment
import com.umc.second_week.ui.main.schedule.SecondFragment
import com.umc.second_week.ui.main.external.TthirdFragment
import com.umc.second_week.ui.main.home.FirstFragment
import com.umc.second_week.ui.main.home.IndivisualActivity
import com.umc.second_week.ui.main.home.SecondActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragmenttag: String // fragment의 Tag를 저장하기 위해

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 앱을 켰을 때 첫 fragment
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentFrame.id, FirstFragment(), "first")
                .commitAllowingStateLoss()
            currentFragmenttag = "first" // 현재 보고 있는 fragmet의 Tag
        }

        binding.imagebutton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.profile.setOnClickListener {
            val intent = Intent(this, IndivisualActivity::class.java)
            startActivity(intent)
        }

        // 네비게이션 버튼 클릭시 프래그먼트 전환
        binding.bottomNavigationView2.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.aaa -> { // 첫 번째 fragment
                    // supportFragmentManager에 "first"라는 Tag로 저장된 fragment 있는지 확인
                    if (supportFragmentManager.findFragmentByTag("first") == null) { // Tag가 없을 때 -> 없을 리가 없다.
                        supportFragmentManager
                            .beginTransaction()
                            .add(binding.fragmentFrame.id, FirstFragment(), "first")
                            .commitAllowingStateLoss()
                    } else { // Tag가 있을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 저장된 "first"라는 Tag를 show 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .show(supportFragmentManager.findFragmentByTag("first")!!)
                            .commitAllowingStateLoss()
                    }
                    // currentFragmenttag에 '현재 fragment Tag' "first"를 저장한다.
                    currentFragmenttag = "first"
                }
                R.id.bbb -> { // 두 번째 fragment
                    // supportFragmentManager에 "second"라는 Tag로 저장된 fragment 있는지 확인
                    if (supportFragmentManager.findFragmentByTag("second") == null) { // Tag가 없을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 "second"라는 Tag로 add 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .add(binding.fragmentFrame.id, SecondFragment(), "second")
                            .commitAllowingStateLoss()
                    } else { // Tag가 있을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 저장된 "second"라는 Tag를 show 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .show(supportFragmentManager.findFragmentByTag("second")!!)
                            .commitAllowingStateLoss()
                    }
                    // currentFragmenttag에 '현재 fragment Tag' "second"를 저장한다.
                    currentFragmenttag = "second"
                }
                R.id.ccc -> { // 세 번째 fragment
                    // supportFragmentManager에 "tthird"라는 Tag로 저장된 fragment 있는지 확인
                    if (supportFragmentManager.findFragmentByTag("tthird") == null) { // Tag가 없을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 "tthird"라는 Tag로 add 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .add(binding.fragmentFrame.id, TthirdFragment(), "tthird")
                            .commitAllowingStateLoss()
                    } else { // Tag가 있을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 저장된 "tthird"라는 Tag를 show 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .show(supportFragmentManager.findFragmentByTag("tthird")!!)
                            .commitAllowingStateLoss()
                    }
                    // currentFragmenttag에 '현재 fragment Tag' "tthird"를 저장한다.
                    currentFragmenttag = "tthird"
                }
                R.id.ddd -> { // 세 번째 fragment
                    // supportFragmentManager에 "tthird"라는 Tag로 저장된 fragment 있는지 확인
                    if (supportFragmentManager.findFragmentByTag("fourth") == null) { // Tag가 없을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 "tthird"라는 Tag로 add 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .add(binding.fragmentFrame.id, InternalFragment(), "fourth")
                            .commitAllowingStateLoss()
                    } else { // Tag가 있을 때
                        // 먼저 currentFragmenttag에 저장된 '이전 fragment Tag'를 활용해 이전 fragment를 hide 시킨다.
                        // supportFragmentManager에 저장된 "tthird"라는 Tag를 show 시킨다.
                        supportFragmentManager
                            .beginTransaction()
                            .hide(supportFragmentManager.findFragmentByTag(currentFragmenttag)!!)
                            .show(supportFragmentManager.findFragmentByTag("fourth")!!)
                            .commitAllowingStateLoss()
                    }
                    // currentFragmenttag에 '현재 fragment Tag' "tthird"를 저장한다.
                    currentFragmenttag = "fourth"
                }
            }
            true
        }
    }
}