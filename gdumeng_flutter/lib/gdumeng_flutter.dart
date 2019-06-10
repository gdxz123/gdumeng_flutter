import 'dart:async';

import 'package:flutter/services.dart';

class GdumengFlutter {
  static const MethodChannel _channel =
      const MethodChannel('gdumeng_flutter');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<bool> makeup(String key, String channel) {
      Map<String, dynamic> args = {
        "key": key,
        "channel": channel
      };

      _channel.invokeMethod("makeup", args);
      return new Future.value(true);

  }
}
