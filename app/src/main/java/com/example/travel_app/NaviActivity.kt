package com.example.travel_app

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.travel_app.databinding.ActivityNaviBinding

private const val TAG_PLANNER = "planner_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_MORE = "more_fragment"

class TestData(
    private var data1: String? = null,
    private var data2: String? = null,
    private var data3: String? = null
){
    fun getData1(): String? {
        return data1
    }
    fun setData1(name: String){
        this.data1 = data1
    }
    fun getData2(): String? {
        return data2
    }
    fun setData2(address: String){
        this.data2 = data2
    }
    fun getData3(): String? {
        return data3
    }
    fun setData3(type: String){
        this.data3 = data3
    }
}
class NaviActivity : AppCompatActivity() {
    var dataList: ArrayList<TestData> = arrayListOf(
        TestData("첫 번째 데이터1", "두 번째 데이터1", "세 번째 데이터1"),
        TestData("첫 번째 데이터2", "두 번째 데이터2", "세 번째 데이터2"),
        TestData("첫 번째 데이터3", "두 번째 데이터3", "세 번째 데이터3"),
        TestData("첫 번째 데이터4", "두 번째 데이터4", "세 번째 데이터4"),
        TestData("첫 번째 데이터5", "두 번째 데이터5", "세 번째 데이터5"),
        TestData("첫 번째 데이터6", "두 번째 데이터6", "세 번째 데이터6"),
        TestData("첫 번째 데이터7", "두 번째 데이터7", "세 번째 데이터7"),
        TestData("첫 번째 데이터8", "두 번째 데이터8", "세 번째 데이터8"),
        TestData("첫 번째 데이터9", "두 번째 데이터9", "세 번째 데이터9"),
        TestData("첫 번째 데이터10", "두 번째 데이터10", "세 번째 데이터10"),
        TestData("첫 번째 데이터11", "두 번째 데이터11", "세 번째 데이터11"),
        TestData("첫 번째 데이터12", "두 번째 데이터12", "세 번째 데이터12"),
        TestData("첫 번째 데이터13", "두 번째 데이터13", "세 번째 데이터13"),
        TestData("첫 번째 데이터14", "두 번째 데이터14", "세 번째 데이터14"),
        TestData("첫 번째 데이터15", "두 번째 데이터15", "세 번째 데이터15")
    )

    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //하단탭에서 홈 탭이 눌린 것으로 초기화
        binding.navigationView.menu.findItem(R.id.homeFragment)?.isChecked = true

        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.moreFragment -> setFragment(TAG_MORE, MoreFragment())
                R.id.plannerFragment -> setFragment(TAG_PLANNER, PlannerFragment())
            }
            true
        }

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.mainFrameLayout,
            HomeFragment()
        )
        transaction.commit()
        intent.putExtra("DataList", dataList)

    }

    private fun setFragment(tag: String, fragment: Fragment){
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if(manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val planner = manager.findFragmentByTag(TAG_PLANNER)
        val home = manager.findFragmentByTag(TAG_HOME)
        val more = manager.findFragmentByTag(TAG_MORE)

        if(planner != null){
            fragTransaction.hide(planner)
        }
        if(home != null){
            fragTransaction.hide(home)
        }
        if(more != null){
            fragTransaction.hide(more)
        }
        if(tag == TAG_PLANNER){
            if(planner!=null){
                fragTransaction.show(planner)
            }
        }else if(tag == TAG_HOME){
            if(home!=null){
                fragTransaction.show(home)

            }
        }else if(tag == TAG_MORE){
            if(more!=null){
                fragTransaction.show(more)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}

