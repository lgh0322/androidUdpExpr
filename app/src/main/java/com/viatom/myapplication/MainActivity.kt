package com.viatom.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.viatom.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class MainActivity : AppCompatActivity() {
    // 定义接收网络数据的字节数组
    var inBuff = ByteArray(560)

    // 以指定的字节数组创建准备接收数据的DatagramPacket对象
    private val inPacket = DatagramPacket(inBuff, inBuff.size)

    // 定义一个用于发送的DatagramPacket对象
    private var outPacket: DatagramPacket? = null

    lateinit var datagramSocket: DatagramSocket
    val dataScope = CoroutineScope(Dispatchers.IO)

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        dataScope.launch {
//            DatagramSocket().use {
//                outPacket = DatagramPacket(
//                    ByteArray(0), 0, InetAddress.getByName("192.168.5.108"),1497)
//                it.send(outPacket)
//               it.receive(inPacket)
//                val xx=inPacket.data
//                val gg=xx.copyOfRange(0,inPacket.length)
//
//                Log.e("fuck",mainX(gg))
//            }
//
//
//
//        }

    }
    fun mainX(byteArray: ByteArray):String {
        var fuc=""
        for (b in byteArray) {
            val st = String.format("%02X", b)
            fuc+=("$st  ");
        }
        return fuc
    }

}