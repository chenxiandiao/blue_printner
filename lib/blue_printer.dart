
import 'package:flutter/services.dart';

import 'blue_printer_platform_interface.dart';

class BluePrinter {
  BluePrinter._();

  static final BluePrinter _instance = BluePrinter._();
  static BluePrinter get instance => _instance;

  Future<String?> getPlatformVersion() {
    return BluePrinterPlatform.instance.getPlatformVersion();
  }

  Future<Map?> printData(Map map) {
    return BluePrinterPlatform.instance.printData(map);
  }


}
