import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'blue_printer_method_channel.dart';

abstract class BluePrinterPlatform extends PlatformInterface {
  /// Constructs a BluePrinterPlatform.
  BluePrinterPlatform() : super(token: _token);

  static final Object _token = Object();

  static BluePrinterPlatform _instance = MethodChannelBluePrinter();

  /// The default instance of [BluePrinterPlatform] to use.
  ///
  /// Defaults to [MethodChannelBluePrinter].
  static BluePrinterPlatform get instance => _instance;
  
  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [BluePrinterPlatform] when
  /// they register themselves.
  static set instance(BluePrinterPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }

  Future<Map?> printData(Map map) {
    throw UnimplementedError('printData() has not been implemented.');
  }

}
