import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'dart:io';
import 'package:gdumeng_flutter/gdumeng_flutter.dart';
import 'package:package_info/package_info.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _platformVersion = 'Unknown';

  String _appVersion = 'Unknown';

  static bool _inited;

  @override
  void initState() {
    super.initState();
    initPlatformState();
    if (_inited == null) {
      _inited = true;
      if (Platform.isIOS) {
        try {
          GdumengFlutter.makeup("5cfdcbed3fc195562c0000ba", "AppStore");
        } on PlatformException {}

      } else if (Platform.isAndroid) {
        try {
          GdumengFlutter.makeup("5cfdcbcb0cafb21ddd0003c6", "Test2");
        } on PlatformException {}
      }

      GdumengFlutter.beginPageView("HomePage");
    }
  }

  @override
  void dispose() {
    super.dispose();
    GdumengFlutter.endPageView("HomePage");
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> initPlatformState() async {
    String platformVersion;
    // Platform messages may fail, so we use a try/catch PlatformException.
    try {
      platformVersion = await GdumengFlutter.platformVersion;
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    String appVersion;
    PackageInfo packageInfo = await PackageInfo.fromPlatform();
    appVersion = packageInfo.version;

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _platformVersion = platformVersion;
      _appVersion = appVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion \n app version: $_appVersion \n'),
        ),
      ),
    );
  }
}
