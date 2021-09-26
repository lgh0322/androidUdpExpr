package com.viatom.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tencent.bugly.proguard.p

import com.viatom.myapplication.databinding.FragmentServerBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Response
import java.io.ByteArrayInputStream
import java.io.IOException
import java.net.*

class ServerFragment : Fragment() {
    lateinit var binding: FragmentServerBinding
    val dataScope = CoroutineScope(Dispatchers.IO)


    var inBuff = ByteArray(560)

    // 以指定的字节数组创建准备接收数据的DatagramPacket对象
    private val inPacket = DatagramPacket(inBuff, inBuff.size)

    private fun intToIp(paramInt: Int): String? {
        return ((paramInt.and(255)).toString() + "." + (paramInt.shr(8)
            .and(255)) + "." + (paramInt.shr(16).and(255)) + "."
                + (paramInt.shr(24).and(255)))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentServerBinding.inflate(inflater, container, false)



        dataScope.launch {
            while (true){
                DatagramSocket().use {
                    val outPacket = DatagramPacket(
                        ByteArray(4){
                            it.toByte()
                        }, 4, InetAddress.getByName("192.168.5.103"),1497)
                    it.send(outPacket)

                }
                delay(1000)
            }

        }


        return binding.root
    }




}