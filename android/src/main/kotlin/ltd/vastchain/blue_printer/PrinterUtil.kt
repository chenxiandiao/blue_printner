package ltd.vastchain.blue_printer

import android.content.Context
import android.util.Log
import android.widget.Toast


/**
 * Created by admin on 2021/12/29.
 */
object PrinterUtil {

    var openPrinter = true

    fun print(context: Context, address: String?, data: PrintModel, blueListener:IBlueListener?) {
        when {
            data.isWarehouse() -> {
                printStoreHouse(context, address, data, blueListener)
            }
            data.isConfigCommodity() -> {
                printCommodity(context, address, data, blueListener)
            }
            else -> {
                printNoConfigCommodity(context, address, data, blueListener)
            }
        }
    }

    private fun printNoConfigCommodity(context: Context, address: String?, data: PrintModel, blueListener:IBlueListener?) {
        if (openPrinter.not()) {
            return
        }
        val zpSDK = zp_cpcl_BluetoothPrinter(context)
        Log.e("Printer", address.orEmpty())
        if (!zpSDK.connect(address)) {
//            Toast.makeText(context, "连接失败------", Toast.LENGTH_LONG).show()
            blueListener?.printFail()
            return
        }
        zpSDK.pageSetup(600, 350)
        zpSDK.drawQrCode(30, 40, data.url, 0, 5, 0)
        if (data.qrCodeId.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 47, data.qrCodeId, 3, 0, 1, false, false)
        }
        if (data.name.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 89, data.name, 3, 0, 1, false, false)
        }
        if (data.packageCount.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 132, data.packageCount, 3, 0, 0, false, false)
        }
        if (data.totalCount.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 169, data.totalCount, 3, 0, 0, false, false)
        }
        if (data.orgName.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 211, data.orgName, 3, 0, 0, false, false)
        }

        zpSDK.print(0, 0)
        zpSDK.disconnect()
        Log.e("H5Log", "print llllll")
        blueListener?.printSuccess()
    }

    private fun printStoreHouse(context: Context, address: String?, data: PrintModel, blueListener:IBlueListener?) {
        if (openPrinter.not()) {
            return
        }
        val zpSDK = zp_cpcl_BluetoothPrinter(context)
        Log.e("Printer", address.orEmpty())
        if (!zpSDK.connect(address)) {
//            Toast.makeText(context, "连接失败------", Toast.LENGTH_LONG).show()
            blueListener?.printFail()
            return
        }
        zpSDK.pageSetup(600, 350)
        zpSDK.drawQrCode(30, 40, data.url, 0, 5, 0)
        if (data.storehouseName.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 47, data.storehouseName, 3, 0, 1, false, false)
        }
        if (data.storehouseOrgName.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 89, data.storehouseOrgName, 3, 0, 0, false, false)
        }
        if (data.qrCodeId.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 169, data.qrCodeId, 3, 0, 0, false, false)
        }
        if (data.orgName.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 211, data.orgName, 3, 0, 0, false, false)
        }

        zpSDK.print(0, 0)
        zpSDK.disconnect()
        blueListener?.printSuccess()
    }

    private fun printCommodity(context: Context, address: String?, data: PrintModel, blueListener:IBlueListener?) {
        if (openPrinter.not()) {
            return
        }
        val zpSDK = zp_cpcl_BluetoothPrinter(context)
        Log.e("Printer", address.orEmpty())
        if (!zpSDK.connect(address)) {
//            Toast.makeText(context, "连接失败------", Toast.LENGTH_LONG).show()
            blueListener?.printFail()
            return
        }
        zpSDK.pageSetup(600, 350)
        zpSDK.drawQrCode(30, 40, data.url, 0, 5, 0)
        if (data.name.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 47, data.name, 3, 0, 1, false, false)
        }
        if (data.totalCount.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 89, data.totalCount, 3, 0, 0, false, false)
        }
        if (data.qrCodeId.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 169, data.qrCodeId, 3, 0, 0, false, false)
        }
        if (data.orgName.isNullOrEmpty().not()) {
            zpSDK.drawText(280, 211, data.orgName, 3, 0, 0, false, false)
        }

        zpSDK.print(0, 0)
        zpSDK.disconnect()
        blueListener?.printSuccess()
    }
}