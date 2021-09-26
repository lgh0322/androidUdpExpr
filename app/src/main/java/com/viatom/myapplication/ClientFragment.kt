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

import com.viatom.myapplication.databinding.FragmentClientBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import okhttp3.Response
import java.io.ByteArrayInputStream
import java.io.IOException
import java.net.*

class ClientFragment : Fragment() {
    lateinit var binding: FragmentClientBinding


    val dataScope = CoroutineScope(Dispatchers.IO)


    var inBuff = ByteArray(2000000)

    // 以指定的字节数组创建准备接收数据的DatagramPacket对象
    private val inPacket = DatagramPacket(inBuff, inBuff.size)


    lateinit var diagramSocket: DatagramSocket

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentClientBinding.inflate(inflater, container, false)
var cc=0

        dataScope.launch {
            diagramSocket= DatagramSocket()
            diagramSocket.broadcast
            while (true){
                DatagramSocket(1497).use {
//                    val outPacket = DatagramPacket(
//                        ByteArray(4){
//                            it.toByte()
//                        }, 4, InetAddress.getByName("192.168.5.104"),1497)
//                    it.send(outPacket)
//                    it.broadcast=true
                    while (true){
                        it.receive(inPacket)
                        cc+=inPacket.length
                        if(cc>100000000){
                            cc=0
                            Log.e("fuck","fuck")
                        }
//                        val gg=xx.copyOfRange(0,inPacket.length)
//
//
//                        Log.e("fuck",gg[0].toUByte().toInt().toString())
                        delay(3)
                    }



                }
                delay(1000)
            }

        }

        return binding.root
    }




}