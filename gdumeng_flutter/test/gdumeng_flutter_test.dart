import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:gdumeng_flutter/gdumeng_flutter.dart';

void main() {
  const MethodChannel channel = MethodChannel('gdumeng_flutter');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await GdumengFlutter.platformVersion, '42');
  });
}
