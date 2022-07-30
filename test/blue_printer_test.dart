import 'package:flutter_test/flutter_test.dart';
import 'package:blue_printer/blue_printer.dart';
import 'package:blue_printer/blue_printer_platform_interface.dart';
import 'package:blue_printer/blue_printer_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockBluePrinterPlatform 
    with MockPlatformInterfaceMixin
    implements BluePrinterPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final BluePrinterPlatform initialPlatform = BluePrinterPlatform.instance;

  test('$MethodChannelBluePrinter is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelBluePrinter>());
  });

  test('getPlatformVersion', () async {
    BluePrinter bluePrinterPlugin = BluePrinter();
    MockBluePrinterPlatform fakePlatform = MockBluePrinterPlatform();
    BluePrinterPlatform.instance = fakePlatform;
  
    expect(await bluePrinterPlugin.getPlatformVersion(), '42');
  });
}
