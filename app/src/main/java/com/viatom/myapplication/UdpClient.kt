package com.viatom.myapplication

import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.*

class UdpClient {
    // 定义接收网络数据的字节数组  
    var inBuff = ByteArray(DATA_LEN)

    // 以指定的字节数组创建准备接收数据的DatagramPacket对象  
    private val inPacket = DatagramPacket(inBuff, inBuff.size)

    // 定义一个用于发送的DatagramPacket对象  
    private var outPacket: DatagramPacket? = null

    @Throws(IOException::class)
    fun init() {
        DatagramSocket().use { socket ->
            // 初始化发送用的DatagramSocket，它包含一个长度为0的字节数组  
            outPacket = DatagramPacket(
                ByteArray(0), 0, InetAddress.getByName(DEST_IP), DEST_PORT
            )



            val buff = "fuck"
            // 设置发送用的DatagramPacket中的字节数据
            outPacket!!.data = buff.toByteArray()
            // 发送数据报
            socket.send(outPacket)
            // 读取Socket中的数据，读到的数据放在inPacket所封装的字节数组中
            socket.receive(inPacket)
            println(
                String(
                    inBuff, 0, inPacket.length
                )
            )

        }
    }

    companion object {
        // 定义发送数据报的目的地  
        const val DEST_PORT = 11110
        const val DEST_IP = "192.168.5.100"

        // 定义每个数据报的最大大小为4KB  
        private const val DATA_LEN = 4096

        @Throws(IOException::class)
        @JvmStatic
        fun main() {
            UdpClient().init()
        }
    }
}