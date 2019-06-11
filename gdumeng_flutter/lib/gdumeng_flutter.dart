import 'dart:async';
import 'package:flutter/services.dart';

class GdumengFlutter {
  static const MethodChannel _channel =
      const MethodChannel('gdumeng_flutter');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> makeup(String key, String channel) async {
      Map<String, dynamic> args = {
        "key": key,
        "channel": channel
      };
      return await _channel.invokeMethod("makeup", args);
  }
}
