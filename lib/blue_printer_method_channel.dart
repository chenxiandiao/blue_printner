import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'blue_printer_platform_interface.dart';

/// An implementation of [BluePrinterPlatform] that uses method channels.
class MethodChannelBluePrinter extends BluePrinterPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('blue_printer');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }

  @override
  Future<Map?> printData(Map map) async {
    return await methodChannel.invokeMethod<Map?>("printData", map);
  }
}
